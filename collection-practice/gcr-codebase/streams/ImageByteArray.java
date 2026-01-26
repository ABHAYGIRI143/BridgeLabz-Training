import java.io.*;

public class ImageByteArray{

    public static void main(String[] args) {

        String sourceImage = "input.jpg";
        String outputImage = "output.jpg";

        try {
            // 🔹 Step 1: Read image file into byte array
            FileInputStream fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            fis.close();
            baos.close();

            System.out.println("Image converted to byte array.");
            System.out.println("Byte array size: " + imageBytes.length);

            // 🔹 Step 2: Write byte array back to image file
            ByteArrayInputStream bais =
                    new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImage);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            bais.close();
            fos.close();

            System.out.println("Byte array written back to image file.");

        } catch (IOException e) {
            System.out.println("Error occurred during image conversion.");
            e.printStackTrace();
        }
    }
}
