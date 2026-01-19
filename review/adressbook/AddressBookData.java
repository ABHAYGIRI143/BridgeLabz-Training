import java.util.ArrayList;

public class AddressBookData {

    static ArrayList<Contact> ct = new ArrayList<>();

    static {
    	try {
    		 ct.add(new Contact("Abhay", "Giri", "Lucknow", "Uttar Pradesh","9161040303", "abhay@gmail.com"));
    	        ct.add(new Contact("Shivam", "Singh", "Lucknow", "Uttar Pradesh", "9161040303", "shivam@gmail.com"));
    	        ct.add(new Contact("Abhay", "Giri", "Lucknow", "Uttar Pradesh", "9161040303", "abhay@gmail.com"));
    	}
       
    	catch(InvalidDetails e) {
    		System.out.println(e.getMessage());
    	}
    }

    public static void main(String[] args) {
    }
}
