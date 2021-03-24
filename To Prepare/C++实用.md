## cmath头文件

其针对的参数大多为double，所有进行整型判断的时候需要进行转换：(double)int；

|||
|-|-|
|**方法**|**含义**|
|fabs()|绝对值|
|floor()、ceil()|向下、向上取整|
|pow(r,p)|幂值： $r^p$|
|sqrt()|开根|
|round()|四舍五入取整|
|log()|以e为底的对数|


并没有以任意数为底的求对数函数，但可以采用换底公式： $log_ab=log_eb/log_ea$

## climits头文件

最常使用的是对最大最小值的赋予： `INT_MAX/MIN`

```C++
    int max = INT_MIN, min = INT_MAX; //最大值初始要足够小，最小值要足够大
    cout << max << " " << min << endl;
```

## bitset头文件

### 二进制操作

```C++
    bitset<5> b("11"); //5表示5个⼆进位
    // 初始化⽅式：
    // bitset<5> b; 都为0
    // bitset<5> b(u); u为unsigned int，如果u = 1,则被初始化为10000
    // bitset<5> b(s); s为字符串，如"1101" -> "10110"
    // bitset<5> b(s, pos, n); 从字符串的s[pos]开始，n位⻓度
    for (int i = 0; i < 5; i++)
        cout << b[i];
    cout << endl
         << b.any(); //b中是否存在1的⼆进制位
    cout << endl
         << b.none(); //b中不存在1吗？
    cout << endl
         << b.count(); //b中1的⼆进制位的个数
    cout << endl
         << b.size(); //b中⼆进制位的个数
    cout << endl
         << b.test(2);              //测试下标为2处是否⼆进制位为1
    b.set(4);                       //把b的下标为4处置1
    b.reset();                      //所有位归零
    b.reset(3);                     //b的下标3处归零
    b.flip();                       //b的所有⼆进制位逐位取反
    unsigned long a = b.to_ulong(); //b转换为unsigned long类型
```

### 进制转换函数

#### 手动写法

```C++
        int len = 0, arr[100];
        do
        {
            arr[len++] = n % radix;
            n = n / radix;
        } while (n != 0); //十进制转为其他进制
        
        for (int i = len - 1; i >= 0; i--)
        {
            n = n * radix + arr[i];
        } //其他进制转为十进制
```

#### **输出格式**

在使用<bitset>头文件时可以根据输出关键字进行进制的转换

```C++
    cout << "35的8进制:" << oct << 35 << endl;
    cout << "35的10进制" << dec << 35 << endl;
    cout << "35的16进制:" << hex << 35 << endl;
    cout << "35的2进制: " << bitset<8>(35) << endl; //<8>：表示保留8位输出
```

#### **strtol()函数**

**任意进制转换为十进制(str→long int)**，其格式为： `long int strtol(const char *nptr, char **endptr, int base)`，base是要转化的数的进制，非法字符会赋值给endptr，nptr是要转化的字符
因为是C语言自带的函数，所以字符串只能用char数组的方式读入（也可以字符串读入然后转换成字符数组）

```C++
    char a[20]="10549stend#12";  
    char *stop;  //建立一个由stop指向的字符数组
    int ans=strtol(a, &stop, 8);   //将八进制数1054转成十进制，后面均为非法字符
    printf("%d\n",ans);  
    printf("%s\n", stop);   

```

#### itoa()函数

**十进制转换为任意进制(int→str)**，其格式为： `char`*`itoa(int value,char`*`string,int radix);`，radix是要转化的数的进制
因为是C语言自带的函数，所以字符串只能用char数组的方式读入（也可以字符串读入然后转换成字符数组）

```C++
    int num = 10;  
    char str[100];  
    _itoa(num, str, 2);  //c++中一般用_itoa，用itoa也行,
    printf("%s\n", str);
```

#### sprintf()函数

**也是将一个10进制数转换为指定格式的n进制字符串**，函数原型： `int sprintf( char *buffer, const char *format, [ argument] … )`

```C++
    char s[100]={0};
    sprintf(s, "%d", 123); //十进制输出产生"123"
    sprintf(s, "%4d%4d", 123, 4567); //指定宽度不足的左边补空格，产生：" 1234567"
    sprintf(s, "%8o", 123);    //八进制输出，宽度占8个位置
    sprintf(s, "%8x", 4567); //小写16 进制，宽度占8 个位置，右对齐
    sprintf(s, "%10.3f", 3.1415626); //产生：" 3.142"
    int i = 100;
    sprintf(s, "%.2f", i);    //注意这是不对的
    sprintf(s, "%.2f", (double)i);    //要按照这种方式才行
```

## cstring头文件

### 函数初始化数组

