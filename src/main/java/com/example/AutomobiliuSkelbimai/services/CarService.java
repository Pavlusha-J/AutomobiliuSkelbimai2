package com.example.AutomobiliuSkelbimai.services;

import com.example.AutomobiliuSkelbimai.carsRepositories.CarRepository;
import com.example.AutomobiliuSkelbimai.carsRepositories.VartotojasRepository;
import com.example.AutomobiliuSkelbimai.models.Car;
import com.example.AutomobiliuSkelbimai.models.Vartotojas;

import java.sql.SQLException;

public class CarService {


    CarRepository carRepository = new CarRepository();

    public void addCar(Car car) throws SQLException {
        carRepository.addCar(car);
    }

}

