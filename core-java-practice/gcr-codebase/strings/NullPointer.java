public class NullPointer {

    public static void main(String[] args) {

        System.out.println("Calling method to generate exception:");
        generateException();

        System.out.println("\nCalling method to handle exception:");
        handleException();
    }

  
       //Method to generate NullPointerException
     
    public static void generateException() {

        String text = null;   // initializing variable to null

        // This line will generate NullPointerException
        System.out.println(text.length());
    }

    
     //  Method to handle NullPointerException using try-catch
   
    public static void handleException() {

        String text = null;   // initializing variable to null

        try {
            System.out.println(text.length()); // causes exception
        } 
        catch (NullPointerException e) {
            System.out.println("NullPointerException caught!");
            System.out.println("Reason: Attempting to access method on null object");
        } 
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught!");
        }
    }
}
