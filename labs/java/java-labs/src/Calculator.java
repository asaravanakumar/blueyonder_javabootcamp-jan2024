import java.util.Scanner;

public class Calculator {

    // Properties / State
    int a;
    int b;

    // Constructor
    public Calculator() {
//        a = 50;
//        b = 25;
    }

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Behaviours
    public int add() {
        return a + b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract() {
        return a - b;
    }

    public int multiply() {
        return a * b;
    }

    public int divide() {
        return a / b;
    }


}
