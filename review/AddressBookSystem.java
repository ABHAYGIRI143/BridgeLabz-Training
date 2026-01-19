import java.util.ArrayList;

class InvalidInformaion extends Exception{
	public InvalidInformaion(String message) {
		super(message);
	}
}

class Contact{
	String firstName;
	String lastName;
	String city;
	String state;
	String phoneNumber;
	String email;
	
	Contact(String firstName,String lastName,String city,String state,String phoneNumber,String email) {
//		if(phoneNumber.charAt(0)=='9' || phoneNumber.length()!=10 || email.contains("@gmail.com")) {
//			new throw InvalidInformaion  ("Invaid Details");
//		}
		
		this.firstName = firstName;
		this.lastName= lastName;
		this.city=city;
		this.state=state;
		this.phoneNumber=phoneNumber;
		this.email=email;
	}
	
}

class AddressBook{
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	void add(String firstName,String lastName,String city,String state,String phoneNumber,String email) {
		Contact newContact = new Contact(firstName,lastName,city,state,phoneNumber,email);
		
		contacts.add(newContact);
		System.out.println("Contact added");
	}
	
}


public class AddressBookSystem {
	public static void main(String args[]) {
		AddressBook addressBook = new AddressBook();
		addressBook.add("Abhay", "Giri", "Lucknow", "Uttar Pradesh", "9161040303", "abhaygiri656@gmail.com");
	}
}
