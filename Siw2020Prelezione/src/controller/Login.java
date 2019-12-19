package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.TempDB;

public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utente utente = (Utente) req.getSession().getAttribute("utente");
		String logout = req.getParameter("logout");
		if ( (logout != null) && logout.equals("true")) {
			req.getSession().setAttribute("utente", null);
			RequestDispatcher rd = req.getRequestDispatcher("");
			rd.forward(req, resp);
		}else {
			if (utente != null) {
				RequestDispatcher rd = req.getRequestDispatcher("alreadyLogged.html");
				rd.forward(req, resp);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Utente utente = TempDB.getInstance().login(username, password);
		
		if (utente != null) {
			req.getSession().setAttribute("utente", utente);
			RequestDispatcher rd = req.getRequestDispatcher("");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("loginFailed.html");
			rd.forward(req, resp);
		}
	}
}
