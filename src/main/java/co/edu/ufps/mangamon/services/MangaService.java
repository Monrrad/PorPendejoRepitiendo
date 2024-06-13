package co.edu.ufps.mangamon.services;
import co.edu.ufps.mangamon.entities.Manga;
import co.edu.ufps.mangamon.repositories.MangaRepository;
import co.edu.ufps.mangamon.repositories.PaisRepository;
import co.edu.ufps.mangamon.repositories.TipoRepository;
import co.edu.ufps.mangamon.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity <?> getMangaById(String id) {

        Integer idManga = 0;
        try {

            idManga = Integer.parseInt(id);
        } catch (Exception e){
            return new ResponseEntity(new Mensaje("Id de manga No es un entero", 500), HttpStatus.BAD_REQUEST);

        }
       Optional <Manga> mangaOpt = mangaRepository.findById(idManga);
       if (mangaOpt.isPresent()) {
           return ResponseEntity.ok(mangaOpt.get());
       } else
       return new ResponseEntity(new Mensaje("Manga No Encontrado",404), HttpStatus.NOT_FOUND);
    }

    public Manga createManga(Manga manga) {
        return mangaRepository.save(manga);
    }

    public Manga updateManga(Integer id, Manga manga) {

        if (mangaRepository.existsById(id)) {
            manga.setId(id);
            return mangaRepository.save(manga);
        }
        return null;
    }

    public void deleteManga(Integer id) {
        mangaRepository.deleteById(id);
    }
}
