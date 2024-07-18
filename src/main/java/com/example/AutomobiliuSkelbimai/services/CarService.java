package com.example.AutomobiliuSkelbimai.services;

import com.example.AutomobiliuSkelbimai.carsRepositories.CarRepository;
import com.example.AutomobiliuSkelbimai.carsRepositories.VartotojasRepository;
import com.example.AutomobiliuSkelbimai.models.Car;
import com.example.AutomobiliuSkelbimai.models.Vartotojas;

import java.sql.SQLException;
import java.util.List;

public class CarService {


    CarRepository carRepository = new CarRepository();

    public void addCar(Car car) throws SQLException {
        carRepository.addCar(car);
    }

public List<Car>getCarList() throws SQLException {
    List<Car> carList = carRepository.getCarList();
    return carList;
}
    public List<String>getMarkeList() throws SQLException {
        List<String> markeList = carRepository.getMarkeList();
        return markeList;
    }

    public List<String>getModelisList() throws SQLException {
        List<String> modelisList = carRepository.getModelisList();
        return modelisList;
    }
}

