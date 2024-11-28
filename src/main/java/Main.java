import models.Adestrador;
import models.Pokedex;
import services.Crud;
import services.MetodosAdestrador;
import services.MetodosPokedex;

import java.util.List;

public class Main {

    public static void main(String[]args){
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        Crud crud = new Crud();

        List<Pokedex> pokedexList = metodosPokedex.getPokemonsList();
        List<Adestrador> adestradorList = metodosAdestrador.getAdestradoresList();

        crud.insertar10Pokemons(pokedexList);
        crud.insertar2Adestradores(adestradorList);



    }
}
