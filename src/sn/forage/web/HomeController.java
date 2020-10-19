package sn.forage.web;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.forage.entities.Village;

@WebServlet(name="home",urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7284579834108215355L;
	
	private EntityManager em ;

	@Override
	public void init() throws ServletException {
		em = EntityMana.getManager();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("base", "http://localhost:8081/JEE_JSP_SERVLET_JPA/");
		req.setAttribute("villages",em.createQuery("SELECT c  FROM Village c").getResultList());
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home/client.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	
	
	
}
