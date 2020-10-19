package sn.forage.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.forage.dao.IUser;
import sn.forage.dao.UserImpl;
import sn.forage.entities.User;
import sn.forage.entities.Village;

@WebServlet(name="home" , urlPatterns = {"/home","*.connex"})
public class HomeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7284579834108215355L;
	
	private EntityManager em ;
	private IUser iuser;
	

	@Override
	public void init() throws ServletException {
		em = EntityMana.getManager();
		iuser = new UserImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("base", "http://localhost:8081/JEE_JSP_SERVLET_JPA/");
		//req.setAttribute("villages",em.createQuery("SELECT c  FROM Village c").getResultList());
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home/login.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pr = resp.getWriter();
		HttpSession session = req.getSession();
		
		if(req.getServletPath().equalsIgnoreCase("/connex.connex")){
				String login = req.getParameter("login");
				String password = req.getParameter("password");
				
				User user = null;
				
				user = iuser.getUserByParams(login, password);
				
				if(user!=null) {
					pr.print("nom : "+user.getNom());
				}else {
					session.setAttribute("message", "LOGIN OU MOT DE PASSE INCORRECTE(S)");
					resp.sendRedirect("home");
				}
		}else{
			resp.sendRedirect("home");
		}
		
	}
	
	
	
	
	
}
