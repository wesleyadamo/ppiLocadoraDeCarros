package ppi.agenda.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ppi.agenda.DAO.ContatoDAO;
import ppi.agenda.model.Contato;

@WebServlet("/salvarServlet")
public class SalvarServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		String telefone = request.getParameter("telefone");
		Calendar dataNascimento = null;

		Date date;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);

		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		contato.setTelefone(telefone);
		// salva o contato
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);

		RequestDispatcher rd = request
				.getRequestDispatcher("/contato-adicionado.jsp");
				rd.forward(request,response);

	}

}
