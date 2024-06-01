package co.edu.ufps.mangamon.models;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer id;
    private String username;
    private String nombre;
    private String email;
    private String password;


}
