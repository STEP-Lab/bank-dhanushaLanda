package com.thoughtworks.step;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionsTest {
    @Test
    public void MustcheckDebitTransactionInTransactions() {
        Transactions transactions = new Transactions();
        transactions.debit(1000,"dhanu");
        assertEquals(transactions.list.get(0).hashCode(),new DebitTransaction(1000,"dhanu").hashCode());
    }

    @Test
    public void MustcheckCreditTransaction() {
        Transactions transactions = new Transactions();
        transactions.credit(1000,"bhanu");
        assertEquals(transactions.list.get(0).hashCode(),new CreditTransaction(1000,"bhanu").hashCode());

    }
}
