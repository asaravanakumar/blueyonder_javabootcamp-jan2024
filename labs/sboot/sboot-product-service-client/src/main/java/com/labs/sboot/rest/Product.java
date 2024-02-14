package com.labs.sboot.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
//@NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String category;
    private String name;
    private String manufacturer;
    private double price;
}
