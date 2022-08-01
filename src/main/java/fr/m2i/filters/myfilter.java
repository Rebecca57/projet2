package fr.m2i.filters;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class myfilter
 */
@WebFilter("/Accueil")
public class myfilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;
	private static final Map<String,String> PAGES;
       
	static {
		PAGES = new TreeMap<String,String>();
        PAGES.put("ACCUEIL","/WEB-INF/pages/accueil.jsp");
        PAGES.put("AUTRE","/WEB-INF/pages/autre.jsp");
        PAGES.put("PAGE1","/WEB-INF/pages/page1.jsp");
        PAGES.put("PAGE2","/WEB-INF/pages/page2.jsp");
	}

	/**
     * @see HttpFilter#HttpFilter()
     */
    public myfilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		HttpServletResponse responseHttp = (HttpServletResponse) response;
		String page = requestHttp.getParameter("page");
		//Si accueil ou null pas de problème
		if (page == null || page.equals("ACCUEIL")) {
			System.out.println("No probleme on redirection on Accueil");
		}
		else {
			if (requestHttp.getSession().getAttribute("isLogin") == null) {
				request.setAttribute("access","No Access to the page --> Login in the header");
				System.out.println("You DO NOT have access");
				requestHttp.setAttribute("access","No access to the other pages");
				request.getServletContext().getRequestDispatcher(PAGES.get("ACCUEIL")).forward(requestHttp, responseHttp);	

			}else {
				System.out.println("You HAVE access");
				request.getServletContext().getRequestDispatcher(PAGES.get(page)).forward(requestHttp, responseHttp);	
			}	
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
