package com.labs.java.arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        // Array Declaration;
        int[] nos;

        // Array Instantiation
        nos = new int[10]; // 10 * 4 = 40 + 8 = 48 bytes

        nos[0] = 10;
        nos[1] = 20;

//        System.out.println(nos[10]); // throws ArrayIndexOutofBounds Exception


        // Array Initialization
//        int[] nos1 = new int[]{10, 20, 30};
        int[] nos1 = {10, 20, 30};

        System.out.println(nos);

        for(int i: nos) {
            System.out.println(i); // 0
        }


        for(int i: nos1) {
            System.out.println(i); // 0
        }
    }
}
