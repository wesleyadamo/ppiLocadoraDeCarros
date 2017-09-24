package ppi.locadora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.agenda.dao.AlugarDao;
import ppi.agenda.dao.CarrosDao;
import ppi.agenda.dao.ClientesDao;
import ppi.agenda.model.Carro;
import ppi.agenda.model.Cliente;

public class AlugarCarro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String[] dados = new String[5];

		dados[0] = req.getParameter("dataretirada");
		dados[1] = req.getParameter("horaretirada");
		dados[2] = req.getParameter("datadevolucao");
		dados[3] = req.getParameter("horadevolucao");
		dados[4] = req.getParameter("combo");
		
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String email =  req.getParameter("email");
		String endereco =  req.getParameter("endereco");
		String carroSelect =  req.getParameter("carro");
		String telefone = req.getParameter("telefone");
		String dataNascimento = req.getParameter("dataNascimento");
		
		Cliente clientenovo = new Cliente();
		clientenovo.setNome(nome);
		clientenovo.setCpf(cpf);
		clientenovo.setDataNascimentoString(dataNascimento);
		
		ClientesDao cliente = new ClientesDao();
		int idCliente  = cliente.adicionaCliente(clientenovo);
		

		
		Carro carro = new CarrosDao().obterCarro(Integer.parseInt(carroSelect));
		
		AlugarDao alugar = new AlugarDao();
		

		
	     int idAluguel =	alugar.alugaCarro(Integer.parseInt(carroSelect), idCliente, dados[0], dados[2], carro.getTarifaDia());
		

		req.setAttribute("idCliente", idCliente);
		req.setAttribute("idAluguel", idAluguel);

		
		System.out.println(idAluguel);
		System.out.println(idAluguel);

		return "confirmacaoReserva.jsp";
	}

}
