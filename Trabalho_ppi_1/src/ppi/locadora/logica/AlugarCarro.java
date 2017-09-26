package ppi.locadora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.dao.AlugarDao;
import ppi.locadora.dao.CarrosDao;
import ppi.locadora.dao.ClientesDao;
import ppi.locadora.model.Carro;
import ppi.locadora.model.Cliente;

public class AlugarCarro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String[] dados = new String[5];

		// recupera dos dados da reserva
		dados[0] = req.getParameter("dataretirada");
		dados[1] = req.getParameter("horaretirada");
		dados[2] = req.getParameter("datadevolucao");
		dados[3] = req.getParameter("horadevolucao");
		dados[4] = req.getParameter("combo");
		
		String carroSelect = req.getParameter("carro");


		// recupera os dados do cliente
		/*String nome = req.getParameter("clientenome");
		String cpf = req.getParameter("clientecpf");
		String endereco = req.getParameter("clienteendereco");
		String email = req.getParameter("clienteemail");
		String carroSelect = req.getParameter("carro");
		String telefone = req.getParameter("clientetelefone");
		String dataNascimento = req.getParameter("clientenascimento");*/
		
		   Cliente cl2 = (Cliente) req.getSession(false).getAttribute("cliente");


	/*	Cliente clientenovo = new Cliente();
		clientenovo.setNome(nome);
		clientenovo.setCpf(cpf);
		clientenovo.setDataNascimentoString(dataNascimento);
		clientenovo.setTelefone(telefone);
		clientenovo.setEmail(email);
		clientenovo.setEndereco(endereco);*/

		// adiciona o cliente e armazena seu id
		ClientesDao cliente = new ClientesDao();
		//int idCliente = cliente.adicionaCliente(clientenovo);
		///.setId(idCliente);
		
		System.out.println(cl2.getNome());
		
		int idCliente = cliente.adicionaCliente(cl2);
		cl2.setId(idCliente);

		// obtem as informações do carro selecionado para reserva
		Carro carro = new CarrosDao().obterCarro(Integer.parseInt(carroSelect));
		
		// reserva o carro e armazena o codigo da reserva
		AlugarDao alugar = new AlugarDao();
		String [] resultAluguel = alugar.alugaCarro(Integer.parseInt(carroSelect), idCliente, dados[0], dados[2],
				carro.getTarifaDia());

		req.setAttribute("result", resultAluguel);

		

		return "WEB-INF/viewsCliente/confirmacaoReserva.jsp";
	}

}
