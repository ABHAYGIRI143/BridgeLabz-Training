import java.util.ArrayList;

public class AddressBookMain {
	public static void main(String args[]) {
		
		
		ArrayList<Contact> contactData=ContactData.contactData;
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.add(contactData.get(1));
		addressBookService.add(contactData.get(1));
		addressBookService.add(contactData.get(0));
		addressBookService.displayContact();
		
		
	}
}	
