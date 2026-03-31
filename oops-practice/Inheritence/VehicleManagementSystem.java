

interface Refuelable{
	void refuel();
}

class Vehicle{
	int maxSpeed;
	String model;
}

class ElectricVehicle extends Vehicle implements Refuelable{
	
	 ElectricVehicle(int maxSpeed,String model) {
		this.maxSpeed = maxSpeed;
		this.model = model;
	}
	
	public void refuel() {
		System.out.println("Charge your vehicle before it get discharged");
	}
	
}

class PetrolVehicle extends Vehicle implements Refuelable{
	
	 PetrolVehicle(int maxSpeed,String model) {
		this.maxSpeed = maxSpeed;
		this.model = model;
	}
	
	public void refuel() {
		System.out.println("Fill the tank");
	}
	
}

public class VehicleManagementSystem {
	public static void main(String args[]) {
		ElectricVehicle e1 = new ElectricVehicle(100,"E001");
		PetrolVehicle p1 = new PetrolVehicle(200, "P001");
		
		e1.refuel();
		p1.refuel();
	}

	
}
