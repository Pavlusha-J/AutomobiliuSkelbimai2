package com.example.AutomobiliuSkelbimai.carsRepositories;


import com.example.AutomobiliuSkelbimai.models.Vartotojas;
import com.example.AutomobiliuSkelbimai.utils.Connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VartotojasRepository {

    public void addVartotojas(Vartotojas vartotojas) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("INSER INTO users (id, name, email, password) " +
                "VALUES (?,?,?,?)");
        ps.setInt(1, vartotojas.getId());
        ps.setString(2, vartotojas.getName());
        ps.setString(3, vartotojas.getEmail());
        ps.setString(4, vartotojas.getPassword());

    }
    }
