package com.labs.java.exception;

public class ExceptionDemo {
    public static void main(String[] args) {
        int output = 0;
        try {
            output = compute(20, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(output);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int compute(int a, int b) throws Exception{
        int out = 0;
        String name = "Amit";
        try {
            out = a / b;
            System.out.println(name.toCharArray()[2]);

        }catch(ArithmeticException ae) {
//            throw new ArithmeticException("Divide by Zero Error");
//            System.out.println("ERROR: " + ae.getMessage());
            throw new ValidationException("Divide by Zero Error", ae);
        }catch(ArrayIndexOutOfBoundsException aie) {
            throw aie;
//            System.out.println("ERROR: " + aie.getMessage());
        }catch(Exception e) {
            System.out.println("Generic Error: " + e.getMessage());
        }finally {
            System.out.println("Finally Called...");
        }
        return out;
    }
}
