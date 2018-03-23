package com.thoughtworks.step;

import java.util.Date;

public class CreditTransaction extends Transaction{
    private final String from;

    public CreditTransaction(Date date, float amount, String from) {
        super(date,amount);
        this.from = from;
    }

    public CreditTransaction(float amount, String from) {
        super(new Date(),amount);
        this.from=from;
    }

    public String fromWhom() {
        return this.from;
    }
}
