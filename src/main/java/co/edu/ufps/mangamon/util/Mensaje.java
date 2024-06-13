package co.edu.ufps.mangamon.util;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mensaje {

    private String mensaje;

    private Integer status;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
        this.status = 200;
    }
}
