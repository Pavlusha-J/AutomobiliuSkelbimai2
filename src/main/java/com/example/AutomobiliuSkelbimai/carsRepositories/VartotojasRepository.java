package com.example.AutomobiliuSkelbimai.carsRepositories;


import com.example.AutomobiliuSkelbimai.models.Vartotojas;
import com.example.AutomobiliuSkelbimai.utils.Connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VartotojasRepository {

    public void addVartotojas(Vartotojas vartotojas) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("INSER INTO cars (pavadinimas, marke, modelis, metai, " +
                "kaina, rida, aprasymas, nuotrauka) VALUES (?,?,?,?,?,?,?,?)");
        ps.setString(1, vartotojas.getPavadinimas());
        ps.setString(2, vartotojas.getMarke());
        ps.setString(3, vartotojas.getModelis());
        ps.setInt(4, vartotojas.getMetai());
        ps.setDouble(5, vartotojas.getKaina());
        ps.setInt(6, vartotojas.getRida());
        ps.setString(7, vartotojas.getAprasymas());
        ps.setBytes(8, vartotojas.getNuotrauka());
}
