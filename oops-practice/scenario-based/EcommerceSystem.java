import java.util.*;

// ================= Custom Exception =================
class PaymentFailedException extends Exception {
    public PaymentFailedException(String msg) {
        super(msg);
    }
}

// ================= Payment Interface =================
interface Payment {
    void pay(double amount) throws PaymentFailedException;
}

// Card payment
class CardPayment implements Payment {
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 50000)
            throw new PaymentFailedException("Card limit exceeded!");
        System.out.println("Paid ₹" + amount + " using Card");
    }
}

// UPI payment
class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

// Wallet payment
class WalletPayment implements Payment {
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 10000)
            throw new PaymentFailedException("Wallet balance low!");
        System.out.println("Paid ₹" + amount + " using Wallet");
    }
}

// ================= Product =================
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

// ================= Customer =================
class Customer {
    int id;
    String name;

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// ================= Order =================
class Order {
    int orderId;
    Customer customer;
    List<Product> products = new ArrayList<>();
    boolean isCancelled = false;

    Order(int id, Customer customer) {
        this.orderId = id;
        this.customer = customer;
    }

    void addProduct(Product p) {
        products.add(p);
    }

    double getTotalAmount() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

    void cancel() {
        isCancelled = true;
        System.out.println("Order cancelled!");
    }
}

// ================= E-Commerce System =================
class ECommerceSystem {

    List<Product> catalog = new ArrayList<>();
    List<Order> orders = new ArrayList<>();

    void addProduct(Product p) {
        catalog.add(p);
    }

    Order placeOrder(Customer c, List<Product> products, Payment payment)
            throws PaymentFailedException {

        Order order = new Order(orders.size() + 1, c);
        for (Product p : products)
            order.addProduct(p);

        double total = order.getTotalAmount();
        payment.pay(total);   // Polymorphism happens here

        orders.add(order);
        System.out.println("Order placed successfully!");
        return order;
    }
}

// ================= Main =================
public class EcommerceSystem {
    public static void main(String[] args) {

        ECommerceSystem shop = new ECommerceSystem();

        Product p1 = new Product(1, "Laptop", 40000);
        Product p2 = new Product(2, "Phone", 15000);

        shop.addProduct(p1);
        shop.addProduct(p2);

        Customer c1 = new Customer(101, "Abhay");

        List<Product> cart = new ArrayList<>();
        cart.add(p1);
        cart.add(p2);

        try {
            Order order = shop.placeOrder(c1, cart, new CardPayment());
            System.out.println("Total Paid: ₹" + order.getTotalAmount());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
