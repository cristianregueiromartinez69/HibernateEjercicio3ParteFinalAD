package services;

import models.Adestrador;
import models.Pokedex;
import models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MetodosPokemon {

    public List<Pokemon> getPokemonList(Crud crud){
        List<Pokemon> pokemons = new ArrayList<>();

        List<Adestrador> adestradorList = crud.getAdestradoresFromDB();
        List<Pokedex> pokedexList = crud.getPokedexFromDB();


        Pokemon pokemon = new Pokemon();

        return null;
    }
}
