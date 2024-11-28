package services.metodosclases;

import models.entitys.Pokedex;
import services.cruddb.Crud;
import services.ficheros.LecturaEscrituraFicheros;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene métodos auxiliares relacionados con la gestión de objetos {@link Pokedex}.
 * Incluye funcionalidades para crear listas de pokemons, listar los pokemons y
 * actualizar la base de datos a partir de un archivo de texto.
 * @author cristian
 * @version 1.0
 */
public class MetodosPokedex {

    /**
     * Crea y devuelve una lista de pokemons predefinidos con sus respectivos atributos.
     *
     * @return una lista de objetos {@link Pokedex}.
     */
    public List<Pokedex> getPokemonsList() {
        List<Pokedex> pokemons = new ArrayList<>();
        Pokedex pokedex1 = new Pokedex("pikachu", BigDecimal.valueOf(6.0), "rata hepatítica");
        Pokedex pokedex2 = new Pokedex("gengar", BigDecimal.valueOf(40.5), "risitas");
        Pokedex pokedex3 = new Pokedex("Feraligatr", BigDecimal.valueOf(88.0), "mandibulon");
        Pokedex pokedex4 = new Pokedex("tinkaton", BigDecimal.valueOf(112.8), "niña martillo");
        Pokedex pokedex5 = new Pokedex("steelix", BigDecimal.valueOf(400.0), "durisimo");
        Pokedex pokedex6 = new Pokedex("houndoom", BigDecimal.valueOf(35.0), "perrazo");
        Pokedex pokedex7 = new Pokedex("sneasler", BigDecimal.valueOf(43.0), "depilador");
        Pokedex pokedex8 = new Pokedex("aerodactyl", BigDecimal.valueOf(59.0), "terry");
        Pokedex pokedex9 = new Pokedex("charizard", BigDecimal.valueOf(90.5), "chorizardo");
        Pokedex pokedex10 = new Pokedex("gholdengo", BigDecimal.valueOf(30.0), "tio gilito");

        pokemons.add(pokedex1);
        pokemons.add(pokedex2);
        pokemons.add(pokedex3);
        pokemons.add(pokedex4);
        pokemons.add(pokedex5);
        pokemons.add(pokedex6);
        pokemons.add(pokedex7);
        pokemons.add(pokedex8);
        pokemons.add(pokedex9);
        pokemons.add(pokedex10);

        return pokemons;
    }

    /**
     * Lista los pokemons de una colección dada imprimiéndolos en consola.
     *
     * @param pokemons la lista de objetos {@link Pokedex} a listar.
     */
    public void listarPokemonsFromPokedex(List<Pokedex> pokemons) {
        for(Pokedex pokedex : pokemons) {
            System.out.println(pokedex);
        }
    }

    /**
     * Actualiza las entradas de la pokedex en la base de datos a partir de un archivo de texto.
     * Para cada entrada en el archivo, se realiza una actualización en la base de datos.
     *
     * @param lef   una instancia de {@link LecturaEscrituraFicheros} para leer los datos del archivo de texto.
     * @param crud  una instancia de {@link Crud} para realizar las actualizaciones en la base de datos.
     * @param path  la ruta del archivo de texto que contiene los datos de la pokedex.
     */
    public void auxUpdatePokedexFromDB(LecturaEscrituraFicheros lef, Crud crud, String path){
        for(int i = 0; i < lef.lectura2EntradasPokedex(path).size(); i++){
            crud.updatePokedexFromDB(lef.lectura2EntradasPokedex(path).get(i).getId(),
                    lef.lectura2EntradasPokedex(path).get(i).getNome(),
                    lef.lectura2EntradasPokedex(path).get(i).getPeso(),
                    lef.lectura2EntradasPokedex(path).get(i).getMisc());
        }
        System.out.println("Entradas actualizadas correctamente");
    }


}
