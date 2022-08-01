package fr.m2i.models;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tache {
	
	//Attributs
	private String _nom;
	private String _description;
	private String _date;
	
	//Constructeur
	public Tache(String n, String d,  String toDay) {
		this.setNom(n);
		this.setDescription(d);
		this.setDate(toDay);
	}
	
	//Getter Setter
	public String getNom() {
		return _nom;
	}
	public void setNom(String _nom) {
		this._nom = _nom;
	}
	public String getDescription() {
		return _description;
	}
	public void setDescription(String _description) {
		this._description = _description;
	}
	public String getDate() {
		return _date;
	}
	public void setDate(String _date) {
		this._date = _date;
	}
	
	
	

}
