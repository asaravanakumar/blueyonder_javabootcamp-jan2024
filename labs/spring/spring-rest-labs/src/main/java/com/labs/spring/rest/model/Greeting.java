package com.labs.spring.rest.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting {

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
