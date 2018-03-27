package com.thoughtworks.step;

import java.util.Date;
import java.util.Objects;

public abstract class  Transaction {
    private final Date date;
    private final float amount;

    Transaction(Date date, float amount){
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Float.compare(that.amount, amount) == 0 &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                '}';
    }

    public String toCSV() {
        return date+","+amount;

    }
}
