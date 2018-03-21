package com.thoughtworks.step;

public class InvalidAccountNumberException extends Exception {
    public InvalidAccountNumberException() {
        super("Invalid Account Number");
    }
}
