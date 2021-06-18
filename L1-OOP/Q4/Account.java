import java.util.ArrayList;
import java.util.Date;

class Account {
    private String name;
    private int id;
    private double balance, annualInterestRate;
    private final Date dateCreated;
    private final ArrayList<Transaction> transactions;

    public Account() {
        this(null, 0, 0);
    }

    public Account(int id, double balance) {
        this(null, id, balance);
    }

    public Account(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
        transactions = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return getMonthlyInterestRate() / 100 * balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction('W', amount, balance, "Withdraw"));
            return true;
        }
        return false;
    }

    public double deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('W', amount, balance, "Deposit"));
        return balance;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(String.format("Account Summary\n\nHolder Name: %s\nInterest Rate: %.2f %%\nBalance: %.2f\n", name, annualInterestRate, balance));
        str.append(String.format("Transaction History:\n%-30s %5s %10s %10s %15s\n", "Date", "Type", "Amount", "Balance", "Description"));

        for (Transaction transaction : transactions) {
            str.append(String.format("%-30s %5s %10.2f %10.2f %15s\n",
                    dateCreated, transaction.getType(), transaction.getAmount(),
                    transaction.getBalance(), transaction.getDescription()));
        }
        return str.toString();
    }
}
