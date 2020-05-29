package com.example.project1.controller;
import java.util.Optional;

import com.example.project1.accessToData.model.Film;
import com.example.project1.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/proba")
public class FilmAdminController
{

    @Autowired
    private final FilmService filmService;

    public FilmAdminController(FilmService filmService) {
        this.filmService = filmService;
    }



    @GetMapping
    public String getAllEmployees(Model model)
    {
        Iterable<Film> film = filmService.findAll();
        model.addAttribute("films",film);
        return "admin";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String updateOrAddFilm(Model model, @PathVariable("id") Optional<Long> id) throws Exception
    {
        if (id.isPresent()) {
            Film film = filmService.findFilmById(id.get());
            model.addAttribute("film", film);
        } else {
            model.addAttribute("film", new Film());
        }
        return "editOrAdd";
    }

    @GetMapping("/{id}")
    String delete(@PathVariable Long id, Model model){
        if (!filmService.exist(id)){
            ResponseEntity.notFound().build();
        }
        filmService.deleteById(id);
        ResponseEntity.noContent().build();
        return "redirect:/proba";
    }

    @RequestMapping(path = "/addFilm", method = RequestMethod.POST)
    public String editOrAddFilm(Film film)
    {
        filmService.editOrAddFilm(film);
        return "redirect:/proba";
    }
}


