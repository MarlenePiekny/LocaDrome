package com.marlene.locadrome.controller;

import com.marlene.locadrome.model.Car;
import com.marlene.locadrome.model.CarList;
import com.marlene.locadrome.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    //LIST ALL CARS URI : /cars
    @GetMapping(value = "/cars")
    public CarList listCars(Car car) {
        return carService.findAll();
    }

    //GET ONE CAR URI : /cars/{id}
    @GetMapping(value = "/cars/{id}")
    public Car displayCar(Car car, @PathVariable int id) {
        return carService.findById(id);
    }

    //ADD CAR URI : /cars/
    @PostMapping(value = "/cars")
    public void saveCar(@RequestBody Car car) {
        carService.save(car);
    }

    //UPDATE CAR URI : /cars/{id}
    @PutMapping(value="/cars/{id}")
    public void updateCar(@RequestBody Car car, @PathVariable int id) {
        carService.update(car, id);
    }

    //DELETE CAR URI : /cars/{id}
    @DeleteMapping(value = "/cars/{id}")
    public void deleteCar(@PathVariable int id)  {
        carService.delete(id);
    }

    //COLOR ALL CARS : /cars/color/{color}
    @GetMapping(value = "/cars/color/{color}")
    public void colorCars(@PathVariable String color) {
        carService.colorAllCars(color);
    }

}
