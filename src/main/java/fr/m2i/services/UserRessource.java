package fr.m2i.services;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.m2i.models.User;

@Path("/User")
public class UserRessource {
	private final ArrayList<User> listUser = new ArrayList<>();
	
	public UserRessource() {
		
		this.listUser.add(new User("Richard","truc"));
		this.listUser.add(new User("Richard","truc"));
		this.listUser.add(new User("Richard","truc"));
		this.listUser.add(new User("Richard","truc"));
		this.listUser.add(new User("Richard","truc"));
		
	}
	
	
	//Crée un fichier JSON
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<User> get() {
		return this.listUser;
	}
	
	//Lit le fichier JSON
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("nom") String nom, @FormParam("prenom") String prenom) {
		this.listUser.add(new User(nom,prenom));
		System.out.print(nom);
		System.out.print(this.listUser.size());
	}
	
	
}