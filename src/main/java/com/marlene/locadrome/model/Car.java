package com.marlene.locadrome.model;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String color;

    public Car() {
        this.id = 0;
        this.brand = "";
        this.model = "";
        this.color = "";
    }

    public Car(int id) {
        this();
        this.id = id;
    }

    public Car(int id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
