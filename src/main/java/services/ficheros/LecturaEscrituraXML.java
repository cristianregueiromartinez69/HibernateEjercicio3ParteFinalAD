package services.ficheros;

import models.entitys.Adestrador;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
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
}
