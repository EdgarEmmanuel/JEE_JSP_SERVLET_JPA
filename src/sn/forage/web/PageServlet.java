package sn.forage.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"*.pages"})
public class PageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getServletPath().equalsIgnoreCase("/villages.pages")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home/village.jsp");
			rd.forward(req, resp);
		}else if(req.getServletPath().equalsIgnoreCase("/client.pages")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home/client.jsp");
			rd.forward(req, resp);
		}
	}
}
