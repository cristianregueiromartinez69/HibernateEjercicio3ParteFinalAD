package models.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class AdestradorDTO implements Serializable {
    private Integer id;
    private String nombre;
    private LocalDate fechaNacimiento;

    public AdestradorDTO(Integer id, String nombre, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public AdestradorDTO() {
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

    @Override
    public String toString() {
        return "AdestradorDTO: " +
                "\nid: " + id +
                "\nnombre: " + nombre + '\'' +
                "\nfechaNacimiento: " + fechaNacimiento;
    }
}
