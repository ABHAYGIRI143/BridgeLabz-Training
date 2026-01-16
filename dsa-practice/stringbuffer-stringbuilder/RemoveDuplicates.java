import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;

public class RemoveDuplicates {
	public static void main(String args[]) throws IOException {
		
		BufferedReader  br= new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().split(" ")[0];
		
		StringBuilder sb = new StringBuilder();
		
		
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }
		
        System.out.println("String after removing the duplicates");
        System.out.println(sb);
		
		
		
		
	}
}
