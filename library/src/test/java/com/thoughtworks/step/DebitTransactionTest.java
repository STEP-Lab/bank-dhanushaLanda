package com.thoughtworks.step;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DebitTransactionTest {
    @Test
    public void checkDate() {
        Date date = new Date();
        DebitTransaction debitTransaction = new DebitTransaction(date, 1000);
        assertTrue(debitTransaction.getDate().equals(date));
    }
}
