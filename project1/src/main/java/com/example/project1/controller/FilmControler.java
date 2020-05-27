package com.example.project1.controller;

import com.example.project1.accessToData.FilmWrite;
import com.example.project1.accessToData.model.Film;
import com.example.project1.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/projects")
public class FilmControler {

    private final FilmService filmService;

    public FilmControler(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    String showFilms(Model model){
        model.addAttribute("project",new Film());
        return "projects";
    }

    @PostMapping
    String addFilm(@ModelAttribute ("project") @Valid Film film, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) return "projects";
        filmService.save(film);
        model.addAttribute("project",new Film());
        model.addAttribute("message","Dodano film");
        return "projects";
    }




}