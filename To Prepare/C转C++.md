## 语法变化

### 输出方法

C++中提供cin(>>)和cout(<<)进行弱类型的输入和输出，cin和cout虽然使用起来方便，但是输入输出的效率不如scanf和printf

### 头文件

C++的头文件一般是没有像C语言的.h后缀，但C++向下包含C，一般C语言中的头文件去掉.h在前面加上c就可以继续使用

```C++
#include <cmath>//相当于 #include <math.h>
#include <cstdio>//相当于 #include <stdio.h>
#include <cstring>//相当于 #include <string.h>
```

### bool类型

C++无需添加头文件就自带布尔类型的变量，在bool中0为false，非零为true

```C++
bool flag=true;
bool flag=-357;//为true
bool flag=0;//为false 
```

C++无需用#define定义常量，统一用 `const 数据类型 常量名称`的方式进行定义

### string类

C++中自带string字符串类，部分情况仍需使用char[] 数组方法，包含定义、输出、拼接和一定的处理
尽量使用<string>头文件，<string>≠<cstring>

```C++
    string str1 = "Hello World";//定义字符串
    string str2;
    cin >> str2;//输入字符串
    string str3 = str2 + str1;//字符串拼接
    cout << str3 << endl;//输出
    for (int i = 0; i < str1.length(); i++)
    { //使用字符数组的方式进行输出
        cout << str1[i];
    }
    cout << endl;

```

#### string输入输出

由于string是C++中产生的，所以C语言中的scanf和printf函数无法对其进行输入输出的处理
可以使用 `printf("%s",str.c_str());`的方式进行输出，c_str()函数返回的是一个C语言中的char指针，表示将字符串转换为一个只读的字符数组
cin的输入处理是以空格结束一个字符串的，如果要进行整行字符串的输入（回车结束）需要使用getline方法

对于字符串长度的获取，也可以直接采用 `str.length();`或者 `str.size()`的方式
由于有些函数只支持迭代器为参数，所以string也可以以迭代器的方式进行访问（可加减）

```C++
    string str4;
    getline(cin, str4);//getline的参数中需要加上cin表示输入
    cout << str4 << endl;
    cout << str4.length() << endl; 
    cout << str4.size() << endl;  
```

#### string函数

1. string可以直接进行赋值或加减拼接

2. 可以直接用比较运算符判断相等或大于小于（以字典序为规则）

```C++
    string str1 = "Hello World"; //定义字符串
    string str2 = "12345";
    str1 += str2; //相加进行拼接
    cout << str1 << endl;
    cout << (str1 > str2) << endl; //输出str1是否小于str2
```

1. 输出长度常用length()而不是size()

2. insert()插入函数常用两种方式
直接位置插入： `insert(位置下标，要插入的字符串)`
迭代器参数插入，常用于将一个字符串的一部分插入到另一字符串： `insert(插入位置，被插入字符串的起点，终点)`

```C++
    string str1 = "Hello World"; //定义字符串
    string str2 = "12345";
    str1.insert(5, "hhh"); //位置插入
    cout << str1 << endl;
    str1.insert(str1.begin() + 5, str2.begin(), str2.end()); //迭代器插入
    cout << str1.length() << endl;     //输出字符串的长度
```

1. substr() 字符串截取函数

```C++
    string str1 = "Hello World";       //定义字符串
    cout << str1.substr(4) << endl;    //从下标4开始到结束
    cout << str1.substr(4, 6) << endl; //从下标4开始，截取6个字符
```

1. 删除字符的函数erase()
erase()接收的也是迭代器作为参数，单个元素或者一个区间

```C++
    string str;
    cin >> str;
    while (str.find('a') != string::npos) //find()返回的是字符的下标
    {
        str.erase(str.find('a'), 1); //第二个参数的1代表删除元素的个数
    }
    cout << str << endl;
    str.erase(str.begin()); //删除第一个字符
    cout << str << endl;
    str.erase(str.begin(), str.begin() + 2); //删除一个范围，左闭右开
    cout << str << endl;
    str.clear(); //清空字符串 
```

