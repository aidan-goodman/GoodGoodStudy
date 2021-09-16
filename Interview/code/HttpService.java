import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Aidan on 2021/8/31 21:24
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

/*
题目要求：
不依赖任何第三方库或框架（只使用 jdk 里面包含的公开可用的类库），tomcat 属于第三方框架所以不要用，com.sun 下的也不要用，开发一个 http 服务：
做加法运算：计算参数 a 和参数 b 的算术和，在浏览器地址栏里输入 `http://localhost:port/add?a=4&b=7`，浏览器窗口中显示 11
做乘法运算：计算参数 a 和参数 b 的算术乘积，在浏览器地址栏里输入 `http://localhost:port/mult?a=4&b=7`，浏览器窗口中显示28
*/
public class HttpService {
    public static Integer result = 0;

    public static void main(String[] args) {
        try {

            // 监听端口号，只要是8888就能接收到
            ServerSocket ss = new ServerSocket(8888);

            // 实例化客户端，固定套路，通过服务端接受的对象，生成相应的客户端实例
            Socket socket = ss.accept();
            // 获取客户端输入流，就是请求过来的基本信息：请求头，换行符，请求体
            BufferedReader bd = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            /**
             * 接受HTTP请求，并解析数据
             */
            String requestHeader;
            if ((requestHeader = bd.readLine()) != null && !requestHeader.isEmpty()) {
                System.out.println(requestHeader);
                /**
                 * 方法处理代码
                 */
                int start = requestHeader.indexOf("?") + 3;
                int terminal = requestHeader.indexOf("&");
                String num1 = requestHeader.substring(start, terminal);
                int space = requestHeader.indexOf("HTTP") - 1;
                String num2 = requestHeader.substring(terminal + 3, space);
                System.out.println(num1 + num2);
                // 加法
                if (requestHeader.contains("add")) {
                    result = Integer.parseInt(num1) + Integer.parseInt(num2);
                }
                // 乘法
                else if (requestHeader.contains("mult")) {
                    result = Integer.parseInt(num1) * Integer.parseInt(num2);
                }
            }
            // 发送回执
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-type:text/html");
            pw.println();
            pw.println("<h1>" + result + "</h1>");

            pw.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
