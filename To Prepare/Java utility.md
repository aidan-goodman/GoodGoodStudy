## Java语法操作

### 输入 输出

对字符串的获取可以采用`next()`和`nextline()`，用`hasNext()`或`hasNextline()`判断是否还有数据输入
`hasNext()`或`hasNextline()`在while循环中可能没啥区别，但`next()`和`nextline()`却大有不同
`next()`不能读取空格，换言之，读取到有效字符之后遇到空格就会停止，但`nextline()`以Enter结束，能存储对应格式的任何字符

#### 多行输入

存在输入多行，且每行输入的字符或数字个数不定的情况，这就需要将`hasnext()`和`nextline()`搭配使用
具体方法是实例化两个`Scanner`对象former和latter，其中latter的参数是former的`nextline()`，然后使用`hasnext()`判断获取到的行是否存在下一个输入
```java{.line-numbers}
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    scanner.nextLine();//抵消N后面的换行符
    int[] arr = new int[10000];
    int count = 0;

    for (int i = 0; i < N; i++) {
        Scanner input = new Scanner(scanner.nextLine());//获取每行
        while (input.hasNext()) {//遍历每行数据
            arr[count++] = input.nextInt();
        }
    }
```

#### 输入字符
Java中不提供`nextChar()`的方法，但可以使用`next().charAt(0)`

```java{.line-number}
Scanner sc = new Scanner(System.in);
char c= sc.next().charAt(0);
//将不空格的一串字符按数组存储：`sc.next().toCharArray();`

int n = sc.nextInt();
int m = sc.nextInt();
char[][] arr = new char[n][m];
for (int i = 0; i < n; i++) {
    arr[i] = sc.next().toCharArray();//读入字符串拆分成字符数组
}
```
#### 格式化输出
`String.format()`和`System.out.printf()`可以进行格式化的输出效果
`%4d`和`%-4d`的区别：`%4d`是靠右输出四位，不足用空格补齐；`%-4d`是靠左输出

输出N位小数，可以使用`DecimalFormat`对格式进行定义；或者使用`String.format(格式,浮点变量)`直接打印
```java
public static void main(String[] args) {
    float f= (float) 3.234567;
    //正常输出
    System.out.println(f);
    //采用类
    DecimalFormat df=new DecimalFormat("#0.00");
    System.out.println(df.format(f));
    //模仿C语言
    System.out.printf("%.2f\n",f);//printf支持和C语言相似的格式化输出
    //转换格式
    System.out.println(String.format("%.2f",f));
```
> 结果：2.35  2.35

### 循环的注意

#### 判断引用型

引用型在循环中的判断不能直接使用`==`,因为即便内容相等的两个数也有可能被引用的地址不相同，而`==`比较的就是引用的地址如下面这种情况：
```java
String str1 = "hello";
String str2 = "HELLO".toLowerCase();
//此时的str1和str2在内容是是相等的但进行等值判断是却会进行不等的运算
```

对引用型的数据统一使用`equals()`的方式进行判断：`if(s1.equals(s2)){···}`但注意如果`s1`的值是空的时候也会报错
所以可以使用`if(s1!=null && s1.equals(s2)){···}`进行判断

#### switch的用法

Java中的switch循环支持字符串的匹配，但不要忘记每个语句后面加`break;`

Java12之后的switch语句中支持使用`->`符号取代`:`进行自动跳出的case语句，如果一个case中要运行多个语句可以用`{}`括起来

### 数组的操作

#### 遍历数组

数组的遍历有三种方式：`for()`循环搭配索引、`for each`迭代每个元素(但无法获取索引)、转换成字符串输出
Java标准库提供的`Arrays.toString()`方法进行将整个数组转换为字符串直接打印输出，二维数组使用：`Arrays.deepToString()`
 ```java
 int[] arr={1,2,3,4,5,6,7,8};
 System.out.println(Arrays.toString(arr));
 ```
> 结果：[1, 2, 3, 4, 5, 6, 7]

#### 数组排序

使用Arrays中的sort方法可以对数组进行快速排序；若要实现降序排序可以使用`Collections.reverseOrder()`方法(仅对类起作用)
 ```java
 int[] arr = {1, 3, 6, 2, 4, 8, 7, 9};
 Arrays.sort(arr);
 
 Integer[] arr = {1, 3, 6, 2, 4, 8, 7, 9};
 Arrays.sort(arr, Collections.reverseOrder());
 for (int m : arr)
     System.out.print(m + " ");
 ```

