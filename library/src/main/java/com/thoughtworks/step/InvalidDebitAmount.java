package com.thoughtworks.step;

public class InvalidDebitAmount extends Throwable {
    public InvalidDebitAmount(){
        super("invalid amount to debit");
    }
}

