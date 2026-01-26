import java.io.*;
import java.nio.charset.StandardCharsets;

public class UppercaseToLowercase {

    public static void main(String[] args) {

        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        // Try-with-resources for automatic closing
        try (
            FileReader fr = new FileReader(sourceFile, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(destinationFile, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {

            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("File copied successfully with lowercase conversion.");

        } catch (IOException e) {
            System.out.println("Error occurred while processing the file.");
            e.printStackTrace();
        }
    }
}
