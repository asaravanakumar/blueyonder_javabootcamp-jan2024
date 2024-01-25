package com.labs.java.oops;

import java.util.Scanner;

public class CalculatorMain {

    private static Scanner in = new Scanner(System.in);
    private static int value1;
    private static int value2;
    private static int output;

    public static void main(String[] args) {
        System.out.println("Welcome to Calculator App!!!");

        Calculator calc = new Calculator();

//        Calculator calc1 = new Calculator(40, 80);
//        Calculator calc2 = new Calculator(50, 30);
//
//        Calculator calc3 = new Calculator(15, 4);
//        Calculator calc4 = new Calculator(40, 10);


        while(true) {
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");


            System.out.print("Enter the option: ");
            int option = in.nextInt();


            switch (option) {
                case 1:
                    readInput();
                    calc.a = value1;
                    calc.b = value2;
                    output = calc.add();
                    break;
                case 2:
                    readInput();
                    calc.a = value1;
                    calc.b = value2;
                    output = calc.subtract();
                    break;
                case 3:
                    readInput();
                    calc.a = value1;
                    calc.b = value2;
                    output = calc.multiply();
                    break;
                case 4:
                    readInput();
                    calc.a = value1;
                    calc.b = value2;
                    output = calc.divide();
                    break;
                case 5:
                    System.out.println("Thank you!!!");
                    in.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Option. Please try again!!!");
                    continue;
            }

            System.out.println("Output is " + output);
        }
    }

    public static void readInput() {
        System.out.print("Enter value1: ");
        value1 = in.nextInt();

        System.out.print("Enter value2: ");
        value2 = in.nextInt();
    }
}
