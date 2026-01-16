import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReverseString {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        System.out.print("Enter text: ");
        String input = br.readLine();   // read String

        sb.append(input);               // append to StringBuilder

        System.out.println("Before reverse");
        
        System.out.println(sb);
        
        sb.reverse();
        
        System.out.println("After reverse");
        
        System.out.println(sb);
        
        System.out.println(sb.toString());
        
    }
}
