package fr.m2i.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.m2i.models.Tache;
import fr.m2i.models.User;

import java.beans.JavaBean;

@JavaBean
@Path("/taches")
public class TachesRessource {

	public static ArrayList<Tache> listeTaches = new ArrayList<Tache>();
	//private int id;
	
	
	//Récupérer la liste des taches
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Tache> voir(){
		return TachesRessource.listeTaches;
	}
	
	//Ajouter une tache dans la liste
	@POST
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public static void add(@FormParam("nom") String nom,
			@FormParam("desc") String desc,
			@FormParam("date") String date) {
		Tache newTache = new Tache(nom,desc,date);
		System.out.println("POST method add: "+newTache);
		TachesRessource.listeTaches.add(newTache);
	}
	
	//Supprimer une tache
	@DELETE
	@Path("/all/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public static void delete(@PathParam("id") int id) {
		for (int i =0; i<listeTaches.size();i++) {
			TachesRessource.listeTaches.remove(id);
		}
		System.out.println(listeTaches.size());
	}
	
	
}
