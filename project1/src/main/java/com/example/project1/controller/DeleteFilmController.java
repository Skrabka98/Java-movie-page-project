package com.example.project1.controller;

import com.example.project1.accessToData.model.Film;
import com.example.project1.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/delete")
public class DeleteFilmController {

    private final FilmService filmService;


    public DeleteFilmController(FilmService filmService) {
        this.filmService = filmService;
    }



    @GetMapping
    String showFilms(Model model){
        Iterable<Film> film = filmService.findAll();
        model.addAttribute("films",film);
        return "deleteFilms";
    }


    @GetMapping("/{id}")
    String delete(@PathVariable Long id, Model model){
        if (!filmService.exist(id)){
            ResponseEntity.notFound().build();
        }
        filmService.deleteById(id);
        ResponseEntity.noContent().build();
        model.addAttribute("message","Usunięto film");
        return "deleteFilms";
    }

}
