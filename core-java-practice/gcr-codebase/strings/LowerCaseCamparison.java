import java.util.Scanner;

public class LowerCaseCamparison {

    public static void main(String[] args) {

    	//Create Scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();   

        String userLowerCase = convertToLowerCase(text);

        
        String builtInLowerCase = text.toLowerCase();

        //campare string
        boolean result = compareStrings(userLowerCase, builtInLowerCase);

        if (result) {
            System.out.println("\nResult: Both strings are SAME");
        } else {
            System.out.println("\nResult: Both strings are DIFFERENT");
        }
        
        //Close Scanner Object
        sc.close();
    }

    
       //Method to convert string to lowercase using charAt()
     
    public static String convertToLowerCase(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Check if character is uppercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);  // ASCII conversion
            }

            result = result + ch;
        }

        return result;
    }

   
      // Method to compare two strings using charAt()
      
    public static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
