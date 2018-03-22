package com.thoughtworks.step;

import java.util.Date;

public abstract class  Transaction {
    private final Date date;
    private final float amount;

    public Transaction(Date date, float amount){

        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return this.date;
    }

}
