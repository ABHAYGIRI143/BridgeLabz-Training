import java.util.Scanner;

public class SquarePerimeter {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int PerimeterOfSquare=sc.nextInt();
        int LengthOfSide=PerimeterOfSquare/4;
        System.out.println("The length of the side is "+LengthOfSide+" whose perimeter is  "+PerimeterOfSquare);
        sc.close();
    }
}
