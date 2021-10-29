package com.marlene.locadrome.service;

import com.marlene.locadrome.dao.CarDao;
import com.marlene.locadrome.model.Car;
import com.marlene.locadrome.model.CarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarImplService implements CarService {

    @Autowired
    private CarDao carDao;

    public CarImplService() {

    }

    @Override
    public CarList findAll() {
        CarList carList = new CarList();
        carList.setCarList(carDao.findAll());
        return carList;
    }

    @Override
    public Car findById(int id) {
        return carDao.findCarById(id);
    }

    @Override
    public void save(Car car) {
        carDao.saveAndFlush(car);
    }

    @Override
    public void update(Car car, int id) {
        carDao.saveAndFlush(car);
    }

    @Override
    public void delete(int id) {
            carDao.delete(carDao.findCarById(id));
    }

    @Override
    public void colorAllCars(String color) {
        carDao.colorAllCars(color);
    }
    public int findLastCarIdCreated() {
        return carDao.findAll().get(carDao.findAll().size()-1).getId();
    }

}
