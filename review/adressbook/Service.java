import java.util.ArrayList;

public class Service{
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	void add(Contact contact) {

		contacts.add(contact);
		System.out.println("Contact added");
	}
	
	void updateContact(String firstName,String lastName,String city,String state,String phoneNumber,String email) throws InvalidDetails{
		String findName=firstName+lastName;
		
		if(contacts.size()==0) {
			System.out.println("Address Book is empty");
			return;
		}

		boolean present=false;
		for(Contact contact:contacts) {
			String name=contact.getFirstName()+contact.getLastName();
			if(name.equalsIgnoreCase(findName)) {
				contacts.remove(contact);
				present=true;
				break;
			}
	
		}
		
		if(!present) {
			System.out.println("not found");
			return;
		}
		
		else {
			Contact newContact = new Contact(firstName,lastName,city,state,phoneNumber,email);
			
			contacts.add(newContact);
			System.out.println("Contact updated");
		}
		
	}
	
	void deleteContact(String firstName,String lastName) {
	String findName=firstName+lastName;
		
		if(contacts.size()==0) {
			System.out.println("Address Book is empty");
			return;
		}

		boolean present=false;
		for(Contact contact:contacts) {
			String name=contact.getLastName()+contact.getLastName();
			if(name.equalsIgnoreCase(findName)) {
				contacts.remove(contact);
				System.out.println("Contact Removed");
				return;
			}
	
		}
		
		if(!present) {
			System.out.println("not found");
		}
	}
	
}
