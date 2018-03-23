package com.thoughtworks.step;


public class Account {
    private final String name;
    private final String accNumber;
    private double balance;
    private Transactions transactions;

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
        this.transactions = new Transactions();
    }

    public double getBalance() {
        return  this.balance;
    }

    public String getAccNumber() {
        return this.accNumber;
    }

    public double credit(float amount, String from) throws MinimumBalanceException {
        if(amount<0){
            throw new MinimumBalanceException("amount should be more than 0");
        }
        this.transactions.credit(amount,from);
        this.balance += amount;
        return this.balance;
    }

    public double debit(float amount, String to) throws InvalidDebitAmount {
        double balance = this.balance-amount;
        if (balance<500 || amount <= 0 ){
            throw new InvalidDebitAmount();
        }
        this.transactions.debit(amount,to);
        return this.balance = balance;
    }
}
