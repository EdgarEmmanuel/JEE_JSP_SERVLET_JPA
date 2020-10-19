package sn.forage.web;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"*.pages"})
public class PageServlet extends HttpServlet {
	
	EntityManager em ;
	
	@Override
	public void init() throws ServletException {
		em = EntityMana.getManager();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getServletPath().equalsIgnoreCase("/villages.pages")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home/village.jsp");
			rd.forward(req, resp);
		}else if(req.getServletPath().equalsIgnoreCase("/client.pages")) {
			req.setAttribute("villages",em.createQuery("SELECT c  FROM Village c").getResultList());
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home/client.jsp");
			rd.forward(req, resp);
		}else if(req.getServletPath().equalsIgnoreCase("/home.pages")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home/Home.jsp");
			rd.forward(req, resp);
		}else if(req.getServletPath().equalsIgnoreCase("/")) {
			
		}
	}
}
