package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;

public class OverdraftAccount extends Account {

    public OverdraftAccount(){}

    public OverdraftAccount(User holder, String iban, double balance) {
        super(holder, iban, balance);
    }

    @Override
    public void withdraw(double amount, String ssn) throws InsufficientBalanceException, SsnNotValidException, NegativeAmountException {
        super.withdraw(amount, ssn);
        try {
            if (amount < 0) throw new NegativeAmountException(amount);
            if (!isSsnValid(ssn)) throw new SsnNotValidException(ssn);

            setBalance(getBalance() - amount);
        }catch (SsnNotValidException | NegativeAmountException e) {
            System.out.println("Error: withrdawl");
            throw e;
        }

    }
}
