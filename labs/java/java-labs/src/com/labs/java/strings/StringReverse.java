package com.labs.java.strings;

public class StringReverse {
    public static void main(String[] args) {
        String name = "BlueYonder";
        // TODO: Logic to do String reverse
        // OUTPUT: rednoYeulB
        char[] arr = name.toCharArray();
        StringBuilder revBuilder = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i-- ) {
//            System.out.println(arr[i]);
            revBuilder.append(arr[i]);
        }
        System.out.println(revBuilder);

        // TODO: Index of given char
        // INPUT: Y
        // OUTUT: 4
        System.out.println(name.indexOf('e'));
        System.out.println(name.lastIndexOf('e'));

        // TODO: No of occurence of given char
        // INPUT: e
        // OUTPUT: 2
        int noOfOccurences = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'e') {
                noOfOccurences++;
            }
        }
        System.out.println(noOfOccurences);
    }
}
