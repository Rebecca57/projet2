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
 * Servlet implementation class log
 */
@WebServlet("/Log")
public class log extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Map<String,String> PAGES;
       
	
	static {
		PAGES = new TreeMap<String,String>();
        PAGES.put("ACCUEIL","/WEB-INF/pages/accueil.jsp");
        PAGES.put("AUTRE","/WEB-INF/pages/autre.jsp");
	}
       
	//Constructeur
    public log() {
        super();
        // TODO Auto-generated constructor stub
    }

    //GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logOut(request);
		request.getServletContext().getRequestDispatcher(PAGES.get("ACCUEIL")).forward(request, response);
	}

	//POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST");
		String user = request.getParameter("user");
		String mdp = request.getParameter("mdp");
		if ( user.equals("user") && mdp.equals("user") ){
			this.logIn(user,request);
		}
		request.getServletContext().getRequestDispatcher(PAGES.get("ACCUEIL")).forward(request, response);
	}
	
	//LOGIN
	protected void logIn(String login, HttpServletRequest request) {
		request.getSession().setAttribute("isLogin", true);
		request.getSession().setAttribute("user", login);
	}
	
	//LOGOUT
	protected void logOut(HttpServletRequest request) {
		request.getSession().removeAttribute("isLogin");
		request.getSession().removeAttribute("user");
	}

}
