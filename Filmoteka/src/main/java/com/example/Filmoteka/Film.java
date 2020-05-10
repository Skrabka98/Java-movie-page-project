package com.example.Filmoteka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;


@Entity
//@Table(name = "film") //nir wiem czemu wywala błąd??
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String link; //może jest cos lepszego


    public Film( String title,String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;

    }
    public Film(){

    }



}
