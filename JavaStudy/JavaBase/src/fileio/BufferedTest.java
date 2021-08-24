package fileio;


import java.io.*;

public class BufferedTest {
    public static void main(String[] args) throws IOException {
        File file = new File("GitHub.jpg");
        File file2 = new File("github2.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[99];
        int length;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
        }
        bufferedInputStream.close();//关闭外层缓冲流会自动关闭被其包裹的内部流
        bufferedOutputStream.close();
    }
}
