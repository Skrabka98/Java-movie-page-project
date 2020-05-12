package com.example.project1.manager;

import com.example.project1.accessToData.FilmRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmManager {
    private FilmRepository filmRepository;

    public FilmManager(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
}
