import java.util.*;

// ================= Custom Exception =================
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String msg) {
        super(msg);
    }
}

// ================= Fine Calculator Interface =================
interface FineCalculator {
    double calculateFine(int daysLate);
}

// Student fine calculation
class StudentFine implements FineCalculator {
    public double calculateFine(int daysLate) {
        return daysLate * 2.0;   // ₹2 per day
    }
}

// Staff fine calculation
class StaffFine implements FineCalculator {
    public double calculateFine(int daysLate) {
        return daysLate * 1.0;   // ₹1 per day
    }
}

// ================= Book =================
class Book {
    int id;
    String title;
    boolean isAvailable = true;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }
}

// ================= User (Base class) =================
class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// ================= Member (inherits User) =================
class Member extends User {
    FineCalculator fineCalculator;

    Member(int id, String name, FineCalculator fineCalculator) {
        super(id, name);
        this.fineCalculator = fineCalculator;
    }
}

// ================= Transaction =================
class Transaction {
    Book book;
    Member member;
    int daysLate;

    Transaction(Book book, Member member, int daysLate) {
        this.book = book;
        this.member = member;
        this.daysLate = daysLate;
    }

    void showFine() {
        double fine = member.fineCalculator.calculateFine(daysLate);
        System.out.println(member.name + " must pay ₹" + fine);
    }
}

// ================= Library =================
class Library {

    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();

    // Add book
    void addBook(Book b) {
        books.add(b);
    }

    // Register member
    void registerMember(Member m) {
        members.add(m);
    }

    // Issue book
    void issueBook(int bookId, Member member) throws BookNotAvailableException {
        for (Book b : books) {
            if (b.id == bookId && b.isAvailable) {
                b.isAvailable = false;
                System.out.println("Book issued: " + b.title);
                return;
            }
        }
        throw new BookNotAvailableException("Book not available!");
    }

    // Return book
    Transaction returnBook(int bookId, Member member, int daysLate) {
        for (Book b : books) {
            if (b.id == bookId) {
                b.isAvailable = true;
                System.out.println("Book returned: " + b.title);
                return new Transaction(b, member, daysLate);
            }
        }
        return null;
    }
}

// ================= Main =================
public class LibrarySystem {
    public static void main(String[] args) {

        Library library = new Library();

        Book b1 = new Book(1, "Java Programming");
        library.addBook(b1);

        Member student = new Member(1, "Abhay", new StudentFine());
        Member staff = new Member(2, "Ravi", new StaffFine());

        library.registerMember(student);
        library.registerMember(staff);

        try {
            library.issueBook(1, student);

            Transaction t = library.returnBook(1, student, 5);
            t.showFine();

        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
