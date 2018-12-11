package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Bank {

    private List<Customer> custList = new ArrayList<>();

    private List<Account> accList = new ArrayList<>();

    private Integer lastCustID = 0;

    private Integer lastAccID = 100;

    // Public API
    public Customer newCustomer(String firstName,
                                String lastName,
                                String email) {
        Customer cust = new Customer(lastCustID++, firstName,
                lastName, email);
        custList.add(cust);
        return cust;
    }

    public Account newAccount(Customer cust, String accType) {
        Account acc;
        switch (accType) {
            case "Savings":
                acc = new SavingsAccount(lastAccID++, 0.0, cust);
                break;
            case "Debit":
                acc = new DebitAccount(lastAccID++, 0.0, cust);
                break;
            default:
                acc = new CheckingAccount(lastAccID++, 0.0, cust);
        }
        accList.add(acc);
        return acc;
    }

    private Account findAccountByID(Integer accID) {
        for (Account acc : accList) {
            if (acc.getAccountID().equals(accID))
                return acc;
        }
        return null;
    }

    public void transfer(int fromAccID, int toAccID, Double amount) {

        Account FromAcc = findAccountByID(fromAccID);
        Account ToAcc = findAccountByID(toAccID);

        if (FromAcc==null)
        {

            JOptionPane.showMessageDialog(null,"The account you want to transfer money from  " +
                    "does not exist.");
            return;
        }

        if (ToAcc==null)
        {
            JOptionPane.showMessageDialog(null,"The account you want to transfer money to " +
                    "does not exist.");
            return;
        }

        if(new BigDecimal(amount).compareTo(FromAcc.getBalance()) == 1)
        {
            JOptionPane.showMessageDialog(null,"Not enough money to finalize the transfer.");
            return;
        }
        if(amount < 0)
        {
            JOptionPane.showMessageDialog(null, "You can not transfer negative values.");
            return;
        }
        FromAcc.charge(amount);
        ToAcc.deposit(amount);
    }


    @Override
    public String toString() {
        return "Bank{" +
                "custs=\n" + custList +
                ",\naccs=\n" + accList +
                '}';
    }
}