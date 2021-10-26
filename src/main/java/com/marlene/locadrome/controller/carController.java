package com.marlene.locadrome.controller;

import com.marlene.locadrome.dao.CarDao;
import com.marlene.locadrome.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class carController {

    @Autowired
    private CarDao carDao;

    //DISPLAY HOME PAGE URI : /
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET )
    public String welcome() {
        return "index";
    }

    //DISPLAY ALL CARS URI : /cars
    @GetMapping(value = "/cars")
    public String listCars(Model model) {
        model.addAttribute("cars", carDao.findAll());
        return "carList";
    }

    //DISPLAY ONE CAR URI : /cars/{id}
    @GetMapping(value = "/cars/{id}")
    public String displayCar(Model model, @PathVariable int id) {
        model.addAttribute("car", carDao.findById(id));
        return "car";
    }

    //DISPLAY ADD CAR FORM URI : /cars/add
    @GetMapping(value = "/addCar")
    public String showAddCar(Model model) {
        model.addAttribute("car", carDao.create());
        return "addCar";
    }

    //SAVE CAR URI : /cars/add
    @PostMapping(value = "/addCar")
    public String saveCar(Model model, //
        @ModelAttribute("car") Car car) {
        carDao.save(car);
        return "redirect:/cars";
    }

    //DELETE CAR URI : /cars/{id}
    @GetMapping(value = "deleteCar/{id}")
    public String deleteCar(Model model, @PathVariable int id) {
        carDao.delete(id);
        return "redirect:/";
    }
}
