package gr.aueb.cf.exceptions;

import gr.aueb.cf.model.IdentifiableEntity;

import java.nio.file.Path;

public class InsufficientBalanceException extends Exception {
    private static final long serialVersionUID = 1L;

    public InsufficientBalanceException(double balance, double amount) {
        super("Insufficient balance" + balance + "for amount"+ amount);
    }
}
