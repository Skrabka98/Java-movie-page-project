package com.example.project1.controller;

import com.example.project1.accessToData.model.Film;
import com.example.project1.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @DeleteMapping
    String delete(@RequestParam Long index, Model model){
        if (!filmService.exist(index)){
            ResponseEntity.notFound().build();
        }
        filmService.deleteById(index);
        ResponseEntity.noContent().build();
        model.addAttribute("message","Usunięto film");
        return "deleteFilms";
    }

}
