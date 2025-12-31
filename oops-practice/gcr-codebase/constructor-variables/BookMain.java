
 class Book{
	 String title;
	 String author;
	 int price;
	 
	 Book(){
		 title = "House of the dragon";
		 author = "Matt Smith";
		 price = 2000;
	 }
	 
	 Book(String title, String author ,int price){
		 this.title= title;
		 this.author= author;
		 this.price= price;
	 }
	 
	 public void display() {
		 System.out.println("The title of the book is : "+title+"\nThe author of the book : "+author+"\nPrice : "+price);
	 }
	 
 }

public class BookMain {
	public static void main(String args[]) {
		Book b1 = new Book();
		b1.display();
		
		Book b2 = new Book("Fly over mountains","Heily Smith",2000);
		b2.display();
	}
}
