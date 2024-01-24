package com.labs.java.collection;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
//        String[] countries = {"India", "Australia", "Japan", "USA", "India"};
//
//        for (String country: countries) {
//            System.out.println(country);
//        }

        List<String> countries = new ArrayList<>();
        countries.add("India");
//        countries.add(100);
        countries.add("Australia");
        countries.add("Japan");
//        countries.add(true);
        countries.add("USA");
//        countries.add("India");

        countries.add(2, "China");
        countries.set(3, "Korea");
        countries.remove(4);

//        System.out.println(countries.get(1));


//        System.out.println("Size: " + countries.size());
//        System.out.println(countries.contains("India"));
//
//        countries.clear();
//
//        System.out.println(countries.contains("India"));
//
//        System.out.println("Size: " + countries.size());

//        for(Object item: countries) {
//            System.out.println(item);
//        }

        // Iterator

//        Iterator it = countries.iterator();

        // Fail Fast
//        countries.add("Germany"); // throws Concurrent Modification Exception

//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }


        // List Iterator
        ListIterator listIt = countries.listIterator();

//        countries.add("Germany");

        listIt.add("Germany");

        while(listIt.hasNext()) {
            System.out.println(listIt.next());
        }

        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous());
        }

        for(Object item: countries) {
            System.out.println(item);
        }

    }
}
