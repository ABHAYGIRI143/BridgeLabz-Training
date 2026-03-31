

class Book{
	public String ISBN;
	protected String title;
	private String author;
	
	 Book(String ISBN, String title, String author) {
	        this.ISBN = ISBN;
	        this.title = title;
	        this.author = author;
	    }

	    // Public setter for author
	    public void setAuthor(String author) {
	        this.author = author;
	    }

	    // Public getter for author
	    public String getAuthor() {
	        return author;
	    }
	
}

class EBook extends Book {

    double fileSize; // in MB

    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    void displayDetails() {
        System.out.println("ISBN: " + ISBN);        // public access
        System.out.println("Title: " + title);      // protected access
        System.out.println("Author: " + getAuthor()); // private via method
    }
}


public class BookLibrarySystem {

	public static void main(String[] args) {
	
		 EBook ebook = new EBook("978-0134685991","Effective Java","Joshua Bloch");

	        ebook.displayDetails();

	        // Modify private author using setter
	        ebook.setAuthor("J. Bloch");
	        System.out.println("Updated Author: " + ebook.getAuthor());
		
	}

}
