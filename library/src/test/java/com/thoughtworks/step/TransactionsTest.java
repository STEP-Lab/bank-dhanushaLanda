package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

    private Transactions transactions;

    @Before
    public void setUp() {
        transactions = new Transactions();
    }

    @Test
    public void MustcheckDebitTransactionInTransactions() {
        transactions.debit(1000,"dhanu");
        DebitTransaction debitTransaction = new DebitTransaction(1000, "dhanu");
        assertThat(transactions.list,hasItem(debitTransaction ));
    }

    @Test
    public void MustcheckCreditTransaction() {
        transactions.credit(1000,"bhanu");
        CreditTransaction bhanu = new CreditTransaction(1000, "bhanu");
        assertThat(transactions.list,hasItem(bhanu));
    }

    @Test
    public void MustCheckCreditAndDebit() {
        transactions.credit(1000,"bhanu");
        transactions.debit(1000,"dhanu");
        CreditTransaction bhanu = new CreditTransaction(1000, "bhanu");
        DebitTransaction debitTransaction = new DebitTransaction(1000, "dhanu");
        assertThat(transactions.list,hasItems(bhanu,debitTransaction));
    }

    @Test
    public void printTransactions() throws FileNotFoundException, UnsupportedEncodingException {
        CreditTransaction bhanu = new CreditTransaction(1000, "bhanu");
        DebitTransaction debitTransaction = new DebitTransaction(1000, "dhanu");
        ArrayList<String> result = new ArrayList<>();
        this.transactions.credit(1000,"bhanu");
        this.transactions.debit(1000,"dhanu");
        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8"){
            public void println(String x) {
                result.add(x);
            }
        };
        this.transactions.print(writer);
        writer.close();
        assertThat(result,hasItems(bhanu.toString(),debitTransaction.toString()));
    }

    @Test
    public void writeTransactionsInCSVFile() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        transactions.debit(1500,"dhanu");
        DebitTransaction debitTransaction = new DebitTransaction(1500, "dhanu");
        FileWriter fileWriter = new FileWriter("transactions.csv")
        {
            public void write(String x) {
                result.add(x);
            }
        };
        this.transactions.printInCsvFile(fileWriter);
        fileWriter.flush();
        fileWriter.close();
        assertThat(result,hasItem(debitTransaction.toCSV()));

    }

    @Test
    public void filterTransactionsByAmountGreaterThan() {
        transactions.credit(1500,"dhanu");
        Transactions filteredTransaction = transactions.filterByAmountGreaterThan(1000);
        System.out.println(filteredTransaction.getClass());
        assertThat(filteredTransaction.list,hasItems(new CreditTransaction(1500,"dhanu")));
    }

    @Test
    public void filterTransactionsByAmountLessThan() {
        transactions.credit(1000,"dhanu");
        transactions.credit(500,"dhanu");
        transactions.credit(900,"dhanu");
        Transactions filteredTransaction = transactions.filterByAmountLessThan(1000);
        assertThat(filteredTransaction.list,hasItems(new CreditTransaction(500,"dhanu"),new CreditTransaction(900,"bhnau")));
    }
    @Test
    public void filterTransactionsByAmountEqualsTo() {
        transactions.credit(1000,"dhanu");
        transactions.credit(1000,"dhanu");
        transactions.credit(900,"dhanu");
        Transactions filteredTransaction = transactions.filterByAmountEqualsTo(1000);
        assertThat(filteredTransaction.list,hasItems(new CreditTransaction(1000,"dhanu"),new CreditTransaction(1000,"dhanu")));
    }

    @Test
    public void filterTransactionsOfDebit() {
        DebitTransaction debitTransaction = new DebitTransaction(1000, "dhanu");
        transactions.credit(1500,"bhanu");
        transactions.debit(1000,"dhanu");
        Class<? extends Transaction> debit = debitTransaction.getClass();
        Transactions transactions1 = transactions.getTransactionsByOfType(debit);
        assertThat(transactions1.list,hasItems(debitTransaction));
    }
}
