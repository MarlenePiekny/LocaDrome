package com.marlene.locadrome.service;

import com.marlene.locadrome.model.Car;
import com.marlene.locadrome.model.CarList;

public interface CarService {

    public CarList findAll();
    public Car findById(int id);
    public void save(Car car);
    public void update(Car car, int id);
    public void delete(int id);

}
