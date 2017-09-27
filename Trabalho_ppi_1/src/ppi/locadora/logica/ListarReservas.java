package ppi.locadora.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.dao.AlugarDao;
import ppi.locadora.model.Aluguel;
import ppi.locadora.model.Cliente;

public class ListarReservas implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//Lista reserva por id ( função do cliente)
		String idTransacao = req.getParameter("id");
		
		Cliente cl = (Cliente) req.getSession(false).getAttribute("cliente");

		AlugarDao buscarAluguel = new AlugarDao();
		Aluguel reserva = buscarAluguel.obterAluguel(Integer.parseInt(idTransacao), cl.getId());

		List<Aluguel> result = new ArrayList<>();
		result.add(reserva);
		if(reserva.getCpfCliente()==null) {
			req.setAttribute("msg", "Nenhuma reserva encontrada!");
			return "consultaID.jsp";

			
		}
		
		req.setAttribute("result",result);
		return "consultaID.jsp";
	}

}
