package co.edu.ufps.mangamon.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
}
