package co.edu.ufps.mangamon.repositories;

import co.edu.ufps.mangamon.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

   public Usuario findByUsername(String username);

}