package thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        WindowsLock w1 = new WindowsLock();
        Thread thread1 = new Thread(w1);
        Thread thread2 = new Thread(w1);
        Thread thread3 = new Thread(w1);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class WindowsLock implements Runnable {
    private int tickets = 100;//三个线程使用一个对象
    //实例化一个ReentrantLock对象
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        try {
            reentrantLock.lock();//锁住
            while (tickets > 0) {//循环输出
                System.out.println(Thread.currentThread().getName() + "：票号：" + (101 - tickets));
                tickets--;
            }
        } finally {
            reentrantLock.unlock();//解锁
        }
    }
}