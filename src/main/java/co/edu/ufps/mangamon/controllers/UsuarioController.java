package co.edu.ufps.mangamon.controllers;

import co.edu.ufps.mangamon.services.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.ufps.mangamon.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity <?> getAllUsurios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @GetMapping("/{username}/favoritos")
    public ResponseEntity <?> getFavorites(@PathVariable String username) {
        return usuarioService.getFavorites(username);
    }

}
