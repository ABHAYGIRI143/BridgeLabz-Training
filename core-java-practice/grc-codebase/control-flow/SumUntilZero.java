import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {

        //create a scanner object
        Scanner sc = new Scanner(System.in);

        //intialize the total sum equlas to 0
        double totalSum = 0;

        //take the input from the user and add to the total sum until it enters 0
        while(true){
            double userInput=sc.nextDouble();
            if(userInput == 0) break;
            totalSum+= userInput;
        }

        System.out.println(totalSum);

        //close the scanner object
        sc.close();
            
    }
}