给数组初始化时，可以使用memset()函数进行填充，而不用for循环遍历，其格式为： `memset(数组名,初始值,sizeof(数组名));
`其在头文件<cstring>中，只用memset()函数为数组赋0或-1时使用
也可对二维数组和多维数组进行初始操作

```C++
int arr[10];
memset(arr, 0, sizeof(arr));
for (auto i = 0; i < 10; i++)
{
    cout << arr[i] << " ";
}
```

### **字符串转换数组**

字符串转换为字符数组需要使用<cstring>中的strncpy方法将字符串内容挨个拷贝进数组中


字符数组转换为字符串可以直接进行赋值转换

```C++
#include <iostream>
#include <cstring>
using namespace std;

int main()
{
    string s = "aaaa vvva";
    char a[10];
    strncpy(a, s.c_str(), s.length()); //使用<cstring>中的方法将字符串拷贝到数组中
    for (int i = 0; i < 10; i++)
        cout << a[i];
    cout << endl;

    char arr[] = "123 45sdf";
    string str = arr; //直接将数组名赋值给字符串
    cout << str << endl;
    system("pause");
    return 0;
}
```

### **tostring函数**

在头文件<string>中，也可以不用
作用是将其他类型的数据转换为string型

```C++
    string s1 = to_string(123); // 将123这个数字转成字符串
    cout << s1 << endl;
    string s2 = to_string(4.5); // 将4.5这个数字转成字符串
    cout << s2 << endl;
    cout << s1 + s2 << endl;           // 将s1和s2两个字符串拼接起来并输出
    printf("%s\n", (s1 + s2).c_str()); // 如果想⽤printf输出string，得加⼀个.c_str()
```

string转换成int，double可以使用stoi和stod方法，其含义为string to int，其他数据类型也适用只要将最后一个字母写成目标类型的首字母

```C++
    string str = "123";
    int a = stoi(str); //非法字符会自动去除
    cout << a << endl;
    str = "123.44";
    double b = stod(str);
    cout << b << endl;
```

## algorithm头文件

### 数学函数

max(x,y)、min(x,y)函数用来返回两个数（可以是浮点）中较大或较小的那个，如果是判断三个数的最大值可以写成： `max(a,max(b,c))`


abs()只能是整数，浮点数可以用<cmath>下的fabs()

swap()用来交换两个数的值

### **sort函数**

sort排序函数在头文件<algorithm>中，主要是对数组进行排序，格式为： `sort(数组头，数组尾，规则cmp);`

cmd的排序规则的格式是返回一个大小判断的bool值，不能有=号，sort是不稳定的排序

```C++
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool cmp(int a, int b) //cmp规则的定义几乎都是这种格式
{                      // cmp函数返回的值是bool类型
    return a > b;      // 从大到小排列，不能有“=”号
}
int main()
{
    vector<int> v(10);
    for (int i = 0; i < 10; i++)
    {
        cin >> v[i];
    }
    sort(v.begin(), v.end()); // 因为这⾥没有传⼊参数cmp，所以按照默认，v从小到大排列

    int arr[10];
    for (int i = 0; i < 10; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr + 10, cmp); // arr从⼤到小排列，因为cmp函数排序规则设置从大到小
    system("pause");
    return 0;
}
```

#### **struct的sort**

结构体中可能会对多个变量进行比对，这就需要进行自定义的cmp函数

有一个学生结构体，要对学生进行排序时按照如下方法：当成绩不同时按从大到小排列，若成绩相同，对相同者进行学号从小到大排列

```C++
struct stu
{ // 定义⼀个结构体stu，number表示学号，score表示分数
    int number;
    int score;
};
bool cmp(stu a, stu b)
{                           // cmp函数，返回值是bool，传⼊的参数类型应该是结构体stu类型
    if (a.score != b.score) // 如果学生分数不同，就按照分数从大到小排列
        return a.score > b.score;
    else // 如果学生分数相同，就按照学号从小到大排列
        return a.number < b.number;
}
bool cmp(stu a, stu b)
{ //写成三目运算符
    return a.score != b.score ? a.score > b.score : a.number < b.number;
}
```

#### cmp_char[]

字符数组的排序不能像字符串那样直接进行比较，需要使用<cstring>中的strcmp()函数

```C++
return (strcmp(a.name, b.name) < 0); //递增
return (strcmp(a.name, b.name) > 0); //递减 
```

#### 项式cmp

PAT(advance)中的T1038中就要将字符串使用多项式相加的规则进行排序

```C++
bool cmp(string a, string b)
{
    return a + b < b + a; //如果a+b<b+a，a就在前面，否则反之
}
```

### **reverse()函数**

<algorithm>中的反转函数，通过指针或迭代器用来反转相应范围内的数，应用于数组和字符串较多
用来反转字符串非常方便

