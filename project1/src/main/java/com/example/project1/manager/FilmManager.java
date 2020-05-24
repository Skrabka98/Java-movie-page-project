package com.example.project1.manager;

import com.example.project1.accessToData.FilmRead;
import com.example.project1.accessToData.FilmRepository;
import com.example.project1.accessToData.table.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import java.awt.print.Pageable;
import java.util.List;


@Service
public class FilmManager {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmManager(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;

    }
    //wtszukuje po tytule
    public List<Film> findFilm(String title){
        return this.filmRepository.findByTitleContaining(title);
    }

    public boolean exist(Long id){
        return this.filmRepository.existsById(id);
    }


    /*public Page<Film> findAll (Pageable pegable) {
        return this.filmRepository.findAll(pegable);
    }*/

    public Iterable<Film> findAll () {
        return this.filmRepository.findAll();
    }

    public Film save(Film film) {
        return this.filmRepository.save(film);
    }


    public void deleteById(Long id) {
       this.filmRepository.deleteById(id);
    }









 /*   //przy oruchominiu aplikacji dodaje film do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void saveDB(){
        save(new Film("Matrix", LocalDate.of(1999, 3,24),"najlepszy","link" ));
    }*/

}
