package ppi.agenda.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.agenda.DAO.ContatoDAO;
import ppi.agenda.model.Contato;

@WebServlet("/buscaServlet")
public class BuscaServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeBusca = request.getParameter("nomeBusca");
		List<Contato> contatos = null;
		
		if(!nomeBusca.equals("")) {
		
			ContatoDAO dao = new ContatoDAO();
			contatos = dao.buscarNome(nomeBusca);
		}
		
		request.setAttribute("contatoBusca",contatos);
		request.getRequestDispatcher("busca.jsp").forward(request, response);;
		
	}
	


}
