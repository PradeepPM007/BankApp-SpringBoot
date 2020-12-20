package application.validator;

import application.entity.Account;


public class AccountValidator {
    public boolean validate(Account account) {
        return (validateBalance(account.getBalance()));
    }

    private boolean validateType(String type) {
        return type.equalsIgnoreCase("debit") || type.equalsIgnoreCase("credit");
    }
    private boolean validateBalance(Double balance) {
        return balance > 0;
    }

}