package services.cruddb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import models.entitys.Adestrador;
import models.entitys.Pokedex;
import models.entitys.Pokemon;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public void updatePokedexFromDB(Integer id, String newNome, BigDecimal newPeso, String newMisc){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            Pokedex pokedex = em.find(Pokedex.class, id);

            if(pokedex != null){
                pokedex.setNome(newNome);
                pokedex.setPeso(newPeso);
                pokedex.setMisc(newMisc);
            }
            System.out.println("Entrada de la pokedex actualizada con éxito");
            tx.commit();

            if(tx.isActive()) tx.rollback();
        }
    }

    public void updateAdestradoresFromDB(Integer id, String newNome, LocalDate newNacemento){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            Adestrador adestrador = em.find(Adestrador.class, id);

            if(adestrador != null){
                adestrador.setNome(newNome);
                adestrador.setNacemento(newNacemento);
            }
            System.out.println("Entrada de adestrador actualizada con éxito");
            tx.commit();

            if(tx.isActive()) tx.rollback();
        }
    }

    public void updatePokemonsFromDB(Integer id, String newNome, LocalDate newNacemento){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            Pokemon pokemon = em.find(Pokemon.class, id);

            if(pokemon != null){
                pokemon.setNome(newNome);
                pokemon.setNacemento(newNacemento);
            }
            System.out.println("Entrada de pokemon actualizada con éxito");
            tx.commit();

            if(tx.isActive()) tx.rollback();
        }
    }

    public void deleteDataTables(String query){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try(managerFactory; em){
            tx.begin();

            int deleteCount = em.createNativeQuery(query).executeUpdate();

            tx.commit();
            if(deleteCount > 0){
                System.out.println("Se han borrado los datos de las tablas correctamente");
            }
            if(tx.isActive()) tx.rollback();
        }
    }






}
