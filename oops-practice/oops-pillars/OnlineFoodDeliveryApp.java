interface Discountable {
    double applyDiscount();
    void getDiscountDetails();
}

abstract class FoodItem implements Discountable {

    // Encapsulation (private fields)
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Item: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }

    // Protected getters for subclasses
    protected double getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }
}


class VegItem extends FoodItem {

    private double discountRate = 0.10; // 10% discount

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * discountRate;
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Veg Item Discount: 10%");
    }
}

class NonVegItem extends FoodItem {

    private double extraCharge = 50;     // Non-veg charge
    private double discountRate = 0.05;  // 5% discount

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + extraCharge;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * discountRate;
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Non-Veg Item Discount: 5%");
        System.out.println("Extra Charge: ₹50");
    }
}

class OrderService {

    public static void generateBill(FoodItem item) {
        System.out.println("\n--- Order Details ---");
        item.getItemDetails();

        double total = item.calculateTotalPrice();
        double discount = item.applyDiscount();

        item.getDiscountDetails();
        System.out.println("Total Price: ₹" + total);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Amount: ₹" + (total - discount));
    }
}

public class OnlineFoodDeliveryApp {

    public static void main(String[] args) {

        FoodItem vegOrder = new VegItem("Paneer Butter Masala", 250, 2);
        FoodItem nonVegOrder = new NonVegItem("Chicken Biryani", 300, 1);

        OrderService.generateBill(vegOrder);
        OrderService.generateBill(nonVegOrder);
    }
}

