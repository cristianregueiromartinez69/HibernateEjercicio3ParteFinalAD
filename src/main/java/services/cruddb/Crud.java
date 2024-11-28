package services.cruddb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import models.Adestrador;
import models.Pokedex;
import models.Pokemon;

import java.util.List;

public class Crud {

    public void insertar10PokemonsPokedex(List<Pokedex> pokedexList){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            for(Pokedex pokedex : pokedexList){
                em.persist(pokedex);
            }
            System.out.println("Los 10 pokemons han sido insertados con éxito en la tabla Pokedex");
            tx.commit();
        }finally{
            if(tx.isActive()) tx.rollback();
        }
    }

    public void insertar2Adestradores(List<Adestrador> adestradorList){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            for(Adestrador adestrador : adestradorList){
                em.persist(adestrador);
            }
            System.out.println("Los 2 adestradores han sido introducidos en la tabla Adestrador");
            tx.commit();
        }
    }

    public void insertar12PokemonsPokemon(List<Pokemon> pokemonList){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            for(Pokemon pokemon : pokemonList){
                em.persist(pokemon);
            }
            System.out.println("Los 12 pokemons han sido insertados con éxito en la tabla Pokemon");
            tx.commit();

            if(tx.isActive()) tx.rollback();
        }
    }

    public List<Adestrador> getAdestradoresFromDB(){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<Adestrador> adestradores = null;

        try(managerFactory; em){

            tx.begin();

            adestradores = em.createQuery("SELECT p from Adestrador p", Adestrador.class).getResultList();
            tx.commit();

            if(tx.isActive()) tx.rollback();
        }
        return adestradores;
    }

    public List<Pokedex> getPokedexFromDB(){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<Pokedex> pokedexList = null;

        try(managerFactory; em){

            tx.begin();

            pokedexList = em.createQuery("SELECT p from Pokedex p", Pokedex.class).getResultList();
            tx.commit();

            if(tx.isActive()) tx.rollback();
        }
        return pokedexList;
    }

    public List<Pokemon> getPokemonFromDB(){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<Pokemon> pokemonList = null;

        try(managerFactory; em){
            tx.begin();

            pokemonList = em.createQuery("SELECT p from Pokemon p", Pokemon.class).getResultList();
            tx.commit();

            if(tx.isActive()) tx.rollback();
        }
        return pokemonList;
    }




}
