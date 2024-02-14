package com.labs.sboot.lombok;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
//@NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String category;
    private String name;
    private String manufacturer;
    private double price;
}
