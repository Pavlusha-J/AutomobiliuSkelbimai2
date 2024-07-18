package com.example.AutomobiliuSkelbimai.controller;

import com.example.AutomobiliuSkelbimai.carsRepositories.CarRepository;
import com.example.AutomobiliuSkelbimai.models.Car;
import com.example.AutomobiliuSkelbimai.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CarController {

    CarService carService = new CarService();

    @CrossOrigin
    @PostMapping("/addCar")
    public void addCar(@RequestBody Car car) throws SQLException {
        carService.addCar(car);
    }
    @CrossOrigin
    @GetMapping("/getCar")
    public List<Car>getCarList() throws SQLException {
        List<Car> carList = carService.getCarList();
        return carList;
    }
    @CrossOrigin
    @GetMapping("/getMarke")
    public List<String>getMarkeList() throws SQLException {
        List<String> markeList = carService.getMarkeList();
        return markeList;
    }
    @CrossOrigin
    @GetMapping ("/getModelis")
    public List<String>getModelisList() throws SQLException {
        List<String> modelisList = carService.getModelisList();
        return modelisList;
    }
      }








