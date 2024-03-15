package com.labs.sboot.mongo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
@Data
@NoArgsConstructor
public class Category {

    @Transient
    public static final String SEQUENCE_NAME = "contacts_sequence";

    @Id
    private Integer id;
    private String name;
    private String description;
}
