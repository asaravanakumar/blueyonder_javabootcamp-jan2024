package com.labs.java.strings;

public class StringsDemo {
    public static void main(String[] args) {
        String name1 = "BlueYonder";
        String name2 = new String("BLUEYONDER");
        String name3 = name1;
        String name4 = "BlueYonder";

        String name5 = name1.toUpperCase();

        System.out.println(name1);
        System.out.println(name5);

        System.out.println(name1 == name5);

        // String Constant Pool

//        System.out.println(name1);
//        System.out.println(name2);
//
//        System.out.println(name1 == name2); // false?
//        System.out.println(name1 == name4); // true?
//
//        System.out.println(name1.equals(name2)); // false
//        System.out.println(name1.equalsIgnoreCase(name2)); // true

        String name6 = "  a  ";

        // useful methods
//        System.out.println("Length: " + name1.length());
//        System.out.println("Upper: " + name1.toUpperCase());
//        System.out.println("Lower: " + name1.toLowerCase());
//        System.out.println("Empty: " + name6.isEmpty());
//        System.out.println("Blank: " + name6.isBlank());
//        System.out.println("Trim: " + name6.trim());
//        System.out.println("Replace: " + name1.replace("e", "*"));
//        System.out.println("Substring: " + name1.substring(0,4));
//        System.out.println("Concat: " + name1.concat(" Bengaluru"));
//        System.out.println("Starts With: " + name1.startsWith("Blue"));
//        System.out.println("Contains: " + name1.contains("Yon"));
//        System.out.println("Ends With: " + name1.endsWith("der"));

        // Character Array
//        char[] arr = name1.toCharArray();
//        for (char ch: arr) {
//            System.out.println(ch);
//        }

        // Byte Array
//        byte[] byArr = name1.getBytes();
//        for(byte by: byArr) {
//            System.out.println(by);
//        }

        // String Buffer - Thread Safe
        StringBuffer nameBuffer = new StringBuffer("BlueYonder");
        System.out.println(nameBuffer.capacity());
        nameBuffer.append(" Bengaluru Karnataka India");
        System.out.println(nameBuffer.capacity());
        nameBuffer.delete(10, nameBuffer.length());
        nameBuffer.reverse();
        System.out.println(nameBuffer);

        // String Builder - Not Thread Safe

        StringBuffer nameBuilder = new StringBuffer("BlueYonder");
        System.out.println(nameBuilder.capacity());
        nameBuilder.append(" Bengaluru Karnataka India");
        System.out.println(nameBuilder.capacity());
        nameBuilder.delete(10, nameBuilder.length());
        nameBuilder.reverse();
        System.out.println(nameBuilder);
    }
}
