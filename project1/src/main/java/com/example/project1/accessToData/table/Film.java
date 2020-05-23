package com.example.project1.accessToData.table;




import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
public class Film  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message="To pole nie może byś puste")
   // @Column(unique = true) zeby tytuły filmu sie nie powtarzały ale to potem
    private String title;
    private LocalDate productionYear;
    private String descryption;
    @NotEmpty
    private String link;

    protected Film() {
    }

    public Film( String title, LocalDate productionYear, String descryption, String link) {
        //this.id = id;
        this.title = title;
        this.productionYear = productionYear;
        this.descryption = descryption;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
