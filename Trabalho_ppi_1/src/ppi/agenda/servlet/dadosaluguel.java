package ppi.agenda.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.agenda.DAO.ContatoDAO;
import ppi.agenda.model.Contato;

/**
 * Servlet implementation class dadosaluguel
 */
@WebServlet("/dadosaluguel")
public class dadosaluguel extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] dados  = new String[5];
		
		dados[0] =  request.getParameter("dataretirada");
		dados[1] =  request.getParameter("horaretirada");
		dados[2] =  request.getParameter("datadevolucao");
		dados[3] =  request.getParameter("horadevolucao");
		dados[4] =  request.getParameter("combo");

	
		request.setAttribute("dados",dados);
		request.getRequestDispatcher("dadosclientesjsp.jsp").forward(request, response);;
		
	}
	


}
