package ppi.locadora.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.dao.CarrosDao;
import ppi.locadora.model.Carro;

public class AlterarCarro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub

		String modelo = req.getParameter("modelo");
		String ano = req.getParameter("anofabricacao");
		String categoria = req.getParameter("combo");
		String renavan = req.getParameter("renavan");
		String tarifaDia = req.getParameter("tarifa");

		Carro c = new Carro();
		c.setRenavan(Long.parseLong(renavan));
		c.setCategoria(categoria);
		c.setModelo(modelo);
		c.setAnoFabricacao(ano);
		c.setTarifaDia(Double.parseDouble(tarifaDia));

		String tipo = req.getParameter("tipo");

		if (tipo!=null) {
			req.setAttribute("carro", c);
			return "edicaocarro.jsp";

		} else {

			CarrosDao carro = new CarrosDao();
			carro.atualizarCarro(c);

			List<Carro> carros = carro.obterListaCarrosCompleta();

			req.setAttribute("carros", carros);
			return "alterarCarros.jsp";

		}
	}

}
