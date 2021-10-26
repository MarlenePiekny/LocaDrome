package com.marlene.locadrome.controller;

import com.marlene.locadrome.dao.CarDao;
import com.marlene.locadrome.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class carController {

    @Autowired
    private CarDao carDao;

    //LIST ALL CARS URI : /cars
    @GetMapping(value = "/cars")
    public List<Car> listCars(Car car) {
        return carDao.findAll();
    }

    //GET ONE CAR URI : /cars/{id}
    @GetMapping(value = "/cars/{id}")
    public Car displayCar(Car car, @PathVariable int id) {
        return carDao.findById(id);
    }

    //ADD CAR URI : /cars/
    @PostMapping(value = "/cars")
    public void saveCar(@RequestBody Car car) {
        carDao.save(car);
    }

    //UPDATE CAR URI : /cars
    @PutMapping(value="/cars/{id}")
    public void updateCar(Car car, @PathVariable int id) {
        carDao.update(car, id);
    }

    //DELETE CAR URI : /cars/{id}
    @RequestMapping(value = "/cars/{id}")
    public void deleteCar(@PathVariable int id)  {
        carDao.delete(id);
    }

}
