package com.marlene.locadrome.dao;

import com.marlene.locadrome.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarImplDao implements CarDao {

    public List<Car> cars = new ArrayList<>();

    public CarImplDao() {
        cars.add(new Car(1, "Renault", "Clio 2", "grise"));
        cars.add(new Car(2, "Dacia", "Sandero", "noire"));
        cars.add(new Car(3, "Volkswagen", "Golf GTI", "bleu"));
        cars.add(new Car(4, "Porsche", "911", "noire"));
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(int id) {
        for (Car car: cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Car create() {
        Car createdCar = new Car(findLastCarIdCreated() +1);
        return createdCar;
    }

    @Override
    public Car save(Car newCar) {
        cars.add(newCar);
        return newCar;
    }

    @Override
    public Car update(int id, String brand, String model, String color) {
        for (Car car: cars) {
            if (car.getId() == id) {
                car.setBrand(brand);
                car.setModel(model);
                car.setColor(color);
                return car;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (Car car: cars) {
            if (car.getId() == id) {
                cars.remove(cars.indexOf(car));
            }
        }
    }

    public int findLastCarIdCreated() {
        return cars.get(cars.size()-1).getId();
    }

}
