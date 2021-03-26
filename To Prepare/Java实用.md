## Java 实用方法

### 输入 输出

**输如：**

对字符串的获取可以采用 next()和 nextline()，用 hasNext()或 hasNextline()判断是否还有数据输入

hasNext()或 hasNextline()在 while 循环中可能没啥区别，但 next()和 nextline()却大有不同

next()不能读取空格，换言之，读取到有效字符之后遇到空格就会停止，但 nextline()以 Enter 结束，能存储对应格式的任何字符

在比赛的使用中可以将按行输入的元素统一存储到 string 字符串中，然后用 string 自带的 split 按空格或其他（，）进行分割存储到字符串数组中

```java
Scanner sc=new Scanner(System.in);
String s=sc.nextLine();
String arr[]=s.split(" ");
for (String t:arr)
    System.out.println(t);
```

**字符的输入：** Java 中不提供 nextChar()的方法，但可以使用 `next().charAt(0)`

```java
Scanner sc = new Scanner(System.in);
char c= sc.next().charAt(0);
```

将不空格的一串字符按数组存储：`sc.next().toCharArray();`

```java
int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] arr = new char[n][m];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.next().toCharArray();//读入字符串拆分成字符数组
    }
```

**输出：**

`%4d` 和 `%-4d` 的区别： `%4d` 是靠右输出四位，不足用空格补齐； `%-4d` 是靠左输出

输出 N 位小数，可以使用 `DecimalFormat` 对格式进行定义；或者使用 `String.format(格式,浮点变量)` 直接打印

```java
public static void main(String[] args) {
    float f= (float) 3.234567;
    //正常输出
    System.out.println(f);
    //采用类
    DecimalFormat df=new DecimalFormat("#0.00");
    System.out.println(df.format(f));
    //模仿C语言
    System.out.printf("%.2f\n",f);//这里使用的C语言中的 printf
    //转换格式
    System.out.println(String.format("%.2f",f));
```

> 结果：2.35  2.35
>

### 数组的操作

**数组的拷贝：**

数组的拷贝，可以使用数组自带的 `clone()` 方法

```java
public static void main(String[] args) {
    int a[]={1,2,3,4};
    int b[]=a.clone();
    for (int n:b)
        System.out.print(n+" ");
}
```

> 结果：1 2 3 4
>

`System.arraycopy(Object a, int begin_a, Object b, int begin_b, int length);` 方法

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
>

`Arrays.copyOf(object,length);` 方法

```java
public static void main(String[] args) {
    int a[]={1,2,3,4};
    int b[]= Arrays.copyOf(a,3);
    for (int n:b)
        System.out.print(n+" ");
}
```

> 结果：1 2 3
>

### Arrays 类

```java
Arrays.asList(Object[] a) 数组a 转换成 List 
public static int binarySearch(Object[] a, Object key) //二分查找（a已排序）
public static boolean equals(Object[] a, Object[] a2)  //判断两数组是否完全一致
public static void fill(Object[] a, Object val)   //在a中所有位置填充val

//在[fromIndex,toIndex)中填充val
public static void fill(Object[] a, int fromIndex, int toIndex, Object val) 
public static String toString(Object[] a) //将数组a转换为字符串，如"[1, 2, 3]"
public static void sort(Object[] a) //改进的快速排序（升序）
public static void sort(Object[] a, int fromIndex, int toIndex) //对[fromIndex,toIndex)升序排序
public static <T> void sort(T[] a, Comparator<? super T> c) //自定义比较器排序

```

### String 类

1. 存入两个字符相同的 string 型时，两者的地址也相同（将后创建的地址指向前者，节约内存）；但是 new String 的两个不同对象的内容即便相同地址也不同

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
>

1. 判断 string 对象是否相同用自带的 equals 方法

```java
public static void main(String[] args) {
    String a="asd";
    String b="asd";
    if (a.equals(b))
        System.out.println("==");
    else
        System.out.println("!=");
}
```

> 结果：==
>

1. 要想遍历 string 的字符内容，需要将其转换为字符数组

```java
public static void main(String[] args) {
    String a = "asd";
    char arr[] = a.toCharArray();
    for (char n : arr)
        System.out.print(n + " ");
}
```

> 结果：a s d
>

