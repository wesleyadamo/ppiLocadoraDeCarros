package ppi.locadora.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ppi.locadora.dao.AlugarDao;
import ppi.locadora.dao.ClientesDao;
import ppi.locadora.model.*;

public class Login implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub

		int tipo = Integer.parseInt(req.getParameter("tipo"));

		String cpf = req.getParameter("cpf");
		String isFunc = req.getParameter("func");

		ClientesDao cliente = new ClientesDao();

		HttpSession sessao = req.getSession();

		// quando o cliente já tem "conta"
		if (tipo == 1) {
			int id = Integer.parseInt(req.getParameter("id"));
			Cliente cl = cliente.obterCliente(id, cpf);
			System.out.println("NOME DO CLIENTE: " + cl.getNome());

			// não foi encontrado o cliente(funcionario)
			if (cl.getCpf() == null) {
				req.setAttribute("msg", "ID e/ou CPF errado");
				return "Login.jsp";

				// funcionário
			} else if (isFunc != null) {

				sessao.setAttribute("cliente", cl);
				AlugarDao aluguel = new AlugarDao();

				List<Aluguel> reservas = aluguel.obterListaAlugueisCompleta();
				req.setAttribute("reservas", reservas);

				return "reservasRealizadas.jsp";

				// cliente
			} else if (isFunc == null) {
				sessao.setAttribute("cliente", cl);
				System.out.println("AQUI CLIENTE COM CONTA: " + sessao.getAttribute("cliente").toString());

				return "ReservarCarro.jsp";
			}

			// cria um novo cliente
		} else {

			Cliente cl = new Cliente();
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			String endereco = req.getParameter("endereco");
			String carroSelect = req.getParameter("carro");
			String telefone = req.getParameter("telefone");
			String dataNascimento = req.getParameter("dataNascimento");

			cl.setCpf(cpf);
			cl.setDataNascimentoString(dataNascimento);
			cl.setEmail(email);
			cl.setEndereco(endereco);
			cl.setNome(nome);
			cl.setTelefone(telefone);

			int idcliente = cliente.adicionaCliente(cl);
			cl.setId(idcliente);

			if (isFunc != null) {

				sessao.setAttribute("cliente", cl);

				AlugarDao aluguel = new AlugarDao();

				List<Aluguel> reservas = aluguel.obterListaAlugueisCompleta();
				req.setAttribute("reservas", reservas);
				return "reservasRealizadas.jsp";

			} else {

				sessao.setAttribute("cliente", cl);
				System.out.println("AQUI CLIENTE COM CONTA");

				return "ReservarCarro.jsp";

			}

		}
		return "";
	}

}
