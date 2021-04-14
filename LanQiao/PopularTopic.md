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
