package 算法入门;

import java.util.Scanner;

public class IP判断 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();//依据换行判断
            String arr[] = s.split("\\.");//用“ . ”进行判断将输入的字符隔开
            char dex = 'Y';
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].startsWith("0")) {//如果是0开始，之间跳出
                    dex = 'N';
                    break;
                }
                try//-----尝试，如果不是整数dex=‘N’，跳出
                {
                    if (Integer.valueOf(arr[i]).intValue() <= 255 &&
                            Integer.valueOf(arr[i]).intValue() >= 0) {//将arr【i】转换成整数判断范围
                        //空语句
                    } else {
                        dex = 'N';
                        break;
                    }
                } catch (Exception e) {
                    dex = 'N';
                    break;//字符会产生转换报错，所有只要出错的数直接按'N'进行输出
                }
            }
            System.out.println(dex);
        }
    }
}
