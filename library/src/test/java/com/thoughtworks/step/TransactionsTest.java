package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

    private Transactions transactions;

    @Before
    public void setUp() throws Exception {
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
            @Override
            public void println(String x) {
                result.add(x);
            }
        };
        this.transactions.print(writer);
        writer.close();
        assertThat(result,hasItems(bhanu.toString(),debitTransaction.toString()));
    }

    @Test
    public void filterTransactionsByAmount() {
        transactions.credit(1000,"dhanu");
        transactions.credit(1500,"bhanu");
        transactions.credit(500,"bhanu");
        Transactions filteredTransaction = this.transactions.filterByAmountGreaterThan(1000);
        assertThat(filteredTransaction.list,hasItems(new CreditTransaction(1000,"dhanu"),new CreditTransaction(1000,"bhnau")));
    }
}
