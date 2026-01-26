import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

// 🔹 Writer Thread
class WriterThread extends Thread {

    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread";

            pos.write(message.getBytes());
            pos.close(); // important to signal end of data

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 🔹 Reader Thread
class ReaderThread extends Thread {

    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            pis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 🔹 Main Class
public class PipedStream{

    public static void main(String[] args) {

        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // connect streams

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            reader.start();
            writer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
