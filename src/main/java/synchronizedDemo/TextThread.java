package synchronizedDemo;

/**
 * Created by zgc on 2016/10/26.
 */
public class TextThread {
    public static void main(String[] args) {
        TxtThread tt = new TxtThread();
        new Thread(tt).start();
        new Thread(tt).start();
        new Thread(tt).start();
        new Thread(tt).start();
    }
}

class TxtThread implements Runnable {
    int num = 100;
    String str = new String();
    public void run() {
        while (true) {
            synchronized (str) {
                if (num > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    System.out.println(Thread.currentThread().getName() + "this is " + num--);
                }
            }
        }
    }
}