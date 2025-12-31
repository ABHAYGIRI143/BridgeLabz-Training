
class Vehicle{
	String ownerName;
	String vehicleType;

	static int registrationfee=10000;

	Vehicle(String ownerName,String vehicleType) {
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
	}
	
	public void displayVehicleDetails() {
		System.out.println("Owner Name "+ownerName+"\nVehicle Type "+vehicleType+"\nRegistration fee "+registrationfee);
	}
	
	public static void updateRegistrationFee(int fee) {
		registrationfee=fee;
		System.out.println("New Registration Fee "+registrationfee);
	} 
	
}

public class VehicleRegistration {

	public static void main(String[] args) {
		Vehicle vh1 = new Vehicle("Abhay", "BMW");
		vh1.displayVehicleDetails();
		
		Vehicle.updateRegistrationFee(20000);
		
		vh1.displayVehicleDetails();

	}

}
