package com.example.project1.api;

import com.example.project1.accessToData.table.Film;
import com.example.project1.manager.FilmManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class FilmApi {


    private FilmManager filmManager;

    @Autowired
    public FilmApi(FilmManager filmManager) {
        this.filmManager = filmManager;
    }

    @GetMapping("/lista")
    public Iterable<Film> getAll(){
        return this.filmManager.findAll();
    }

    @GetMapping
    public Optional<Film> getById(@RequestParam Long id){
        return this.filmManager.findById(id);
    }

    @PostMapping
    public Film addFilm(@RequestBody Film film){
        return this.filmManager.save(film);
    }

    @DeleteMapping
    public void deleteFilm(@RequestParam Long id){
        this.filmManager.deleteById(id);
    }

    @GetMapping("/victory")
    public String proba(){
        return "Udało sie ";
    }


}
