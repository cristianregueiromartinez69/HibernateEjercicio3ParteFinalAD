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

/**
 * Clase Crud que proporciona métodos para realizar operaciones CRUD
 * (Crear, Leer, Actualizar, Eliminar) en una base de datos.
 *
 * Utiliza JPA para gestionar entidades relacionadas con Pokémon,
 * Entrenadores (Adestradores) y la Pokedex.
 * @author cristian
 * @version 1.0
 */
public class Crud {

    /**
     * Inserta una lista de 10 entradas en la tabla "Pokedex".
     *
     * @param pokedexList Lista de objetos Pokedex a insertar en la base de datos.
     */
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

    /**
     * Inserta una lista de 2 entrenadores en la tabla "Adestrador".
     *
     * @param adestradorList Lista de objetos Adestrador a insertar en la base de datos.
     */
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

    /**
     * Inserta una lista de 12 Pokémon en la tabla "Pokemon".
     *
     * @param pokemonList Lista de objetos Pokemon a insertar en la base de datos.
     */
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

    /**
     * Obtiene una lista de todos los entrenadores (Adestradores) almacenados en la base de datos.
     *
     * @return Lista de objetos Adestrador recuperados.
     */
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

    /**
     * Obtiene una lista de todas las entradas de la Pokedex almacenadas en la base de datos.
     *
     * @return Lista de objetos Pokedex recuperados.
     */
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

    /**
     * Obtiene una lista de todos los Pokémon almacenados en la base de datos.
     *
     * @return Lista de objetos Pokemon recuperados.
     */
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

    /**
     * Actualiza una entrada en la tabla "Pokedex" con nuevos valores.
     *
     * @param id        Identificador único de la entrada a actualizar.
     * @param newNome   Nuevo nombre para la entrada.
     * @param newPeso   Nuevo peso para la entrada.
     * @param newMisc   Nueva información adicional para la entrada.
     */
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

    /**
     * Actualiza una entrada en la tabla "Adestrador" con nuevos valores.
     *
     * @param id            Identificador único del entrenador a actualizar.
     * @param newNome       Nuevo nombre para el entrenador.
     * @param newNacemento  Nueva fecha de nacimiento para el entrenador.
     */
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

    /**
     * Actualiza una entrada en la tabla "Pokemon" con nuevos valores.
     *
     * @param id            Identificador único del Pokémon a actualizar.
     * @param newNome       Nuevo nombre para el Pokémon.
     * @param newNacemento  Nueva fecha de nacimiento para el Pokémon.
     */
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

    /**
     * Borra datos de tablas utilizando una consulta nativa.
     *
     * @param query Consulta SQL nativa para realizar la operación de eliminación.
     */
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
