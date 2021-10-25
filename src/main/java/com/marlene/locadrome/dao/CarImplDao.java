package com.marlene.locadrome.dao;

import com.marlene.locadrome.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarImplDao implements CarDao {

    public static List<Car> cars = new ArrayList<>();
    static {
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
    public Car save(int id, String brand, String model, String color) {
        Car newCar = new Car(id, brand, model, color);
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
    public void delete(Car carToDelete) {
        for (Car car: cars) {
            if (car.getId() == carToDelete.getId()) {
                cars.remove(carToDelete);
            }
        }
    }
}