1. find()查找字符或字串，查找失败返回 `string::npos`

```C++
    string str = "qwertasd";
    string str2 = "asd";
    cout << str.find('a') << endl;
    //查找单个字符返回的这个字符的下标，可用其返回值!=string::npos的方式表示查找成功
    cout << str.find(str2) << endl;    //返回匹配成功的起始下标
    cout << str.find(str2, 4) << endl; //表示从下标4开始向后查找，返回值与上一样
```

1. replace()函数替换字串： `replace(替换起始位置，替换长度，替换的字串)`
也支持迭代器参数替换： `replace(迭代器位置起，始，字串)`

```C++
    string str = "qwertasd";
    string str2 = "asd";
    cout << str.replace(3, 3, str2) << endl; //从下标3开始往后的三个字符被str2替代
    cout << str.replace(str.begin(), str.begin() + 4, str2) << endl;
```

### struct的使用

在C++中，结构体生成对象时无需进行结构体的声明，也就是不用在前面加是struct
结构体的定义尽量在main() 方法之外

```C++
    struct stu
    {
        int grade;
        float score;
    };
    struct stu arr1[10]; // C语言里面需要写struct
    stu arr2[10];        // C++里面不用写
```

### &在C++中的引用

C++中的&符号在函数的参数列表中作引用，要与C语言的取地址输入分开，这两者并不相同
做引用时的意思是将传送进来的变量参数直接进行操作（可以理解成拷贝副本），只是将名字换成了定义方法中的局部变量名

```C++
void function(int &a);
int main()
{
    int n = 0;
    function(n); // n由0变成了99
    cout << n << endl;
    system("pause");
    return 0;
}
void function(int &a)// 传⼊的是n的引⽤，相当于直接对n进⾏了操作，只不过在function函数中换了个名字叫a
{ 
    a = 99;
}
```

```C++
void function(int a);
int main()
{
    int n = 0;
    function(n); // 并没有对n这个值进行改变，还是0
    cout << n << endl;
    system("pause");
    return 0;
}
void function(int a) // 传⼊的是0这个值，并不会改变main函数中n的值
{
    a = 99;
} 
```

## STL的应用

STL称为标准模板库（Standard Template Library） ，STL 已完全被内置到支持 C++ 的编译器中，无需额外安装

### vector动态数组

动态数组vector，能够在运行阶段设置数组的长度、在末尾增加新的数据、在中间插入新的值、长度任意被改变

1. 定义vector，vector是包含在头文件<vector>中的，预定义头文件之后的生成格式为： `vector<数据类型> 数组名;`

2. vector的大小如果在初始不进行定义的话默认为0，可以采用`vector<数据类型> 数组名(``size``);` 的方式来进行初始大小的定义，也可以采用resize方法进行大小的重定义

3. 对定义了长度的数组，那么它的初始值将全部定义为0
也可以采用`vector<数据类型> 数组名(size,初始值);` 在初始化的是否就赋予初始值

4. 对vector动态数组的访问和普通数组的访问方式一样，也是通过下标的方式，但可以通过迭代器进行遍历

```C++
    vector<int> num;
    cout << num.size() << endl; //刚创建的数组为空，size==0
    vector<int> number(10);     //将number数组的大小定义为10
    cout << number.size() << endl;
    num.resize(5); //将num的长度重定义为5
    cout << num.size() << endl;
    for (int i = 0; i < num.size(); i++)
    {
        cout << num[i] << " "; //此时初始值为0
    }
    cout << endl;
    vector<int> numbers(10, 5);//初始化数组长度为10，所有元素的初始值为5
    for (int i = 0; i < numbers.size(); i++)
    {
        cout << numbers[i] << " "; //此时初始值为5
    }
    num.clear();//清空数组元素，复杂度为O(N)（N为元素的个数） 
    for (int i : numbers)//读取型遍历
    {
      cout << i << endl;
    }  
```

