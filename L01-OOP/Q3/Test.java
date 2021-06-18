public class Test {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);

        System.out.println("Account Balance\t\t: " + account.getBalance());
        System.out.println("Monthly Interest\t: " + account.getMonthlyInterest());
        System.out.println("Date created\t\t: " + account.getDateCreated());
    }
}
