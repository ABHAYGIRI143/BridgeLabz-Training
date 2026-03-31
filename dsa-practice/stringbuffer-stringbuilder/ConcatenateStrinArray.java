import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConcatenateStrinArray {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arr[] = br.readLine().split(" ");
		
		StringBuilder sb= new StringBuilder();
		
		for(String str:arr){
			sb.append(str);
			sb.append(" " );
		}
		
		System.out.println(sb);
	}
}
