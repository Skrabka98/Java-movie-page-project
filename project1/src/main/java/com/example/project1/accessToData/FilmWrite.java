package com.example.project1.accessToData;

import com.example.project1.accessToData.table.Film;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class FilmWrite {

    @NotEmpty(message="To pole nie może byś puste")
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate productionYear;
    private String descryption;
    @NotEmpty(message="To pole nie może byś puste")
    private String link;


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

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public Film createFilm(){
        return new Film(title,productionYear,descryption,link);
    }
}
