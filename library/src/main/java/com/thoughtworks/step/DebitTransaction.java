package com.thoughtworks.step;

import java.util.Date;

public class DebitTransaction extends Transaction{
    public DebitTransaction(float amount, float amount1) {
        super(new Date(),amount);
    }

    public DebitTransaction(Date date, float amount) {
        super(date,amount);
    }

}
