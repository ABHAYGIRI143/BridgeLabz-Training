
class Book {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;

    Book next;
    Book prev;

    Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}


class LibraryManagement {

    private Book head = null;
    private Book tail = null;

    // 🔹 Add book at beginning
    void addAtBeginning(int id, String title, String author, String genre, boolean available) {
        Book newBook = new Book(id, title, author, genre, available);

        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // 🔹 Add book at end
    void addAtEnd(int id, String title, String author, String genre, boolean available) {
        Book newBook = new Book(id, title, author, genre, available);

        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // 🔹 Add book at specific position (1-based)
    void addAtPosition(int position, int id, String title, String author, String genre, boolean available) {

        if (position <= 1) {
            addAtBeginning(id, title, author, genre, available);
            return;
        }

        Book temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(id, title, author, genre, available);
            return;
        }

        Book newBook = new Book(id, title, author, genre, available);

        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    // 🔹 Remove book by ID
    void removeById(int id) {

        if (head == null) {
            System.out.println("Library is empty");
            return;
        }

        Book temp = head;

        while (temp != null) {

            if (temp.bookId == id) {

                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                }
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Book removed successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found");
    }

    // 🔹 Search by title
    void searchByTitle(String title) {

        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found");
    }

    // 🔹 Search by author
    void searchByAuthor(String author) {

        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found");
    }

    // 🔹 Update availability status
    void updateAvailability(int id, boolean status) {

        Book temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found");
    }

    // 🔹 Display forward
    void displayForward() {

        if (head == null) {
            System.out.println("Library is empty");
            return;
        }

        Book temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // 🔹 Display reverse
    void displayReverse() {

        if (tail == null) {
            System.out.println("Library is empty");
            return;
        }

        Book temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // 🔹 Count total books
    int countBooks() {
        int count = 0;
        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // 🔹 Helper method
    private void displayBook(Book b) {
        System.out.println("ID: " + b.bookId +
                ", Title: " + b.title +
                ", Author: " + b.author +
                ", Genre: " + b.genre +
                ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        LibraryManagement lib = new LibraryManagement();

        lib.addAtEnd(101, "Java Programming", "James Gosling", "Education", true);
        lib.addAtBeginning(102, "Clean Code", "Robert Martin", "Programming", true);
        lib.addAtEnd(103, "Harry Potter", "J.K. Rowling", "Fantasy", false);
        lib.addAtPosition(2, 104, "Effective Java", "Joshua Bloch", "Programming", true);

        System.out.println("\n--- Library (Forward) ---");
        lib.displayForward();

        System.out.println("\n--- Library (Reverse) ---");
        lib.displayReverse();

        System.out.println("\n--- Search by Author ---");
        lib.searchByAuthor("Joshua Bloch");

        System.out.println("\n--- Update Availability ---");
        lib.updateAvailability(103, true);

        System.out.println("\nTotal Books: " + lib.countBooks());

        System.out.println("\n--- Remove Book ---");
        lib.removeById(101);

        System.out.println("\n--- Final Library ---");
        lib.displayForward();
    }
}
