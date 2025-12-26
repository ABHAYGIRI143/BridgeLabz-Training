import java.util.Scanner;

public class FrequentChar {
    public static void main(String[] args) {

        //Create Scanner Object
        Scanner sc=new Scanner(System.in);
        
        //Get user input
        System.out.print("Enter a string: ");
        String str=sc.nextLine();
        
        int[] freq=new int[256];
        char maxChar=str.charAt(0);
        
        int maxCount=0;
        for(char c:str.toCharArray()){
            freq[c]++;
            if (freq[c] > maxCount) {
                maxCount = freq[c];
                maxChar = c;
            }
        }

        System.out.println("Most Frequent Character: '" + maxChar + "'");
    
        //Close Scanner Object
        sc.close();
    }
}