#### 拷贝数组

可以直接使用数组自身的`.clone()`方法，因为数组是引用型，将数组放入方法或者类中很容易导致内外部操作互相影响，所以`.clone()`方法在这种场景下常用
```java
    int[] arr = {1, 4, 5, 2, 8, 12, 99, 345, 234, 6};
    int[] copy = arr.clone();

    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(copy));
```

系统提供的数组拷贝方法：`System.arraycopy(Object a, int begin_a, Object b, int begin_b, int length);`
```java
public static void main(String[] args) {
    int a[]={1,2,3,4};
    int b[]=new int[10];
    System.arraycopy(a,0,b,0,3);
    for (int n:b)
        System.out.print(n+" ");
}//这种方法可以进行自定义长度的拷贝
```
> 结果：1 2 3 0 0 0 0 0 0 0

将一个数组的一部分拷贝到另一数组中可以使用`Arrays.copyOf(object,length);`方法
```java
public static void main(String[] args) {
    int a[]={1,2,3,4};
    int b[]= Arrays.copyOf(a,3);
    for (int n:b)
        System.out.print(n+" ");
}
```
> 结果：1 2 3

### Arrays类

Arrays类提供很多使用的方法，常见的如下：
```java
Arrays.asList(Object[] a) //数组转换成List 
public static int binarySearch(Object[] a, Object key) //二分查找(仅支持有序)
public static boolean equals(Object[] a, Object[] a2)  //判断两数组内容是否一致
public static void fill(Object[] a, Object val)   //在a中所有位置填充val
public static void fill(Object[] a, int fromIndex, int toIndex, Object val)
//在[fromIndex,toIndex)中填充val

//其提供了三种排序比较方法：
public static void sort(Object[] a) //改进的快速排序（升序）
public static void sort(Object[] a, int fromIndex, int toIndex) //对[fromIndex,toIndex)升序排序
public static <T> void sort(T[] a, Comparator<? super T> c) //自定义比较器排序
```

### 字符串

#### String类

存入两个字符相同的string型时，两者的地址也相同(将后创建的地址指向前者，节约内存)；但是new String的两个不同对象的内容即便相同地址也不同
```java
public static void main(String[] args) {
    String a="asd";
    String b="asd";
    boolean t=a==b;
    String c=new String("iop");
    String d=new String("iop");
    boolean y=c==d;
    System.out.println(t);
    System.out.println(y);
}//==和！=是用来判断string对象地址是否相同的
```
> 结果：
> true
> false

判断string对象是否相同用自带的`.equals()`方法，同时还提供一种忽略大小写的判断方法`.equalsIgnoreCase()`
```java
public static void main(String[] args) {
    String a = "asd";
    String b = "asd";
    if (a.equals(b)) {
        System.out.println("==");
    } else {
        System.out.println("!=");
    }
    System.out.println(a.equalsIgnoreCase(b.toUpperCase()));
}
```
> 结果：==
> true

要想遍历string的字符内容，需要将其转换为字符数组
```java
public static void main(String[] args) {
    String a = "asd";
    char arr[] = a.toCharArray();
    for (char n : arr)
        System.out.print(n + " ");
}
```
> 结果：a s d

| 方法            | 目的                       |
| --------------- | -------------------------- |
| `contains()`    | 是否包含相应的字符或子串   |
| `trim()`        | 移除首位空白字符(\t,\r,\n) |
| `isEmpty()`     | 是否为空                   |
| `isBlank()`     | 是否为空白字符串           |
| `replace()`     | 替换字符(串)               |
| `join("?",arr)` | 用指定字符连接字符或字符串 |
| `split("?")`    | 分割字符串                 |

```java{.line-numbers}
public static void main(String[] args) {
    String s = "asdeGHAasDeFg";
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);//字符串转换为字符
    }
    //指定字符的查找
    s.indexOf('s');
    s.indexOf('s', 2);
    s.lastIndexOf('s');
    s.lastIndexOf('s', 6);
    String[] ss = s.split("s");//将字符串按指定字符分割

    String str1 = s.substring(2, 5);//截取start到end的子串，左闭右开
    char[] cs = s.toCharArray();//字符串转换为字符数组
    String str2 = s.toLowerCase();//将字符串转换为小写
    String sToL = s.toUpperCase();//将字符串转换为大写
    String sToU = String.valueOf(123);
    //将指定数据转换为字符串，也可加参数radio将其转换为radio进制的字符串
}
```

