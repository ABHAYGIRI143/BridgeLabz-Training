public class PenDistribution {
 public static void main(String args[]){
    int noOfPens=14;
    int noOfStdents=3;
    int eachOneGet=noOfPens/noOfStdents;
    int remainingPens=noOfPens%noOfStdents;
    System.out.println("The Pen Per Student is "+ eachOneGet +" and the remaining pen not distributed is  "+remainingPens);
 }   
}