1. string.contains() 方法用于判断字符串中是否包含指定的字符或字符串，返回 Boolean 类型
2. string 自带的使用方法还有 split：分割、大小写转换，提取子字符串等，具体可查阅 API

```java
String s = "asdefgasdefg";
for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);//字符串转换为字符
}
//指定字符的查找
s.indexOf('s');
s.indexOf('s', 2);
s.lastIndexOf('s');
s.lastIndexOf('s', 6);
String[] ss = s.split("regex");//将字符串按指定字符分割

String s = s.substring( int start, int end);//截取start到end的子串，左闭右开
char[] cs = s.toCharArray();//字符串转换为字符数组
String s = s.toLowerCase();//将字符串转换为小写
String s = s.toUpperCase();//将字符串转换为大写
String s = String.valueOf(object);//将指定数据转换为字符串，也可加参数radio将其转换为radio进制的字符串
```

#### StringBuilder

StringBuilder 对象被当作是一个包含字符序列的变长数组

```java
StringBuilder & StringBuffer
StringBuilder sb = new Stringbuilder("String");
sb.append("");
sb.reverse();
sb.delete(int start,int end);//删除索引从a开始（包含a）到b（不包含b）的所有字符；
sb.deleteCharAt(int index);//删除索引为a的字符；
sb.insert(int index,"string";//String参数字符按顺序插入到这个序列中的指定位置
sb.toString();
sb.setCharAt(int index,char c);
```

#### StringBuffer

StringBuffer 类和 String 一样，也用来代表字符串，只是由于 StringBuffer 的内部实现方式和 String 不同，所以 StringBuffer 在进行字符串处理时，不生成新的对象，在内存使用上要优于 String 类。 所以在实际使用时，如果经常需要对一个字符串进行修改，例如插入、删除等操作，使用 StringBuffer 要更加适合一些。 在 StringBuffer 类中存在很多和 String 类一样的方法，这些方法在功能上和 String 类中的功能是完全一样的。 但是有一个最显著的区别在于，对于 StringBuffer 对象的每次修改都会改变对象自身，这点是和 String 类最大的区别。 另外由于 StringBuffer 是线程安全的，所以在多线程程序中也可以很方便的进行使用，但是程序的执行效率相对来说就要稍微慢一些。

```java
StringBuffer s = new StringBuffer("abc");//将字符串或者string变量转为buffer型
s.append("efg");//在后续添加字符串
s.deleteCharAt(2);//删除指定位置的字符
s.delete(0, 2);//删除指定区间以内的所有字符，左闭右开
s.insert(2, "hello");//在指定位置插入字符串
s.reverse();//反转字符串
s.setCharAt(1, 'D');//修改对象中索引值为index位置的字符
System.out.println(s.toString());//输出要转换为string型
```

### 边界处理

数组判空： `if(arr == null|| arr.length == 0)`
二维数组判空： `if(arr == null || arr.length == 0 || arr[0].length == 0)`

字符串判空： `if(str == null || str.equals(""))`

所有封装类的最大最小值都有其存在的方法： `Integer n=Integer.MAX_VALUE;`

### 格式转换

1. 最简单直接的是在变量前加(目标类型)，此方法只用于基本的数据类型，不支持 String 类型

```java
char c= 'a';
int a=(int)c;
System.out.println(a);
```

1. String 和其他基本数据类型的转换

可以使用 toString 将其他数据类型转换为 String 类，但这种方法只对包装类起作用(如：Integer)
使用 String 自带的 valueOf()方法，支持将基本的数据类型转换
而将 String 转换为其他，可以用自带类的.parseXXX(string)方法
包装后的 Integer···  不要用  `==` 判断用 `.equals()`

```java
Integer a=new Integer(100);
String s1=a.toString();//类自带的toString()方法
int i=99;
String s2=String.valueOf(i);//String自带的valueOf()方法
Integer b=Integer.parseInt(s2);//每个类都有.parseXXX(String s)方法
```

### 快速排序

实用 Arrays 中的 sort 方法可以对数组进行快速排序

