package com.marlene.locadrome.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private List<Car> carList;

    public CarList() {
        carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

}
