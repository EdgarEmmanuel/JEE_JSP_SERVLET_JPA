package sn.forage.web;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.forage.dao.ClientImpl;
import sn.forage.dao.IClient;
import sn.forage.dao.IVillage;
import sn.forage.dao.VillageImpl;
import sn.forage.entities.Client;
import sn.forage.entities.Village;

@WebServlet(urlPatterns = {"*.act"})
public class FormServlet extends HttpServlet {
	private IVillage ivillage ;
	private EntityManager em;
	private IClient iclient;
	
	@Override
	public void init() throws ServletException {
		ivillage = new VillageImpl();
		em = EntityMana.getManager();
		iclient = new ClientImpl();
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
		}else if(req.getServletPath().equalsIgnoreCase("/insert_client.act")) {
			
			//fetch data from the form
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String adresse = req.getParameter("addresse");
			String telephone = req.getParameter("telephone");
			String email = req.getParameter("email");
			int id_village = Integer.parseInt(req.getParameter("id_village"));
			
			
			//instantiate the client 
			Client cl = new Client();
			cl.setAdresse(adresse);
			cl.setEmail(email);
			cl.setNom(nom);
			cl.setPrenom(prenom);
			cl.setTelephone(telephone);
			cl.setVillage(em.find(Village.class, id_village));
			
			//insert the client in the database 
			int val = iclient.insertClient(cl);
			
			//redirect
			if(val==1) {
				session.setAttribute("message", "INSERTION CLIENT REUSSIE");
			}else {
				session.setAttribute("message", "ERREUR ! OUPS ");
			}
		}
		
		
		
		
		
	}
}