```java
Arrays.sort();//n*log(n);//重载了四个方法
sort(T[] a);
sort(T[] a,int fromIndex,int toIndex);//按升序排列数组的指定范围。 
sort(T[] a,Comparator<? super T> c);//根据指定比较器产生的顺序对指定对象数组进行排序。
//根据指定比较器产生的顺序对指定对象数组的指定对象数组进行排序。
sort(T[] a,int fromIndex,int toIndex,Comparator<? super T> c);

int[] arr = {1, 3, 6, 2, 4, 8, 7, 9};
Arrays.sort(arr);
```

若要实现降序排序可以使用 `Collections.reverseOrder()` 方法(数组必须为 Integer 类)

```java
Integer[] arr = {1, 3, 6, 2, 4, 8, 7, 9};
Arrays.sort(arr, Collections.reverseOrder());
for (int m : arr)
    System.out.print(m + " ");
```

#### 比较器

使用 Comparator 类定义的比较器可以实现自定义排序，而结构体的排序可以直接在结构体类中进行 cmp 方法的编写

```java
Comparator<Object> cmp = new Comparator<Object>() {//声明排序对象的目标类型
    @Override
    public int compare(Object o1, Object o2) {//在方法的参数中声明对象
        //升序
        return o1 - o2;//升序返回负数
        //降序
        return o2 - o1;//降序返回正数
    }
};
```

### 大数的使用

1. 定义 BigInteger 类型可以使用实例化类的方法，也可以使用 BigInteger 中的 valueOf(数字/变量)

```java
BigInteger a = new BigInteger("3");
BigInteger b = BigInteger.valueOf(3);
int i = 788;
BigInteger c = BigInteger.valueOf(i);
```

2. 大数的类是在 java.math.*包里的，所以继承了 math 的所有方法，而运算也是使用方法来进行

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
>

### Math 类

1. 可以求 sqrt(平方根)、abs(绝对值)、max、min、pow(幂)、取整(ceil、floor、round)具体查阅 API
2. 输出一个随机数用 random()方法

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

### 日期类

MONTH 字段是从 0 月开始计数的，所以 12 月对应的值是 11。DAY_OF_WEEK 中星期天对应的是 1，星期一对应的是 2，星期六对应的是 7，而 YEAR 和 DAY_OF_MONTH 都是从 1 开始计数

```java
public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date.toString());//输出当前时间
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//定义日期格式
        System.out.println(ft.format(date));//按格式输出
        System.out.printf("%tR",date);////printf方法也具有日期格式的输出
        Calendar c = Calendar.getInstance();//默认是当前日期
        c.set(2009, 6 - 1, 12);//对日期对象进行设置
        int month=c.get(Calendar.MONTH)+1;//月份的存储是从0开始的
        get(Calendar.*)方法可以获取很多日期信息
        GregorianCalendar gc=new GregorianCalendar(2020,10-1,14);
        int a=gc.getActualMaximum(Calendar.DAY_OF_MONTH);//当前月的的总日
        int b=gc.get(Calendar.DAY_OF_WEEK);//当前月第一天是星期几
        System.out.println(a);
        System.out.println(b);
    }
```

### Date 类

```java
public static void main(String[] args) {
    Date date1 = new Date(21, 6, 23, 12, 0, 0);
    System.out.println(date1);
    Date date2 = new Date(120, 6, 1, 12, 0, 0);
    System.out.println(date2);
    long time = date2.getTime() - date1.getTime();
    System.out.println(time / (60000));//得到的值是毫秒，求分钟要/60000
    //求天数：(毫秒)/(1000*60*60*24)+1
}
```

## 模板

### 公约公倍数

1. 求最大公约数可以采用辗转相除法，就是两数的最大公约数就是较小数和两数余数的最大公约数
2. 最小公倍数等于两数的乘积除最大公约数

```java
public class 练习 {
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

在 Integer 对象中，常用的进制转换

| 十进制的转换对象 | 对应的方法和参数           | 返回值         |
| ---------------- | -------------------------- | -------------- |
| 数字转换字符串   | Integer.toBinaryString(n); | 二进制字符串   |
| 数字转换字符串   | Integer.toOctalString(n);  | 八进制字符串   |
| 数字转换字符串   | Integer.toHexString(n);    | 十六进制字符串 |
| 数字转换字符串   | Integer.toString(n, r);    | r 进制字符串   |
| 字符串转换数字   | Integer.parseInt(str,r);   | r 进制整数     |

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
