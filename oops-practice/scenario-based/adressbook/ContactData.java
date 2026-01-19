import java.util.ArrayList;

public class ContactData {

    public static ArrayList<Contact> contactData = new ArrayList<>();

    static {
        Contact c1 = new Contact(
                "Abhay", "Giri",
                "Street 10", "Delhi",
                "Delhi",
                "9876543210",
                "abhay@gmail.com"
        );

        Contact c2 = new Contact(
                "Rahul", "Sharma",
                "MG Road", "Mumbai",
                "Maharashtra",
                "9123456789",
                "rahul@gmail.com"
        );

        contactData.add(c1);
        contactData.add(c2);
    }
}
