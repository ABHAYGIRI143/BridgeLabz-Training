import java.util.Scanner;

public class CharArrayComparison {

    public static void main(String[] args) {

    	//create the scanner object
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the text: ");
        String text = sc.next();   

      
        char[] userArray = getCharacters(text);

       
        char[] builtInArray = text.toCharArray();

        //campare both arrays
        boolean isSame = compareCharArrays(userArray, builtInArray);

       
        System.out.print("\nCharacters using user-defined method: ");
        displayArray(userArray);

        System.out.print("Characters using toCharArray():      ");
        displayArray(builtInArray);

        if (isSame) {
            System.out.println("\nResult: Both character arrays are SAME");
        } else {
            System.out.println("\nResult: Both character arrays are DIFFERENT");
        }

        //close the scanner object
        sc.close();
    }

    
     //  Method to return characters using charAt()
     
    public static char[] getCharacters(String str) {

        char[] result = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }

        return result;
    }

    
    //   Method to compare two character arrays
      
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    
    public static void displayArray(char[] arr) {

        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
