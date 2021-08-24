package thread;

public class DeadLock {
    public static void main(String[] args) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();

        new Thread() {//线程一
            @Override
            public void run() {
                synchronized (stringBuilder1) {
                    stringBuilder1.append('a');
                    stringBuilder2.append(1);

                    try {//假定现在线程一已经拿到锁stringBuilder1，阻塞0.1秒
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //重新执行时锁stringBuilder2已经被线程二持有
                    synchronized (stringBuilder2) {
                        stringBuilder1.append('b');
                        stringBuilder2.append(2);

                        System.out.println(stringBuilder1);
                        System.out.println(stringBuilder2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {//线程二
            @Override
            public void run() {
                synchronized (stringBuilder2) {
                    stringBuilder1.append('a');
                    stringBuilder2.append(1);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //此时锁stringBuilder1被线程一持有
                    synchronized (stringBuilder1) {
                        stringBuilder1.append('b');
                        stringBuilder2.append(2);

                        System.out.println(stringBuilder1);
                        System.out.println(stringBuilder2);
                    }
                }
            }
        }).start();
    }
}
