package co.edu.ufps.mangamon.repositories;
import co.edu.ufps.mangamon.entities.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<Manga, Integer> {
}
