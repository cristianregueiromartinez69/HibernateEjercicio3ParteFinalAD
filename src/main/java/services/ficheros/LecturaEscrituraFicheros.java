package services.ficheros;

import models.dto.PokedexDTO;
import models.entitys.Pokedex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LecturaEscrituraFicheros {

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

    private static void auxLectura2EntradasPokedex(String path, List<Pokedex> pokedexList) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

        PokedexDTO pokedexDTO;

        while((pokedexDTO = (PokedexDTO) ois.readObject()) != null){
            pokedexList.add(new Pokedex(pokedexDTO.id(), pokedexDTO.nombre(), pokedexDTO.peso(), pokedexDTO.misc()));
        }
    }

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
