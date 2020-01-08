package controller.servizi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CorsoDiLaurea;
import model.Dipartimento;
import persistence.TempDB;

public class CorsiDiLaurea extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dipartimento = req.getParameter("dipartimento");
		
		Dipartimento dip = TempDB.getInstance().dammiDipartimento(dipartimento);
		
		resp.getOutputStream().println("<option>---</option>");
		for (CorsoDiLaurea cld : dip.getCorsiDiLaurea()) {
			resp.getOutputStream().println("<option value=\"" + cld.getId() + "\"> \"" + cld.getNome() + "\"</option>");
		}
	}
}
