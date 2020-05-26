package com.example.project1.controller;

import com.example.project1.accessToData.model.Film;
import com.example.project1.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value = "/")
public class FilmIndexControler {
    private final FilmService filmService;

    public FilmIndexControler(FilmService filmService) {
        this.filmService = filmService;
    }


    @GetMapping
    String showFilms(Model model){
        Iterable<Film> film = filmService.findAll();
        model.addAttribute("films",film);
        return "index";
    }


}
