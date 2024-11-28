package models.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('pokemon_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacemento")
    private LocalDate nacemento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokedexentry")
    private Pokedex pokedexentry;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adestrador")
    private Adestrador adestrador;

    public Pokemon(Integer id, String nome, LocalDate nacemento, Pokedex pokedexentry, Adestrador adestrador) {
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }

    public Pokemon(String nome, LocalDate nacemento, Pokedex pokedexentry, Adestrador adestrador) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }

    public Pokemon() {
    }

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