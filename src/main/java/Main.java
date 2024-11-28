import models.Adestrador;
import models.Pokedex;
import models.Pokemon;
import services.cruddb.Crud;
import services.metodosclases.MetodosAdestrador;
import services.metodosclases.MetodosPokedex;
import services.metodosclases.MetodosPokemon;

import java.util.List;

public class Main {

    public static void main(String[]args){
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        MetodosPokemon metodosPokemon = new MetodosPokemon();

        Crud crud = new Crud();

        List<Pokedex> pokedexList = metodosPokedex.getPokemonsList();
        List<Adestrador> adestradorList = metodosAdestrador.getAdestradoresList();

        //crud.insertar10PokemonsPokedex(pokedexList);
        //crud.insertar2Adestradores(adestradorList);

        List<Pokemon> pokemonList = metodosPokemon.getPokemonList(crud);
        //crud.insertar12PokemonsPokemon(pokemonList);

        metodosAdestrador.listarAdestradores(crud.getAdestradoresFromDB());
        metodosPokedex.listarPokemonsFromPokedex(crud.getPokedexFromDB());
        metodosPokemon.listarPokemonFromPokemon(crud.getPokemonFromDB());






    }
}
