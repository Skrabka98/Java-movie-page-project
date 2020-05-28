package com.example.project1.service;

import com.example.project1.dao.FilmRepository;
import com.example.project1.accessToData.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class FilmService {

    //odwołuje się do film repository które dziediczy po jparepoziotory a tam znajduja sie wszystkie metody które wywołujemy po kropce
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;

    }

    //wtszukuje po tytule
    public List<Film> findFilm(String title){
        return this.filmRepository.findByTitleContaining(title);
    }

//sprawdza czy istnieje film o takim id
    public boolean exist(Long id){
        return this.filmRepository.existsById(id);
    }


    /*public Page<Film> findAll (Pageable pegable) {
        return this.filmRepository.findAll(pegable);
    }*/

// zwraca wszystkie filmy
    public Iterable<Film> findAll () {
        return this.filmRepository.findAll();
    }

    public Optional<Film>  findById(Long id){
        return this.filmRepository.findById(id);
    }

    //zapisuje nowy film do bazy
    public Film save(Film film) {
        return this.filmRepository.save(film);
    }

    //usuwa film po id
    public void deleteById(Long id) {
        this.filmRepository.deleteById(id);
    }









 /*   //przy oruchominiu aplikacji dodaje film do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void saveDB(){
        save(new Film("Matrix", LocalDate.of(1999, 3,24),"najlepszy","link" ));
    }*/

}