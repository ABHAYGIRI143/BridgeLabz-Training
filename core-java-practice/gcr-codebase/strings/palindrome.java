import java.util.*;
public class palindrome {
    static boolean isPalindrome(String str) {
        int s=0,e=str.length()-1 ;
        
        while(s<e){
            if(str.charAt(s)!=str.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
    public static void main(String[]args){

        //Create Scanner Object
        Scanner sc=new Scanner(System.in);
        
        //user input
        String str=sc.nextLine();
        
        //Call Methods
        if(isPalindrome(str)){
            System.out.println("Is Palindrome");
        }else{
            System.out.println("Is Not Palindrome");
        }

        //Close Scanner Object
        sc.close();
    }
}
