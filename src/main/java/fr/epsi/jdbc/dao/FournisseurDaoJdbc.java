package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Article;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDaoJdbc implements FournisseurDao {
    public static final String REQUETE_RECHERCHE = "SELECT * FROM fournisseur";
    public static final String REQUETE_INSERTION = "insert into fournisseur(nom)";
    private static final String REQUETE_MISE_A_JOUR = "update fournisseur set nom=? where id=?";
    private static final String REQUETE_SUPPRESSION = "delete from fournisseur where id=?";


    public List<Fournisseur> extraire() throws Exception {

        List<Fournisseur> resultat = new ArrayList<>();
        Connection connection = DBConnection.getSingle().getSqlConnection();
        Statement requete = connection.createStatement();
        ResultSet rs = requete.executeQuery(REQUETE_RECHERCHE);
        while (rs.next()) {

            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setId(rs.getInt("idFournisseur"));
            fournisseur.setNom(rs.getString("nomFournisseur"));
            Article article = new Article();
            article.setDesignation(rs.getString("designationArticle"));
            article.setId(rs.getInt("idArticle"));
            article.setPrix(rs.getDouble("prixArticle"));
            article.setFournisseur(fournisseur);
            resultat.add(fournisseur);
        }
        requete.close();
        connection.close();
        return resultat;


    }

    public void inserer(Fournisseur fournisseur) throws Exception {
        Connection connection = DBConnection.getSingle().getSqlConnection();
        PreparedStatement requete = connection.prepareStatement(REQUETE_INSERTION);
        requete.setString(1, fournisseur.getNom());
        requete.execute();
        requete.close();
        connection.close();
    }

    public void mettreAJour(Fournisseur ancien, Fournisseur nouveau) throws Exception {
        Connection connection = DBConnection.getSingle().getSqlConnection();
        PreparedStatement requete = connection.prepareStatement(REQUETE_MISE_A_JOUR);
        requete.setString(1, nouveau.getNom());
        requete.setInt(3, ancien.getId());
        requete.execute();
        requete.close();
        connection.close();
    }

    public void supprimer(Fournisseur fournisseur) throws Exception {
        Connection connection = DBConnection.getSingle().getSqlConnection();
        PreparedStatement requete = connection.prepareStatement(REQUETE_SUPPRESSION);
        requete.setInt(1, fournisseur.getId());
        requete.execute();
        requete.close();
        connection.close();

    }
}
