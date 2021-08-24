package fileio;

import org.testng.annotations.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {
    @Test
    public void client() throws IOException {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, 8899);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，我是".getBytes());

        outputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[5];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            byteArrayInputStream.write(bytes, 0, length);
        }
        System.out.println(byteArrayInputStream.toString());
        System.out.println(socket.getInetAddress().getHostName());

        byteArrayInputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
