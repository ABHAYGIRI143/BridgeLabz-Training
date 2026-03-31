import java.util.*;
public class RotateString {
  public static void main(String args[]){

    //Create Scanner Object
   Scanner sc = new Scanner(System.in);
  
    //Inpuit two Strings
   String str1 = sc.next();
   String str2 = sc.next();

  //method call
  boolean check =  rotateString(str1,str2);

  System.out.println(check);

}

 public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
  }



