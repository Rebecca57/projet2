package fr.m2i.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/exemple")
public class ExempleRessource {
	
	
	@GET
	public String sayHello() {
		
		return "Hello, the world!";
	}

}