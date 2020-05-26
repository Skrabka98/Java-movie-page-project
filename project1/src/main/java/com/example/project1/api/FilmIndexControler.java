package com.example.project1.api;

import com.example.project1.accessToData.table.Film;
import com.example.project1.manager.FilmManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FilmIndexControler {
    private final FilmManager filmManager;

    public FilmIndexControler(FilmManager filmManager) {
        this.filmManager = filmManager;
    }

    @RequestMapping(value = "/index")
    String showFilms(Model model){
        Iterable<Film> film = filmManager.findAll();
        model.addAttribute("film",film);
        return "index";
    }
}
