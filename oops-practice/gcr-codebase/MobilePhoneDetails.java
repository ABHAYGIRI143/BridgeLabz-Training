

class MobilePhone{
	String brand;
	String model;
	int price;


	MobilePhone(String brand,String model,int price){
		this.brand = brand;
		this.model = model;
		this.price = price;
	}
	
	public void display() {
		System.out.println("Brand of mobile : "+brand+"\n Model of mobile :"+model+"\n Price of mobile :"+price);
	}
	
}
public class MobilePhoneDetails {

	public static void main(String[] args) {
		MobilePhone mobile1 = new MobilePhone("VIVO", "VIVO V29", 30000);
		mobile1.display();
		
	}

}
