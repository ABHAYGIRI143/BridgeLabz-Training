import java.util.Scanner;
public class BmiCalc{
    public static void main(String[] args) {
        
        //create scanner object 
        Scanner sc = new Scanner(System.in);
        
        //take inputs weight in kilogram , height in centimeter
        double weight = sc.nextDouble();
        double heightCm = sc.nextDouble();
        double heightInMeter = heightCm / 100;
        double bmi=weight/(heightInMeter*heightInMeter);

        System.out.println("BMI is: " + bmi);

        //check whether he/she lie in underweight , normal weight , overweight ,  obese
        if(bmi<18.5)
            System.out.println("Underweight");
        else if (bmi<25)
            System.out.println("Normal weight");
        else if (bmi<40)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
  
        //close scanner object
        sc.close();
    }


}
