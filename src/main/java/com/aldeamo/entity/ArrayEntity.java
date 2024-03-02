package com.aldeamo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "arrays")
public class ArrayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String input_array;

    public ArrayEntity() {
    }

    public ArrayEntity(Integer id, String input_array) {
        this.id = id;
        this.input_array = input_array;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInput_array() {
        return input_array;
    }

    public void setInput_array(String input_array) {
        this.input_array = input_array;
    }
    
}