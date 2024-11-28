package models.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

/**
 * Clase que representa la entidad "Pokedex" en la base de datos.
 * <p>
 * Mapeada con JPA, esta clase define los campos y relaciones de la tabla "pokedex".
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "pokedex")
public class Pokedex {

    /**
     * Identificador único del registro de la Pokédex.
     * Generado automáticamente usando la estrategia {@code GenerationType.IDENTITY}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('pokedex_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Nombre del Pokémon.
     * Almacena un máximo de 50 caracteres y no permite valores nulos.
     */
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    /**
     * Peso del Pokémon en la Pokédex.
     * Almacena un valor decimal con precisión de hasta 10 dígitos y escala de 2 decimales.
     */
    @Column(name = "peso", precision = 10, scale = 2)
    private BigDecimal peso;

    /**
     * Información adicional del Pokémon.
     * Puede contener textos largos.
     */
    @Column(name = "misc", length = Integer.MAX_VALUE)
    private String misc;

    /**
     * Constructor con todos los campos.
     *
     * @param id    Identificador único del registro de la Pokédex.
     * @param nome  Nombre del Pokémon.
     * @param peso  Peso del Pokémon.
     * @param misc  Información adicional del Pokémon.
     */
    public Pokedex(Integer id, String nome, BigDecimal peso, String misc) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    /**
     * Constructor sin el campo {@code id}.
     * Útil para casos donde el identificador es generado automáticamente.
     *
     * @param nome  Nombre del Pokémon.
     * @param peso  Peso del Pokémon.
     * @param misc  Información adicional del Pokémon.
     */
    public Pokedex(String nome, BigDecimal peso, String misc) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    //contructor por defecto
    public Pokedex() {

    }

    /**
     * Getter y Setter de la clase
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

    /**
     * Representación en forma de cadena del objeto {@code Pokedex}.
     *
     * @return Cadena con los detalles del registro de la Pokédex, formateada en varias líneas.
     */
    @Override
    public String toString() {
        return "Pokedex: " +
                "\nid: " + id +
                "\nnome: " + nome +
                "\npeso: " + peso +
                "\nmisc: " + misc;
    }
}