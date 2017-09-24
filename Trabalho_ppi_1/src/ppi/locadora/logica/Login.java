package ppi.locadora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ppi.agenda.model.*;

import ppi.agenda.dao.ClientesDao;

public class Login implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		int tipo = Integer.parseInt(req.getParameter("tipo"));
		
		String cpf = req.getParameter("cpf");
		
		ClientesDao cliente = new ClientesDao();

		
		if(tipo == 1) {
			int id = Integer.parseInt(req.getParameter("id"));
			Cliente cl = cliente.obterCliente(id, cpf);
			
			System.out.println(cl.getCpf());
			
			if(cl.getCpf()==null) {
				req.setAttribute("msg", "ID e/ou CPF errado");
				return "Login.jsp";
			}else {
				req.setAttribute("cliente", cl);

				return "ReservarCarro.jsp";

			}
			
			
		} else {
			
			Cliente cl = new Cliente();
			String nome = req.getParameter("nome");
			String email =  req.getParameter("email");
			String endereco =  req.getParameter("endereco");
			String carroSelect =  req.getParameter("carro");
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
			
			req.setAttribute("cliente", cl);
			return "ReservarCarro.jsp";
			
		}
	}

}
