import java.util.Scanner;

public class CalcTotalPrice {
 public static void main(String args[]){
    
    Scanner sc = new Scanner(System.in);
    int unitPrice = sc.nextInt();
    int quantity = sc.nextInt();
    int totalPrice = unitPrice*quantity;
    System.out.println("The total purchase price is "+totalPrice+ " if the quantity "+quantity+" and unit price is "+unitPrice);
    sc.close();
}   
}
