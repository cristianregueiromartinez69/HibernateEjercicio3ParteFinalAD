package models.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

/**
 * Clase que representa la entidad "Pokemon" en la base de datos.
 * <p>
 * Mapeada con JPA, esta clase define los campos y relaciones de la tabla "pokemon".
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "pokemon")
public class Pokemon {

    /**
     * Identificador único del Pokémon.
     * Generado automáticamente usando la estrategia {@code GenerationType.IDENTITY}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('pokemon_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Nombre del Pokémon.
     * Almacena un máximo de 50 caracteres y no permite valores nulos.
     */
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    /**
     * Fecha de nacimiento del Pokémon.
     */
    @Column(name = "nacemento")
    private LocalDate nacemento;

    /**
     * Relación con la entidad {@link Pokedex}, indicando la entrada correspondiente en la Pokédex.
     * Utiliza una relación de muchos a uno con una carga tipo {@code EAGER}.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokedexentry")
    private Pokedex pokedexentry;

    /**
     * Relación con la entidad {@link Adestrador}, indicando el entrenador asociado al Pokémon.
     * Utiliza una relación de muchos a uno con una carga tipo {@code EAGER}.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adestrador")
    private Adestrador adestrador;

    /**
     * Constructor con todos los campos.
     *
     * @param id           Identificador único del Pokémon.
     * @param nome         Nombre del Pokémon.
     * @param nacemento    Fecha de nacimiento del Pokémon.
     * @param pokedexentry Entrada correspondiente en la Pokédex.
     * @param adestrador   Entrenador asociado al Pokémon.
     */
    public Pokemon(Integer id, String nome, LocalDate nacemento, Pokedex pokedexentry, Adestrador adestrador) {
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }

    /**
     * Constructor sin el campo {@code id}.
     * Útil para casos donde el identificador es generado automáticamente.
     *
     * @param nome         Nombre del Pokémon.
     * @param nacemento    Fecha de nacimiento del Pokémon.
     * @param pokedexentry Entrada correspondiente en la Pokédex.
     * @param adestrador   Entrenador asociado al Pokémon.
     */
    public Pokemon(String nome, LocalDate nacemento, Pokedex pokedexentry, Adestrador adestrador) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }

    /**
     * Constructor por defecto
     */
    public Pokemon() {
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

    public Pokedex getPokedexentry() {
        return pokedexentry;
    }

    public void setPokedexentry(Pokedex pokedexentry) {
        this.pokedexentry = pokedexentry;
    }

    public Adestrador getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(Adestrador adestrador) {
        this.adestrador = adestrador;
    }

    /**
     * Representación en forma de cadena del objeto {@code Pokemon}.
     *
     * @return Cadena con los detalles del Pokémon, formateada en varias líneas.
     */
    @Override
    public String toString() {
        return "Pokemon: " +
                "\nid: " + id +
                "\nnome: " + nome +
                "\nnacemento: " + nacemento +
                "\npokedexentry: " + pokedexentry +
                "\nadestrador=" + adestrador;
    }
}