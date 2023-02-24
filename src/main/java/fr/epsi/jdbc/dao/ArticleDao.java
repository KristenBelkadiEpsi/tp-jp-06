package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Article;

import java.util.List;

public interface ArticleDao {
    List<Article> extraire() throws Exception;

    void inserer(Article article) throws Exception;

    void mettreAJour(Article ancien, Article nouveau) throws Exception;

    void supprimer(Article article) throws Exception;
}
