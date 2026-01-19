
class InvalidDetails extends Exception{
	public InvalidDetails(String message) {
		super(message);
	}
}

public class Contact{
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	protected String phoneNumber;
	protected String email;
	
	Contact(String firstName,String lastName,String city,String state,String phoneNumber,String email) throws InvalidDetails{
		if(phoneNumber.length()!=10 || !email.contains("@gmail.com")) {
			throw new  InvalidDetails ("Invalid Details");
		}
		
		this.firstName = firstName;
		this.lastName= lastName;
		this.city=city;
		this.state=state;
		this.phoneNumber=phoneNumber;
		this.email=email;
	}
	
	String  getFirstName() {
		return firstName;
	}
	
	String  getLastName() {
		return lastName;
	}
	
	String  getPhoneNumber() {
		return phoneNumber;
	}
	
	String  getEmail() {
		return email;
	}
	
	void setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	
	void setEmail(String email) {
		this.email=email;
	}
	
	
}
