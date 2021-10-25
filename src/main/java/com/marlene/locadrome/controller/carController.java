package com.marlene.locadrome.controller;

import com.marlene.locadrome.dao.CarDao;
import com.marlene.locadrome.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
