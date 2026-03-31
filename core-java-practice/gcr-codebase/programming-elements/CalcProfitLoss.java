public class CalcProfitLoss {
 public static void main(String args[]){

    // All the prices are in INR
    int costPrice = 129;
    int sellingPrice = 191;
    int profit = sellingPrice-costPrice;
    int profitPercentage = (profit*100)/costPrice;
    System.out.println("The Cost Price is INR "+costPrice+" and Selling price is INR " + sellingPrice);
    System.out.println("The Profit is INR "+ profit+" and the Profit Percentage is "+profitPercentage);
 }   
}
