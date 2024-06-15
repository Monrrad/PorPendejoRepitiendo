package co.edu.ufps.mangamon.services;

import co.edu.ufps.mangamon.entities.Manga;
import co.edu.ufps.mangamon.entities.Usuario;
import co.edu.ufps.mangamon.models.MangaDTO;
import co.edu.ufps.mangamon.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public ResponseEntity<?> getFavoritesMangas (String username){

       Usuario usuario = usuarioRepository.findByUsername(username);
       return ResponseEntity.ok(usuario.getMangas());

    }

}