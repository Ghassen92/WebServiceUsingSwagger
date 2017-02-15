package tn.sifast.bean;

 import java.io.Serializable;

public class Ingenieur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7152205444410225047L;
	int id;
	String nom;
	String prenom;

	public Ingenieur() {

	}

	public Ingenieur(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Ingenieur( String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
