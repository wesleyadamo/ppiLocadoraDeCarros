package ppi.locadora.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.dao.AlugarDao;
import ppi.locadora.dao.CarrosDao;
import ppi.locadora.model.Carro;

public class RemoverCarro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub

		
		// remove carro de acordo com o id do mesmo
		String id = req.getParameter("renavan");

		CarrosDao carro = new CarrosDao();
		carro.removerCarro(Integer.parseInt(id));
		
		List<Carro> carros =  carro.obterListaCarrosCompleta();
		
		req.setAttribute("carros", carros);
		return "alterarCarros.jsp";
		

	}

}
