import java.io.*;
import java.io.IOException;

public class IoException {
	public static void main(String arg[]) {
		try (BufferedReader br = new BufferedReader(new FileReader("src\\daata"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
        } 
		
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		catch (IOException e) {
            e.printStackTrace();
        }
	}
}
