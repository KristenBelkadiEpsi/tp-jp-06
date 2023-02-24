package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Article;
import fr.epsi.jdbc.entites.Fournisseur;

import java.util.List;

public interface FournisseurDao {
    List<Fournisseur> extraire() throws Exception;

    void inserer(Fournisseur fournisseur) throws Exception;

    void mettreAJour(Fournisseur ancien, Fournisseur nouveau) throws Exception;

    void supprimer(Fournisseur fournisseur) throws Exception;
}
