
class Book{
	String title;
	String author;
	int price;
	
	 Book(String title, String author , int price) {
		this.title=title;
		this.author=author;
		this.price=price;
	}
	 
	 public void displayBookDetails() {
		 System.out.println("Title of the book "+title +" \n Author of the book is "+author+" \n Price of the book is "+price);
	 }
	
}

public class BookDetails {
	public static void main(String args[]) {
		Book b1 = new Book("Fly To Mountains","Abhay Giri" , 2000);
		b1.displayBookDetails();
	}
	
}
