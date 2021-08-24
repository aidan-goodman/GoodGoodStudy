package thread;

/**
 * 实现三个窗口同时卖一百张票
 */
public class WindowSale {
    public static void main(String[] args) {
/*使用继承Thread的方式
        Windows w1 = new Windows();
        Windows w2 = new Windows();
        Windows w3 = new Windows();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
        */
        Windows w1 = new Windows();
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

/*使用继承Thread的方式
class Windows extends Thread {
    private static int tickets = 100;//静态定义,确保三个窗口一共卖100张

    @Override
    public void run() {
        while (tickets > 0) {//循环输出
            System.out.println(this.getName() + "：票号：" + (101 - tickets));
            tickets--;
        }
    }
}*/

class Windows implements Runnable {
    private int tickets = 100;//三个线程使用一个对象

    @Override
    public void run() {
        while (tickets > 0) {//循环输出
            System.out.println(Thread.currentThread().getName() + "：票号：" + (101 - tickets));
            tickets--;
        }
    }
}