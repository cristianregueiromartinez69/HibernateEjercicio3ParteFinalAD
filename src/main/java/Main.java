import controlador.Controller;
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

public class Main {

    public static void main(String[]args){

        new Controller().logicaPrograma();
    }
}
