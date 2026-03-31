
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}


abstract class LibraryItem implements Reservable {

    // Encapsulated fields
    private int itemId;
    private String title;
    private String author;

    // Borrower details (secured)
    private String borrowerName;
    private boolean isAvailable;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    // Interface methods
    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            this.borrowerName = borrowerName;
            this.isAvailable = false;
            System.out.println("Item reserved by: " + borrowerName);
        } else {
            System.out.println("Item is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

    // Encapsulated access to borrower data
    protected String getBorrowerName() {
        return borrowerName;
    }
}


class Book extends LibraryItem {

    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // days
    }
}


class Magazine extends LibraryItem {

    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // days
    }
}


class DVD extends LibraryItem {

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // days
    }
}


class LibraryService {

    public static void displayItemInfo(LibraryItem item) {
        System.out.println("\n--- Library Item Details ---");
        item.getItemDetails();
        System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
    }
}


public class LibraryManagementApp {

    public static void main(String[] args) {

        LibraryItem book = new Book(101, "Effective Java", "Joshua Bloch");
        LibraryItem magazine = new Magazine(102, "Time Magazine", "Editorial Team");
        LibraryItem dvd = new DVD(103, "Inception", "Christopher Nolan");

        LibraryService.displayItemInfo(book);
        book.reserveItem("Rahul");

        LibraryService.displayItemInfo(magazine);
        magazine.reserveItem("Anita");

        LibraryService.displayItemInfo(dvd);
        dvd.reserveItem("Amit");
    }
}
