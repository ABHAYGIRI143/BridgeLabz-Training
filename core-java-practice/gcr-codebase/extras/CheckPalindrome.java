
import java.util.Scanner;

public class CheckPalindrome {
      
    //method to check whether string is palindrome
    public static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
    
    //method to display result
    public static void displayResult(String str, boolean result) {

        if (result) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is not a Palindrome");
        }
    }

    public static void main(String[] args) {
         
         //Create Scanner Object
         Scanner sc = new Scanner(System.in);
        String input =  sc.nextLine();
       
        boolean result = isPalindrome(input);
        displayResult(input, result);

        //Create Scanner Object
        sc.close();
    }
}

