class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;

    Item next;

    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}


class InventoryManagement {

    private Item head = null;

    // 🔹 Add at beginning
    void addAtBeginning(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);
        newItem.next = head;
        head = newItem;
    }

    // 🔹 Add at end
    void addAtEnd(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);

        if (head == null) {
            head = newItem;
            return;
        }

        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // 🔹 Add at specific position (1-based)
    void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos <= 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        Item temp = head;
        int count = 1;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            addAtEnd(id, name, qty, price);
            return;
        }

        Item newItem = new Item(id, name, qty, price);
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // 🔹 Remove item by ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory empty");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed");
            return;
        }

        Item curr = head;
        while (curr.next != null) {
            if (curr.next.itemId == id) {
                curr.next = curr.next.next;
                System.out.println("Item removed");
                return;
            }
            curr = curr.next;
        }

        System.out.println("Item not found");
    }

    // 🔹 Update quantity by ID
    void updateQuantity(int id, int newQty) {
        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // 🔹 Search by ID
    void searchById(int id) {
        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // 🔹 Search by Name
    void searchByName(String name) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found");
    }

    // 🔹 Total inventory value
    void calculateTotalValue() {
        double total = 0;
        Item temp = head;

        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: ₹" + total);
    }

    // 🔹 Display all items
    void displayInventory() {
        if (head == null) {
            System.out.println("Inventory empty");
            return;
        }

        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // 🔹 Sort by Item Name (Bubble Sort)
    void sortByName(boolean ascending) {
        if (head == null) return;

        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                    (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {
                    swapData(i, j);
                }
            }
        }
    }

    // 🔹 Sort by Price (Bubble Sort)
    void sortByPrice(boolean ascending) {
        if (head == null) return;

        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if ((ascending && i.price > j.price) ||
                    (!ascending && i.price < j.price)) {
                    swapData(i, j);
                }
            }
        }
    }

    // 🔹 Swap data (not nodes)
    private void swapData(Item a, Item b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    // 🔹 Helper
    private void displayItem(Item i) {
        System.out.println("ID: " + i.itemId +
                ", Name: " + i.itemName +
                ", Qty: " + i.quantity +
                ", Price: ₹" + i.price);
    }
}


public class InventoryManagementSystem {

    public static void main(String[] args) {

        InventoryManagement inv = new InventoryManagement();

        inv.addAtEnd(101, "Laptop", 5, 55000);
        inv.addAtBeginning(102, "Mouse", 20, 500);
        inv.addAtEnd(103, "Keyboard", 15, 1500);
        inv.addAtPosition(2, 104, "Monitor", 7, 12000);

        System.out.println("\n--- Inventory ---");
        inv.displayInventory();

        System.out.println("\n--- Update Quantity ---");
        inv.updateQuantity(101, 10);

        System.out.println("\n--- Search by Name ---");
        inv.searchByName("Mouse");

        System.out.println("\n--- Total Value ---");
        inv.calculateTotalValue();

        System.out.println("\n--- Sort by Price (Ascending) ---");
        inv.sortByPrice(true);
        inv.displayInventory();

        System.out.println("\n--- Remove Item ---");
        inv.removeById(103);
        inv.displayInventory();
    }
}
