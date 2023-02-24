package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.ArticleDaoJdbc;
import fr.epsi.jdbc.dao.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Article;
import fr.epsi.jdbc.entites.Fournisseur;
import org.h2.tools.Server;

import java.sql.SQLException;

public class TestJdbcArticles {
    public static void main(String[] args) throws Exception {
//        FournisseurDaoJdbc fdj = new FournisseurDaoJdbc();
//        ArticleDaoJdbc adj = new ArticleDaoJdbc();
//        Fournisseur maisonDeLaPeinture = new Fournisseur();
//        Article blanche1l = new Article();
//        blanche1l.setId(1);
//        blanche1l.setDesignation("Peinture blanche 1L");
//        blanche1l.setPrix(12.5);
//        blanche1l.setFournisseur(maisonDeLaPeinture);
//        Article rougeMate1l = new Article();
//        rougeMate1l.setId(2);
//        rougeMate1l.setDesignation("Peinture rouge mate 1L");
//        rougeMate1l.setPrix(15.5);
//        rougeMate1l.setFournisseur(maisonDeLaPeinture);
//        Article noireLaquee1l = new Article();
//        noireLaquee1l.setId(3);
//        noireLaquee1l.setDesignation("Peinture noire laquée 1L");
//        noireLaquee1l.setPrix(17.8);
//        noireLaquee1l.setFournisseur(maisonDeLaPeinture);
//        Article bleuMate1L = new Article();
//        bleuMate1L.setId(4);
//        bleuMate1L.setDesignation("Peinture bleu mate 1L");
//        bleuMate1L.setPrix(15.5);
//        bleuMate1L.setFournisseur(maisonDeLaPeinture);
//        maisonDeLaPeinture.setId(1);
//        maisonDeLaPeinture.setNom("Maison de la peinture");
//
//        fdj.inserer(maisonDeLaPeinture);
//        adj.inserer(blanche1l);
//        adj.inserer(rougeMate1l);
//        adj.inserer(noireLaquee1l);
//        adj.inserer(bleuMate1L);
        try {
            Server.createWebServer("-web", "-webAllowOthers", "-webPort", "9090")
                    .start();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
