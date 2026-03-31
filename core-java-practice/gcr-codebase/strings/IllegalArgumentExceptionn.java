import java.util.Scanner;

public class IllegalArgumentExceptionn{

    public static void main(String[] args) {

    	//Create Scanner Object
        Scanner sc = new Scanner(System.in);

       
        String text = sc.next();

      
        handleException(text);

        //Close Scanner Object
        sc.close();
    }

    
       //Method to generate IllegalArgumentException
       
    public static void generateException(String text) {

        System.out.println("\nGenerating IllegalArgumentException...");
        // start index > end index
        String result = text.substring(5, 2); 
        System.out.println(result);
    }

   
      // Method to handle IllegalArgumentException

    public static void handleException(String text) {

        System.out.println("\nHandling IllegalArgumentException...");

        try {
            // start index > end index
            String result = text.substring(5, 2);
            System.out.println(result);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
            System.out.println("Error Message: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Caught Generic RuntimeException");
        }

        System.out.println("Program continues after exception handling.");
    }
}
