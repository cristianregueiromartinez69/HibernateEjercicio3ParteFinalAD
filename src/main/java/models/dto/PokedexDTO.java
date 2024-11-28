package models.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PokedexDTO implements Serializable {

    private Integer id;
    private String nombre;
    private BigDecimal peso;
    private String misc;

    public PokedexDTO(Integer id, String nombre, BigDecimal peso, String misc) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.misc = misc;
    }

    public PokedexDTO() {

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

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "PokedexDTO: " +
                "\nid: " + id +
                "\nnombre: " + nombre +
                "\npeso: " + peso +
                "\nmisc: " + misc;
    }
}
