import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ErrorLineReader {

    public static void main(String[] args) {

        String filePath = "largefile.log";

        // Try-with-resources ensures proper closing
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(filePath, StandardCharsets.UTF_8))) {

            String line;

            while ((line = br.readLine()) != null) {
                // Case-insensitive check
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error while reading the file.");
            e.printStackTrace();
        }
    }
}
