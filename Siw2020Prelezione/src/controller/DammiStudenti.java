package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Studente;

public class DammiStudenti extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		resp.getWriter().println("<h1>Sto elaborando la richiesta</h1>");
		
		RequestDispatcher rd = req.getRequestDispatcher
				("ottieniStudenti.html");
		//rd.include(req, resp);
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Studente s = (Studente) req.getSession().getAttribute("studenteInserito");
		
		resp.getWriter().println("Studente " + s.getCognome() + " aggiunto con successo");
	}
}