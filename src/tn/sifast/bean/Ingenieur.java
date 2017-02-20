package tn.sifast.bean;

 import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement()
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

	@Override
    public Ingenieur clone() {
        return new Ingenieur(id, nom,prenom);
    }
    
    public void restore(Ingenieur ing) {
        this.id = ing.getId();
        this.nom = ing.getNom();
        this.prenom=ing.getPrenom();
    }

	@Override
	public String toString() {
		return "Ingenieur [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingenieur other = (Ingenieur) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
}
