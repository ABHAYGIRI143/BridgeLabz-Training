class Book {
    String title;
    String author;
    double price;
    boolean available;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;	
        this.available = true;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is not available.");
        }
    }

    void display() {
        System.out.println(title + " by " + author + 
            " | Price: " + price + 
            " | Available: " + available);
    }

    public static void main(String[] args) {
        Book b = new Book("Java Programming", "James Gosling", 500);

        b.display();
        b.borrowBook();
        b.borrowBook();
    }
}
