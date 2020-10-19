package sn.forage.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.forage.dao.IVillage;
import sn.forage.dao.VillageImpl;
import sn.forage.entities.Village;

@WebServlet(urlPatterns = {"*.act"})
public class FormServlet extends HttpServlet {
	private IVillage ivillage ;
	
	@Override
	public void init() throws ServletException {
		ivillage = new VillageImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		
		if(req.getServletPath().equalsIgnoreCase("/village.act")) {
			//get from the form
			String localisation = req.getParameter("localisation");
			String libelle = req.getParameter("libelle");
			
			//instantiate a Village
			Village village = new Village();
			village.setNom(libelle);
			village.setLocalisation(localisation);
			
			//insert in the database 
			int val = ivillage.insertVillage(village);
			
			//redirect
			if(val==1) {
				session.setAttribute("message", "INSERTION VILLAGE REUSSIE");
			}else {
				session.setAttribute("message", "ERREUR ! OUPS ");
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home/message.jsp");
			rd.forward(req, resp);
		}
	}
}
