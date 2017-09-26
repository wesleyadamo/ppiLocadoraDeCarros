package ppi.locadora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.dao.AlugarDao;
import ppi.locadora.model.Aluguel;

public class Devolucao implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// pega o id da reserva
		String id = req.getParameter("idReserva");
		// obtem a reserva
		AlugarDao aluguel = new AlugarDao();
		Aluguel al = aluguel.obterAluguel(Integer.parseInt(id));

		// envia os dados do aluguel na request
		req.setAttribute("aluguel", al);

		return "WEB-INF/viewsCliente/devolucao.jsp";
	}

}
