## 蓝桥杯普及题

### 判断素数

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

```java
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

### 字符串I/O

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

```java
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

```java
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

```java
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
```java
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

### 判断回文数

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
```java
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
```java
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
```java
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

### 蚂蚁感冒

**题目：**
长100厘米的细长直杆子上有n 蚂蚁。它们的头有的朝左，有的朝右
每只蚂蚁都只能沿着杆子向前爬，速度是每秒1cm
当两只蚂蚁碰面时，它们会同时掉头往相反的方向爬行
这些蚂蚁中，有1只蚂蚁感冒了，并且在和其它蚂蚁碰面时，会把感冒传染给碰到的蚂蚁
请你计算，当所有蚂蚁都爬离杆子时，有多少只蚂蚁患上了感冒

*输入：*
第一行输入一个整数n($1<n<50$)，表示蚂蚁的总数
接着的一行是n个用空格分开的整数Xi($-100<X_i<100$)，Xi的绝对值，表示蚂蚁离开杆子左边端点的距离。正值表示头朝右，负值表示头朝左，数据中不会出现0值，也不会出现两只蚂蚁占用同一位置。其中，第一个数据代表的蚂蚁感冒了

*输出：*
要求输出1个整数，表示最后感冒蚂蚁的数目

*样例输入：*
>5
-10 8 -20 12 25

*样例输出：*
>3

**思路：**
* 每个蚂蚁速度相同，所以不存在后边的蚂蚁感冒追上前边蚂蚁的情况发生，而且与感冒的蚂蚁（叫做X）相对的一定会被感染
* 被感染的蚂蚁与X没有任何区别，那么掉头可以看作两只蚂蚁碰头后穿过继续走
* 当X传染给相对蚂蚁后，被传染的蚂蚁继续走的情况下就又会传染给与他相对的其他蚂蚁，反之也相同
* 那么可以分左右进行判断，对X以外的蚂蚁依次读入，判断是否与X相对，除了相对会被传染外还有跟随在X后边的蚂蚁，当有被X传染的蚂蚁就表示跟随X的蚂蚁也会被传染，需要将跟随的蚂蚁数量记录下来，最后判断是否需要添加

**代码：**
```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int first = scanner.nextInt();
        int sum = 1, next = 0;
        boolean flag = false;

        while (--N != 0) {
            int temp = scanner.nextInt();
            if (first > 0) {//当感冒的蚂蚁朝右
                if (Math.abs(temp) > first && temp < 0) {//与其相对时必感冒
                    flag = true;
                    sum++;
                } else if (temp < first && temp > 0) {//在其后边跟随的
                    next++;
                }
            }
            if (first < 0) {//感冒蚂蚁朝左
                if (Math.abs(temp) < Math.abs(first) && temp > 0) {//与其相对时必感冒
                    flag = true;
                    sum++;
                } else if (temp < first) {
                    next++;
                }
            }
        }
        sum += flag ? next : 0;
        System.out.println(sum);
    }
}
```

### 错误票据

**题目：**
某涉密单位下发了某种票据，并要在年终全部收回。每张票据有唯一的ID号，所有票据的ID号是连续的，但ID的开始数码是随机选定的。因为工作人员疏忽，在录入ID号的时候发生了一处错误，造成了某个ID断号，另外一个ID重号。通过编程，找出断号的ID和重号的ID
假设断号不可能发生在最大和最小号

*输入：*
要求程序首先输入一个整数N($N<100$)表示后面数据行数
接着读入N行数据,每行数据长度不等，是用空格分开的若干个(不大于100个)正整数(不大于100000)，请注意行内和行末可能有多余的空格，你的程序需要能处理这些空格
每个整数代表一个ID号。

*输出：*
要求程序输出1行，含两个整数m表示断号，n表示重号

*样例输入：*
>2
5 6 8 11 9
10 12 9

*样例输出：*
>7 9

**思路：**
主要解决的输入格式，因为是输入不同行，所以可以实例化A、B两个`Scanner`对象，用A获取每行，用B拆解A的每行数据，然后排序判断即可

