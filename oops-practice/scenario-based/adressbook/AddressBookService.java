import java.util.ArrayList;

public class AddressBookService {
	ArrayList <Contact> contacts = new ArrayList<Contact>();
		
	void add(Contact contact) {
		for(Contact c:contacts) {
			if((c.getFirstName().equals(contact.getFirstName()) && c.getPhoneNumber().equals(contact.getPhoneNumber())) || (c.getFirstName().equals(contact.getFirstName()) && c.getAddress().equals(contact.getAddress()))) {
				System.out.println("Contact is already saved");
				return;
			}
		}
		contacts.add(contact);
		System.out.println("Contact Added");
	}
	
	void delete(Contact contact) {
		for(Contact c:contacts) {
			if(c.getFirstName().equals(contact.getFirstName()) && c.getPhoneNumber().equals(contact.getPhoneNumber())) {
				contacts.remove(contact);
				System.out.println("Contact removed");
				return;
			}
		}
		System.out.println("Contact not found");
	}
	
	void displayContact() {
		for(Contact contact:contacts) {
			contact.displayContact();
		}
	}
	
	void update(String firstName,String phoneNumber,Contact contact) {
		for(Contact c:contacts) {
			if(c.getFirstName().equals(contact.getFirstName()) && c.getPhoneNumber().equals(contact.getPhoneNumber())) {
					contacts.remove(contact);
					System.out.println("Contact removed");
					add(contact);
					System.out.println("Contact Updated");
				return;
			}
		}
		System.out.println("Contact not found");
	}
	
	void searchByAddress(Contact contact) {
		for(Contact c:contacts) {
			if(c.getFirstName().equals(contact.getFirstName()) && (c.getAddress().equals(contact.getAddress()))) {
					contact.displayContact();
				return;
			}
		}
		System.out.println("Contact not found");
	}
}
