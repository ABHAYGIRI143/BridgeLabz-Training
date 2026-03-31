import java.util.Scanner;

public class StringIndexOutOfBound {

    public static void main(String[] args) {

    	//Create Scanner Object
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.println("\nCalling method to generate exception:");
        generateException(text);

        System.out.println("\nCalling method to handle exception:");
        handleException(text);

        //Close Scanner Object
        sc.close();
    }

    
       //Method to generate StringIndexOutOfBoundsException
       
    public static void generateException(String text) {

        // Accessing index beyond string length
        int invalidIndex = text.length();  

        // This line will generate StringIndexOutOfBoundsException
        System.out.println(text.charAt(invalidIndex));
    }

    
      // Method to handle StringIndexOutOfBoundsException
     
    public static void handleException(String text) {

        try {
            int invalidIndex = text.length();
            System.out.println(text.charAt(invalidIndex));
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught!");
            System.out.println("Reason: Index accessed is outside string length");
        }
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught!");
        }
    }
}
