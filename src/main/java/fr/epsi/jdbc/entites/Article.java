package fr.epsi.jdbc.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private Integer id;


    private String designation;


    private Double prix;


    private Fournisseur fournisseur;

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", designation='" + designation + '\'' + ", prix=" + prix + '}';
    }
}
