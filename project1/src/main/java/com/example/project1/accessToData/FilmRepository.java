package com.example.project1.accessToData;

import com.example.project1.accessToData.table.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {

   @RestResource(path="findFilm",rel="findFilm")
   List<Film> findByTitleContaining(@RequestParam String title);



}
