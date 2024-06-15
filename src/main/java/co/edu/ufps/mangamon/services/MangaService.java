package co.edu.ufps.mangamon.services;
import co.edu.ufps.mangamon.entities.Manga;
import co.edu.ufps.mangamon.entities.Pais;
import co.edu.ufps.mangamon.entities.Tipo;
import co.edu.ufps.mangamon.models.MangaDTO;
import co.edu.ufps.mangamon.repositories.MangaRepository;
import co.edu.ufps.mangamon.repositories.PaisRepository;
import co.edu.ufps.mangamon.repositories.TipoRepository;
import co.edu.ufps.mangamon.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private TipoRepository tipoRepository;

    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }

    public Manga getMangaById(Integer id) {

       Optional <Manga> manga = mangaRepository.findById(id);
       if(manga.isPresent()) {
           return manga.get();
       } else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }

    }

    public Manga createManga(MangaDTO mangaDTO) {
        Manga manga = new Manga();
        manga.setNombre(mangaDTO.getNombre());
        manga.setFechaLanzamiento(mangaDTO.getFecha_lanzamiento());
        manga.setTemporadas(mangaDTO.getTemporadas());
        manga.setAnime(mangaDTO.getAnime());
        manga.setJuego(mangaDTO.getJuego());
        manga.setPelicula(mangaDTO.getPelicula());

        Optional<Pais> pais = paisRepository.findById(mangaDTO.getPaisId());

        Optional<Tipo> tipo = tipoRepository.findById(mangaDTO.getTipoId());

        if (pais.isPresent() && tipo.isPresent()) {
            manga.setPais(pais.get());
            manga.setTipo(tipo.get());
        }

        return mangaRepository.save(manga);
    }

    public Manga updateManga(Integer id, MangaDTO mangaDTO) {

        Manga mangaFound = getMangaById(id);

        mangaFound.setNombre(mangaDTO.getNombre());
        mangaFound.setFechaLanzamiento(mangaDTO.getFecha_lanzamiento());
        mangaFound.setTemporadas(mangaDTO.getTemporadas());
        mangaFound.setAnime(mangaDTO.getAnime());
        mangaFound.setJuego(mangaDTO.getJuego());
        mangaFound.setPelicula(mangaDTO.getPelicula());

        Optional<Pais> pais = paisRepository.findById(mangaDTO.getPaisId());

        Optional<Tipo> tipo = tipoRepository.findById(mangaDTO.getTipoId());

        if (pais.isPresent() && tipo.isPresent()) {
            mangaFound.setPais(pais.get());
            mangaFound.setTipo(tipo.get());
        }

        return mangaFound;
    }

    public Manga deleteManga(Integer id) {
        Manga mangaFound = getMangaById(id);
        if (mangaFound != null) {
            mangaRepository.delete(mangaFound);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return mangaFound;
    }
}
