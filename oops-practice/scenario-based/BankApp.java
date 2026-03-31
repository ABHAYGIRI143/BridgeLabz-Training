abstract class BankAccount {

    private final String accountNumber;
    private final double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters (no setters → immutability)
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Polymorphic method
    public abstract double calculateFee();
}



class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        // 0.5% of balance
        return getBalance() * 0.005;
    }
}


class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        // Flat 1.0 fee if balance < 1000
        return getBalance() < 1000 ? 1.0 : 0.0;
    }
}


public class BankApp {
    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount("12345", 1000.0);
        System.out.printf("%.2f%n", savings.calculateFee());

        BankAccount s2 = new SavingsAccount("11111", 500.0);
        System.out.printf("%.2f%n", s2.calculateFee());

        BankAccount c1 = new CheckingAccount("22222", 1500.0);
        System.out.printf("%.2f%n", c1.calculateFee());

        BankAccount c2 = new CheckingAccount("33333", 500.0);
        System.out.printf("%.2f%n", c2.calculateFee());
    }
}
