package fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("GitHub.jpg");
        File file2 = new File("github2.jpg");
        file2.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        byte[] bytes = new byte[99];
        int length;
        while ((length = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, length);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
