package com.thoughtworks.step;

import java.util.Date;
import java.util.Objects;

public abstract class  Transaction {
    private final Date date;
    private final float amount;

    public Transaction(Date date, float amount){
        this.date = date;
        this.amount = amount;
    }

    protected Date getDate() {
        return this.date;
    }

    protected float getAmount() {
        return amount;
    }
    @Override
    public int hashCode() {

        return Objects.hash(date, amount);
    }
}
