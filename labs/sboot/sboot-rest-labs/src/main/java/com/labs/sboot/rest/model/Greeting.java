package com.labs.sboot.rest.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement
public class Greeting {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Type can't be blank")
    private String type;

    @NotBlank(message = "Message can't be blank")
    @Size(min = 1, max = 30, message = "Message should be between 1 to 30 characters")
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
