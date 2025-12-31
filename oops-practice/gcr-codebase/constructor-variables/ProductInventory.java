

class Product{
	String productName;
	int price;
	static int totalProducts;
	
	public Product(String productName,int price) {
		this.productName = productName;
		this.price = price ;
		totalProducts++;
	}
	
	public void displayProductDetails() {
		System.out.println("Product name :"+ productName+"\nPrice "+price);
	}
	
	public static void displayTotalProdcuts() {
		System.out.println("Total Products are " + totalProducts);
	}
	
}

public class ProductInventory {

	public static void main(String[] args) {
		
		Product p1 = new Product("Gel", 200);
		Product p2 = new Product("Oil", 200);
	
		p1.displayProductDetails();
		Product.displayTotalProdcuts();
	}

}
