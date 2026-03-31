import java.util.*;

// ---------------- ITEM CLASS ----------------
class Item {
    String name;
    double price;
    int stock;

    Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

// ---------------- CUSTOMER CLASS ----------------
class Customer {
    String customerName;
    Map<String, Integer> cart;

    Customer(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }

    void addItem(String itemName, int quantity) {
        cart.put(itemName, quantity);
    }
}

// ---------------- SMART CHECKOUT SYSTEM ----------------
class SmartCheckoutMain {

    Queue<Customer> queue = new LinkedList<>();
    Map<String, Item> inventory = new HashMap<>();

    // Add item to inventory
    void addItemToInventory(String name, double price, int stock) {
        inventory.put(name, new Item(name, price, stock));
    }

    // Add customer to queue
    void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println(customer.customerName + " joined the queue");
    }

    // Process next customer
    void processNextCustomer() {

        Customer customer = queue.poll();

        if (customer == null) {
            System.out.println("No customers in queue");
            return;
        }

        double totalBill = 0;
        System.out.println("\nBilling for " + customer.customerName);

        for (Map.Entry<String, Integer> entry : customer.cart.entrySet()) {

            String itemName = entry.getKey();
            int quantity = entry.getValue();

            Item item = inventory.get(itemName);

            if (item == null) {
                System.out.println(itemName + " not available");
                continue;
            }

            if (item.stock < quantity) {
                System.out.println("Insufficient stock for " + itemName);
                continue;
            }

            double cost = item.price * quantity;
            totalBill += cost;
            item.stock -= quantity;

            System.out.println(itemName + " x" + quantity + " = ₹" + cost);
        }

        System.out.println("Total Bill: ₹" + totalBill);
        System.out.println("----------------------------");
    }
}

// ---------------- MAIN CLASS ----------------
public class SmartCheckoutMain {
    public static void main(String[] args) {

        SmartCheckoutMain checkout = new SmartCheckoutMain();

        // Inventory setup
        checkout.addItemToInventory("Milk", 50, 20);
        checkout.addItemToInventory("Bread", 40, 15);
        checkout.addItemToInventory("Rice", 60, 30);

        // Customers
        Customer c1 = new Customer("Amit");
        c1.addItem("Milk", 2);
        c1.addItem("Bread", 1);

        Customer c2 = new Customer("Neha");
        c2.addItem("Rice", 5);
        c2.addItem("Milk", 1);

        // Queue operations
        checkout.addCustomer(c1);
        checkout.addCustomer(c2);

        // Billing
        checkout.processNextCustomer();
        checkout.processNextCustomer();
    }
}
