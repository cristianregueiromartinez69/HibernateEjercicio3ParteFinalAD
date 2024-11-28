package services.ficheros;

import models.entitys.Adestrador;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la lectura y escritura de archivos XML relacionados con la entidad {@link models.entitys.Adestrador}.
 * Permite almacenar y recuperar objetos de tipo {@link Adestrador} en formato XML.
 * @author cristian
 * @version 1.0
 */

public class LecturaEscrituraXML {

    /**
     * Escribe las primeras dos entradas de una lista de objetos {@link Adestrador} en un archivo XML.
     * Si el archivo no existe, se crea uno nuevo.
     *
     * @param adestradoresList la lista de objetos {@link Adestrador} a escribir en el archivo XML.
     * @param path             la ruta del archivo XML donde se escribirán los datos.
     */
    public void writeXMLFile2EntradasAdestrador(List<Adestrador> adestradoresList, String path){

        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        try{
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(path));
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("adestradores");

            for (Adestrador adestrador : adestradoresList) {
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("adestrador");
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("id");
                xmlStreamWriter.writeCharacters(String.valueOf(adestrador.getId()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("nombre");
                xmlStreamWriter.writeCharacters(adestrador.getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("fechaNacimiento");
                xmlStreamWriter.writeCharacters(String.valueOf(adestrador.getNacemento()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();

            System.out.println("Fichero xml de adestradores escrito correctamente");
        } catch (XMLStreamException e) {
            System.out.println("Ups, error al escribir en el xml el archivo de adestradores");
        } catch (IOException e) {
            System.out.println("Ups, error durante la ejecución de escritura de fichero xml de adestradores");
        }
    }

    /**
     * Lee un archivo XML y recupera una lista de objetos {@link Adestrador}.
     * Convierte cada entrada en el archivo XML en un objeto {@link Adestrador}.
     *
     * @param path la ruta del archivo XML que contiene los datos de los adestradores.
     * @return una lista de objetos {@link Adestrador} recuperados del archivo XML.
     */
    public List<Adestrador> getAdestradoresFromXML(String path){
        List<Adestrador> adestradoresList = new ArrayList<>();

        String elementoActual = "";
        Integer id = 0;
        String nombre = "";
        LocalDate fechaNacimiento = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try{
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(path));
            int element;

            while(xmlStreamReader.hasNext()){
                element = xmlStreamReader.next();

                if(element == XMLStreamConstants.START_ELEMENT){
                    elementoActual = xmlStreamReader.getLocalName();

                }
                else if(element == XMLStreamConstants.CHARACTERS){
                    String text = xmlStreamReader.getText().trim();
                    if("id".equals(elementoActual) && !text.isEmpty()){
                        id = Integer.parseInt(text);
                    }
                    else if("nombre".equals(elementoActual) && !text.isEmpty()){
                        nombre = text;
                    } else if ("fechaNacimiento".equals(elementoActual) && !text.isEmpty()) {
                        fechaNacimiento = LocalDate.parse(text);
                    }
                }
                else if(element == XMLStreamConstants.END_ELEMENT){
                    if("adestrador".equals(xmlStreamReader.getLocalName())){
                        adestradoresList.add(new Adestrador(id, nombre, fechaNacimiento));
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println("Ups, error al leer el archivo xml de adestradores");
        } catch (FileNotFoundException e) {
            System.out.println("Ups, no se encontró el archivo xml de adestradores");
        }
        return adestradoresList;
    }
}
