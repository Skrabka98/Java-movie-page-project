package com.example.project1.controller;

import com.example.project1.accessToData.model.Film;
import com.example.project1.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping(value = "/film")
public class FilmViewController {


        private final FilmService filmService;

        public FilmViewController(FilmService filmService) {
            this.filmService = filmService;
        }

        @GetMapping()
        String showFilms(Model model){
            Iterable<Film> film = filmService.findAll();
            model.addAttribute("films",film);
            return "movie";
        }


        @GetMapping("/{id}")
        String getFilmById(@PathVariable Long id, Model model){
            var film = filmService.findById(id);
            model.addAttribute("films",film.get());
            return "movie";
        }


}
