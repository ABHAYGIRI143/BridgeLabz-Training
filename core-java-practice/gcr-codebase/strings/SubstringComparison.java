import java.util.Scanner;

public class SubstringComparison {

    public static void main(String[] args) {

        //create the scanner object
    	Scanner sc = new Scanner(System.in);

      
        System.out.print("Enter a string: ");
        String text = sc.next();   

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        
        String manualSubstring = createSubstring(text, start, end);

        
        String builtInSubstring = text.substring(start, end);

        // campare both strings
        boolean result = compareStrings(manualSubstring, builtInSubstring);

        //display strings
        System.out.println("\nSubstring using charAt()   : " + manualSubstring);
        System.out.println("Substring using substring(): " + builtInSubstring);

        if (result) {
            System.out.println("Both substrings are EQUAL");
        } else {
            System.out.println("Both substrings are NOT EQUAL");
        }

        //close the scanner object
        sc.close();
    }

    
    //  method used to create substring suing charAt() function
    public static String createSubstring(String str, int start, int end) {

        String result = "";

        for (int i = start; i < end; i++) {
            result = result + str.charAt(i);
        }

        return result;
    }

   // camapre  both strings either they are equal or not
    public static boolean compareStrings(String s1, String s2) {

        // If lengths are different, strings are not equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare character by character
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
