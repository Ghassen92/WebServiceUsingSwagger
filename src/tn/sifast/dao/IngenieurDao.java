package tn.sifast.dao;

import java.util.List;

import tn.sifast.bean.Ingenieur;

public interface IngenieurDao {

	List<Ingenieur> getAll();
	Ingenieur get(int id);
	int creerIngenieur(Ingenieur b); // retourne l'id
	int delete(int id); 	     // retourne 1 s'il n'y a pas des erreurs
	int update(Ingenieur ing, int id); // retourne 1 s'il n'y a pas des erreurs
}
