import java.util.Scanner;

public class ArrayIndexOutOfBound {

    public static void main(String[] args) {

    	
    	//create the scanner object
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        String[] names = new String[n];

        System.out.println("Enter the names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

      
        handleException(names);

        //close the scanner object
        sc.close();
    }

    
    //   Method to generate ArrayIndexOutOfBoundsException
      
    public static void generateException(String[] arr) {

        System.out.println("\nGenerating ArrayIndexOutOfBoundsException...");
        System.out.println(arr[arr.length]); // Invalid index
    }

  
       //Method to handle ArrayIndexOutOfBoundsException
            
    public static void handleException(String[] arr) {

        System.out.println("\nHandling ArrayIndexOutOfBoundsException...");

        try {
            System.out.println(arr[arr.length]); // Invalid index
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            System.out.println("Error Message: " + e.getMessage());
        }


    }
}
