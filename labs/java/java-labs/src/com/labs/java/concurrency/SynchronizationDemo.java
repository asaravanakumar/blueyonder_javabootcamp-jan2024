package com.labs.java.concurrency;

public class SynchronizationDemo {

    static int counter;

    public static void main(String[] args) {
        Thread t1 = new Thread(t);
        t1.setName("T1");
        t1.start();

        Thread t2 = new Thread(t);
        t2.setName("T2");
        t2.start();

        Thread t3 = new Thread(t);
        t3.setName("T3");
        t3.start();

        Thread t4 = new Thread(t);
        t4.setName("T4");
        t4.start();
    }

    static Runnable t = new Runnable() {
        @Override
        public synchronized  void run() {
//            synchronized (this) {
                counter = counter + 1; // T1
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
                counter = counter + 1; //
                System.out.println(Thread.currentThread().getName() + " - " + counter);
//            }
        }
    };
}
