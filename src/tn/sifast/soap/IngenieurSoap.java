package tn.sifast.soap;



import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


import tn.sifast.bean.Ingenieur;
import tn.sifast.dao.DaoFactory;
import tn.sifast.dao.IngenieurDao;

@WebService
@SOAPBinding(style = Style.RPC)

public class IngenieurSoap {

	DaoFactory dao;
	IngenieurDao ingenieurDao;

	public IngenieurSoap() {
		dao=DaoFactory.getInstance();
		ingenieurDao=dao.getIngenieurDao();
 	}
	
	public Ingenieur[]getAll() {
		List<Ingenieur> listeIng=ingenieurDao.getAll();
		Ingenieur[]tmp=new Ingenieur[listeIng.size()];
		listeIng.toArray(tmp);
		return tmp;
	}

	public Ingenieur getIngenieur(@WebParam (name="id")int id) {
		return ingenieurDao.get(id);
	}

	public int creerIngenieur( @WebParam(name="nom")String nom, 
						   @WebParam(name="prenom")String prenom) {
		return ingenieurDao.creerIngenieur(new Ingenieur(nom,prenom));
	}

	public int supprimerIngenieur(@WebParam (name="id")int id) {
		return ingenieurDao.delete(id);
	}

	public int modifierIngenieur( @WebParam(name="id")int id,
								@WebParam(name="nom")String nom, 
						   		@WebParam(name="prenom")String prenom){
		return ingenieurDao.update( nom,prenom,id);
	}
	
	
}
