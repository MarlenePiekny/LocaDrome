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
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public void save(Car car) {
        carDao.save(car);
    }

    @Override
    public void update(Car car, int id) {
        carDao.update(car, id);
    }

    @Override
    public void delete(int id) {
        carDao.delete(id);
    }
}
