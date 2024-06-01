package co.edu.ufps.mangamon.models;

import lombok.Data;
import java.time.LocalDate;


@Data
public class MangaDTO {
    private Integer id;
    private String nombre;
    private LocalDate fecha_lanzamiento;
    private String temporadas;
    private String paisId;
    private String  anime;
    private String juego;
    private String pelicula;
    private String tipoId;
}
