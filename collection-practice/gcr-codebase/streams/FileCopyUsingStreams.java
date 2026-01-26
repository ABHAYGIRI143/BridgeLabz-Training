import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class FileCopyUsingStreams {

    public static void main(String[] args) {

        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        File src = new File(sourceFile);

        // Check if source file exists
        if (!src.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        try (
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile)
        ) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while copying the file.");
            e.printStackTrace();
        }
    }
}
