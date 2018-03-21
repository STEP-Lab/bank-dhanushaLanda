package com.thoughtworks.step;

public class Account {
    private final String name;
    private final String accNumber;
    private float balance;

    public Account(String name, String accNumber, float balance) {
        this.name = name;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public float getBalance() {
        return  this.balance;
    }

    public String getAccNumber() {
        return this.accNumber;
    }
}
