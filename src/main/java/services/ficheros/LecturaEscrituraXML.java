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

public class LecturaEscrituraXML {

    public void writeXMLFile2EntradasAdestrador(List<Adestrador> adestradoresList, String path){

        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        try{
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(path));
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("adestradores");

            for(int i = 0; i < adestradoresList.size(); i++){
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("adestrador");
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("id");
                xmlStreamWriter.writeCharacters(String.valueOf(adestradoresList.get(i).getId()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("nombre");
                xmlStreamWriter.writeCharacters(adestradoresList.get(i).getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("fechaNacimiento");
                xmlStreamWriter.writeCharacters(String.valueOf(adestradoresList.get(i).getNacemento()));
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
