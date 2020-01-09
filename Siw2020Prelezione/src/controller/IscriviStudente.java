package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dipartimento;
import model.Studente;
import persistence.DBManager;


public class IscriviStudente  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		String matricola = req.getParameter("matricola");
		String cognome = req.getParameter("cognome");
		String nome = req.getParameter("nome");
		String dataNascita = req.getParameter("dataNascita");
		String scuola = req.getParameter("scuola");
		
		Studente stud = new Studente();
		stud.setMatricola(matricola);
		stud.setCognome(cognome);
		stud.setDataNascita(dataNascita);
		stud.setNome(nome);
		
		DBManager.getInstance().aggiungiStudente(stud);
		List<Studente> studenti = DBManager.getInstance().dammiStudenti();
		
		req.setAttribute("studenteRegistrato", stud);
		req.setAttribute("studenti", studenti);
		
		RequestDispatcher rd = req.getRequestDispatcher("ottieniStudenti");
		rd.forward(req, resp);
		
//		System.out.println(matricola + " "  + nome + " " + cognome);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Dipartimento> dipartimenti = DBManager.getInstance().dammiDipartimenti();
		
		req.setAttribute("dipartimenti", dipartimenti);
		
		RequestDispatcher rd = req.getRequestDispatcher("iscriviStudenti.jsp");
		rd.forward(req, resp);
	}
}