## 蓝桥杯普及题

### 用筛选法判断素数

**题目：**
用筛选法求0~N之间的素数

*输入：*
> N

*输出：*
> 0~N之间的所有素数，用回车进行分割

**思路：**
1. 直接使用 for()循环在遍历每一个数，使用封装好的判断方法进行判断即可
2. 使用素数打表的方式根据数据规模建立一个素数表，直接通过下标的进行输出即可
   
第一种方法思路较清晰，第二种方法简单易写

**代码：**
```java
import java.util.Scanner;

public class Main {
    static boolean judge(int x) {//素数判断函数
        boolean flag = true;//使用单一出口

        if (x <= 1) {
            flag = false;
        }

        for (int i = 2; i <= (int) Math.sqrt((double) x); i++) {//因子在2到其开根之间
            if (x % i == 0) {
                flag = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 1; i < N; i++) {
            if (judge(i)) {
                System.out.print(i + " ");
            }
        }
    }
    
}
```
