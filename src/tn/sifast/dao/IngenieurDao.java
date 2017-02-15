package tn.sifast.dao;

import java.util.List;

import tn.sifast.bean.Ingenieur;

public interface IngenieurDao {

	List<Ingenieur> getAll();
	Ingenieur get(int id);
	int createBean(Ingenieur b); // retourne 1 s'il n'y a pas des erreurs
	int delete(int id); 	     // retourne 1 s'il n'y a pas des erreurs
	
}
