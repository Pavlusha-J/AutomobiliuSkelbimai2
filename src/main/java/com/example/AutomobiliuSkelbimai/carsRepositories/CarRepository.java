package com.example.AutomobiliuSkelbimai.carsRepositories;

import com.example.AutomobiliuSkelbimai.models.Car;
import com.example.AutomobiliuSkelbimai.utils.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        byte[] bytes = car.getNuotrauka();
        ps.setBytes(8, bytes);
        ps.execute();
    }

    public List<Car> getCarList() throws SQLException {
        List<Car> carList = new ArrayList<>();
        PreparedStatement ps = Connect.SQLConnection("SELECT * FROM cars");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Car car = new Car(rs.getInt("id"), rs.getString("pavadinimas"),
                    rs.getString("marke"), rs.getString("modelis"), rs.getInt("metai"),
                    rs.getDouble("kaina"), rs.getInt("rida"), rs.getString("aprasymas"),
                    rs.getBytes("nuotrauka"));
            carList.add(car);
        }
        return carList;
    }

    public List<String> getMarkeList() throws SQLException {
        List<String> markeList = new ArrayList<>();
        PreparedStatement ps = Connect.SQLConnection("SELECT DISTINCT marke FROM cars");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            markeList.add(rs.getString("marke"));
        }
        return markeList;
    }

    public List<String> getModelisList(String marke) throws SQLException {
        List<String> modelisList = new ArrayList<>();
        PreparedStatement ps = Connect.SQLConnection("SELECT DISTINCT modelis FROM cars WHERE marke = ?");
        ps.setString(1, marke);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            modelisList.add(rs.getString("modelis"));
        }
        return modelisList;

    }

    public List<Car> getSearchList(String marke, String modelis, double kainanuo, double kainaiki) throws SQLException {
        List<Car> kainosList = new ArrayList<>();
        PreparedStatement ps = Connect.SQLConnection("SELECT * FROM cars WHERE marke = ? AND modelis = ? " +
                "AND kaina < ? AND kaina > ?");
        ps.setString(1, marke);
        ps.setString(2, modelis);
        ps.setDouble(3, kainaiki);
        ps.setDouble(4, kainanuo);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Car car = new Car(rs.getInt("id"), rs.getString("pavadinimas"),
                    rs.getString("marke"), rs.getString("modelis"), rs.getInt("metai"),
                    rs.getDouble("kaina"), rs.getInt("rida"), rs.getString("aprasymas"),
                    rs.getBytes("nuotrauka"));
            kainosList.add(car);
        }
        return kainosList;


    }

    public List<Car> getSearchListMarke(String marke, double kainaNuo, double kainaIki) throws SQLException {
        List<Car> kainosList = new ArrayList<>();
        PreparedStatement ps = Connect.SQLConnection("SELECT * FROM cars WHERE marke = ? AND kaina > ? AND kaina < ?");
        ps.setString(1, marke);
        ps.setDouble(2, kainaNuo);
        ps.setDouble(3, kainaIki);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Car car = new Car(rs.getInt("id"), rs.getString("pavadinimas"),
                    rs.getString("marke"), rs.getString("modelis"), rs.getInt("metai"),
                    rs.getDouble("kaina"), rs.getInt("rida"), rs.getString("aprasymas"),
                    rs.getBytes("nuotrauka"));
            kainosList.add(car);
        }
        return kainosList;
    }

    public List<Car> getSearchListKaina(double kainaNuo, double kainaIki) throws SQLException {
        List<Car> kainosList = new ArrayList<>();
        PreparedStatement ps = Connect.SQLConnection("SELECT * FROM cars WHERE kaina > ? AND kaina < ?");
        ps.setDouble(1, kainaNuo);
        ps.setDouble(2, kainaIki);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Car car = new Car(rs.getInt("id"), rs.getString("pavadinimas"),
                    rs.getString("marke"), rs.getString("modelis"), rs.getInt("metai"),
                    rs.getDouble("kaina"), rs.getInt("rida"), rs.getString("aprasymas"),
                    rs.getBytes("nuotrauka"));
            kainosList.add(car);
        }
        return kainosList;
    }

    public void modifyCar(Car car) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("UPDATE cars SET pavadinimas = ?, marke = ?, modelis = ?, metai = ?, kaina = ?, rida = ?, aprasymas = ?, nuotrauka = ? WHERE id = ?");
        ps.setString(1, car.getPavadinimas());
        ps.setString(2, car.getMarke());
        ps.setString(3, car.getModelis());
        ps.setInt(4, car.getMetai());
        ps.setDouble(5, car.getKaina());
        ps.setInt(6, car.getRida());
        ps.setString(7, car.getAprasymas());
        ps.setBytes(8, car.getNuotrauka());
        ps.setInt(9, car.getId());
        ps.execute();

    }

    public Car getCarById(int id) throws SQLException {
        Car car = null;
        PreparedStatement ps = Connect.SQLConnection("SELECT * FROM cars WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            car = new Car(rs.getInt("id"), rs.getString("pavadinimas"),
                    rs.getString("marke"), rs.getString("modelis"), rs.getInt("metai"),
                    rs.getDouble("kaina"), rs.getInt("rida"), rs.getString("aprasymas"),
                    rs.getBytes("nuotrauka"));
        }
        return car;
    }

    public void deleteCarById(int id) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("DELETE FROM cars WHERE id = ?");
        ps.setInt(1,id);
        ps.execute();
    }
}