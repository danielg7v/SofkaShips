package com.example.mongodb.model;

public class lanzadera {

    private String id;

    private String name;

    private String description;


    private String color;

    public lanzadera() {
    }
    public lanzadera(String name, String description, String color) {
        this.name = name;
        this.description = description;
        this.color = color;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getColor() {
        return color;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void toHonkLanzadera(){
        System.out.println("PIIIII");
    }

    }

