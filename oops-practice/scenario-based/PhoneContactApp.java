import java.util.ArrayList;
import java.util.List;


class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}


class Contact {

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}


class ContactOrganizer {

    private List<Contact> contacts = new ArrayList<>();

    // Validate phone number
    private void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits.");
        }
    }

    // Check duplicate
    private boolean isDuplicate(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    // Add contact
    public void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        validatePhoneNumber(phoneNumber);

        if (isDuplicate(phoneNumber)) {
            System.out.println("Duplicate contact not allowed.");
            return;
        }

        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }

    // Delete contact
    public void deleteContact(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(c);
                System.out.println("Contact deleted.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Search contact
    public void searchContact(String keyword) {
        boolean found = false;

        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(keyword)
                    || c.getPhoneNumber().equals(keyword)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching contact found.");
        }
    }

    // Display all contacts
    public void showAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}


public class PhoneContactApp {

    public static void main(String[] args) {

        ContactOrganizer organizer = new ContactOrganizer();

        try {
            organizer.addContact("Rahul", "9876543210");
            organizer.addContact("Amit", "9123456789");

            // Invalid phone number
            organizer.addContact("Rohit", "12345");

        } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }

        organizer.addContact("Duplicate", "9876543210"); // duplicate

        System.out.println("\n--- All Contacts ---");
        organizer.showAllContacts();

        System.out.println("\n--- Search Contact ---");
        organizer.searchContact("Rahul");

        System.out.println("\n--- Delete Contact ---");
        organizer.deleteContact("9123456789");

        System.out.println("\n--- Final Contact List ---");
        organizer.showAllContacts();
    }
}




