package ppi.agenda.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import ppi.agenda.DAO.ContatoDAO;
import ppi.agenda.model.Contato;


@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// buscando os parâmetros no request
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("data");
		String telefone = request.getParameter("telefone");
		Calendar dataNascimento = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);

			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);

		} catch (ParseException | java.text.ParseException e) {
			return; //parar a execução do método
		}

		
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setId(Long.parseLong(id));
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		contato.setTelefone(telefone);

		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);
		
		response.sendRedirect("agenda.jsp");		
	}
	
	
	

}
