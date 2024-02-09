package com.labs.java.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorFPTests {

//    @Test
//    public void testAdd() {
//        CalculatorFP calc = new CalculatorFP();
//        int result = calc.add(10,20);
//
////        if(result == 30) {
////            System.out.println("Test Passed");
////        } else {
////            System.out.println("Test Failed");
////        }
//
//        // TODO: Add assertion logic
//        assertEquals(30, result);
//    }

    private static CalculatorFP calc;

    @BeforeAll
    public static void init () {
        System.out.println("Called Before All...");
        calc = new CalculatorFP();
    }

    @BeforeEach
    public void initBeforeEachTest() {
        System.out.println("Called Before Each Test...");
    }

    @Test
    @Order(5)
    public void givenTwoArgumentsArePositive_thenReturnPositiveValue() {
        int result = calc.add(10,20);
        assertEquals(30, result);
    }

    @Test
    @Order(4)
    public void givenTwoArgumentsAreNegative_thenReturnNegativeValue() {
        int result = calc.add(-10,-20);
        assertEquals(-30, result);
    }

    @Test
    @Order(3)
    public void givenTwoArgumentsAreZero_thenReturnZeroValue() {
        int result = calc.add(0,0);
        assertEquals(0, result);
    }

    @Test
    @Order(2)
    public void givenFirstArgumentsPositiveAndSecondIsNegativeWithSmaller_thenReturnPostiveValue() {
        int result = calc.add(20,-10);
        assertEquals(10, result);
    }

    @Test
    @Order(1)
    public void givenFirstArgumentsPositiveAndSecondIsNegativeWithBigger_thenReturnNegativeValue() {
        int result = calc.add(10,-20);
        assertEquals(-10, result);
    }

    @AfterEach
    public void cleanupAfterEachTest() {
        System.out.println("Called After Each Test...");
    }

    @AfterAll
    public static void cleanup () {
        System.out.println("Called After All...");
    }

}
