package tn.sifast.dao;

import java.util.List;

import tn.sifast.bean.Ingenieur;

public interface IngenieurDao {

	List<Ingenieur> getAll();
	Ingenieur get(int id);
	int creerIngenieur(Ingenieur b); // retourne l'id de l'ingenieur cree
	int delete(int id); 	     // retourne 1 s'il n'y a pas des erreurs
	int update(String nom,String prenom, int id); // retourne 1 s'il n'y a pas des erreurs
}
