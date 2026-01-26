import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UnbufferedFileCopy {

    public static void main(String[] args) {

        String source = "largefile.dat";
        String destination = "unbuffered_copy.dat";

        long startTime = System.nanoTime();

        try (
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination)
        ) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();

        System.out.println("Unbuffered Copy Time: "
                + (endTime - startTime) / 1_000_000 + " ms");
    }
}
