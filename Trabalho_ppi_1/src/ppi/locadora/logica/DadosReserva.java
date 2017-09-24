package ppi.locadora.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.agenda.dao.CarrosDao;
import ppi.agenda.model.Carro;
import ppi.agenda.model.Cliente;

public class DadosReserva implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
       
		String [] dados  = new String[5];
		
		dados[0] =  req.getParameter("dataretirada");
		dados[1] =  req.getParameter("horaretirada");
		dados[2] =  req.getParameter("datadevolucao");
		dados[3] =  req.getParameter("horadevolucao");
		dados[4] =  req.getParameter("combo");
		
		
		Cliente cliente = new Cliente();
		
		cliente.setId(Integer.parseInt(req.getParameter("clienteid")));
		cliente.setCpf(req.getParameter("clientecpf"));
		cliente.setNome(req.getParameter("clientenome"));
		cliente.setEmail(req.getParameter("clienteemail"));
		cliente.setTelefone(req.getParameter("clientetelefone"));
		cliente.setEndereco(req.getParameter("clienteendereco"));
		cliente.setDataNascimentoString(req.getParameter("clientenascimento"));
		
		CarrosDao carro = new CarrosDao();
		
		
		List<Carro> listacarros = carro.obterListaCarrosDisponivel(dados[4], dados[0], dados[2]);
					
		if(listacarros.isEmpty()) {
			
			req.setAttribute("msg","Não há carro disponível ");

			return "ReservarCarro.jsp";
		} else {
			
	
		req.setAttribute("dados",dados);
		req.setAttribute("carros", listacarros);
		req.setAttribute("cliente", cliente);
		
		
		
		
		return "confirmarReserva.jsp";
		
		}
	}
	
	

}
