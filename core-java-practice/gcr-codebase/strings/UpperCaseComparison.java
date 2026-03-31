import java.util.Scanner;

public class UpperCaseComparison {

    public static void main(String[] args) {

        
    	//close the scanner object
    	Scanner sc = new Scanner(System.in);

      
       
        String text = sc.nextLine();   

       
        String userUpperCase = convertToUpperCase(text);

      
        String builtInUpperCase = text.toUpperCase();

        //campare both strings
        boolean isSame = compareStrings(userUpperCase, builtInUpperCase);

       

        if (isSame) {
            System.out.println("Result: Both strings are SAME");
        } else {
            System.out.println("Result: Both strings are DIFFERENT");
        }
        
        

        //close the scanner object
        sc.close();
    }

    // method to convert string to upper case string using charAt
    public static String convertToUpperCase(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Check if character is lowercase (a-z)
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);   // ASCII conversion
            }

            result = result + ch;
        }

        return result;
    }

    // method to camapre both strings
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