**代码：**
```java
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();//抵消N后面的换行符
        int[] arr = new int[10000];
        int count = 0, interrupt = 0, repeat = 0;

        for (int i = 0; i < N; i++) {
            Scanner input = new Scanner(scanner.nextLine());//获取每行
            while (input.hasNext()) {//遍历每行数据
                arr[count++] = input.nextInt();
            }
        }
        Arrays.sort(arr, 0, count);

        for (int begin = arr[0], i = 0; i < count; i++) {
            if (begin != arr[i]) {
                if (arr[i] - arr[i - 1] == 2) {
                    interrupt = arr[i] - 1;
                    begin = arr[i];
                }
                if (arr[i] == arr[i - 1]) {
                    repeat = arr[i];
                    begin = arr[i];
                }
            }
            begin++;
        }
        System.out.println(interrupt + " " + repeat);
    }
}
```

### FJ的字符串

**题目：**
FJ在沙盘上写了这样一些字符串：
>A1  =  "A"
A2  =  "ABA"
A3  =  "ABACABA"
A4  =  "ABACABADABACABA"
··· ···

*输入：*
仅有一个数：N($N≤26$)

*输出:*
请输出相应的字符串$A_N$，以一个换行符结束

*样例输入：*
>3

*样例输出：*
>ABACABA

**思路：**
字符串变长，避免内存冗余的情况使用`StringBuilder`比较好，使用循环配合ASCII码即可，注意`StringBuilder`每次拼接返回的都是自身所以每次循环时保存一下之前的字符串(使用`char[]`数组节约空间)

**代码：**
```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        var sb = new StringBuilder();
        sb.append('A');
        for (int i = 1; i < N; i++) {
            char[] temp = sb.toString().toCharArray();//StringBuilder每次拼接返回自身，先保存一下
            sb.append((char) (65 + i)).append(temp);
        }
        System.out.println(sb);
    }
}
```

### 分解质因数

**题目：**
求出区间a,b($2≤a≤b≤10000$)中所有整数的质因数分解

*输入：*
输入两个整数a,b

*输出：*
每行输出一个数的分解，形如 k=a1*a2*a3···

*样例输入：*
>3 10

*样例输出：*
>3=3
4=2*2
5=5
6=2*3
7=7
8=2*2*2
9=3*3
10=2*5

**思路：**
1. 质因数分解，就是最后的因子全部变为质数，那这样还需要判断质数本身
2. 创建从a->b的循环，赋值于临时变量t，t可能重复分解，所以这里用while循环
3. 如果while循环判断不能进行时继续fori循环，直至`t==i`时说明最大的素数因子已然出现

**代码：**
```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = a; i <= b; i++) {
            int temp = i;
            System.out.print(temp + "=");//输出开头
            for (int j = 2; j <= temp; j++) {
                while (temp % j == 0 && temp != j) {//防止除数和被除数相等进入死循环
                    System.out.print(j + "*");
                    temp /= j;
                }
                if (temp == j) {//相等表示分解完毕
                    System.out.println(j);
                }
            }
        }
    }
}
```

### 合并链表

**题目：**
给出两个有序链表，将其合并为一个链表后仍然有序

**思路：**
使用递归对每一个节点进行比对总是返回较小值

**代码：**
```java
public class Test {
    public static void main(String[] args) {
        Node head1 = new Node(3);
        Node head2 = new Node(4);
        Node h1Next1 = new Node(5);
        Node h2Next1 = new Node(6);
        Node h1Next2 = new Node(7);
        Node h2Next2 = new Node(8);
        Node h1Next3 = new Node(10);
        head1.next = h1Next1;
        h1Next1.next = h1Next2;
        h1Next2.next = h1Next3;
        head2.next = h2Next1;
        h2Next1.next = h2Next2;
        merTwoList(head1, head2);
        Node temp = head1;
        for (int i = 0; i < 7; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static Node merTwoList(Node one, Node two) {
        if (one == null && two == null) {
            return null;
        }
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }

        Node head;
        if (one.data > two.data) {
            head = two;
            head.next = merTwoList(one, two.next);
        } else {
            head = one;
            head.next = merTwoList(two, one.next);
        }
        return head;
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
```

### 打乱数组

