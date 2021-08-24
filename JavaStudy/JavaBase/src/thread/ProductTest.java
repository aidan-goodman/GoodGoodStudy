package thread;

/**
 * 生产者将产品交给店员，消费者从店员处买走产品，店员持有不超过20个
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Customer customer = new Customer(clerk);

        Thread producerThread = new Thread(producer);
        Thread customerThread = new Thread(customer);
        Thread customerThread2 = new Thread(customer);

        producerThread.setName("一号生产商：");
        customerThread.setName("一号顾客：");
        customerThread2.setName("二号顾客：");

        producerThread.start();
        customerThread.start();
        customerThread2.start();
    }
}

class Clerk {
    private int produces = 0;

    public synchronized void produce() {
        if (produces < 20) {
            produces++;
            notify();
            System.out.println(Thread.currentThread().getName() + "生产第" + produces + "个产品");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {
        if (produces > 0) {
            System.out.println(Thread.currentThread().getName() + "消费第" + produces + "个产品");
            produces--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品...");
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }
    }
}

class Customer implements Runnable {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费产品...");
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();
        }
    }
}
