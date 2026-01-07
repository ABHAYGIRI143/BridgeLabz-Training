import java.util.ArrayList;
import java.util.List;

// ================= Custom Exception =================
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// ================= Abstraction =================
interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    void transfer(Account toAccount, double amount) throws InsufficientBalanceException;
    double calculateInterest();
}

// ================= Base Account Class =================
abstract class Account implements BankService {

    private int accountNumber;
    private String holderName;
    protected double balance;
    protected List<String> transactionHistory = new ArrayList<>();

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        transactionHistory.add("Account created with balance ₹" + balance);
    }

    // Thread-safe deposit
    public synchronized void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited ₹" + amount);
    }

    // Thread-safe withdraw
    public synchronized void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn ₹" + amount);
    }

    // Thread-safe transfer
    public synchronized void transfer(Account toAccount, double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for transfer!");
        }
        this.balance -= amount;
        toAccount.deposit(amount);

        transactionHistory.add("Transferred ₹" + amount +
                " to Account " + toAccount.accountNumber);
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History for Account " + accountNumber);
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}

// ================= Savings Account =================
class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 0.04; // 4%

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Polymorphism
    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

// ================= Current Account =================
class CurrentAccount extends Account {

    private static final double INTEREST_RATE = 0.02; // 2%

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Polymorphism
    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

// ================= Multithreading =================
class TransactionThread extends Thread {

    private Account account;
    private double amount;
    private boolean isDeposit;

    public TransactionThread(Account account, double amount, boolean isDeposit) {
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    public void run() {
        try {
            if (isDeposit) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

// ================= Main Class =================
public class OnlineBankingSystem {

    public static void main(String[] args) {

        // CREATE accounts
        Account savings = new SavingsAccount(101, "Abhay", 50000);
        Account current = new CurrentAccount(102, "Rahul", 30000);

        // Concurrent transactions
        Thread t1 = new TransactionThread(savings, 5000, true);
        Thread t2 = new TransactionThread(savings, 7000, false);
        Thread t3 = new TransactionThread(current, 10000, true);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fund transfer
        try {
            savings.transfer(current, 8000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        // READ
        System.out.println("\nSavings Balance: ₹" + savings.getBalance());
        System.out.println("Current Balance: ₹" + current.getBalance());

        // Polymorphism (dynamic interest calculation)
        System.out.println("\nSavings Interest: ₹" + savings.calculateInterest());
        System.out.println("Current Interest: ₹" + current.calculateInterest());

        // Transaction history
        savings.showTransactionHistory();
        current.showTransactionHistory();
    }
}
