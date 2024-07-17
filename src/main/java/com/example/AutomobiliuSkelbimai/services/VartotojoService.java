package com.example.AutomobiliuSkelbimai.services;

import com.example.AutomobiliuSkelbimai.carsRepositories.VartotojasRepository;
import com.example.AutomobiliuSkelbimai.models.Vartotojas;

import java.sql.SQLException;

public class VartotojoService {

    VartotojasRepository vartotojasRepository = new VartotojasRepository();
    public void addVartotojas(Vartotojas vartotojas) throws SQLException {
        vartotojasRepository.addVartotojas(vartotojas);
    }
}
