package ppi.locadora.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.dao.AlugarDao;
import ppi.locadora.model.Aluguel;

public class ListarReservas implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//Lista reserva por id ( função do cliente)
		String idTransacao = req.getParameter("id");

		AlugarDao buscarAluguel = new AlugarDao();
		Aluguel reserva = buscarAluguel.obterAluguel(Integer.parseInt(idTransacao));

		List<Aluguel> result = new ArrayList<>();
		result.add(reserva);
		if(reserva.getCpfCliente()==null) {
			System.out.println("entrou no null");
			req.setAttribute("msg", "Nenhuma reserva encontrada!");
			return "WEB-INF/viewsCliente/consultaID.jsp";

			
		}
		
		req.setAttribute("result",reserva);
		return "WEB-INF/viewsCliente/consultaID.jsp";
	}

}