**题目：**
编写一个程序，将数据中的所有数据随机打乱，确保每一个数据都被更换过

**思路：**
在循环中，使用生成随机数与当前所剩未打乱数据的个数相乘，找出一个符合数组范围的随机数作为下标，将其与当前循环变量的值做下标的数据相调换

**代码：**
```java
public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int t = (int) (Math.random() * len--);//长度乘随机数确保每个值都被更换到
            int temp = arr[i];
            arr[i] = arr[t];
            arr[t] = temp;
        }
        for (int each : arr) {
            System.out.println(each);
        }
    }
}
```

### 等差公式吗？

**题目：**
给定一个无序数组，判断其是否是一个等差数列(要求时间复杂度为O<sub>n</sub>)

**思路：**
有时间复杂度的约束可以使用公式来考虑，遍历一遍找出其中的最大最小值然后求出差$d(d=\frac{max-min}{length-1})$，再遍历一遍判断每个值减去$min$后是否能整除$d$

**代码：**
```java
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = {2, 4, 6, 7, 10};
        var min = (int)Math.floor(Collections.min(Arrays.asList(arr)));
        var max = (int)Math.floor(Collections.max(Arrays.asList(arr)));
        var d = (max - min) / (arr.length - 1);
        boolean flag = true;
        for (Integer each : arr) {
            if (0 != (each - min) % d) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
```

### 字符串对比

**题目：**
给定两个仅由大写字母或小写字母组成的字符串(长度介于1到10之间)，它们之间的关系是以下四种情况之一：
>1. 两个字符串长度不等。比如Beijing和Hebei
>2. 两个字符串不仅长度相等，而且相应位置上的字符完全一致(区分大小写)，比如Beijing和Beijing
>3. 两个字符串长度相等，相应位置上的字符仅在不区分大小写的前提下才能达到完全一致(也就是说，它并不满足情况2)，比如  beijing和BEIjing
>4. 两个字符串长度相等，但是即使是不区分大小写也不能使这两个字符串一致。比如Beijing和Nanjing

编程判断输入的两个字符串之间的关系属于这四类中的哪一类，给出所属的类的编号

*输入：*
包括两行，每行都是一个字符串

*输出：*
仅有一个数字，表明这两个字符串的关系编号

*样例输入：*
>BEIjing
beiJing

*样例输出：*
>3

**思路：**
1. 四个条件相加就是全集，所以最后的条件4无需判断
2. 引用`String`类中的实用方法`.equals()`和`.compareToIgnoreCase()`
3. 定义一个num变量用来记录符合的条件，先判断长度，长度相同直接将num赋值为 4，然后进行2、3的判断

**代码：**
```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int num;
        if (str1.length() != str2.length()) {
            num = 1;
        } else {
            num = 4;
            if (str1.equals(str2)) {
                num = 2;
            }
            if (0 == str1.compareToIgnoreCase(str2)) {
                num = 3;
            }
        }
        System.out.println(num);
    }
}
```

### 完美的代价

**题目：**
回文串才是完美的
现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串
交换的定义是：交换两个相邻的字符
> 例如 mamad
第一次交换 ad : mamda
第二次交换 md : madma
第三次交换 ma : madam (回文！完美！)

*输入：*
第一行是一个整数N，表示接下来的字符串的长度($N≤8000$)
第二行是一个字符串，只包含小写字母

*输出:*
如果可能，输出最少的交换次数
否则输出`Impossible`

*样例输入:*
>5
mamad

*样例输出:*
>3

**思路：**
* 分支判断，先判断什么情况下不可能组成回文数：当出现奇数次字符的个数超过2次
* 剩下的情况一定能够组成回文数，模拟的时间复杂度太高，直接用字符串删除的方式判断
  * 判断第一个出现的字符最后一次出现是在什么位置，将二者直接删除，计算出字符从最后出现的位置到串尾需要换几次，累加后继续递归判断
  * 如果有个字符出现了奇数次，在几次删除后(也可能初始时)就只有这一个字符处于串首，这种情况直接舍掉，累加其对换到串中需要的次数
  * 最后字符串的长度小于等于2时无需调换，以此为递归出口

