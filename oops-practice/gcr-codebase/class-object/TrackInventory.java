
class Item{
	String itemCode;
	String itemName;
	int itemPrice;
	
	Item(String itemCode,String itemName,int itemPrice){
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public void displayItemDetails() {
		System.out.println("Item Code is "+itemCode +"\nItem Price is "+itemPrice+" \nItem Name is "+itemName);
	}
}

public class TrackInventory {

	public static void main(String[] args) {
		Item item1 = new Item("AA23","Rice",200);
		item1.displayItemDetails();

	}

}
