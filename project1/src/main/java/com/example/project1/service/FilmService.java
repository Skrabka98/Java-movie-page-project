package com.example.project1.service;

import com.example.project1.accessToData.FilmRead;
import com.example.project1.accessToData.FilmRepository;
import com.example.project1.manager.FilmManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private FilmManager filmManager;

    public FilmService(FilmManager filmManager) {
        this. filmManager =  filmManager;
    }

   /* public List<FilmRead> readAll(){
        return filmManager.findAll()
    }*/
}
