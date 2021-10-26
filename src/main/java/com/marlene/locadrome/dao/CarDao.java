package com.marlene.locadrome.dao;

import com.marlene.locadrome.model.Car;

import java.util.List;

public interface CarDao {

    public List<Car> findAll();
    public Car findById(int id);
    public void save(Car car);
    public void update(Car car, int id);
    public void delete(int id);

}
