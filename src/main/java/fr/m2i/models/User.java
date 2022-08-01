package fr.m2i.models;

public class User {
	//Attributs
	private String _nom;
	private String _prenom;
	
	public User(String n, String p) {
		this.setNom(n);
		this.setPrenom(p);
	}

	
	//Getter Setter
	public String getNom() {
		return _nom;
	}
	public void setNom(String _nom) {
		this._nom = _nom;
	}
	public String getPrenom() {
		return _prenom;
	}
	public void setPrenom(String _prenom) {
		this._prenom = _prenom;
	}

}
