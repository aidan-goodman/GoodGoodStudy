## 蓝桥杯普及题

### 用筛选法判断素数

**题目：**
用筛选法求 0~N 之间的素数

*输入：*
> N

*输出：*
> 0~N 之间的所有素数，用回车进行分割

**思路：**
1. 直接使用 for() 循环在遍历每一个数，使用封装好的判断方法进行判断即可
2. 使用素数打表的方式根据数据规模建立一个素数表，直接通过下标的进行输出即可

**代码：**
```java{.line-numbers}
import java.util.Scanner;

public class Main {
    static boolean judge(int x) {// 素数判断函数
        boolean flag = true;// 使用单一出口

        if (x <= 1) {
            flag = false;
        }

        for (int i = 2; i <= (int) Math.sqrt((double) x); i++) {// 因子在 2 到其开根之间
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

### 字符串的输入输出

**题目：**

*输入：*
首先输入一个不大于 100 的整数 N；
之后输入大于 N 行的字符串，字符串可以包含空格；
字符串个数不大于 1000。

*输出：*
前 N 行按原样输出；后边的字符串按空格或回车以每行的形式输出且每行之间输出一个空行

**思路：**
按行输入那就要用到 `nextline()`, nextline 不同于 next 的一点就是：next 读取到空格就结束；nextline 读取到换行结束
输出的字符串大于 N,所以还需要使用 `hasnext()` 方法来判断不明确的输入

**代码：**
```java{.line-numbers}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();//截取输入N之后的换行符

        for (int i = 0; i < N; i++) {
            String str = scanner.nextLine();
            System.out.println(str);//获取整行直接输出
        }

        while (scanner.hasNext()) {//还有输入在进行
            String s = scanner.next();
            System.out.println(s);
        }
    }

}
```

### 蛇形矩阵

**题目：**
蛇形矩阵是由 1 开始的自然数依次排列成的一个矩阵上三角形。

*输入*
本题有多组数据，每组数据由一个正整数 N 组成。（N 不大于 100）

*输出*
对于每一组数据，输出一个 N 行的蛇形矩阵。两组输出之间不要额外的空行。矩阵三角中同一行的数字用一个空格分开。行尾不要多余的空格

*输入样例*
>5

*输出样例*
>1 3 6 10 15
2 5 9 14
4 8 13
7 12
11

**思路：**
首先要搞清楚输出的规律
1. 输出的行数以 N-1 递减
2. 每列第一个数为 1 开始差为 +1 的等差数列
3. 每行为 2 开始差为 +1 的等差数列
4. 根据 2、3 条可以将行差与列差关联起来，然后双重循环嵌套

**代码：**
```java{.line-numbers}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int row = 1, subR = 1;//row为每行的首元素，subR为每行首元素的差
        for (int i = N; i >= 0; i--) {//反向遍历方便控制列数
            int column = row, subC = subR + 1;//每列首元素为每行的首元素，列差为行差+1
            for (int j = 0; j < i; j++) {
                System.out.print(column);

                if (j != i - 1) {//注意行尾空格
                    System.out.print(" ");
                }

                column += subC;
                subC++;
            }
            System.out.println();
            row += subR;
            subR++;
        }
    }

}
```

### DNA
**题目：**
输入包含多组测试数据，根据输入的组数和每组的数据打印出目标图形

*输入：*
第一个整数N(N<=15)表示组数，每组数据包含两个整数a,b;其中a(3<=a<=39)表示一个单位的DNA串的行数，恒为奇数。b(1<=b<=20)表示重复度

*输出：*
输出DNA的形状，每组输出间有空行

*样例输入：*
>２
>3 1
>5 4

*样例输出：*
```ditaa {cmd=true args=["-E"]}
X X
 X
X X

X   X
 X X
  X
 X X
X   X
 X X
  X
 X X
X   X
 X X
  X
 X X
X   X
 X X
  X
 X X
X   X
```

**思路：**
* 每组分布是有规律的：
  * X的分布：`row == column || row == a - column - 1`
  * 空格的分布：`row > column || row < a - column - 1`
* 根据分布规律将每个字符存入a行a列的字符数组中，然后根据组数进行输出

**代码：**
```java{.line-numbers}
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//读取组数

        while (0 != N--) {//设置N组数据的循环
            int a, b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            char[][] map = new char[a][a];//建立一个a行a列的字符数组
            //根据分布规则进行赋值
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    if (i == j || i == a - j - 1) {
                        map[i][j] = 'X';
                    } else if (i > j || i < a - j - 1) {
                        map[i][j] = ' ';
                    } else {//出现两个X之后的字符赋予N，这样的目的是输出时有所判断不会输出多余的空格
                        map[i][j] = 'N';
                    }
                }
            }

            for (char c : map[0]) {//输出第一行，第一行只可能为X或空格
                System.out.print(c);
            }
            System.out.println();
            for (int i = 0; i < b; i++) {//根据重复度从第二行开始输出
                for (int j = 1; j < a; j++) {
                    for (char tempC : map[j]) {
                        if (tempC != 'N') {//输出每行不为N的字符
                            System.out.print(tempC);
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

}
```

### IP 判断

**题目：**
判断一个IP字符串的合法性。合法的IP是这样的形式：A.B.C.D,其中 A、B、C、D 均为位于[0, 255]中的整数
为了简单起见，我们规定这四个整数中不允许有前导零存在，如001这种情况

*输入：*
输入由多行组成，每行是一个字符串，输入由“End of file”结束

*输出：*
对于每一个输入，单独输出一行，如果该字符串是合法的IP，输出Y,否则，输出N

*样例输入：*
>1.2.3.4
a.b.c.d
267.43.64.12
12.34.56.bb
210.43.64.129
-123.4.5.6

*样例输出：*
>Y
N
N
N
Y
N

**思路：**
1. 通过字符串获取一行用`split()`方法根据'.'进行分割成字符串数组
2. 判断时需要将字符串转换为`Int`型，可以使用`Integer.parseInt(String s)`的方法，但如果不全是数字会报错，加一个异常抛出，如果捕获到异常说明不符合IP规范，无异常进行范围的判断

**代码：**

```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if ("End of file".equals(str)) {//遇到End of file程序结束
                break;
            }
            String[] arr = str.split("\\.");//分割使用转义字符的方式
            boolean flag = true;
            for (int i = 0; i < arr.length; i++) {
                try {
                    if (Integer.parseInt(arr[i]) <= 255 & Integer.parseInt(arr[i]) >= 0) {

                    } else {//不符合IP范围，令flag为false
                        flag = false;
                        break;
                    }
                } catch (Exception e) {//非数字转换出错，令flag为false
                    flag = false;
                    break;
                }

            }
            if (flag) {
                System.out.println('Y');
            } else {
                System.out.println('N');
            }
        }
    }

}
```

### Tom 数

**题目：**
正整数的各位数字之和被Tom称为Tom数
输入一个数N($N<2^{32}$),求N的Tom数

*输入：*
每行输入一个整数N

*输出：*
每行一个输出，对应N的各位数之和

*样例输入：*
>12345
56123
82

*样例输出：*
>15
17
10

**思路：**
使用字符串获取每行输入的N，使用`charAt()`的方式进行字符的遍历，遍历出的每个数字减去0的ASCII码获得这个数字本身的值相加即可

**代码：**

```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i)-'0';//这里的-'0'是减去0的ASCII码得到数字
            }
            System.out.println(sum);
        }
    }

}
```


