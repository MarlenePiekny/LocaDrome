package com.marlene.locadrome.dao;

import com.marlene.locadrome.model.Car;
//import com.marlene.locadrome.model.CarList;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public abstract class CarImplDao {

//    public List<Car> cars = new ArrayList<>();
//
//    public CarImplDao() {
//        cars.add(new Car(1, "Renault", "Clio 2", "grise"));
//        cars.add(new Car(2, "Dacia", "Sandero", "noire"));
//        cars.add(new Car(3, "Volkswagen", "Golf GTI", "bleu"));
//        cars.add(new Car(4, "Porsche", "911", "noire"));
//    }
//
//    @Override
//    public List<Car> findAll() {
//        return cars;
//    }
//
//    @Override
//    public Car findById(int id) {
//        for (Car car: cars) {
//            if (car.getId() == id) {
//                return car;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Car save(Car car) {
//        car.setId(findLastCarIdCreated() +1);
//        cars.add(car);
//        return car;
//    }
//
//    @Override
//    public void update(Car car, int id) {
//        for (Car c: cars) {
//            if (c.getId() == id) {
//                if (!car.getBrand().equals("")) {
//                    c.setBrand(car.getBrand());
//                }
//                if (!car.getModel().equals("")) {
//                    c.setModel(car.getModel());
//                }
//                if (!car.getColor().equals("")) {
//                    c.setColor(car.getColor());
//                }
//            }
//        }
//    }
//
//    @Override
//    public void delete(int id) {
//        cars.remove(this.getCarIndexById(id));
//    }
//
//
//    @Override
//    public void deleteAll() {
//        cars.clear();
//    }
//
//    private int getCarIndexById(int id) {
//        for (int i = 0; i < cars.size(); i++) {
//            if (cars.get(i).getId() == id) {
//                return i;
//            }
//        }
//
//        throw new RuntimeException(String.format("Car with id: %d does not exist", id));
//    }
//
//    public int findLastCarIdCreated() {
//        return cars.get(cars.size()-1).getId();
//    }

//}
