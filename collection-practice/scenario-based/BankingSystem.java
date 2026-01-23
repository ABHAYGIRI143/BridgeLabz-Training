import java.util.*;

class Customer {
    int accountNumber;
    String name;
    double balance;

    public Customer(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Name: " + name + ", Balance: ₹" + balance;
    }
}

public class BankingSystem {

    public static void main(String[] args) {
        // HashMap: AccountNumber -> Customer
        HashMap<Integer, Customer> customers = new HashMap<>();
        customers.put(101, new Customer(101, "Alice", 5000));
        customers.put(102, new Customer(102, "Bob", 7000));
        customers.put(103, new Customer(103, "Charlie", 6000));

        // TreeMap to sort customers by balance
        TreeMap<Double, Customer> sortedByBalance = new TreeMap<>();
        for (Customer c : customers.values()) {
            sortedByBalance.put(c.balance, c);
        }

        System.out.println("Customers sorted by balance:");
        for (Customer c : sortedByBalance.values()) {
            System.out.println(c);
        }

        // Queue to process withdrawal requests
        Queue<String> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add("Alice: 1000");
        withdrawalQueue.add("Bob: 2000");
        withdrawalQueue.add("Charlie: 500");

        System.out.println("\nProcessing withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            String request = withdrawalQueue.poll();
            System.out.println("Processed withdrawal -> " + request);
        }
    }
}
