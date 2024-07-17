package com.example.AutomobiliuSkelbimai.controller;

import com.example.AutomobiliuSkelbimai.models.Car;
import com.example.AutomobiliuSkelbimai.services.CarService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
@RestController
public class CarController {

         CarService carService = new CarService();

        @CrossOrigin
        @PostMapping("/addCar")
        public void addCar(@RequestBody Car car) throws SQLException {
            carService.addCar(car);
        }
    }





