import java.util.*;

// ================= Custom Exception =================
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

// ================= Interface =================
interface TransferService {
    void transfer(double amount, Wallet toWallet) throws InsufficientBalanceException;
}

// ================= Transaction Class =================
class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String toString() {
        return type + " : ₹" + amount;
    }
}

// ================= User Class =================
class User {
    String name;
    Wallet wallet;

    User(String name) {
        this.name = name;
        this.wallet = new Wallet(this);
    }
}

// ================= Wallet Class =================
class Wallet implements TransferService {

    private double balance = 0;
    private List<Transaction> history = new ArrayList<>();
    private User owner;

    Wallet(User owner) {
        this.owner = owner;
        history.add(new Transaction("Wallet Created", 0));
    }

    // CREATE
    public void addMoney(double amount) {
        balance += amount;
        history.add(new Transaction("Added", amount));
    }

    // DELETE
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Not enough balance!");

        balance -= amount;
        history.add(new Transaction("Withdrawn", amount));
    }

    // READ
    public double getBalance() {
        return balance;
    }

    // Interface method
    @Override
    public void transfer(double amount, Wallet toWallet) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Transfer failed. Low balance.");

        this.balance -= amount;
        toWallet.balance += amount;

        history.add(new Transaction("Transferred to " + toWallet.owner.name, amount));
        toWallet.history.add(new Transaction("Received from " + this.owner.name, amount));
    }

    // Transaction history
    public void showHistory() {
        System.out.println("\nTransaction history of " + owner.name);
        for (Transaction t : history)
            System.out.println(t);
    }
}

// ================= Main Class =================
public class DigitalWalletSystem {
    public static void main(String[] args) {

        User u1 = new User("Abhay");
        User u2 = new User("Rahul");

        u1.wallet.addMoney(5000);
        u1.wallet.addMoney(2000);

        try {
            u1.wallet.transfer(3000, u2.wallet);
            u2.wallet.withdraw(500);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Abhay Balance: ₹" + u1.wallet.getBalance());
        System.out.println("Rahul Balance: ₹" + u2.wallet.getBalance());

        u1.wallet.showHistory();
        u2.wallet.showHistory();
    }
}
