package models.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

/**
 * Clase que representa la entidad "Adestrador" en la base de datos.
 * <p>
 * Mapeada con JPA, esta clase define los campos y relaciones de la tabla "adestrador".
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "adestrador")
public class Adestrador {

    /**
     * Identificador único del adestrador.
     * Generado automáticamente usando la estrategia {@code GenerationType.IDENTITY}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('adestrador_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Nombre del adestrador.
     * Almacena un máximo de 50 caracteres y no permite valores nulos.
     */
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    /**
     * Fecha de nacimiento del adestrador.
     * Puede ser nula.
     */
    @Column(name = "nacemento")
    private LocalDate nacemento;

    /**
     * Constructor con todos los campos.
     *
     * @param id         Identificador único del adestrador.
     * @param nome       Nombre del adestrador.
     * @param nacemento  Fecha de nacimiento del adestrador.
     */
    public Adestrador(Integer id, String nome, LocalDate nacemento) {
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
    }

    /**
     * Constructor sin el campo {@code id}.
     * Útil para casos donde el identificador es generado automáticamente.
     *
     * @param nome       Nombre del adestrador.
     * @param nacemento  Fecha de nacimiento del adestrador.
     */
    public Adestrador(String nome, LocalDate nacemento) {
        this.nome = nome;
        this.nacemento = nacemento;
    }

    //constructor por defecto
    public Adestrador() {

    }

    /**
     * getter y setter de la clase
     * @return los atributos correspondientes
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNacemento() {
        return nacemento;
    }

    public void setNacemento(LocalDate nacemento) {
        this.nacemento = nacemento;
    }

    /**
     * Representación en forma de cadena del objeto {@code Adestrador}.
     *
     * @return Cadena con los detalles del adestrador, formateada en varias líneas.
     */
    @Override
    public String toString() {
        return "Adestrador: " +
                "\nid: " + id +
                "\nnome: " + nome +
                "\nnacemento: " + nacemento;
    }
}