1. push_back() 和pop_back() 函数实现在数组尾插入或删除元素

```C++
    vector<int> num = {10, 20, 30};
    num.push_back(40); //在数组末尾插入40
    num.pop_back();    //移除最后一个元素 
```

1. 迭代器访问，完整的指针类型定义应该是 `vector<int>::iterator` ，但在C++１１中出现了auto型，会自动进行检测变量的类型

美国人的思想为**左闭右开**，也就是end()函数不进行存储任何东西，表示一个数组到这就为空了（尾元素的下一个元素的地址）

```C++
    vector<int> num = {10, 20, 30, 40, 50};
    for (auto it = num.begin(); it != num.end(); it++)//num.begin()是一个指针，代表指向第一个元素
    {                       //auto相当于生成一个vector类型的迭代器，it是iterator的缩写
        cout << *it << " "; //it是一个指针，加*进行取值
    }
```

只有vector和string中才允许有 `ve.begin()+3`这种迭代器加整数的操作

1. 在指定位置插入新的元素，可以使用自带的insert()和emplace()函数

- insert() 函数的功能是在 vector 容器的指定位置插入一个或多个元素。该函数的语法格式有多种

|||
|-|-|
|语法格式|用法说明|
|insert(pos,elem)|在迭代器 pos 指定的位置之前插入一个新元素elem，并返回表示新插入元素位置的迭代器|
|insert(pos,n,elem)|在迭代器 pos 指定的位置之前插入 n 个元素 elem，并返回表示第一个新插入元素位置的迭代器|
|insert(pos,first,last)|在迭代器 pos 指定的位置之前，插入其他容器（不仅限于vector）中位于 [first,last) 区域的所有元素，并返回表示第一个新插入元素位置的迭代器|
|insert(pos,initlist)|在迭代器 pos 指定的位置之前，插入初始化列表（用大括号{}括起来的多个元素，中间有逗号隔开）中所有的元素，并返回表示第一个新插入元素位置的迭代器|


```C++
#include <iostream>
#include <vector>
#include <array>
using namespace std;

int main()
{
    vector<int> demo{1, 2};
    //第一种格式用法
    demo.insert(demo.begin() + 1, 3); //{1,3,2}
    //第二种格式用法
    demo.insert(demo.end(), 2, 5); //{1,3,2,5,5}
    //第三种格式用法
    array<int, 3> test{7, 8, 9};
    demo.insert(demo.end(), test.begin(), test.end()); //{1,3,2,5,5,7,8,9}
    //第四种格式用法
    demo.insert(demo.end(), {10, 11}); //{1,3,2,5,5,7,8,9,10,11}
    for (int i = 0; i < demo.size(); i++)
    {
        cout << demo[i] << " ";
    }
    system("pause");
    return 0;
}
```

- emplace()用于在 vector 容器指定位置之前插入一个新的元素，其格式为 `iterator emplace (const_iterator pos, args...);` emplace()函数的效率更高一些

```C++
#include <vector>
#include <iostream>
using namespace std;

int main()
{
    vector<int> demo1{1, 2};
    //emplace() 每次只能插入一个 int 类型元素
    demo1.emplace(demo1.begin(), 3);
    for (int i = 0; i < demo1.size(); i++)
    {
        cout << demo1[i] << " ";
    }
    system("pause");
    return 0;
}
```

1. erase()删除函数用来删除数组中的特定元素，但其接收的参数为一个迭代器，可以先用<algorithm>下的find()函数查找出位置

```C++
    vector<int> num = {3, 4, 5, 6, 7};
    auto it = find(num.begin(), num.end(), 6); //查找相应元素的迭代器
    num.erase(it);                             //删除这个元素
    num.erase(num.begin());
    for (auto it = num.begin(); it != num.end(); it++)
    {
        cout << *it << " ";
    }
```

