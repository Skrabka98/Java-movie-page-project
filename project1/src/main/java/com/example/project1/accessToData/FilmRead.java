package com.example.project1.accessToData;

import com.example.project1.accessToData.model.Film;

import java.time.LocalDate;

public class FilmRead {

    private String title;
    private LocalDate productionYear;

    public FilmRead(Film film) {
        title= film.getTitle();
        productionYear= film.getProductionYear();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }
}
