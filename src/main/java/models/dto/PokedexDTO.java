package models.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Clase de registro que representa un objeto de transferencia de datos (DTO) para un Pokémon en la Pokedex.
 * <p>
 * Esta clase se utiliza para transportar datos de un Pokémon entre diferentes capas de la aplicación,
 * implementando la interfaz {@link Serializable} para permitir su serialización.
 *
 * @param id     Identificador único del Pokémon.
 * @param nombre Nombre del Pokémon.
 * @param peso   Peso del Pokémon, representado como un {@link BigDecimal}.
 * @param misc   Información adicional del Pokémon.
 * @author cristian
 * @version 1.0
 */
public record PokedexDTO(Integer id, String nombre, BigDecimal peso, String misc) implements Serializable {


    /**
     * Representación en forma de cadena del objeto {@code PokedexDTO}.
     *
     * @return Cadena con los detalles del objeto {@code PokedexDTO}, formateada en varias líneas.
     */
    @Override
    public String toString() {
        return "PokedexDTO: " +
                "\nid: " + id +
                "\nnombre: " + nombre +
                "\npeso: " + peso +
                "\nmisc: " + misc;
    }
}
