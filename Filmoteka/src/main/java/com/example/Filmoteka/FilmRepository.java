package com.example.Filmoteka;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface FilmRepository extends JpaRepository<Film, Integer> {

}
