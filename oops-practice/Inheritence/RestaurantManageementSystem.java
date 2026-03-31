interface Worker{
	 void performDuties();
	}

class Person{
	String name;
	int id;
}

class Waiter extends Person implements Worker{
	
	
	Waiter(String name,int id){
		this.name=name;
		this.id=id;
		
	}
	
	public void performDuties() {
		System.out.println("My Duty is to serve food to the client ");
	}
	
}

class Chef extends Person implements Worker{
	
	Chef(String name,int id){
		this.name=name;
		this.id=id;
	}
	
	public void performDuties() {
		System.out.println("My Duty is to make food for the client ");
	}
}


public class RestaurantManageementSystem {
	public static void main(String args[]) {
		Chef chef1 = new Chef("Abhay", 1);
		Waiter worker1 =  new Waiter("manas",01); 
		
		chef1.performDuties();
		worker1.performDuties();
	}
}
