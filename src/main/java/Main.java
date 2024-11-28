import models.Pokedex;
import services.Crud;
import services.MetodosPokedex;

import java.util.List;

public class Main {

    public static void main(String[]args){
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        Crud crud = new Crud();

        List<Pokedex> pokedexList = metodosPokedex.getPokemonsList();
        crud.insertar10Pokemons(pokedexList);



    }
}
