package com.example.AutomobiliuSkelbimai.carsRepositories;

import com.example.AutomobiliuSkelbimai.models.Car;
import com.example.AutomobiliuSkelbimai.utils.Connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarRepository {

    public void addCar(Car car) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("INSERT INTO cars (pavadinimas, marke, modelis, metai, " +
                "kaina, rida, aprasymas, nuotrauka) VALUES (?,?,?,?,?,?,?,?)");
        ps.setString(1, car.getPavadinimas());
        ps.setString(2, car.getMarke());
        ps.setString(3, car.getModelis());
        ps.setInt(4, car.getMetai());
        ps.setDouble(5, car.getKaina());
        ps.setInt(6, car.getRida());
        ps.setString(7, car.getAprasymas());
        ps.setBytes(8, car.getNuotrauka());
        ps.execute();
    }
}
