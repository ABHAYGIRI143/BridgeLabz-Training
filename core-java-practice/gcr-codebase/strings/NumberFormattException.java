import java.util.Scanner;

public class NumberFormattException {

    public static void main(String[] args) {

    	//Create Scanner Object
        Scanner sc = new Scanner(System.in);

        
        String text = sc.next();

      
        handleException(text);

        //Close Scanner Object
        sc.close();
    }

    
      // Method to generate NumberFormatException
      
    public static void generateException(String text) {

        System.out.println("\nGenerating NumberFormatException...");
        int number = Integer.parseInt(text); // Exception occurs here
        System.out.println("Extracted Number: " + number);
    }

      // Method to handle NumberFormatException
    
    public static void handleException(String text) {

        System.out.println("\nHandling NumberFormatException...");

        try {
            int number = Integer.parseInt(text); // May throw exception
            System.out.println("Extracted Number: " + number);
        }
        catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
            System.out.println("Error Message: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Caught Generic RuntimeException");
        }

       
    }
}
