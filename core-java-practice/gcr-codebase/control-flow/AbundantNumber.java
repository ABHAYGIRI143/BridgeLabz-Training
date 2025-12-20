import java.util.*;
public class AbundantNumber {
    public static void main(String[] args) {
       
        //create scanner object 
        Scanner sc = new Scanner(System.in);
        
        //take a number as input
        int n = sc.nextInt();
        int c = 0;
        
        for(int i = 1 ; i<n ; i++){
            if( n%i == 0 )c+=i;
        }
        if(c > n)System.out.println("It is an Abundant Number");
        else System.out.println("Not an abundant number");
    
        //close the scanner object
        sc.close();
    }
}
