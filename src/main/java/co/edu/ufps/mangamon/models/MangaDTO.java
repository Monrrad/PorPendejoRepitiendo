package co.edu.ufps.mangamon.models;

import lombok.Data;
import java.time.LocalDate;


@Data
public class MangaDTO {

    private Integer id;
    private String nombre;
    private LocalDate fecha_lanzamiento;
    private Integer temporadas;
    private Integer paisId;
    private Integer  anime;
    private Integer juego;
    private Integer pelicula;
    private Integer tipoId;

}
