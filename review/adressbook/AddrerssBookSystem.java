import java.util.ArrayList;

public class AddrerssBookSystem {
	
	
public static void main(String args[]) {
	AddressBookData contactData = new AddressBookData ();
	ArrayList <Contact>  data= contactData.ct;
	
	Service service = new Service();
//	service.add(data.get(0));
//	
//	try {
//
//		service.updateContact("Abhay","Giri","Lucknow","Uttar Pradesh","9161040321","abhay@gmail.com");
//			
//	}
//	
//	catch(InvalidDetails e) {
//		System.out.println(e.getMessage());
//	}
	
	service.deleteContact("Abhay", "giri");
		
	}
}
