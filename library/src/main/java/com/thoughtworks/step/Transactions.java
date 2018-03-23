package com.thoughtworks.step;

import java.util.ArrayList;
import java.util.Objects;

public class Transactions {

    ArrayList<Transaction> list;

    public Transactions() {
        this.list = new ArrayList<Transaction>();
    }

    public void debit(float amount, String to) {
        this.list.add(new DebitTransaction(amount,to));
    }

    public void credit(float amount, String from) {
        this.list.add(new CreditTransaction(amount,from));

    }
}
