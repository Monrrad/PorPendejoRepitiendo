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
    public ResponseEntity <?> getAllMangas() {
        return ResponseEntity.ok(mangaService.getAllMangas());
    }
@GetMapping("/{id}")
    public ResponseEntity <?> getManga(@PathVariable String id) {
        return mangaService.getMangaById(id);
}

@PostMapping
    public Manga createManga(@RequestBody Manga manga) {
        return mangaService.createManga(manga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manga> updateManga(@PathVariable Integer id, @RequestBody Manga manga) {
        Manga updatedManga = mangaService.updateManga(id, manga);
        if (updatedManga == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(updatedManga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteManga(@PathVariable Integer id) {
        mangaService.deleteManga(id);
        return ResponseEntity.ok("Manga deleted successfully");
    }

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("message", "Servidor en funcionamiento");
        status.put("timestamp", LocalDateTime.now());
        return status;
    }
}


