package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class Person {

    private final UUID id;
    //@NotBlank //Makes sure that Person is always present. Not null because empty strings count
    private final String name;

    //JsonProerty is needed for postman to send James Bond to the server
    //The properties (name,id) need to be defined in our model
    //So when we send the Json spring knows to take the property and convert it to java class
    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
