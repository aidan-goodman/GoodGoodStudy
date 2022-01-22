package fileio;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTest {
    @Test
    public void sender() throws IOException {
        DatagramSocket dc = new DatagramSocket();
        String str = "我是UDP方式发送的导弹";
        byte[] data = str.getBytes();
        DatagramPacket dp = new DatagramPacket
                (data, 0, data.length, InetAddress.getLocalHost(), 9090);
        dc.send(dp);
        dc.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket dc = new DatagramSocket(9090);
        byte[] buffer = new byte[100];
        DatagramPacket dp = new DatagramPacket(buffer, 0, buffer.length);
        dc.receive(dp);
        System.out.println(new String(dp.getData(), 0, dp.getLength()));
        dc.close();
    }
}