### set集合

集合中的元素各不相同，而且元素之间会进行从小到大的排序

1. set是包含在头文件<set>中的，预定义头文件之后的生成格式为： `set<数据类型> 集合名;`

2. set集合中的元素是有序的，所以不用管插入的位置，插入方式为： `set.insert(元素);`

3. 集合的输出：使用迭代器的方式进行集合的遍历输出，但集合是默认从小到大排序的，所以可以使用 `set.rbegin()/set.rend()`反向迭代器实现反向遍历
可以通过 `*(num.begin())`这种指针取值的方式来对第一个元素（最小元素）进行输出；同理`*(num.rbegin())`对最后一个元素（最大元素）进行输出

4. 对集合中元素的查找可以使用 `set.find(目标元素)`，但此方法是一个迭代器，我们可以用 `set.find(目标元素) != set.end()`的方式，通过返回值1或0判断集合中有无这个元素

```C++
    set<int> num;               //定义set集合
    num.insert(1);              //向集合中插入元素1
    cout << num.size() << endl; //输出集合的大小
    for (int i = 3; i < 10; i++)
    {
        num.insert(i);
    }
    num.erase(5);//擦除元素5
    cout << "min:" << *(num.begin()) << endl; //输出集合中第一个元素的元素
    cout << "max:" << *(num.rbegin()) << endl; //输出集合中最后一个元素的元素
    for (auto it = num.begin(); it != num.end(); it++)
    { //遍历集合
        cout << *it << " ";
    }
    cout << endl;
    for (auto it = num.rbegin(); it != num.rend(); it++)
    { //反向遍历集合
        cout << *it << " ";
    }
    cout << endl
         << (num.find(7) != num.end()) << endl; //查找元素7
    cout << *(num.find(7)) << endl; 
    num.clear(); //清空集合 
```

set集合的erase()函数不同于vector只能以迭代器作为参数，可以用迭代器，元素值和迭代器范围进行删除
但是set集合又不允许迭代器相加的操作

```C++
    set<int> num; //定义set集合
    for (int i = 0; i < 10; i++)
    {
        num.insert(i);
    }
    num.erase(5);                              //擦除元素5
    num.erase(num.begin());                    //擦除起始元素
    num.erase(num.begin(), num.find(4));       //擦除开始到元素4的位置（不包含num.find(4)）
```

### map键值对

map集合又称为映射，采用一键对一值的方式进行存储，存放的元素会通过键进行从小到大的排列
map是包含在头文件<map>中的，预定义头文件之后的生成格式为： `map<键数据类型,值数据类型> 集合名;`

通过键作为下标存储值达到同时存储一对数据的目的，擦除也是一样
也有迭代器遍历和反迭代器的内部函数，但是无需对指针进行取值，只要用指针指向frist或second便可直接显示键或值的内容，如`data.begin()->frist`表示第一对元素的键的内容

```C++
    map<string, int> data;
    data["hello"] = 2;
    data["world"] = 7;
    data[";"] = 2;                 //在map中插入元素
    cout << data["hello"] << endl; //通过键输出值,不存在返回0
    cout << data.size() << endl;   //map的大小，一对键值看作一个元素
    data.erase("hello");           //通过键擦除一对元素
    for (auto it = data.begin(); it != data.end(); it++)
    { //迭代器遍历，直接用指针取值，指向frist表示键，指向seco表示值
        cout << it->first << "  " << it->second << endl;
    } 
```

1. find()函数，参数为key，查找成功返回一个迭代器

2. count()函数，返回被查找元素的个数（map中的元素不重复，值只可能是1或0），参数也是key

3. erase()函数，删除单个元素时的参数可以是迭代器也可以是key，删除区间元素只能是迭代器的起始位置

