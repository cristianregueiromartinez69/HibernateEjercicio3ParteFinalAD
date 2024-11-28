package controlador;

import models.entitys.Adestrador;
import models.entitys.Pokedex;
import models.entitys.Pokemon;
import services.cruddb.Crud;
import services.ficheros.LecturaEscrituraFicheros;
import services.ficheros.LecturaEscrituraXML;
import services.metodosclases.MetodosAdestrador;
import services.metodosclases.MetodosPokedex;
import services.metodosclases.MetodosPokemon;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Controller {

    public void logicaPrograma(){
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        MetodosPokemon metodosPokemon = new MetodosPokemon();
        LecturaEscrituraFicheros lef = new LecturaEscrituraFicheros();
        LecturaEscrituraXML lefXML = new LecturaEscrituraXML();

        Crud crud = new Crud();

        List<Pokedex> pokedexList = metodosPokedex.getPokemonsList();
        List<Adestrador> adestradorList = metodosAdestrador.getAdestradoresList();

        crud.insertar10PokemonsPokedex(pokedexList);
        crud.insertar2Adestradores(adestradorList);

        List<Pokemon> pokemonList = metodosPokemon.getPokemonList(crud);
        crud.insertar12PokemonsPokemon(pokemonList);

        metodosAdestrador.listarAdestradores(crud.getAdestradoresFromDB());
        metodosPokedex.listarPokemonsFromPokedex(crud.getPokedexFromDB());
        metodosPokemon.listarPokemonFromPokemon(crud.getPokemonFromDB());

        String path2EntrysPokedex = "C:/Users/crm23/OneDrive/Escritorio/dam2Clase/FicherosSerialziadosHibernate3/entradasPokedex.dat";

        lef.escritura2EntradasPokedex(crud.getPokedexFromDB(), path2EntrysPokedex);

        lefXML.writeXMLFile2EntradasAdestrador(crud.getAdestradoresFromDB(), "adestradores.xml");

        crud.updateAdestradoresFromDB(3, "liko", LocalDate.of(2022, 4, 10));
        crud.updateAdestradoresFromDB(4, "polo", LocalDate.of(2010, 9, 25));

        crud.updatePokedexFromDB(11, "nidoking", BigDecimal.valueOf(62.0), "cornudo");
        crud.updatePokedexFromDB(12, "vaporeon", BigDecimal.valueOf(29.0), "sireno");

        metodosAdestrador.listarAdestradores(crud.getAdestradoresFromDB());
        metodosPokedex.listarPokemonsFromPokedex(crud.getPokedexFromDB());
        metodosPokemon.listarPokemonFromPokemon(crud.getPokemonFromDB());

        metodosPokedex.auxUpdatePokedexFromDB(lef, crud, path2EntrysPokedex);

        metodosAdestrador.auxUpdateAdestradoresDB(lefXML, crud, "adestradores.xml");

        metodosAdestrador.listarAdestradores(crud.getAdestradoresFromDB());
        metodosPokedex.listarPokemonsFromPokedex(crud.getPokedexFromDB());
        metodosPokemon.listarPokemonFromPokemon(crud.getPokemonFromDB());

        crud.deleteDataTables("DELETE FROM Pokemon");
        crud.deleteDataTables("DELETE FROM Pokedex");
        crud.deleteDataTables("DELETE FROM Adestrador");


    }
}
