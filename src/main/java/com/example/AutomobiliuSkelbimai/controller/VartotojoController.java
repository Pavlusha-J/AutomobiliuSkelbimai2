package com.example.AutomobiliuSkelbimai.controller;

import com.example.AutomobiliuSkelbimai.carsRepositories.VartotojasRepository;
import com.example.AutomobiliuSkelbimai.models.Vartotojas;
import com.example.AutomobiliuSkelbimai.services.VartotojoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class VartotojoController {

    VartotojoService vartotojoService = new VartotojoService();

    @CrossOrigin
    @GetMapping("/addVartotojas")
    public void addVartotojas(@RequestBody Vartotojas vartotojas) throws SQLException {
        vartotojoService.addVartotojas(vartotojas);
    }
}
