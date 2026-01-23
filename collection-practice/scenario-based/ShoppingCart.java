import java.util.*;

public class ShoppingCart {

    public static void main(String[] args) {
        // HashMap: Product -> Price
        HashMap<String, Double> productPrices = new HashMap<>();
        productPrices.put("Laptop", 75000.0);
        productPrices.put("Phone", 25000.0);
        productPrices.put("Headphones", 1500.0);
        productPrices.put("Mouse", 500.0);

        // LinkedHashMap to maintain order of items added
        LinkedHashMap<String, Double> cart = new LinkedHashMap<>();
        cart.put("Phone", productPrices.get("Phone"));
        cart.put("Laptop", productPrices.get("Laptop"));
        cart.put("Mouse", productPrices.get("Mouse"));

        System.out.println("Items in cart (in order added):");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }

        // TreeMap to display items sorted by price
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            sortedByPrice.put(entry.getValue(), entry.getKey());
        }

        System.out.println("\nItems sorted by price:");
        for (Map.Entry<Double, String> entry : sortedByPrice.entrySet()) {
            System.out.println(entry.getValue() + " -> ₹" + entry.getKey());
        }
    }
}
