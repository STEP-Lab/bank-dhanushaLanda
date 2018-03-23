package com.thoughtworks.step;

import java.util.ArrayList;
import java.util.Objects;

public class Transactions {

    ArrayList<Transaction> list;

    public Transactions() {
        this.list = new ArrayList<Transaction>();
    }

    public void debit(int amount, String to) {
        this.list.add(new DebitTransaction(amount,to));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    public void credit(int amount, String from) {
        this.list.add(new CreditTransaction(amount,from));

    }
}
