import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    public static void main(String[] args) throws IOException{

        try (BufferedReader br = new BufferedReader(new FileReader("src\\info.txt"))) {

            String firstLine = br.readLine();
            if (firstLine != null) {
                System.out.println(firstLine);
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
