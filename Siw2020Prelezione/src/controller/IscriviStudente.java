package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Scuola;
import model.Studente;
import persistence.TempDB;


public class IscriviStudente  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		String matricola = req.getParameter("matricola");
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String dataNascita = req.getParameter("dataNascita");
		String idScuola = req.getParameter("scuola");
		
		Scuola scuola = TempDB.getInstance().dammiScuolaById(Long.parseLong(idScuola));
		
	
		DateFormat format = new SimpleDateFormat(
							"yyyy-mm-dd", Locale.ITALIAN);
		
		try {
			Date date = format.parse(dataNascita);
			Studente s = new Studente(matricola, nome, cognome, date);	
			s.setScuolaDiDiploma(scuola);
			TempDB.getInstance().aggiungiStudente(s);
			
//			req.setAttribute("studenteCreato", sSalvato);
			
			req.getSession().setAttribute("studenteInserito", s);
			RequestDispatcher rd = req.getRequestDispatcher("/ottieniStudenti");
			rd.include(req, resp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		resp.getWriter().println(matricola);
	}
	
}