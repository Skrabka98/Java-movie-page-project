package com.example.project1.service;

import com.example.project1.accessToData.FilmRead;
import com.example.project1.accessToData.FilmWrite;
import com.example.project1.accessToData.model.Film;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceNieWiemPoCo {

    private FilmService filmManager;

    public FilmServiceNieWiemPoCo(FilmService filmManager) {
        this. filmManager =  filmManager;
    }


}
