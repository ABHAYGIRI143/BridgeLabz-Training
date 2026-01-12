class Book {
    String title;

    Book(String title) {
        this.title = title;
    }
}

public class SmartShelf {

    // Insertion Sort by book title
    public static void insertionSort(Book[] books, int n) {

        for (int i = 1; i < n; i++) {

            Book key = books[i];
            int j = i - 1;

            // Compare titles alphabetically
            while (j >= 0 && books[j].title.compareToIgnoreCase(key.title) > 0) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Book[] readingList = new Book[6];

        readingList[0] = new Book("Algorithms");
        readingList[1] = new Book("Java Programming");
        readingList[2] = new Book("Data Structures");
        readingList[3] = new Book("Operating Systems");
        readingList[4] = new Book("Cloud Computing");
        readingList[5] = new Book("Artificial Intelligence");

        // Sort the reading list
        insertionSort(readingList, readingList.length);

        System.out.println("Sorted Reading List:");
        for (Book b : readingList) {
            System.out.println(b.title);
        }
    }
}
