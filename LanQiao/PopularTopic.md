## 蓝桥杯普及题

### 用筛选法判断素数

**题目：**
用筛选法求0~N之间的素数

*输入：*
> N

*输出：*
> 0~N之间的所有素数，用回车进行分割

**思路：**
1. 直接使用for()循环在遍历每一个数，使用封装好的判断方法进行判断即可
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

### 字符串的输入输出

**题目：**

*输入：*
首先输入一个不大于100的整数N；
之后输入大于N行的字符串，字符串可以包含空格；
字符串个数不大于1000。

*输出：*
前N行按原样输出；后边的字符串按空格或回车以每行的形式输出且每行之间输出一个空行

**思路：**
按行输入那就要用到`nextline()`, nextline不同于next的一点就是：next读取到空格就结束；nextline读取到换行结束
输出的字符串大于N, 所以还需要使用`hasnext()`方法来判断不明确的输入

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
蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。

*输入：*
本题有多组数据，每组数据由一个正整数N组成(N<=100)

*输出：*
对于每一组数据，输出一个N行的蛇形矩阵
两组输出之间不要额外的空行，行尾不要多余的空格
矩阵三角中同一行的数字用一个空格分开

*输入样例：*
>5

*输出样例：*
>1 3 6 10 15
2 5 9 14
4 8 13
7 12
11

**思路：**
首先要搞清楚输出的规律：
1. 输出每行的列数以N-1递减
2. 每列第一个数为1开始差为+1的等差数列
3. 每行为2开始差为+1的等差数列
4. 根据2、3条可以将行差与列差关联起来，然后双重循环嵌套

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
输出DNA的形状，每组输出间有空行，行尾没有多余的空格

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

```java{.line-numbers}
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
输入一个数N($N<2^{32}$)，求N的Tom数

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

```java{.line-numbers}
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

### 分糖果

**题目：**
有n个小朋友围坐成一圈，老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：
每个小朋友都把自己的糖果分一半给左手边的孩子。
一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数
反复进行这个游戏，直到所有小朋友的糖果数都相同为止
你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果

*输入：*
首先读入一个整数N($2<N<100$)，表示小朋友的人数
接着是一行用空格分开的N个偶数(每个偶数不大于1000，不小于2)

*输出：*
要求程序输出一个整数，表示老师需要补发的糖果数。

*样例输入：*
>3
2 2 4

*样例输出：*
>4

**思路：**
* 用数组的方式进行存储每人的糖果，分糖果时可以采用每人减半加后边人的一半，注意运算前先保存第一人的值
* 每个人手中的糖果数更新后进行奇数判断，进行相应操作

**代码：**
```java{.line-numbers}
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int count = 0;
        while (judge(arr) != true) {
            int frist = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i] / 2 + arr[i + 1] / 2;
                if (arr[i] % 2 != 0) {
                    arr[i]++;
                    count++;
                }
            }
            arr[N - 1] = arr[N - 1] / 2 + frist / 2;
            if (arr[N - 1] % 2 != 0) {
                arr[N - 1]++;
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean judge(int[] temp) {
        boolean flag = true;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != temp[0]) {
                flag = false;
            }
        }
        return flag;
    }
}
```

### 回文数的判断

**题目：**
本题要求你找到一些5位或6位的十进制回文数字
满足要求：该数字的各个数位之和等于输入的整数

*输入：*
一个正整数n($10<n<100$)，表示要求满足的数位和

*输出：*
若干行，每行包含一个满足要求的5位或6位整数
数字按从小到大的顺序排列
如果没有满足条件的，输出：-1

**思路：**
* 因为要对每位进行相加判断，用遍历的方式就效率太低了，要求的值为5/6位，可以嵌套三重循环，每层遍历1~9，若能够达到以下条件就输出
   * 五位：`2*a+2*b+c==n`那么就可以输出`a+b+c+b+a`
   * 六位同理
* 从1~9进行遍历，自然满足从小到大的排列
* 设置一个计数器，在没有符合条件的值出现时输出"-1"

**代码：**
```java{.line-numbers}
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (2 * i + 2 * j + k == N) {
                        System.out.println("" + i + j + k + j + i);
                        count++;
                    }
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (2 * i + 2 * j + 2 * k == N) {
                        System.out.println("" + i + j + k + k + j + i);
                        count++;
                    }
                }
            }
        }

        if (count == 0) {
            System.out.println(-1);
        }
    }
}
```

### 数字游戏

**题目：**
游戏的规则是这样的：栋栋和同学们一共n个人围坐在一圈。栋栋首先说出数字1。接下来，坐在栋栋左手边的同学要说下一个数字2。再下面的一个同学要从上一个同学说的数字往下数两个数说出来，也就是说4。下一个同学要往下数三个数，说7。依次类推。
为了使数字不至于太大，栋栋和同学们约定，当在心中数到k-1时，下一个数字从0开始数。例如，当k=13时，栋栋和同学们报出的前几个数依次为：
>1、2、4、7、11、3、9、3、11

游戏进行了一会儿，栋栋想知道，到目前为止，他所有说出的数字的总和是多少。
栋栋说出的数依次为1、7、9，和为17

*输入：*
输入的第一行包含三个整数N、K、T，其中N和K的意义如上面所述，T表示到目前为止栋栋一共说出的数字个数

*输出：*
输出一行，包含一个整数，表示栋栋说出所有数的和

**思路：**
* 栋栋一共说了T个数，所以只要把这T个数相加即可，无需管其他的数，已知T1为1，这样只需`for(i=1;i<t;i++)`执行T-1次即可
* 数字之间的差为+1的等差数列，这样可以找出规律求T2、T3···
  * 可以将所有的数看成N个人一组，总共T组，每组的指定报数就是就是上一组的指定数加当前组等差数列的和
  * 公式为`T(m)=(((a+a+n-1)*n/2)+T(m-1))%k;`

**代码：**
```java{.line-numbers}
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int T = scanner.nextInt();

        long a = 1, An = 1, sum = An;//注意int型会溢出
        for (int i = 0; i < T - 1; i++) {//已将首项加入sum中
            An = (((a + a + N - 1) * N / 2) + An) % K;//按组加差
            sum += An;
            a += N;//将首项值加N作为下一组的首项
        }
        System.out.println(sum);
    }
}
```

### 分核桃

**题目：**
有3个开发组，打算给每个组发一袋核桃要求是：
>* 各组的核桃数量必须相同
>* 各组内必须能平分核桃
>* 尽量提供满足1,2条件的最小数量

*输入:*
输入包含三个正整数 a、b、c表示每个组正在加班的人数，用空格分开($a,b,c<30$)

*输出；*
输出一个正整数，表示每袋核桃的数量

**思路：**
其实就是求最小公倍数，因为 a,b,c<30，所以核桃数量最多不会超过`Math.pow(30,3)`

**代码：**
```java{.line-numbers}
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        for (int i = 0; i < Math.pow(30, 3); i++) {
            if (i >= a && i >= b && i >= c) {
                if (i % a == 0 && i % b == 0 && i % c == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
```
