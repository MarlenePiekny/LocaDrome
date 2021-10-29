package com.marlene.locadrome.dao;

import com.marlene.locadrome.model.Car;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CarDao extends JpaRepository<Car, Integer> {
    public Car findCarById(int id);

    @Query("UPDATE car SET color =:'color'")
    public void colorAllCars(String color);
}
