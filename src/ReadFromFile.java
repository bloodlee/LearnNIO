import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by yli on 1/19/16.
 */
public class ReadFromFile {

    private static int _1K = 1024;

    private static int _100 = 100;

    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("/home/yli/.bashrc");
        FileChannel fc = fin.getChannel();

        WritableByteChannel fout = Channels.newChannel(System.out);

        ByteBuffer buffer = ByteBuffer.allocate(_1K);

        int times = 0;
        while (true) {
            buffer.clear();

            int r = fc.read(buffer);
            if (r <= 0) {
                break;
            }

            buffer.flip();

            System.out.println();
            System.out.println("----------------------------");
            fout.write(buffer);
        }

        System.out.println("Done");
    }
}
