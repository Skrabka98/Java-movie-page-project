package com.example.project1.api;

import com.example.project1.accessToData.table.Film;
import com.example.project1.manager.FilmManager;
import org.hibernate.sql.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/film")
public class FilmApi {

    private static final Logger logger = LoggerFactory.getLogger(FilmApi.class);
    private final FilmManager filmManager;

    @Autowired
    public FilmApi(final FilmManager filmManager) {
        this.filmManager = filmManager;
    }

    @GetMapping(value = "/lista",params = {"!sort", "!page", "!size"} )
    public ResponseEntity<Iterable<Film>> getAll(){
        logger.warn("Lista filmów");
        return ResponseEntity.ok(this.filmManager.findAll());
    }

   /* @GetMapping(value = "/lista")
    public ResponseEntity<Iterable<Film>> getAll(Pageable pegable){
        logger.info("Lista filmów");
        return ResponseEntity.ok(this.filmManager.findAll(pegable));
    }*/


    @GetMapping
    public ResponseEntity<List<Film>>  findFilm(@Param("title") String title){
        return ResponseEntity.ok(this.filmManager.findFilm(title));
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film){
        this.filmManager.save(film);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFilm(@PathVariable Long id,@RequestBody Film film){
        if (!this.filmManager.exist(id)){
            return  ResponseEntity.notFound().build();
        }
        film.setId(id);
        this.filmManager.save(film);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void deleteFilm(@RequestParam Long index){
        if (!this.filmManager.exist(index)){
              ResponseEntity.notFound().build();
        }
        this.filmManager.deleteById(index);
        ResponseEntity.noContent().build();
    }

   


}
