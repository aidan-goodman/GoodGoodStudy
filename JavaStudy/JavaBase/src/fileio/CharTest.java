package fileio;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharTest {
    @Test
    public void readTest() throws IOException {
        File file = new File("Hello.txt");
        /*FileReader fileReader = new FileReader(file);

        int data = fileReader.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fileReader.read();
        }
        fileReader.close();*/

        /*FileReader fileReader = new FileReader(file);
        char[] charBuffer = new char[5];
        int length;
        while ((length = fileReader.read(charBuffer)) != -1) {
            for (int i = 0; i < length; i++) {
                //charBuffer.length的写法会导致最后传入缓存的字符没有全部覆盖倒数第二次的数组
                System.out.print(charBuffer[i]);
            }
            String str = new String(charBuffer, 0, length);
            //同理，不能直接进行Char[]到String的转换
            System.out.print(str);
        }
        fileReader.close();*/

        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter("hello1.txt");//是否追加内容，false为覆盖

        char[] chars = new char[5];
        int length;
        while ((length = fileReader.read(chars)) != -1) {
            fileWriter.write(chars, 0, length);
        }
        fileReader.close();
        fileWriter.close();

    }
}
