package com.example.project1.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class FilmControler {

    @GetMapping
    String showFilms(){
        return "projects";
    }
}
