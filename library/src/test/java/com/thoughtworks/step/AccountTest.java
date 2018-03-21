package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception, MinimumBalanceException {
        account = new Account("Dhanu", "1234-1234", 1000);
    }

    @Test
    public void getBalance() {
        assertEquals(account.getBalance(),1000,0);
    }

    @Test
    public void getAccNumber() {
        assertEquals(account.getAccNumber(),"1234-1234");
    }

    @Test
    public void credit() throws MinimumBalanceException {
        assertEquals(account.credit(100),1100,0);
    }

    @Test (expected= MinimumBalanceException.class)
    public void checkCreditBalance() throws MinimumBalanceException {
        account.credit(-90);
    }

    @Test
    public void debit() throws InvalidDebitAmount {
        assertEquals(account.debit(100),900,0);
    }

    @Test (expected = InvalidDebitAmount.class)
    public void checkDebitAmount() throws InvalidDebitAmount {
        account.debit(1200);
    }

    @Test (expected = InvalidAccountNumberException.class)
    public void accNumberCheck() throws MinimumBalanceException, InvalidAccountNumberException {
        account = new Account("dhanu","122",1111);

    }
}