package co.edu.ufps.mangamon.models;

import lombok.Data;

import java.util.Date;

@Data
public class MangaDTO {
    private Integer id;
    private String nombre;
    private Date fecha_lanzamiento;
    private String temporadas;
    private String pais_id;
    private String  anime;
    private String juego;
    private String pelicula;
    private String tipo_id;
}
