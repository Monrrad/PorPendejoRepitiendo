package co.edu.ufps.mangamon.controllers;

import co.edu.ufps.mangamon.entities.Manga;
import co.edu.ufps.mangamon.models.MangaDTO;
import co.edu.ufps.mangamon.services.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mangas")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @GetMapping
    public List<Manga> getAllMangas() {
        return mangaService.getAllMangas();
    }

    @GetMapping("/{id}")
    public ResponseEntity <?> getManga(@PathVariable Integer id) {
        try {
            Manga manga = mangaService.getMangaById(id);
            return ResponseEntity.ok(manga);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Manga createManga(@RequestBody MangaDTO mangaDTO) {
        return mangaService.createManga(mangaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manga> updateManga(@PathVariable Integer id, @RequestBody MangaDTO mangaDTO) {

        Manga updatedManga = mangaService.updateManga(id, mangaDTO);
        if (updatedManga == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(updatedManga);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteManga(@PathVariable Integer id) {
        try {
            Manga manga = mangaService.deleteManga(id);
            return ResponseEntity.ok(manga);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Manga not found");
        }
    }

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("message", "Servidor en funcionamiento");
        status.put("timestamp", LocalDateTime.now());
        return status;
    }
}