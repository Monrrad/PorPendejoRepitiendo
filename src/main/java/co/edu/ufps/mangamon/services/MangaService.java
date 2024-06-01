package co.edu.ufps.mangamon.services;


import co.edu.ufps.mangamon.entities.Manga;
import co.edu.ufps.mangamon.repositories.MangaRepository;
import co.edu.ufps.mangamon.repositories.PaisRepository;
import co.edu.ufps.mangamon.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return mangaRepository.findById(id).orElse(null);
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
