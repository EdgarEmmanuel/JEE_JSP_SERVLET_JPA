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
		
		iuser = new UserImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			
			req.setAttribute("base", "http://localhost:8081/JEE_JSP_SERVLET_JPA/");
			if(req.getServletPath().equalsIgnoreCase("/deconnex.connex")) {
				//clear the cche on logout
				resp.setHeader("Cache-Control","no-cache");   
			    resp.setHeader("Cache-Control","no-store");  
			    resp.setDateHeader("Expires", 0);
			    resp.setHeader("Pragma","no-cache"); 
			    
			    //clear session
			    req.getSession().setAttribute("nom_admin",null);
			    
			    //redirect
				//rd = req.getRequestDispatcher("/WEB-INF/views/home/login.jsp");
			    session.invalidate();
			    resp.sendRedirect("home");
			}else {
				RequestDispatcher rd = null;
				rd = req.getRequestDispatcher("/WEB-INF/views/home/login.jsp");
				rd.forward(req, resp);
			}
			
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pr = resp.getWriter();
		HttpSession session = req.getSession();
		
		if(req.getServletPath().equalsIgnoreCase("/connex.connex")){
				String login = req.getParameter("login");
				String password = req.getParameter("password");
				String role = req.getParameter("role");
				
				User user = null;
				
				switch(role) {
					case "administrateur":
							user = iuser.getUserByParams(login, password);
							
							if(user!=null){
								//set the session
								session.setAttribute("nom_admin", user.getNom()+" "+user.getPrenom());
								
								/* resp.setHeader("Cache-Control", "no-cache");
								resp.setHeader("Cache-Control", "no-store");
								resp.setHeader("Pragma", "no-cache");
								resp.setDateHeader("Expires", 0);*/
								RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home/Home.jsp");
								rd.forward(req, resp);
							}else{
								session.setAttribute("message", "LOGIN OU MOT DE PASSE INCORRECTE(S)");
								resp.sendRedirect("home");
							}
					break;
				}
		}else if(req.getServletPath().equalsIgnoreCase("/deconnex.connex")) {
			pr.print("deconnexion");
		}else{
			resp.sendRedirect("home");
		}
		
	}
	
	
	
	
	
}
