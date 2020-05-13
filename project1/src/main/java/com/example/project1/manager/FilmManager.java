package com.example.project1.manager;

import com.example.project1.accessToData.FilmRepository;
import com.example.project1.accessToData.table.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FilmManager {

    private FilmRepository filmRepository;

    @Autowired
    public FilmManager(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;

    }

    public Optional<Film> findById (Long id) {
        return this.filmRepository.findById(id);
    }

    public Iterable<Film> findAll () {
        return this.filmRepository.findAll();
    }

    public Film save(Film film) {
        return this.filmRepository.save(film);
    }
    public void deleteById(Long id) {
       this.filmRepository.deleteById(id);
    }

    //jeszcez dopisze się metode która wyświrtla filmy posortowane po nazwie ale to potem
    //bo nie che mi sie teraz szukać        Lista < T > findAll ( Sort  sort)


    //przy oruchominiu aplikacji dodaje film do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void saveDB(){
        save(new Film("Matrix", LocalDate.of(1999, 3,24),"najlepszy","link" ));
    }

}