```C++
    char arr[8] = {'1', '2', '3', '4', '5', '6', '7', '8'};
    reverse(arr, arr + 4);
    string str;
    getline(cin, str);
    reverse(str.begin(), str.end());//反转首尾
    cout << str << endl;
```

### next_pernumtation()

当前序列的下一个全排列，可配合do…while()循环输出一个序列的全排列

```C++
    int arr[3] = {1, 2, 3};
    do //先输出本身
    {
        cout << arr[0] << " " << arr[1] << " " << arr[2] << endl; //只能使用单循环语句
    } while (next_permutation(arr, arr + 3));                     //输出最后一个序列后返回值为false
```

### **max_element（）及min_element（）函数**

<algorithm>中的求最大最小值的函数，可对普通数组和vector数组进行使用
返回的是迭代器或指针，所以加上取值符*，若求下标则用返回的结果减去数组的起始位置即可

```C++
//求值
vector<int> vec;
int maxValue = *max_element(v.begin(),v.end()); 
int minValue = *min_element(v.begin(),v.end());
int maxPosition = max_element(v.begin(),v.end()) - v.begin(); 

a[]={1,2,3,4,5,6};
int maxValue = *max_element(a,a+6); 
int minValue = *min_element(a,a+6); 
int maxPosition = max_element(a,a+6) - a; 

```

### 初始化数组

#### memset()函数

给数组初始化时，可以使用memset()函数进行填充，而不用for循环遍历，其格式为： `memset(数组名,初始值,sizeof(数组名));
`其在头文件<cstring>中，只用memset()函数为数组赋0或-1时使用
也可对二维数组和多维数组进行初始操作

```C++
int arr[10];
memset(arr, 0, sizeof(arr));
for (auto i = 0; i < 10; i++)
{
    cout << arr[i] << " ";
}
```

#### fill()函数

与memset不同的是可以对数组不同范围内赋予任意值，格式： `fill(起，始，初始值)`

```C++
    int arr[10];
    fill(arr + 2, arr + 5, 234);
```

### find函数

find()函数的具体实用是可以返回一个数组（包括动态）中某个特定元素的指针（迭代器），因为数组的存储空间是连续的，用当前指针（迭代器）去减去开始的指针（迭代器）得到的就是数组中该元素的下标

```C++
    int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
    int a_length = sizeof(a) / a[0]; //获取数组a的长度
    vector<int> b{10, 20, 30, 40, 50};
    int *a_head = a;                                //获取起始位置
    int *a_position = find(a, a + a_length, 6);     //被查找元素的位置
    cout << a_position - a_head << endl;            //下标
    auto b_position = find(b.begin(), b.end(), 30); //动态数组返回的是迭代器类型，auto==vector<int>::iterator
    cout << b_position - b.begin() << endl;         //下标
```

### binary_search()

用以实现二分查找： `binary_search(first,last,val)`，直接使用find函数也可，但如果查找数组中第一个大于X的数就不好实现了，所以二分查找又延伸出边界的查找

```C++
    int a[100] = {4, 10, 11, 30, 69, 70, 96, 100};
    int b = binary_search(a, a + 9, 4); //查找成功，返回1
```

#### 查找边界

lower_bound()和upper_bound()函数作用的对象是一个有序数组或容器，其格式为： `lower_bound(first,last,val)`，返回数组或容器中第一个小于（或大于）val的值的位置（指针或迭代器），若获取下标用其返回的位置减去起始位置即可

```C++
    vector<int> v = {2, 5, 1, 3, 7, 6, 9, 5};
    sort(v.begin(), v.end());
    int up_position = upper_bound(v.begin(), v.end(), 6) - v.begin();
    cout << v[up_position] << endl;

    int arr[10] = {3, 5, 6, 2, 7, 9, 1, 2, 6, 8};
    sort(arr, arr + 10);
    int low_position = lower_bound(arr, arr + 10, 7) - arr - 1;
    cout << arr[low_position] << endl;
```

## cctype头文件

<cctype>就是C语言中的<ctype.h>头文件，里边包含一些类型判断函数非常方便
有时不进行头文件引用也可以进行函数的使用

```C++
    char c;
    cin >> c;
    if (isalpha(c))
    {
        cout << "c is alpha";
    }
    if (islower(c))
    {
        cout << endl
             << "islow";
    }

```

其他的判断函数还包括：

|||
|-|-|
|**函数名**|**意义**|
|isalpha |字母（包括大写、小写）|
|islower|小写字母|
|isupper|大写字母|
|isalnum|字母（大写、小写）+数字|
|isblank|space和\t|
|isspace|space、\t、\r、\n|


此外还有tolower和toupper方法用来将字符转换为大写或小写

```C++
    char c = 'A';
    char t = tolower(c); // 将c字符转化为⼩写字符赋值给t
    cout << t << endl;   // 此处t为'a' 
```