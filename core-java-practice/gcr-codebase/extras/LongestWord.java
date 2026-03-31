import java.util.*;

public class LongestWord {
    public static void main(String[] args) {

        //Create Sccanner Object
        Scanner sc = new Scanner(System.in);
        
        //Get user input
        String s = sc.nextLine();
        
        String[] parts = s.split(" ");
        String longest = "";
        for (String w : parts) {
            if (w.length() > longest.length()) longest = w;
        }
        System.out.println(longest);
    }
}
