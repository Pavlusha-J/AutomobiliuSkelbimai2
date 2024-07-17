package com.example.AutomobiliuSkelbimai.carsRepositories;


import com.example.AutomobiliuSkelbimai.models.Vartotojas;
import com.example.AutomobiliuSkelbimai.utils.Connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VartotojasRepository {

    public void addVartotojas(Vartotojas vartotojas) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("INSERT INTO users (name, email, password) " +
                "VALUES (?,?,?)");
        ps.setString(1, vartotojas.getName());
        ps.setString(2, vartotojas.getEmail());
        ps.setString(3, vartotojas.getPassword());
        ps.execute();
    }
}
