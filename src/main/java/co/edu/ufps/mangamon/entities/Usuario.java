package co.edu.ufps.mangamon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.nio.MappedByteBuffer;
import java.util.List;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String username;
    private String email;
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "usuarios")
    public List<Manga> mangas;
}
