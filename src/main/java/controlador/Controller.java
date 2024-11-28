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

/**
 * Clase que gestiona la lógica del programa, interactuando con las clases de servicios para realizar operaciones CRUD
 * en los objetos {@link Pokedex}, {@link Adestrador} y {@link Pokemon}. Esta clase también se encarga de leer y escribir
 * datos en ficheros y archivos XML.
 * @author cristian
 * @version 1.0
 */
public class Controller {

    /**
     * Metodo principal que gestiona la lógica del programa.
     * Realiza las siguientes acciones:
     * - Inserta datos en la base de datos para las tablas de {@link Pokedex}, {@link Adestrador} y {@link Pokemon}.
     * - Muestra los datos de los adestradores, la pokedex y los pokemons desde la base de datos.
     * - Realiza operaciones de escritura en ficheros binarios y XML.
     * - Realiza actualizaciones en los registros de adestradores, pokedex y pokemons.
     * - Borra los datos de las tablas al final del proceso.
     */
    public void logicaPrograma(){
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        MetodosPokemon metodosPokemon = new MetodosPokemon();
        LecturaEscrituraFicheros lef = new LecturaEscrituraFicheros();
        LecturaEscrituraXML lefXML = new LecturaEscrituraXML();

        Crud crud = new Crud();

        // Obtener listas de datos
        List<Pokedex> pokedexList = metodosPokedex.getPokemonsList();
        List<Adestrador> adestradorList = metodosAdestrador.getAdestradoresList();

        // Insertar datos en la base de datos
        crud.insertar10PokemonsPokedex(pokedexList);
        crud.insertar2Adestradores(adestradorList);

        // Crear y agregar pokemons a la base de datos
        List<Pokemon> pokemonList = metodosPokemon.getPokemonList(crud);
        crud.insertar12PokemonsPokemon(pokemonList);

        // Listar los datos de adestradores, pokedex y pokemons
        metodosAdestrador.listarAdestradores(crud.getAdestradoresFromDB());
        metodosPokedex.listarPokemonsFromPokedex(crud.getPokedexFromDB());
        metodosPokemon.listarPokemonFromPokemon(crud.getPokemonFromDB());

        // Escribir datos en un fichero binario
        String path2EntrysPokedex = "C:/Users/crm23/OneDrive/Escritorio/dam2Clase/FicherosSerialziadosHibernate3/entradasPokedex.dat";
        lef.escritura2EntradasPokedex(crud.getPokedexFromDB(), path2EntrysPokedex);

        // Escribir datos en un archivo XML
        lefXML.writeXMLFile2EntradasAdestrador(crud.getAdestradoresFromDB(), "adestradores.xml");

        // Actualizar registros en la base de datos
        crud.updateAdestradoresFromDB(1, "liko", LocalDate.of(2022, 4, 10));
        crud.updateAdestradoresFromDB(2, "polo", LocalDate.of(2010, 9, 25));

        crud.updatePokedexFromDB(1, "nidoking", BigDecimal.valueOf(62.0), "cornudo");
        crud.updatePokedexFromDB(2, "vaporeon", BigDecimal.valueOf(29.0), "sireno");

        crud.updatePokemonsFromDB(1, "annihilape", LocalDate.of(2021, 2, 25));
        crud.updatePokemonsFromDB(2, "alomomola", LocalDate.of(2013, 4, 12));
        crud.updatePokemonsFromDB(3, "excadrill", LocalDate.of(2016, 12, 1));
        crud.updatePokemonsFromDB(4, "greninja", LocalDate.of(2018, 9, 13));

        // Listar los datos después de la actualización
        metodosAdestrador.listarAdestradores(crud.getAdestradoresFromDB());
        metodosPokedex.listarPokemonsFromPokedex(crud.getPokedexFromDB());
        metodosPokemon.listarPokemonFromPokemon(crud.getPokemonFromDB());

        // Realizar actualizaciones auxiliares con ficheros
        metodosPokedex.auxUpdatePokedexFromDB(lef, crud, path2EntrysPokedex);
        metodosAdestrador.auxUpdateAdestradoresDB(lefXML, crud, "adestradores.xml");

        // Listar nuevamente los datos después de las actualizaciones auxiliares
        metodosAdestrador.listarAdestradores(crud.getAdestradoresFromDB());
        metodosPokedex.listarPokemonsFromPokedex(crud.getPokedexFromDB());
        metodosPokemon.listarPokemonFromPokemon(crud.getPokemonFromDB());

        // Eliminar los datos de las tablas al finalizar
        crud.deleteDataTables("DELETE FROM Pokemon");
        crud.deleteDataTables("DELETE FROM Pokedex");
        crud.deleteDataTables("DELETE FROM Adestrador");


    }
}
