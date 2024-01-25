package com.labs.java.concurrency;

public class ExtendingThreadClassDemo extends Thread {

    @Override
    public void run() {
        System.out.println("Entering --> " + Thread.currentThread().getName());
        for(int i = 0; i < 10; i++) {
            System.out.println("Hello " + Thread.currentThread().getName() +  " - " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting <-- " + Thread.currentThread().getName());
    }

    public void run(int a) {
        System.out.println("Overloaded run method...");
    }

    public void start(int a) {
        System.out.println("Overloaded start method...");
    }

    public static void main(String[] args) {

        System.out.println("Entering --> " + Thread.currentThread().getName());

        ExtendingThreadClassDemo t1 = new ExtendingThreadClassDemo();
        t1.setName("T1");
        t1.run();
//        t1.start();

//        ExtendingThreadClassDemo t2 = new ExtendingThreadClassDemo();
//        t2.setName("T2");
//        t2.start();


        for(int i = 0; i < 10; i++) {
            System.out.println("Hello Main!!! " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting <-- " + Thread.currentThread().getName());

    }
}
