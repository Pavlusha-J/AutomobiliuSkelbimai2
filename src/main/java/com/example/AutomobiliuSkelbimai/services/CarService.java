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

    public List<String>getModelisList(String marke) throws SQLException {
        List<String> modelisList = carRepository.getModelisList(marke);
        return modelisList;
    }
    public List<Car> getSearchList(String marke, String modelis, double kainaNuo, double kainaIki) throws SQLException {
        if(marke == ""){
            return carRepository.getSearchListKaina(kainaNuo, kainaIki);
        }
        if(modelis == ""){
            return carRepository.getSearchListMarke(marke, kainaNuo, kainaIki);
        }
        return carRepository.getSearchList(marke, modelis, kainaNuo, kainaIki);
    }
    public void modifyCar(Car car) throws SQLException {
        carRepository.modifyCar(car);
    }
    public Car getCarById(int id) throws SQLException {
        return carRepository.getCarById(id);
    }
}

