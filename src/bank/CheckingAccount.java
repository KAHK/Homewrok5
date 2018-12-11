package bank;

public class CheckingAccount extends Account {
    public CheckingAccount(Integer accountID, Double balance, String currency, Customer customer) {
        super(accountID, balance, currency, customer);
    }

    public CheckingAccount(Integer accountID, Double balance, Customer customer) {
        super(accountID, balance, customer);
    }
}
