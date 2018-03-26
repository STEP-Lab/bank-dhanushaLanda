package com.thoughtworks.step;

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
}
