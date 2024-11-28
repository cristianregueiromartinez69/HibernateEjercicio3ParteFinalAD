package services;

import models.Adestrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MetodosAdestrador {

    public List<Adestrador> getAdestradoresList(){
        List<Adestrador> adestradores = new ArrayList<>();
        LocalDate dateAd1 = LocalDate.of(1990, 10, 20);
        Adestrador ad1 = new Adestrador("ash mostaza", dateAd1);

        LocalDate dateAd2 = LocalDate.of(2006, 5, 12);
        Adestrador ad2 = new Adestrador("tobías", dateAd2);

        adestradores.add(ad1);
        adestradores.add(ad2);

        return adestradores;
    }
}
