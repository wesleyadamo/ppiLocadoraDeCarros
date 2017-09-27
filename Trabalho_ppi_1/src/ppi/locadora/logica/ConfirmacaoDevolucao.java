package ppi.locadora.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.dao.AlugarDao;
import ppi.locadora.model.Aluguel;

public class ConfirmacaoDevolucao implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub

		String id = req.getParameter("idReserva");

		// devolve o carro
		AlugarDao al = new AlugarDao();
		al.devolveCarro(Integer.parseInt(id));

		// pega a lista de algueis e chama a view que mostra as reservas feitas
		List<Aluguel> reservas = al.obterListaAlugueisCompleta();
		req.setAttribute("reservas", reservas);

		return "reservasRealizadas.jsp";
	}

}
