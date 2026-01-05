interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}
	

abstract class BankAccount implements Loanable {

    // Encapsulated fields
    private long accountNumber;
    private String holderName;
    protected double balance;

    // Constructor
    public BankAccount(long accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Encapsulated account details
    public void getAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }
}


class SavingsAccount extends BankAccount {

    private static final double INTEREST_RATE = 0.04; // 4%

    public SavingsAccount(long accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied: ₹" + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 5; // 5 times balance
    }
}


class CurrentAccount extends BankAccount {

    private static final double INTEREST_RATE = 0.02; // 2%

    public CurrentAccount(long accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied: ₹" + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 3; // 3 times balance
    }
}


class BankService {

    public static void processAccount(BankAccount account) {
        System.out.println("\n--- Account Summary ---");
        account.getAccountDetails();
        System.out.println("Calculated Interest: ₹" + account.calculateInterest());
        System.out.println("Loan Eligibility: ₹" + account.calculateLoanEligibility());
    }
}


public class BankingSystemApp {

    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount(1001, "Rahul", 50000);
        BankAccount current = new CurrentAccount(2001, "Amit", 80000);

        savings.deposit(10000);
        savings.withdraw(5000);

        current.deposit(20000);
        current.withdraw(15000);

        BankService.processAccount(savings);
        BankService.processAccount(current);
    }
}
