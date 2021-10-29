package com.marlene.locadrome.dao;

import com.marlene.locadrome.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarDao extends JpaRepository<Car, Integer> {
    public Car findCarById(int id);
}