**代码：**
```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str = scanner.next();
        var arr = new char[N];
        arr = str.toCharArray();
        int oddCount = 0;

        int[] flagArr = new int[26];
        for (char c : arr) {
            flagArr[c - 'a']++;//记录每个字符出现的次数
        }
        for (int k : flagArr) {
            if (k % 2 != 0) {
                oddCount++;//记录出现奇数次字符的个数
            }
        }
        if (oddCount > 1) {
            System.out.println("Impossible");
        } else {
            System.out.println(getCount(str));
        }
    }

    static int getCount(String str) {//使用递归进行判断
        int count = 0;
        if (str.length() == 1 || str.length() == 2) {
            return count;//长度小于等于2时，无需移动
        }
        //取字符串第一个字符最后一次出现的位置
        int temp = str.lastIndexOf(str.charAt(0));
        if (temp == 0) {
            //恰好第一个数就是奇数，截取后面的继续判断
            count = (str.length() / 2) + getCount(str.substring(1));
            //假设将首位的唯一奇数放到中间了
        } else {
            //0号位字符和已找到temp位置的字符都移除,然后进行递归
            StringBuilder strBuilder = new StringBuilder(str);
            strBuilder.deleteCharAt(temp);
            strBuilder.deleteCharAt(0);
            count = str.length() - 1 - temp + getCount(strBuilder.toString());
        }
        return count;
    }
}
```

### 报时助手

**题目：**
给定当前的时间，请用英文的读法将它读出来
时间用时 h 和分 m 表示，在英文的读法中，读一个时间的方法是：
如果 m 为 0，则将时读出来，然后加上 "o'clock"，如 3:00 读作 "three  o'clock"
如果 m 不为 0，则将时读出来，然后将分读出来，如 5:30 读作 "five thirty"
时和分的读法使用的是英文数字的读法，其中 0~20 读作：
>0:zero,  1:  one,  2:two,  3:three,  4:four,  5:five,  6:six,  7:seven,  8:eight,  9:nine,  10:ten,  11:eleven,  12:twelve,  13:thirteen,  14:fourteen,  15:fifteen,  16:sixteen,  17:seventeen,  18:eighteen,  19:nineteen,  20:twenty, 30:thirty, 40:forty, 50:fifty
对于大于 20 小于 60 的数字，首先读整十的数，然后再加上个位数，如 31 首先读 30 再加 1 的读法，读作 "thirty one"
按上面的规则 21:54 读作 "twenty one fifty four"，9:07读作 "nine seven"，0:15 读作 "zero fifteen"

*输入：*
输入包含两个非负整数 h 和 m，表示时间的时和分。非零的数字前没有前导 0。h 小于 24，m 小于 60。

*输出：*
输出时间时刻的英文

*样例输入：*
>0 15

*样例输出：*
>zero fifteen

**思路：**
1. 先定义一个字符串数组存储既定输出（0~20）；两个变量：h,m 将两个分开判断
    * 无论 m 的值为任何数，h 并不会受影响（只是输出 `o'clock` 的不同）
    * h 在 0 和 24 之间，但其实字符串数组的大小只有 21，所以判断 h 是否小于 21，小于输出对应下标的字符串，否则先输出 `twenty` 然后 h-20，再输出 `s[h]`
2. 然后判断 m，当 `m==0` 时输出 `o'clock`，否则跟 h 一样同理判断，但 m 在 0~60 之间，所以在 20 之后进行每次 + 10 的区间判断
   
**代码：**
```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        String[] s = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        //处理时的输出
        if (h >= 21) {
            System.out.print("twenty");
            h = h - 20;
        }
        System.out.print(s[h] + " ");
        //处理分的输出
        if (m == 0) {
            System.out.print("o'clock");
        } else if (m < 21) {
            System.out.print(s[m]);
        } else if (m < 30) {
            System.out.print("twenty");
            m = m - 20;
            System.out.print(s[m]);
        } else if (m == 30) {
            System.out.print("thirty");
        } else if (m < 40) {
            System.out.print("thirty");
            m = m - 30;
            System.out.print(s[m]);
        } else if (m == 40) {
            System.out.print("forty");
        } else if (m < 50) {
            System.out.print("forty");
            m = m - 40;
            System.out.print(s[m]);
        } else if (m == 50) {
            System.out.print("fifty");
        } else if (m < 60) {
            System.out.print("fifty");
            m = m - 50;
            System.out.print(s[m]);
        }
    }
}
```

