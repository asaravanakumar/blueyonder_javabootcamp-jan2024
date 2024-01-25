package com.labs.java.concurrency;

public class ImplRunnableInterfaceDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("Entering --> " + Thread.currentThread().getName());
        for(int i = 0; i < 10; i++) {
            System.out.println("Hello " + Thread.currentThread().getName() +  " - " + i);
        }
        System.out.println("Exiting <-- " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Entering --> " + Thread.currentThread().getName());

        Thread t1 = new Thread(new ImplRunnableInterfaceDemo());
        t1.setName("T1");
        t1.start();
//        t1.start();

//        Thread t2 = new Thread(new ImplRunnableInterfaceDemo());
//        t2.setName("T2");
//        t2.start();

        for(int i = 0; i < 10; i++) {
            System.out.println("Hello Main!!! " + i);
        }
        System.out.println("Exiting <-- " + Thread.currentThread().getName());
    }
}
