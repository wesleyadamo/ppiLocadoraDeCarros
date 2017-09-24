package ppi.locadora.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.agenda.dao.CarrosDao;
import ppi.agenda.model.Carro;

public class DadosReserva implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
       
		String [] dados  = new String[5];
		
		dados[0] =  req.getParameter("dataretirada");
		dados[1] =  req.getParameter("horaretirada");
		dados[2] =  req.getParameter("datadevolucao");
		dados[3] =  req.getParameter("horadevolucao");
		dados[4] =  req.getParameter("combo");
		
		
	
		CarrosDao carro = new CarrosDao();
		
		
		List<Carro> listacarros = carro.obterListaCarrosDisponivel(dados[4], dados[0], dados[2]);
		

		System.out.println("Tamanho da lista: "+ listacarros.size());
			
		if(listacarros.isEmpty()) {
			
			req.setAttribute("msg","Não há carro disponível ");

			return "ReservarCarro.jsp";
		} else {
			
	
		req.setAttribute("dados",dados);
		req.setAttribute("carros", listacarros);
		
		System.out.println(req.getAttribute("carros").toString());
		
		
		
		return "confirmarReserva.jsp";
		
		}
	}
	
	

}
