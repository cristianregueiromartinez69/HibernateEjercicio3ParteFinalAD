package models.dto;

import models.entitys.Adestrador;
import models.entitys.Pokedex;

import java.io.Serializable;
import java.time.LocalDate;

public class PokemonDTO implements Serializable {

   private Integer id;
   private String nombre;
   private LocalDate fechaNacimiento;
   private Pokedex pokedexEntry;
   private Adestrador adestradorEntry;

    public PokemonDTO(Integer id, String nombre, LocalDate fechaNacimiento, Pokedex pokedexEntry, Adestrador adestradorEntry) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.pokedexEntry = pokedexEntry;
        this.adestradorEntry = adestradorEntry;
    }

    public PokemonDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Pokedex getPokedexEntry() {
        return pokedexEntry;
    }

    public void setPokedexEntry(Pokedex pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }

    public Adestrador getAdestradorEntry() {
        return adestradorEntry;
    }

    public void setAdestradorEntry(Adestrador adestradorEntry) {
        this.adestradorEntry = adestradorEntry;
    }

    @Override
    public String toString() {
        return "PokemonDTO: " +
                "\nid: " + id +
                "\nnombre: " + nombre +
                "\nfechaNacimiento: " + fechaNacimiento +
                "\npokedexEntry: " + pokedexEntry +
                "\nadestradorEntry: " + adestradorEntry;
    }
}
