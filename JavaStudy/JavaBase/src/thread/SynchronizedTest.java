package thread;

public class SynchronizedTest {
    public static void main(String[] args) {
        Window w1 = new Window();
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

class Window implements Runnable {
    private int tickets = 100;//三个线程使用一个对象

    @Override
    public void run() {
        //锁必须是对象，而且锁只能是同一个
//        synchronized (this) {//使用当前对象
        synchronized (Window.class) {//使用当前类
            while (tickets > 0) {//循环输出
                System.out.println(Thread.currentThread().getName() + "：票号：" + (101 - tickets));
                tickets--;
            }
        }
    }
}