package synchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * Created by zgc on 2016/10/26.
 */
public class SynchronizedTest {
    private static Object lock = new Object();

    public synchronized static void fun() {
        while (true) {
            System.out.println("in fun");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fun1() {
        synchronized (SynchronizedTest.class) {
            while (true) {
                System.out.println("in fun1");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fun2() {
        synchronized (lock) {
            while (true) {
                System.out.println("in fun2");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                fun();
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                fun1();
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                fun2();
            }
        }.start();
    }
}
