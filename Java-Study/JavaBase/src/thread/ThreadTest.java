package thread;

/**
 * 方式一：继承于Thread类
 * 1. 创建子类extends Thread
 * 2. Override父类的run()
 * 3.实例化子类，调用start()
 */

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();//创建第一个线程
        //start两个作用：创建线程；调用run方法
        //一个线程只能启动一次，可以通过创建多个线程对象调用的方式
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();//创建第二个线程
    }
}

//1. 创建子类extends Thread
class MyThread extends Thread {
    //2. Override父类的run()
    @Override
    public void run() {//输出偶数
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {//输出字母
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