### 龟兔赛跑预测

**题目：**
一旦任意秒结束后兔子发现自己领先 t 米或以上，它们就会停下来休息 s 秒，对于不同的兔子，t，s 的数值是不同的，但是所有的乌龟却是不到终点不停止
然而有些比赛相当漫长，全程观看会耗费大量时间，而小华发现只要在每场比赛开始后记录下兔子的速度 v1/秒，乌龟的速度 v2/秒，以及兔子对应的 t、s值，以及赛道的长度l，就能预测出比赛的结果

*输入：*
输入只有一行，包含用空格隔开的五个正整数 v1、v2、t、s、l，其中数据范围为：$v1,v2≤100;t≤300;s≤10;l≤10000$且为v1、v2的公倍数

*输出：*
输出包含两行，第一行输出比赛结果：“T” 或 “R” 或 “D”，分别表示乌龟获胜，兔子获胜，或者两者同时到达终点
第二行输出一个正整数，表示获胜者（或者双方同时）到达终点所耗费的时间（秒数）

*样例输入：*
>10 5 5 2 20

*样例输出：*
>D
4

**思路：**
1. 分别为兔子和乌龟设置属性：当前时间和当前路程，只要二者都未到达终点便一直循环模拟
2. 当兔子超过乌龟t米时直接进行时间跳转到s秒之后的处理，可能存在不需s秒乌龟就到达终点，判断一下

**代码：**
```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v1, v2, t, s, l;
        v1 = scanner.nextInt();
        v2 = scanner.nextInt();
        t = scanner.nextInt();
        s = scanner.nextInt();
        l = scanner.nextInt();

        int timeT = 0;
        int timeR = 0;
        int sT = 0;
        int sR = 0;
        while (sT < l && sR < l) {//只要没有到达终点就一直循环
            if (sR - sT < t) {//兔子没超过位置就按秒模拟
                timeR++;
                timeT++;
                sR += v1;
                sT += v2;
            } else {//按s的时长相加
                timeR += s;
                timeT += s;
                sT += s * v2;
                if ((sT > l) && ((sT - l) / v2 > 0)) {//存在乌龟过线不需要s秒的情况
                    timeT -= (sT - l) / v2;
                    sT = timeT * v2;
                    break;
                }
            }
        }

        if (sT == sR) {
            System.out.println("D\n" + timeR);
        } else if (sT > sR) {
            System.out.println("T\n" + timeT);
        } else {
            System.out.println("R\n" + timeR);
        }
    }
}
```

### 数组替换

**题目：**
该函数将数组 b 的前 n 个元素追加到数组 a 的前 m 个元素后，假定数组 a 具有至少存放 m+n 个元素的空间
例如，如果数组 a 为{22,33,44,55,66,77,88,99}，数组 b 为{20,30,40,50,60,70,80,90}，则调用Add(a,5,b,3)后，将把数组 a 变为{22,33,44,55,66,20,30,40}
注意数组 b 并没有改变，而且数组 a 中只需改变 n 个元素。

*输入：*
第一行输入a、b数组的长度，第二、三行输入数组的元素，最后输入m、n表示a数组的m元素后替换为b数组的前n个元素

*输出：*
最后数组 a 中的元素，两个元素之间以逗号隔开
* 样例输入 *
>8 8
1 2 3 4 5 6 7 8
9 10 11 12 13 14 15 16
4 5

*样例输出：*
>1,2,3,4,9,10,11,12,13

**思路：**
将a数组长度设置为两数组长度的总和，操作后根据长度判断输出即可

**代码：**
```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int b[] = new int[n];
        int a[] = new int[m + n];// 注意数组大小
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int m1 = in.nextInt();
        int n1 = in.nextInt();
        int temp = m1;
        for (int i = 0; i < n1; i++) {
            a[temp++] = b[i];
        }
        if (m - m1 < n1)
            m = m1 + n1;// 改变之后 a 数组的大小
        for (int i = 0; i < m - 1; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.print(a[m - 1]);
    }
}
```

