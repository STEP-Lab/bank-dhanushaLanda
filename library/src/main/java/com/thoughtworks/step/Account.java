package com.thoughtworks.step;


public class Account {
    private final String name;
    private final String accNumber;
    private float balance;

    public Account(String name, String accNumber, float balance) throws MinimumBalanceException, InvalidAccountNumberException {
        if (balance<500){
            throw new MinimumBalanceException("minimum balance to open account is 500");
        }
        if (!accNumber.matches("[0-9]{4}(-)[0-9]{4}")){
            throw new InvalidAccountNumberException();
        }
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

    public double credit(double amount) throws MinimumBalanceException {
        if(amount<0){
            throw new MinimumBalanceException("amount should be more than 0");
        }
        this.balance += amount;
        return this.balance;
    }

    public double debit(double amount) throws InvalidDebitAmount {
        if (this.balance-amount<500){
            throw new InvalidDebitAmount();
        }
        this.balance-=amount;
        return this.balance;
    }
}
