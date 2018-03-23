package com.thoughtworks.step;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CreditTransactionTest {
    @Test
    public void checkDate() {
        Date date = new Date();
        CreditTransaction creditTransaction = new CreditTransaction(date,1000,"dhanu");
        assertEquals(creditTransaction.getDate(),date);
    }

    @Test
    public void checkAmount() {
        CreditTransaction credit = new CreditTransaction(1000, "dhanu");
        assertEquals(credit.getAmount(),1000,0);
    }

    @Test
    public void fromWhom() {
        CreditTransaction credit = new CreditTransaction(1000, "dhanu");
        assertThat(credit.fromWhom(),is("dhanu"));

    }
}
