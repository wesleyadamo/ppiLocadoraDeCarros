package ppi.locadora.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.Days;

import ppi.locadora.dao.CarrosDao;
import ppi.locadora.model.Carro;
import ppi.locadora.model.Cliente;

public class DadosReserva implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// pega os dados da primeira tela da reserva do carro

		String[] dados = new String[7];

		dados[0] = req.getParameter("dataretirada");
		dados[1] = req.getParameter("horaretirada");
		dados[2] = req.getParameter("datadevolucao");
		dados[3] = req.getParameter("horadevolucao");
		dados[4] = req.getParameter("combo");

		/*
		 * cliente.setId(Integer.parseInt(req.getParameter("clienteid")));
		 * cliente.setCpf(req.getParameter("clientecpf"));
		 * cliente.setNome(req.getParameter("clientenome"));
		 * cliente.setEmail(req.getParameter("clienteemail"));
		 * cliente.setTelefone(req.getParameter("clientetelefone"));
		 * cliente.setEndereco(req.getParameter("clienteendereco"));
		 * cliente.setDataNascimentoString(req.getParameter("clientenascimento"));
		 * 
		 */
		
		
		java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dados[0]);
		Calendar dataCalendar = Calendar.getInstance();
		dataCalendar.setTime(date);
		
	
		DateTime dataInicioAluguel = new DateTime( dataCalendar );
		
		date =  new SimpleDateFormat("dd/MM/yyyy").parse(dados[2]);
		dataCalendar.setTime(date);
		DateTime dataFinalAluguel = new DateTime( dataCalendar);
		
		
		if(dataFinalAluguel.isBefore(dataInicioAluguel)|| dataFinalAluguel.equals(dataInicioAluguel)) {
			req.setAttribute("msg", "Datas inválidas");
			return "ReservarCarro.jsp";
		}
		

		CarrosDao carro = new CarrosDao();

		// pega a lista de carros disponivies passando a categoria, a data de reseva e
		// de entrega
		List<Carro> listacarros = carro.obterListaCarrosDisponivel(dados[4], dados[0], dados[2]);

		// quando não há carro disponivel, retorna pra mesma tela de reserva mostrando a
		// mensagem
		if (listacarros.isEmpty()) {

			req.setAttribute("msg", "Não há carro disponível ");
			// req.setAttribute("cliente", cliente);

			return "ReservarCarro.jsp";

			// quando há carro disponivel
		} else {
			
			
			
			int dias = Days.daysBetween(dataInicioAluguel, dataFinalAluguel).getDays();
			
			float tarifaBase = Float.parseFloat(req.getParameter("tarifa"));
			dados[5] = ""+dias;
			dados[6] = ""+(tarifaBase * dias);
			
			System.out.println("dias: "+ dias);

			// coloca os dados da reserva na request
			req.setAttribute("dados", dados);
			// lista de todos os carros disponivies
			req.setAttribute("carros", listacarros);
			// req.setAttribute("cliente", cliente);

			return "confirmarReserva.jsp";

		}
	}

}
