package models.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "pokedex")
public class Pokedex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('pokedex_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "peso", precision = 10, scale = 2)
    private BigDecimal peso;

    @Column(name = "misc", length = Integer.MAX_VALUE)
    private String misc;

    public Pokedex(Integer id, String nome, BigDecimal peso, String misc) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    public Pokedex(String nome, BigDecimal peso, String misc) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    public Pokedex() {

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
        return "Pokedex: " +
                "\nid: " + id +
                "\nnome: " + nome +
                "\npeso: " + peso +
                "\nmisc: " + misc;
    }
}