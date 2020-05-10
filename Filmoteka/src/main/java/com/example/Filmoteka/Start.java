package com.example.Filmoteka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

public class Start {

    private FilmRepository filmRepository;

    @Autowired
    public  Start (FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    @EventListener
    public void Run (){
        Film film = new Film("Tytanic","sdfghksf","safaf");
        filmRepository.save(film);
    }

}
