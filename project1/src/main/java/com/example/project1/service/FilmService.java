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
    public List<Film> findFilm(String title) {
        return this.filmRepository.findByTitleContaining(title);
    }

    //sprawdza czy istnieje film o takim id
    public boolean exist(Long id) {
        return this.filmRepository.existsById(id);
    }


    /*public Page<Film> findAll (Pageable pegable) {
        return this.filmRepository.findAll(pegable);
    }*/

    // zwraca wszystkie filmy
    public Iterable<Film> findAll() {
        return this.filmRepository.findAll();
    }

    public Optional<Film> findById(Long id) {
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

    public Film findFilmById(Long id) throws Exception
    {
        Optional<Film> filmOptional = filmRepository.findById(id);

        if(filmOptional.isPresent()) {
            return filmOptional.get();
        }else {
           throw new Exception();
        }
    }



    //dodaje lub usuwa film
    public Film editOrAddFilm(Film film) {
        if (film.getId() == null) {
            film = filmRepository.save(film);

            return film;
        } else {
            Optional<Film> optionalFilm = filmRepository.findById(film.getId());

            if (optionalFilm.isPresent()) {
                Film newFilm = optionalFilm.get();
                newFilm.setTitle(film.getTitle());
                newFilm.setProductionYear(film.getProductionYear());
                newFilm.setDescryption(film.getDescryption());
                newFilm.setLink(film.getLink());

                newFilm = filmRepository.save(newFilm);

                return newFilm;
            } else {
                film = filmRepository.save(film);

                return film;
            }
        }
    }
}








 /*   //przy oruchominiu aplikacji dodaje film do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void saveDB(){
        save(new Film("Matrix", LocalDate.of(1999, 3,24),"najlepszy","link" ));
    }*/