#### StringBuilder

StringBuilder对象被当作是一个包含字符序列的变长数组，在需要频繁更改字符串的场景下常用
```java
public static void main(String[] args) {
    var sb = new StringBuilder("String");
    sb.append("123");//每次返回添加后的自身，因此可以进行链式操作
    sb.append("456").append("789");
    sb.reverse();//反转
    sb.delete(3, 7);//删除索引从a开始到b的所有字符（左闭右开）
    sb.deleteCharAt(3);//删除索引为a的字符；
    sb.insert(4, "string");//参数字符插入到指定位置
}
```

#### StringJoiner

在String中有`join`方法进行使用特定字符连接字符串，但如果数据太多就不实用了
```java
public static void main(String[] args) {
    var sj = new StringJoiner(" +++ ", "Hello: ", "!");
    //初始化时参数默认是连接符，多个参数格式为(连接符，开头，结束)
    String[] strArr = {"Aidan", "Amy", "Bob", "Jack", "Jhon"};
    for (String each : strArr) {
        sj.add(each);
    }
    System.out.println(sj);
}
```
>结果：Hello: Aidan +++ Amy +++ Bob +++ Jack +++ Jhon!

### 边界处理

数组判空：`if(arr == null|| arr.length == 0)`
二维数组判空：`if(arr == null || arr.length == 0 || arr[0].length == 0)`
字符串判空：`if(str == null || str.equals(""))`

所有封装类的最大最小值都有其存在的方法： `Integer n=Integer.MAX_VALUE;`

浮点数的判断条件，因为浮点数的值往往没法准确进行显示，所以对数据较为精确的题目的判断条件要使用差的绝对值小于某个临界值的形式：`Math.abs(x-0.1)<0.00001`
有些数据的处理还要使用扩大1000(甚至更大)倍转换成`Long Long`形式，然后在输出的时候除以之前扩大的倍数

### 格式转换

程序运算时会进行自动转型，但这是由下向上转型，所有有些时候需要进行强制转型
最简单直接的是在变量前加(目标类型)，此方法只用于基本的数据类型，不支持String类型

String和其他基本数据类型的转换
可以使用`toString`将其他数据类型转换为String类，但这种方法只对包装类起作用(如：Integer)
使用String自带的valueOf()方法，支持将基本的数据类型转换
而将String转换为其他，可以用自带类的.parseXXX(string)方法
```java
Integer a=new Integer(100);
String s1=a.toString();//类自带的toString()方法
int i=99;
String s2=String.valueOf(i);//String自带的valueOf()方法
Integer b=Integer.parseInt(s2);//每个封装类类都有.parseXXX(String s)方法
```

### 快速排序

实用Arrays中的sort方法可以对数组进行快速排序
若要实现降序排序可以使用`Collections.reverseOrder()`方法(数组必须为Integer类)
```java
Integer[] arr = {1, 4, 5, 2, 8, 12, 99, 345, 234, 6};
Arrays.sort(arr);//默认排序
Arrays.sort(arr, Collections.reverseOrder());//反转
```

#### 比较器

使用Comparator类定义的比较器可以实现自定义排序
排序自定义类(结构体)时也可以使用comparable接口在类中直接覆写方法
```java{.line-numbers}
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        /*比较器排序
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });*/

        Person[] arr = new Person[]{new Person(12, "Aidan"),
                new Person(6, "John"),
                new Person(12, "Bob"),
                new Person(17, "Amy"),
                new Person(15, "Dave"),};

        /*比较器自定义排序类
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age != o2.age) {
                    return o1.age - o2.age;
                } else {
                    return o1.name.compareTo(o2.name);
                }
            }
        });*/
        Arrays.sort(arr, (o1, o2) -> {//比较器的简单写法
            if (o1.age != o2.age) {
                return o1.age - o2.age;//升序
            } else {
                return o1.name.compareTo(o2.name);//降序
            }
        });
        for (Person each : arr) {
            System.out.println(each.toString());
        }
    }
}

class Person {
    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "，年龄：" + age;
    }
}
```

### 大数类

大数类分为整型`BigInteger`和浮点型`BigDecimal`

