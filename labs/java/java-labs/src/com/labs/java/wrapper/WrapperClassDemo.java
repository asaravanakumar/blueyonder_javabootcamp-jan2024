package com.labs.java.wrapper;

import com.sun.jdi.FloatType;

import java.util.concurrent.Flow;

public class WrapperClassDemo {
    public static void main(String[] args) {
        int a = 100; // 4 bytes
        int b = 200; // 4 bytes

//        Number nr;
//            Byte by;
//            Short sh;
//            Integer in;
//            Long lo;
//            Float fl;
//            Double Dl;
//
//        Character ch;
//        Boolean bool;

        Integer a1 = new Integer(100); // 4 + 8 = 12 bytes
        Integer b1 = Integer.valueOf(200);

        Integer a2 = new Integer(100);

        System.out.println(a1.longValue());

        System.out.println(a + b);
        System.out.println(a1 + b1);

        Integer b3 = b; // Auto Boxing

        int a3 = a1; // Auto Unboxing


        System.out.println(a == a1); // true
        System.out.println(a1 == a2); // false

        System.out.println(b3 + a3);

        String id = "123";

        Integer id1 = Integer.parseInt(id);
        Integer id2 = Integer.valueOf(id);
        System.out.println(id1 == id2);
    }
}
