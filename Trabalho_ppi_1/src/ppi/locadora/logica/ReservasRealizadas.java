package ppi.locadora.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.dao.AlugarDao;
import ppi.locadora.model.Aluguel;

public class ReservasRealizadas implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		AlugarDao alugar = new AlugarDao();
		List<Aluguel> reservas = alugar.obterListaAlugueisCompleta();
		
		System.out.println("TAMANHO DA LISTA RESERVAS: "+ reservas.size());
		
		
		req.setAttribute("reservas", reservas);
		
		return "reservasRealizadas.jsp";
	}

}
