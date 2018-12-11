package bank;

import java.math.BigDecimal;

public abstract class Account {

    private Integer accountID;

    private BigDecimal balance;

    private String currency = "USD";

    private Customer customer;

    public Account(Integer accountID, Double balance,
                   String currency, Customer customer) {
        this.accountID = accountID;
        this.balance = new BigDecimal(balance);
        this.balance.setScale(2);
        this.currency = currency;
        this.customer = customer;
    }

    public Account(Integer accountID, Double balance,
                   Customer customer) {
        this.accountID = accountID;
        this.balance = new BigDecimal(balance);
        this.balance.setScale(2);
        this.customer = customer;
    }

    public void deposit(Double amount) {
        this.balance = balance.add(new BigDecimal(amount));
    }

    public void charge(Double amount) {
        balance = balance.subtract(new BigDecimal(amount));
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                .replace("Account", "") + "{" +
                "ID=" + accountID +
                "," + currency + "=" + balance +
                ", cust=" + customer.getCustomerID() +
                '}';
    }
}
