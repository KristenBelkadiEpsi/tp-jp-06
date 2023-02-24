package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Article;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoJdbc implements ArticleDao {
    public static final String REQUETE_RECHERCHE = "select f.id as idFournisseur, f.nom as nomFournisseur, a.designation as designationArticle, a.prix as prixArticle from article a natural join fournisseur f";
    public static final String REQUETE_INSERTION = "insert into Article(designation, prix, idFournisseur)";
    private static final String REQUETE_MISE_A_JOUR = "update article set designation=?, prix=?, idFournisseur=? where id=?";
    private static final String REQUETE_SUPPRESSION = "delete from article where id=?";


    public List<Article> extraire() throws Exception {

        List<Article> resultat = new ArrayList<>();
        Connection connection = DBConnection.getSingle().getSqlConnection();
        Statement requete = connection.createStatement();
        ResultSet rs = requete.executeQuery(REQUETE_RECHERCHE);
        while (rs.next()) {

            Article article = new Article();
            article.setId(rs.getInt("id"));
            article.setDesignation(rs.getString("designation"));
            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setId(rs.getInt("idFournisseur"));
            fournisseur.setNom(rs.getString("nomFournisseur"));
            article.setFournisseur(fournisseur);
            resultat.add(article);
        }
        requete.close();
        connection.close();
        return resultat;


    }

    public void inserer(Article article) throws Exception {
        Connection connection = DBConnection.getSingle().getSqlConnection();
        PreparedStatement requete = connection.prepareStatement(REQUETE_INSERTION);
        requete.setString(1, article.getDesignation());
        requete.setDouble(2, article.getPrix());
        requete.setInt(3, article.getFournisseur().getId());
        requete.execute();
        requete.close();
        connection.close();
    }

    public void mettreAJour(Article ancien, Article nouveau) throws Exception {
        Connection connection = DBConnection.getSingle().getSqlConnection();
        PreparedStatement requete = connection.prepareStatement(REQUETE_MISE_A_JOUR);
        requete.setString(1, nouveau.getDesignation());
        requete.setDouble(2, nouveau.getPrix());
        requete.setInt(3, nouveau.getFournisseur().getId());
        requete.setInt(4, ancien.getId());
        requete.execute();
        requete.close();
        connection.close();
    }

    public void supprimer(Article article) throws Exception {
        Connection connection = DBConnection.getSingle().getSqlConnection();
        PreparedStatement requete = connection.prepareStatement(REQUETE_SUPPRESSION);
        requete.setInt(1, article.getId());
        requete.execute();
        requete.close();
        connection.close();

    }
}
