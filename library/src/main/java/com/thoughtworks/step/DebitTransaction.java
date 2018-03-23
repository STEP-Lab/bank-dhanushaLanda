package com.thoughtworks.step;

import java.util.Date;

public class DebitTransaction extends Transaction{
    private final String to;
    private float amount;


    public DebitTransaction(Date date, float amount, String to) {
        super(date,amount);
        this.to = to;
    }

    public DebitTransaction(float amount, String to) {
        super(new Date(),amount);
        this.to = to;
    }

    public String toWhom() {
        return this.to;
    }
}