```C++
    map<char, int> data;
    data['a'] = 2;
    data['b'] = 3;
    data['c'] = 4;
    data['d'] = 5;
    auto it = data.find('a'); //查找成功返回位置5
    cout << it->first << " " << it->second << endl;
    data.erase('a');                      //通过key删除元素
    data.erase(data.find('b'));           //通过迭代器删除元素
    data.erase(data.begin(), data.end()); //通过迭代器起始删除区间元素
    data.clear();                         //清空元素
```

#### unordered集合

因为在map和set集合中的元素都是有序的，但unordered的意思是未经排序，也就是里面的元素是无序的，时间复杂度更小一下，用法相同

### queue队列

有头尾指针front和back，先进先出，队尾入，队首移除
主要使用是在广度优先搜索时无需手动编写队列

1. 头文件<queue>，定义格式： `queue<数据类型> 队名;`

2. push()和pop()进行入队和出队操作（队尾入，队首出），无法遍历，可读取队首队尾，可访问大小

```C++
    queue<int> que;
    for (int i = 0; i < 10; i++)
    {
        que.push(i); //从队尾入队
    }
    que.pop();                                        //移除队首元素
    cout << que.front() << " " << que.back() << endl; //输出首尾元素
    cout << que.size() << endl;                       //输出大小
    cout << que.empty() << endl;                      //判断是否为空
```

1. empty()函数判断是否为空返回bool型，在使用front和back进行输出时，先判断是否为空，否则容易出错

#### priority_queue队列

称为优先队列，底层是用堆来实现的，具体表现为队首元素永远时优先级最高的那个（优先级可以自己规定）

优先队列没有front和back指针，统一用top来对队首进行操作（又称为堆顶），其他使用与queue无异

```C++
    priority_queue<int> num;
    num.push(2);
    num.push(4);
    num.push(3);
    cout << num.top() << endl; //输出堆顶
    num.pop();
    cout << num.top() << endl;
```

优先级的定义，可以使用自带的大小定义，其格式为： `priority_queue<类型，vector<类型>，less<类型>> num;`这是指小的放后边，也就是默认的规则，若改为大的放后边只要将less改为greater即可
其他方法看算法笔记P235

### stack栈

先进后出，只能对栈顶进行操作，所以只有一个指针top

1. 头文件<stack>，定义格式： `stack<数据类型> 栈名;`

2. push()和pop()进行入栈和出栈操作，无法遍历，只能读取栈顶top，可访问大小

```C++
    stack<int> s; // 定义⼀个空栈s
    for (int i = 0; i < 6; i++)
    {
        s.push(i); // 将元素i压⼊栈s中
    }
    s.pop();                  // 移除栈顶元素
    cout << s.top() << endl;  // 访问s的栈顶元素
    cout << s.size() << endl; // 输出s的元素个数 
```

### pair元素对

在头文件<utility>中，主要是将两个元素（无论类型是否相同）合成一个元素，就像定义在结构体中定义两个不同变量，但是用起来更简单，可以直接比较大小（先比较first，如果相同再比较second）
访问就像map中的first元素和second函数（但不是指向，而是类似结构体的形式）

初始化可以直接在后边加圆括号直接输入，还有三种赋值方式

```C++
    pair<string, int> psi;
    //pair<string, int> psi("hh", 5);//初始化
    psi = make_pair("ha", 6); //使用make_pair()函数定义
    cout << psi.first << " " << psi.second << endl;
    psi = pair<string, int>("hh", 5); //指定类型定义
    cout << psi.first << " " << psi.second << endl;
    psi.first = "xx"; //指定变量定义
    psi.second = 7;
    cout << psi.first << " " << psi.second << endl;
```

具体使用就是代替二元结构体和作为键值对插入map中

```C++
    map<string, int> msi;
    msi["hh"] = 6;                    //传统定义
    msi.insert(make_pair("xixi", 8)); //pair插入
    auto it = msi.find("hh");
    cout << it->first << " " << it->second << endl;
    it = msi.find("xixi");
    cout << it->first << " " << it->second << endl;
```
