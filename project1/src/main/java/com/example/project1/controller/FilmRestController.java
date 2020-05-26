package com.example.project1.controller;

import com.example.project1.accessToData.model.Film;
import com.example.project1.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmRestController {

    private static final Logger logger = LoggerFactory.getLogger(FilmRestController.class);
    private final FilmService filmService; //połączenie z filmService


    @Autowired
    public FilmRestController(final FilmService filmService) {
        this.filmService = filmService;

    }

    //zwraca wszystkie filmy
    @GetMapping(value = "/lista",params = {"!sort", "!page", "!size"} )
    public ResponseEntity<Iterable<Film>> getAll(){
        logger.warn("Lista filmów");
        return ResponseEntity.ok(this.filmService.findAll());
    }

  /*  @GetMapping(value = "/lista")
    public ResponseEntity<Iterable<Film>> getAll(Pageable pegable){
        logger.info("Lista filmów");
        return ResponseEntity.ok(this.filmManager.findAll(pegable));
    }*/

    //wyszukuje film po tytule
    @GetMapping
    public ResponseEntity<List<Film>>  findFilm(@Param("title") String title){
        return ResponseEntity.ok(this.filmService.findFilm(title));
    }

    //dodawanie filmu
    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film){
        this.filmService.save(film);
        return ResponseEntity.noContent().build();
    }

    //edycja filmu o wybranym id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFilm(@PathVariable Long id,@RequestBody Film film){
        if (!this.filmService.exist(id)){
            return  ResponseEntity.notFound().build();
        }
        film.setId(id);
        this.filmService.save(film);
        return ResponseEntity.noContent().build();
    }

    //usuwanie filmu
    @DeleteMapping
    public void deleteFilm(@RequestParam Long index){
        if (!this.filmService.exist(index)){
              ResponseEntity.notFound().build();
        }
        this.filmService.deleteById(index);
        ResponseEntity.noContent().build();
    }

   


}