定义BigInteger类型可以使用实例化类的方法，也可以使用BigInteger中的valueOf(数字/变量)
```java
BigInteger a = new BigInteger("3");
BigInteger b = BigInteger.valueOf(3);
int i = 788;
BigInteger c = BigInteger.valueOf(i);
```

大数的类是在java.math.*包里的，所以继承了math的所有方法，而运算也是使用方法来进行
```java
BigInteger a = new BigInteger("3");
BigInteger b = BigInteger.valueOf(-3);
int i = 788;
BigInteger c = BigInteger.valueOf(i);
BigInteger ad=a.add(c);
BigInteger sub=a.subtract(b);
BigInteger mul=a.multiply(b);
BigInteger div=c.divide(a);
BigInteger re=c.remainder(a);
BigInteger ab=b.abs();
System.out.println(ad);
System.out.println(sub);
System.out.println(mul);
System.out.println(div);
System.out.println(re);
System.out.println(ab);
```
> 结果：791 6 -9 262 2 3

BigDecimal使用`.scale()`表示小数位数
具体计算方法与整型差不读，但浮点型进行除法的时候可能会存在除不尽的情况，这样就可以对其进行精度上的取余
判断相等时可能小数位后面存在多个0这样虽然不影响大小但在操作的时候会导致大小不同，可以使用`compareTo()`方法

### Math类


可以求sqrt(平方根)、abs(绝对值)、max、min、pow(幂)、取整(ceil、floor、round)具体查阅API

输出一个随机数用random()方法
```java
public static void main(String[] args) {
    double c = Math.random();
    System.out.println(c);//输出一个0-1之间的随机数（double类型）
    int b = 100;
    int d = (int) (Math.random() * b + 1);//输出一个1-b之间的随机数
    System.out.println(d);
    int a = 50;
    int e = (int) (Math.random() * (b - a + 1) + a);// 输出一个a-b的随机数
    System.out.println(e);
}//+ 1 是因为random()最大取不到1,所以上限取整后就会少1
```

## 模板

### 公约公倍数

求最大公约数可以采用辗转相除法，就是两数的最大公约数就是较小数和两数余数的最大公约数
最小公倍数等于两数的乘积除最大公约数
```java
public class Test {
    static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);//辗转相除法，两数的最大公约数等于较小数与两数余数的最大公约数
    }
    static int lcm(int a,int b){
        return a*b/gcd(a,b);//最小公倍数等于两数相乘除最大公约数
    }
    public static void main(String[] args) {
        System.out.println(gcd(12,5));
        System.out.println(lcm(12,5));
    }
}
```

### 进制转换

在Integer对象中，常用的进制转换


| 十进制的转换对象 | 对应的方法和参数           | 返回值         |
| ---------------- | -------------------------- | -------------- |
| 数字转换字符串   | Integer.toBinaryString(n); | 二进制字符串   |
| 数字转换字符串   | Integer.toOctalString(n);  | 八进制字符串   |
| 数字转换字符串   | Integer.toHexString(n);    | 十六进制字符串 |
| 数字转换字符串   | Integer.toString(n, r);    | r进制字符串    |
| 字符串转换数字   | Integer.parseInt(str,r);   | r进制整数      |
```java
public static void main(String[] args) {
      int n=18;
      System.out.println(Integer.toBinaryString(n));//转换二进制
      System.out.println(Integer.toOctalString(n));//转换成八进制
      System.out.println(Integer.toHexString(n));//转换成十六进制
      System.out.println(Integer.toString(n,2));
      String s = "10101";
      System.out.println(Integer.parseInt(s,2));//回转为十进制
      // 判断十进制整数转换成二进制后“1”的个数
      System.out.println(Integer.bitCount(21));
  }
```

### 全排列

```java
static int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
static int ans = 0;
static void dfs(int k) {
    if (k >= 9) {//递归出口
        ans++;
    }
    for (int i = k; i < 9; i++) {
        int t = arr[k];
        arr[k] = arr[i];
        arr[i] = t;//将相邻的两位数互换
        dfs(k + 1);//互换下一个
        t = arr[k];
        arr[k] = arr[i];
        arr[i] = t;//回溯时更换回来，不影响下一次排列
    }
}

public static void main(String[] args) {
    dfs(0);
    System.out.println(ans);
}
```

### 判断闰年

```java
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n % 400 == 0 || (n % 4 == 0 && n % 100 != 0))
        System.out.println("true");
    else
        System.out.println("false");
}
```
