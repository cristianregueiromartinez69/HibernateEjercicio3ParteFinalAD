package services.metodosclases;

import models.entitys.Adestrador;
import services.cruddb.Crud;
import services.ficheros.LecturaEscrituraXML;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene métodos auxiliares relacionados con la gestión de objetos {@link Adestrador}.
 * Incluye funcionalidades para crear listas de adestradores, listar los adestradores y
 * actualizar la base de datos a partir de un archivo XML.
 * @author cristian
 * @version 1.0
 */
public class MetodosAdestrador {

    /**
     * Crea y devuelve una lista de adestradores predefinidos.
     *
     * @return una lista de objetos {@link Adestrador}.
     */
    public List<Adestrador> getAdestradoresList(){
        List<Adestrador> adestradores = new ArrayList<>();
        LocalDate dateAd1 = LocalDate.of(1990, 10, 20);
        Adestrador ad1 = new Adestrador("ash mostaza", dateAd1);

        LocalDate dateAd2 = LocalDate.of(2006, 5, 12);
        Adestrador ad2 = new Adestrador("tobías", dateAd2);

        adestradores.add(ad1);
        adestradores.add(ad2);

        return adestradores;
    }

    /**
     * Lista los adestradores de una colección dada imprimiéndolos en consola.
     *
     * @param adestradores la lista de objetos {@link Adestrador} a listar.
     */
    public void listarAdestradores(List<Adestrador> adestradores){
        for(Adestrador ad : adestradores){
            System.out.println(ad);
        }
    }

    /**
     * Actualiza los datos de los adestradores en la base de datos a partir de un archivo XML.
     * Para cada entrada en el archivo XML, se realiza una actualización en la base de datos.
     *
     * @param xml  una instancia de {@link LecturaEscrituraXML} para leer los datos del archivo XML.
     * @param crud una instancia de {@link Crud} para realizar las actualizaciones en la base de datos.
     * @param path la ruta del archivo XML que contiene los datos de los adestradores.
     */
    public void auxUpdateAdestradoresDB(LecturaEscrituraXML xml, Crud crud, String path){
        for(int i = 0; i < xml.getAdestradoresFromXML(path).size(); i++){
            crud.updateAdestradoresFromDB(xml.getAdestradoresFromXML(path).get(i).getId(),
                    xml.getAdestradoresFromXML(path).get(i).getNome(),
                    xml.getAdestradoresFromXML(path).get(i).getNacemento());
        }
        System.out.println("Adestradores actualizados con éxito");
    }
}
