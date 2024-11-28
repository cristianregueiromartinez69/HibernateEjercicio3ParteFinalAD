package services.ficheros;

import models.dto.PokedexDTO;
import models.entitys.Pokedex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la lectura y escritura de archivos relacionados con la entidad Pokedex.
 * Permite almacenar y recuperar objetos de tipo {@link models.entitys.Pokedex} en archivos serializados.
 * @author cristian
 * @version 1.0
 */
public class LecturaEscrituraFicheros {

    /**
     * Escribe las primeras dos entradas de una lista de objetos {@link Pokedex} en un archivo serializado.
     * Si el archivo no existe, se crea uno nuevo.
     *
     * @param pokedexList la lista de objetos {@link Pokedex} a escribir.
     * @param path        la ruta del archivo donde se escribirán las entradas.
     */
    public void escritura2EntradasPokedex(List<Pokedex> pokedexList, String path) {
        File file = new File(path);
        if (!file.exists()) {
            auxWriteObject2EntrysPokedex(pokedexList, path, file);
        }
        else{
            if(file.isFile()){
                auxWriteObject2EntrysPokedex(pokedexList, path, file);
            }
        }
    }

    /**
     * Lee las primeras dos entradas de un archivo serializado que contiene objetos {@link PokedexDTO}.
     * Los datos leídos se transforman en una lista de objetos {@link Pokedex}.
     *
     * @param path la ruta del archivo que contiene las entradas serializadas.
     * @return una lista de objetos {@link Pokedex} leídos del archivo.
     */
    public List<Pokedex> lectura2EntradasPokedex(String path) {
        File file = new File(path);
        List<Pokedex> pokedexList = new ArrayList<>();
        if (file.exists()) {
            try{
                auxLectura2EntradasPokedex(path, pokedexList);
            } catch (FileNotFoundException e) {
                System.out.println("Ups, fichero de 2 entradas en pokedex no encontrado");
            } catch (IOException e) {
                System.out.println("Ups, error al leer fichero de 2 entradas en la pokedex");
            } catch (ClassNotFoundException e) {
                System.out.println("Ups, clase no encontrada en la pokedexDTO");
            }
        }
        return pokedexList;
    }

    /**
     * Metodo auxiliar para la lectura de objetos {@link PokedexDTO} desde un archivo serializado.
     * Los datos leídos se transforman en objetos {@link Pokedex} y se añaden a una lista.
     *
     * @param path         la ruta del archivo que contiene los datos serializados.
     * @param pokedexList  la lista donde se almacenarán los objetos {@link Pokedex} leídos.
     * @throws IOException            si ocurre un error al acceder al archivo.
     * @throws ClassNotFoundException si no se encuentra la clase durante la deserialización.
     */
    private static void auxLectura2EntradasPokedex(String path, List<Pokedex> pokedexList) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

        PokedexDTO pokedexDTO;

        while((pokedexDTO = (PokedexDTO) ois.readObject()) != null){
            pokedexList.add(new Pokedex(pokedexDTO.id(), pokedexDTO.nombre(), pokedexDTO.peso(), pokedexDTO.misc()));
        }
    }

    /**
     * Metodo auxiliar para escribir las primeras dos entradas de una lista de objetos {@link Pokedex} en un archivo serializado.
     * Si el archivo no existe, se crea uno nuevo.
     *
     * @param pokedexList la lista de objetos {@link Pokedex} a escribir.
     * @param path        la ruta del archivo donde se escribirán las entradas.
     * @param file        el archivo en el que se almacenarán los datos.
     */
    private void auxWriteObject2EntrysPokedex(List<Pokedex> pokedexList, String path, File file) {
        try{
            if(file.createNewFile()){
                ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(path));

                for(int i = 0; i < 2; i++){
                    ous.writeObject(new PokedexDTO(pokedexList.get(i).getId(), pokedexList.get(i).getNome(), pokedexList.get(i).getPeso(), pokedexList.get(i).getMisc()));
                }
                System.out.println("Fichero 2 entradas de pokedex escrito correctamente");
                ous.close();
            }
        } catch (IOException e) {
            System.out.println("Ups, no se pudo crear el archivo serializado para escribir 2 entradas de la pokedex");
        }
    }


}
