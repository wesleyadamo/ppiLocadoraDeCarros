package ppi.locadora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.dao.CarrosDao;
import ppi.locadora.model.Carro;

public class AdicionarCarro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub

		String modelo = req.getParameter("modelo");
		String categoria = req.getParameter("categoria");
		String anoFabricacao = req.getParameter("anofabricacao");
		String renavan = req.getParameter("renavan");
		String tarifa = req.getParameter("tarifa");

		Carro carro = new Carro();
		carro.setModelo(modelo);
		carro.setCategoria(categoria);
		carro.setAnoFabricacao(anoFabricacao);
		carro.setRenavan(Long.parseLong(renavan));
		carro.setTarifaDia(Double.parseDouble(tarifa));

		CarrosDao cd = new CarrosDao();

		boolean add = cd.adicionaCarro(modelo, categoria, carro.getRenavan(), anoFabricacao, carro.getTarifaDia());

		if (add) {
			req.setAttribute("msg", "Carro adicionado");
			return "adicionarCarro.jsp";
		} else {
			req.setAttribute("msg", "Renavan já cadastrado");
			return "adicionarCarro.jsp";

		}
	}

}
