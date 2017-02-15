package tn.sifast.soap;


import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import tn.sifast.bean.Ingenieur;
import tn.sifast.dao.DaoFactory;
import tn.sifast.dao.IngenieurDao;

@WebService
public class IngenieurSoap {

	DaoFactory dao;
	IngenieurDao ingenieurDao;

	public IngenieurSoap() {
		dao=DaoFactory.getInstance();
		ingenieurDao=dao.getBeanDao();
 	}
	
	public List<Ingenieur> getAll() {
		return ingenieurDao.getAll();
	}

	public Ingenieur get(@WebParam (name="id")int id) {
		return ingenieurDao.get(id);
	}

	public int createBean( @WebParam(name="nom")String nom, 
						   @WebParam(name="prenom")String prenom) {
		return ingenieurDao.createBean(new Ingenieur(nom,prenom));
	}

	public int delete(@WebParam (name="id")int id) {
		return ingenieurDao.delete(id);
	}

	
	
	
}
