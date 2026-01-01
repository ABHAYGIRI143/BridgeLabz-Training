
class Book{
	
	static String libraryName = "GLA Univeristy Library";
	String title;
	String author;
	final String ISBN;
	
	Book(String title,String author,String ISBN){
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}
	
	
	static void displyLibraryName() {
		System.out.println("Library name is "+libraryName);
	}
	
	
	void displayDetails() {
		System.out.println("Title: "+title+"\nAuthor"+author+"\nISBN: "+ISBN);
	}
	
}

public class LibraryManagementSystem {
	public static void main(String args[]) {
		Book b1 = new Book("Expert Java","Joshua Boluch","978-01346589");
		
		if(b1 instanceof Book) {
			System.out.println("b1 is instance of Book class");
		}
		
		Book.displyLibraryName();
		b1.displayDetails();
	}
}
