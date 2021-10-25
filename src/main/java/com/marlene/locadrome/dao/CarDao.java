package com.marlene.locadrome.dao;

import com.marlene.locadrome.model.Car;

import java.util.List;

public interface CarDao {

    public List<Car> findAll();
    public Car findById(int id);
    public Car save(int id, String brand, String model, String color);
    public Car update(int id, String brand, String model, String color);
    public void delete(Car car);

}
