package ppi.locadora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.dao.ClientesDao;
import ppi.locadora.model.Cliente;

public class AlterarCliente implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String tipo = req.getParameter("tipo");
		String idCliente = req.getParameter("id");

		// Atualizar dados do cliente
		if (tipo.equals("1")) {

			String nomeCliente = req.getParameter("nome");
			String cpfCliente = req.getParameter("cpf");
			String emailCliente = req.getParameter("email");
			String enderecoCliente = req.getParameter("endereco");
			String dataCliente = req.getParameter("dataNascimento");
			String telefoneCliente = req.getParameter("telefone");

			System.out.println("DATA: " + dataCliente);

			ClientesDao cliente = new ClientesDao();
			Cliente clienteEditado = new Cliente();

			System.out.println("em: " + emailCliente);
			clienteEditado.setId(Integer.parseInt(idCliente));
			clienteEditado.setCpf(cpfCliente);
			if (!dataCliente.isEmpty()) {
				clienteEditado.setDataNascimentoString(dataCliente);

			} else clienteEditado.setDataNascimentoString("0/0/0000");
			
			
			clienteEditado.setEmail(emailCliente);
			clienteEditado.setEndereco(enderecoCliente);
			clienteEditado.setNome(nomeCliente);
			clienteEditado.setTelefone(telefoneCliente);

			boolean sucesso = cliente.editaCliente(clienteEditado);
			if (sucesso) {
				
				req.setAttribute("msg", "Conta alterada com sucesso");


				if(clienteEditado.getDataNascimentoString().equals("30/11/0002")) {
					req.setAttribute("dataNascimento", "");

				}
					
				req.getSession(false).setAttribute("cliente", clienteEditado);
				return "dadosPessoais.jsp";

			}
			// excluir o clinete
		} else if (tipo.equals("2")) {
			ClientesDao cliente = new ClientesDao();
			boolean sucesso = cliente.excluirCliente(Integer.parseInt(idCliente));

			if (sucesso) {
				req.setAttribute("msg", "Conta excluída com sucesso");
				req.getSession(false).invalidate();
				return "Login.jsp";
			} else {
				req.setAttribute("msg", "Erro! Cliente com reserva cadastrada!");
				return "dadosPessoais.jsp";
			}

		}
		return null;
	}

}
