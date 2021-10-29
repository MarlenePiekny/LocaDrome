package com.marlene.locadrome.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "name", length = 30, nullable = false)
    private String brand;
    @Column(name = "model", length = 30, nullable = false)
    private String model;
    @Column(name = "color", length = 30, nullable = false)
    private String color;

    public Car() {
        this.id = 0;
        this.brand = "";
        this.model = "";
        this.color = "";
    }

    public Car(String brand, String model, String color) {
        this();
        this.brand = brand;
        this.model = model;
        this.color = color;

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
