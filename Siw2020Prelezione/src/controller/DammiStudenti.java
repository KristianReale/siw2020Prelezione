package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Studente;
import persistence.TempDB;

public class DammiStudenti extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
//		resp.getWriter().println("<h1>Sto elaborando la richiesta</h1>");
		
		List<Studente> studenti = TempDB.getInstance().dammiStudenti();
		req.setAttribute("studenti", studenti);
		
		RequestDispatcher rd = req.getRequestDispatcher
				("ottieniStudenti.jsp");
		//rd.include(req, resp);
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Studente s = (Studente) req.getAttribute("studenteInserito");
//		resp.getWriter().println("Studente " + s.getCognome() + " aggiunto con successo");
		RequestDispatcher rd = req.getRequestDispatcher
				("ottieniStudenti.jsp");
		//rd.include(req, resp);
		rd.forward(req, resp);
	}
}