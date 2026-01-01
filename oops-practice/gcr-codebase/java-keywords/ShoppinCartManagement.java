
	
class Product{
	static int discount = 200;
	String productName;
	int price;
	int quantity;
	final String productId;
	
	Product(String productName,int price,int quantity,String productId ){
		this.productName =  productName;
		this.price = price;
		this.quantity =  quantity;
		this.productId =  productId ;
		displayDetail();
	}
	
	static void updateDiscount(int update) {
		discount = update;
	}
	
	void displayDetail() {
		System.out.println("Product name: "+productName+"\nPrice "+price+"\nQuantity "+quantity+"\nDiscount "+discount);
	}
	
}

public class ShoppinCartManagement {

	public static void main(String[] args) {
		Product p1 = new Product("Laptop", 50000, 2, "P001");
		Product.updateDiscount(2000);
		
		p1.displayDetail();
		

	}

}
