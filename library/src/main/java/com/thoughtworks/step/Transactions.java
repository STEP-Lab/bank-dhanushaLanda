package com.thoughtworks.step;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Transactions {

    ArrayList<Transaction> list;

    public Transactions() {
        this.list = new ArrayList<Transaction>();
    }

    public void debit(float amount, String to) {
        this.list.add(new DebitTransaction(amount,to));
    }

    public void credit(float amount, String from) {
        this.list.add(new CreditTransaction(amount,from));

    }

    public Transactions filterByAmountGreaterThan(float amount) {
        Transactions transactions = new Transactions();
        for (Transaction transaction: list) {
            if (transaction.getAmount()>=amount){
                transactions.list.add(transaction);
            }
        }
        return transactions;
    }

    public void print(PrintWriter writer) {
        for (Transaction transaction: list) {
            writer.println(transaction.toString());
        }
    }

    public Transactions getTransactionsByOfType(Class<? extends Transaction> type) {
        Transactions transactions = new Transactions();
        for (Transaction transaction: list) {
            if (transaction.getClass().equals(type)){
                transactions.list.add(transaction);
            }
        }
        return transactions;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "list=" + list +
                '}';
    }

    public Transactions filterByAmountLessThan(int amount) {
        Transactions transactions = new Transactions();
        for (Transaction transaction: list) {
            if (transaction.getAmount()<=amount){
                transactions.list.add(transaction);
            }
        }
        return transactions;
    }

    public Transactions filterByAmountEqualsTo(int amount) {
        Transactions transactions = new Transactions();
        for (Transaction transaction: list) {
            if (transaction.getAmount()==amount){
                transactions.list.add(transaction);
            }
        }
        return transactions;
    }

    public void printInCsvFile(FileWriter fileWriter) throws IOException {
        for (Transaction transaction: list) {
            fileWriter.write(transaction.toCSV());
        }
    }
}
