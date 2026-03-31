public class DisscountedPrice {
   public static void main(String args[]){
    
      //Fees us ub INR
    int fee = 125000;
    int discountPercent = 10;//discount is 10%;
    int discount = (fee/100) * discountPercent;
    int discountedfee = fee - discount;
    System.out.println("The discount amount is INR "+discount+" and the discounted fee is INR "+ discountedfee);
   } 
}
