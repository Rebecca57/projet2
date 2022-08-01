package fr.m2i.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Map<String,String> PAGES;
       
	
	static {
		PAGES = new TreeMap<String,String>();
        PAGES.put("ACCUEIL","/WEB-INF/pages/accueil.jsp");
        PAGES.put("AUTRE","/WEB-INF/pages/autre.jsp");
        PAGES.put("PAGE1","/WEB-INF/pages/page1.jsp");
        PAGES.put("PAGE2","/WEB-INF/pages/page2.jsp");
	}

	
    public Accueil() {
        super();
        
        // TODO Auto-generated constructor stub
    }
    
    public void redirection(String page, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    		System.out.println("redirection ok :"+PAGES.get(page));
    		request.getServletContext().getRequestDispatcher(PAGES.get(page)).forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Seulement pour la page acceuil ou le démarrage sans parametre page
		String pageAttribute = request.getParameter("page");
		if (pageAttribute == null || pageAttribute.equals("ACCUEIL")) {
			request.getServletContext().getRequestDispatcher(PAGES.get("ACCUEIL")).forward(request, response);
		}
		
		// gestion de la redirection
		//
		/**
		if (pageAttribute == null || !PAGES.containsKey(pageAttribute)) {
			request.getServletContext().getRequestDispatcher(PAGES.get("ACCUEIL")).forward(request, response);
		}
		else {
			this.redirection(pageAttribute, request, response);
		}
		**/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
