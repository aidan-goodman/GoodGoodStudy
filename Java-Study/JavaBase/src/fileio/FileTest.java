package fileio;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        /*File file=new File(".\\hello.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        }
        boolean isDel =file.delete();
        if (isDel){
            System.out.println("删除成功");
        }*/

        /*File file = new File(".");
        String[] strings = file.list();
        for (String str :
                strings) {
            if (str.contains(".jpg")) {
                System.out.println(str);
            }
        }*/

        File file = new File(".");
        File dir = file.getCanonicalFile();
        printFileName(dir, 1);
    }

    private static void printFileName(File dir, int level) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 1; i < level; i++) {
            stringBuilder.append("  ");
        }
        System.out.print(stringBuilder.toString() + dir.getName());
        if (dir.isDirectory()) {
            System.out.println("//");
        } else {
            System.out.println();
        }
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file :
                    files) {
                printFileName(file, level + 1);
            }
        }
    }
}