### 质数的积

*此题考查模除公式的应用*
>(a+b) mod n=((a mod n)+(b mod n)) mod n;
(a - b) mod n=((a mod n)-(b mod n)+ n) mod n;
ab mod n =(a mod n)(b mod n) mod n;

**题目：**
算出前 n 个质数的乘积(只要算出这个数模上 50000 的值)

*输入：*
仅包含一个正整数 n，其中 n< =100000

*输出:*
输出一行，即前 n 个质数的乘积模 50000 的值

*样例输入*
>1

*样例输出:*
>2

**思路：**
使用计数器进行N个数的判断，是质数与积相乘取余即可

**代码：**
```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int i = 2, count = 0;
        long product = 1;
        while (count < N) {//从2开始遍历，等计数器到N时停止循环
            boolean flag = true;

            for (int j = 2; j * j <= i; j++) {//判断质数的另一种方式
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                product = product * i % 50000;
                count++;
            }
            i++;
        }
        System.out.println(product);
    }
}
```

### 乘法运算

**题目：**
从键盘读入 2 个 100 以内的正整数，进行乘法运算并以竖式输出
*样例输入：*
16  8
*样例输出：*
```
  16
×  8
━━━━
 128
```
8×16=128，则第四行 128 右侧对准个位输出
再例如：87x76
```
  87
× 76
━━━━
 522
609
━━━━
6612
```
*输入：*
输入只有一行，是两个用空格隔开的数字，均在 1~99 之间

*输出：*
输出为 4 行或 7 行，符合乘法的竖式运算格式(乘号和下划线为特殊符号)

** 思路：**
1. 首先输出 "x" 和 "━━━" 此类的特殊字符，都应该从题目中复制，要不然出错
2. 因为输出需要对齐，空格不能适用于多种状况，所以采用 "%nd" 的方式输出
3. 输出为 4 或 7 行，主要是根据乘数是否为两位数决定，所以要设置一个 b>=10 的判断语句
4. 如果乘数的个位是 0 那么直接输出 "00" 即可

** 代码：**
```java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.printf("%4d\n×%3d\n", a, b);
        System.out.println("━━━");
        if (b >= 10) {
            if (b % 10 == 0) {
                System.out.println("00");
            } else {
                System.out.printf("%4d\n", (b % 10) * a);
            }
            System.out.printf("%3d\n━━━\n%4d\n", (b / 10) * a, a * b);
        }
    }
}
```

### 五次方数

**题目：**
对一个数十进制表示时的每一位数字乘五次方再求和，会得到一个数的五次方数
例如：1024 的五次方数为 1+0+32+1024=1057
有这样一些神奇的数，它的五次方数就是它自己，而且这样的数竟然只有有限多个
从小到大输出所有这样的数

**思路：**
因为是有限数，所以首先要判断它的边界
* 上边界：十进制数中最大的是 9，而 9<sup>5</sup>=59049, 是一个五位数，那最大不会超过每一位都为 9 时的五次方数，也就是 5*9<sup>5</sup>=295245，而当位数是6或者大于6的时候，不论每一位的数是几，它本身的五次方数永远不会超过这个数本身，就没有了相等的可能，所以 295245 是理论上的最大值，这里的边界用实际上最大的六位数 999999 来表示
* 下边界：0，1 不符合条件，所以可以直接从两位数开始，下边界为 10

**代码：**
```java
public class Test {
    public static void main(String[] args) {
        for (int i = 10; i < 999999; i++) {
            int t1 = i % 10, t2 = i / 10 % 10, t3 = i / 100 % 10, t4 = i / 1000 % 10, t5 = i / 10000 % 10, t6 = i / 100000;
            if (Math.pow(t1, 5) + Math.pow(t2, 5) + Math.pow(t3, 5)
                    + Math.pow(t4, 5) + Math.pow(t5, 5) + Math.pow(t6, 5) == i) {
                System.out.println(i);
            }
        }
    }
}
```
