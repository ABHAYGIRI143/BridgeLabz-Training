

class PalindromeChecker{
	
	String str;
	
	public PalindromeChecker(String str) {
		this.str = str;
	}
	
	public void check() {
		
		boolean isPalindrome = true;
		String str1 = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = str1.length() - 1;

        while (left < right) {
            if (str1.charAt(left) != str1.charAt(right)) {
            	System.out.println(str1.charAt(left)+" "+str1.charAt(right));
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome)
            System.out.println(str+" is Palindrome");
        else
            System.out.println(str+ " is not Palindrome");
    
	}
}
public class CheckPalindrome {
	public static void main(String args[]) {
		
		PalindromeChecker str1 =  new PalindromeChecker("A man a plan a canal Panama");
		str1.check();
	}
}
