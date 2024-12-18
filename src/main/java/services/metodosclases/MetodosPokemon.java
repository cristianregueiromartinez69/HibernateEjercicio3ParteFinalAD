package services.metodosclases;

import models.entitys.Adestrador;
import models.entitys.Pokedex;
import models.entitys.Pokemon;
import services.cruddb.Crud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene métodos auxiliares relacionados con la gestión de objetos {@link Pokemon}.
 * Proporciona métodos para crear una lista de pokemons con datos de {@link Pokedex} y {@link Adestrador},
 * y para listar los pokemons en consola.
 * @author cristian
 * @version 1.0
 */
public class MetodosPokemon {

    /**
     * Crea y devuelve una lista de pokemons, asociándolos con sus datos de {@link Pokedex} y {@link Adestrador}
     * desde la base de datos a través de la clase {@link Crud}.
     *
     * @param crud la instancia de {@link Crud} para obtener los datos de los adestradores y la pokedex.
     * @return una lista de objetos {@link Pokemon}.
     */
    public List<Pokemon> getPokemonList(Crud crud){
        List<Pokemon> pokemonsList = new ArrayList<>();

        List<Adestrador> adestradorList = crud.getAdestradoresFromDB();
        List<Pokedex> pokedexList = crud.getPokedexFromDB();


        Pokemon pokemon1 = new Pokemon("pikachu", LocalDate.of(1990, 1, 20), pokedexList.get(0), adestradorList.get(0));
        Pokemon pokemon2 = new Pokemon("gengar", LocalDate.of(2000, 2, 12), pokedexList.get(1), adestradorList.get(0));
        Pokemon pokemon3 = new Pokemon("Feraligatr", LocalDate.of(2002, 3, 7), pokedexList.get(2), adestradorList.get(0));
        Pokemon pokemon4 = new Pokemon("tinkaton", LocalDate.of(2022, 8, 11), pokedexList.get(3), adestradorList.get(0));
        Pokemon pokemon5 = new Pokemon("steelix", LocalDate.of(2001, 7, 29), pokedexList.get(4), adestradorList.get(0));
        Pokemon pokemon6 = new Pokemon("houndoom", LocalDate.of(2003, 10, 1), pokedexList.get(5), adestradorList.get(0));
        Pokemon pokemon7 = new Pokemon("sneasler", LocalDate.of(2010, 4, 18), pokedexList.get(6), adestradorList.get(1));
        Pokemon pokemon8 = new Pokemon("aerodactyl", LocalDate.of(2017, 5, 26), pokedexList.get(7), adestradorList.get(1));
        Pokemon pokemon9 = new Pokemon("charizard", LocalDate.of(2008, 9, 9), pokedexList.get(8), adestradorList.get(1));
        Pokemon pokemon10 = new Pokemon("goldengho", LocalDate.of(2022, 12, 25), pokedexList.get(9), adestradorList.get(1));
        Pokemon pokemon11 = new Pokemon("dragonite", LocalDate.of(1998, 6, 8), null, adestradorList.get(1));
        Pokemon pokemon12 = new Pokemon("gyarados", LocalDate.of(2005, 7, 7), null, adestradorList.get(1));

        pokemonsList.add(pokemon1);
        pokemonsList.add(pokemon2);
        pokemonsList.add(pokemon3);
        pokemonsList.add(pokemon4);
        pokemonsList.add(pokemon5);
        pokemonsList.add(pokemon6);
        pokemonsList.add(pokemon7);
        pokemonsList.add(pokemon8);
        pokemonsList.add(pokemon9);
        pokemonsList.add(pokemon10);
        pokemonsList.add(pokemon11);
        pokemonsList.add(pokemon12);

        return pokemonsList;
    }

    /**
     * Lista los pokemons de una colección dada imprimiéndolos en consola.
     *
     * @param pokemonList la lista de objetos {@link Pokemon} a listar.
     */
    public void listarPokemonFromPokemon(List<Pokemon> pokemonList){
        for(Pokemon pokemon : pokemonList){
            System.out.println(pokemon);
        }
    }


}
