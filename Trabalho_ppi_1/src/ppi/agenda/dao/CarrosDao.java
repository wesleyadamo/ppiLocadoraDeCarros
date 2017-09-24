package ppi.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import ppi.agenda.jdbc.ConnectionFactory;
import ppi.agenda.model.Aluguel;
import ppi.agenda.model.Carro;

public class CarrosDao {

	private Connection connection;

	public CarrosDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public List<Carro> obterListaCarrosDisponivel(String categoria, String dataInicial, String dataFinal) {

		/*
		 * System.out.println(categoria+" "+ dataInicial+" "+ dataFinal); List<Aluguel>
		 * alugueis = new ArrayList<Aluguel>(); List<Carro> carros = new
		 * ArrayList<Carro>(); List<Integer> blackList = new ArrayList<Integer>();
		 * List<String> modelosExistentes = new ArrayList<String>();
		 * 
		 * // Transforma a data inicial passada para Calendar Calendar
		 * dataInicialCalendar = Calendar.getInstance();; try { java.util.Date date1 =
		 * new SimpleDateFormat("dd/MM/yyyy").parse(dataInicial);
		 * dataInicialCalendar.setTime(date1); } catch (ParseException e1) {
		 * e1.printStackTrace(); } // Transforma em Joda Date DateTime dataInicialDT =
		 * new DateTime(dataInicialCalendar);
		 * 
		 * 
		 * 
		 * 
		 * // Transforma a data final passada para Calendar Calendar dataFinalCalendar =
		 * Calendar.getInstance(); try { java.util.Date date2 = new
		 * SimpleDateFormat("dd/MM/yyyy").parse(dataFinal);
		 * dataFinalCalendar.setTime(date2); } catch (ParseException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); } // Transforma em Joda Date
		 * DateTime dataFinalDT = new DateTime(dataFinalCalendar);
		 * 
		 * System.out.println("aqui2");
		 */
		List<Carro> CarrosDisponiveis = new ArrayList<Carro>();

		try {

			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicial);
			String dataInicialFormatada = new SimpleDateFormat("yyyy/MM/dd").format(data);

			data = new SimpleDateFormat("dd/MM/yyyy").parse(dataFinal);
			String dataFinalFormatada = new SimpleDateFormat("yyyy/MM/dd").format(data);

			PreparedStatement stmt;
			try {
				stmt = this.connection.prepareStatement(

						"select * from carros where categoria like ? and id not in (select idDoCarro from aluguel where dataFinalAluguel between ? and ? ); ");
				stmt.setString(1, categoria);
				stmt.setString(2, dataInicialFormatada);
				stmt.setString(3, dataFinalFormatada);
				

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {

					Carro novoCarro = new Carro();
					novoCarro.setId(rs.getInt("id"));
					novoCarro.setModelo(rs.getString("modelo"));
					novoCarro.setCategoria(rs.getString("categoria"));
					novoCarro.setRenavan(rs.getString("renavan"));
					novoCarro.setAnoFabricacao(rs.getString("anoFabricacao"));
					novoCarro.setTarifaDia(rs.getDouble("tarifaDia"));

					boolean existe = false;

					if (CarrosDisponiveis.isEmpty())
						CarrosDisponiveis.add(novoCarro);
					else {
						for (int j = 0; j < CarrosDisponiveis.size(); j++) {

							if (CarrosDisponiveis.get(j).getModelo().equals(novoCarro.getModelo())) {
								existe = true;
								break;
							}

						}

						if (!existe) {
							CarrosDisponiveis.add(novoCarro);

						}

					}

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		return CarrosDisponiveis;

		}

		// Obtem os dados de todos os alugueis ate o momento
		// aluguelDao = new AlugarDao();
		// alugueis = aluguelDao.obterListaAlugueisCompleta();

		/*
		 * if(alugueis.isEmpty()) {
		 * 
		 * try {
		 * 
		 * 
		 * // Pega todos os carros PreparedStatement stmt = this.connection.
		 * prepareStatement("SELECT * FROM carros where categoria like ? ;");
		 * stmt.setString(1, categoria); ResultSet rs = stmt.executeQuery();
		 * 
		 * while(rs.next()) { System.out.println("rsrs");
		 * 
		 * Carro novoCarro = new Carro(); novoCarro.setId(rs.getInt("id"));
		 * novoCarro.setModelo(rs.getString("modelo"));
		 * novoCarro.setCategoria(rs.getString("categoria")); //
		 * novoCarro.setRenavan(rs.getString("renavan")); //
		 * novoCarro.setAnoFabricacao(rs.getString("anoFabricacao"));
		 * //novoCarro.setTarifaDia(rs.getDouble("tarifaDia"));
		 * 
		 * boolean existe = false; for(int j = 0; j < carros.size(); j++) {
		 * 
		 * if(carros.get(j).getModelo().equals(novoCarro.getModelo())) { existe = true;
		 * break; }
		 * 
		 * }
		 * 
		 * System.out.println(existe); if(!existe){ carros.add(novoCarro);
		 * 
		 * } }
		 * 
		 * } catch(SQLException e) {
		 * 
		 * }
		 * 
		 * }else for(int i = 0; i < alugueis.size(); i++) {
		 * 
		 * System.out.println("aqui2");
		 * 
		 * Aluguel aluguel = alugueis.get(i);
		 * 
		 * DateTime dataInicialAlugado = new DateTime(aluguel.getDataInicioAluguel());
		 * DateTime dataFinalAlugado = new DateTime(aluguel.getDataFinalAluguel());
		 * 
		 * 
		 * // Adiciona a blackList os que tem as datas coincidentes
		 * if(dataInicialDT.isAfter(dataInicialAlugado) ||
		 * dataInicialDT.isBefore(dataFinalAlugado) ||
		 * dataFinalDT.isAfter(dataInicialAlugado) ||
		 * dataFinalDT.isBefore(dataFinalAlugado) ||
		 * dataInicialDT.equals(dataInicialAlugado) ||
		 * dataFinalDT.equals(dataFinalAlugado)) {
		 * 
		 * blackList.add(aluguel.getIdDoCarro());
		 * 
		 * }
		 * 
		 * System.out.println("aqui1");
		 * 
		 * 
		 * try {
		 * 
		 * 
		 * // Pega todos os carros PreparedStatement stmt = this.connection.
		 * prepareStatement("SELECT * FROM carros where categoria like ?;");
		 * stmt.setString(1, categoria); ResultSet rs = stmt.executeQuery();
		 * 
		 * while(rs.next()) {
		 * 
		 * 
		 * 
		 * int id = rs.getInt("id"); boolean existe = false;
		 * 
		 * // Testa se o carro esta na blackList for(int j = 0; j < blackList.size();
		 * j++) { if(id == blackList.get(j)) existe = true; }
		 * 
		 * 
		 * // Se nao existe entao adiciona a lista if(!existe) {
		 * 
		 * Carro novoCarro = new Carro(); novoCarro.setId(id);
		 * novoCarro.setModelo(rs.getString("modelo"));
		 * novoCarro.setCategoria(rs.getString("categoria"));
		 * novoCarro.setRenavan(rs.getString("renavan"));
		 * novoCarro.setAnoFabricacao(rs.getString("anoFabricacao"));
		 * novoCarro.setTarifaDia(rs.getDouble("tarifaDia"));
		 * 
		 * 
		 * // Testar se e da categoria selecionado e se ja tem
		 * 
		 * // Se o carro obtido é da categoria que o usuario passou ele aceita
		 * if(novoCarro.getCategoria().equals(categoria)){
		 * 
		 * 
		 * // Se a lista de modelos ja tem algum carro, significa que minha lista ja tem
		 * // Entao tem que comparar se nao sao carros iguais
		 * if(modelosExistentes.size() > 0) {
		 * 
		 * boolean existeModelo = false; for(int k = 0; k < modelosExistentes.size();
		 * k++) {
		 * 
		 * // Se ja existir um modelo igual vira true
		 * if(novoCarro.getModelo().equals(modelosExistentes.get(k))) existeModelo =
		 * true;
		 * 
		 * }
		 * 
		 * // Se Não existe o modelona lista ele adiciona a lista de carros Aptos a
		 * alugar if(!existeModelo) { modelosExistentes.add(novoCarro.getModelo());
		 * carros.add(novoCarro); }
		 * 
		 * 
		 * 
		 * } else { // Se minha lista de modelos existentes e igual a 0 é pq nenhum foi
		 * adicionado // entao adiciona direto
		 * modelosExistentes.add(novoCarro.getModelo()); carros.add(novoCarro); }
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * }
		 * 
		 * } catch (SQLException e) {
		 * System.out.println("Erro ao obter carros disponiveis: " + e.getMessage()); }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 */

		// try {
		//
		// PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM
		// carros WHERE categoria like = ? AND disponivel = 1 GROUP BY modelo");
		// stmt.setString(1, categoria);
		// ResultSet rs = stmt.executeQuery();
		//
		// while(rs.next()) {
		//
		// Carro novoCarro = new Carro();
		//
		// novoCarro.setId(rs.getInt("id"));
		// novoCarro.setModelo(rs.getString("modelo"));
		// novoCarro.setCategoria(rs.getString("categoria"));
		// novoCarro.setRenavan(rs.getString("renaven"));
		// novoCarro.setAnoFabricacao(rs.getString("anoFabricacao"));
		// novoCarro.setTarifaDia(rs.getDouble("tarifaDia"));
		// novoCarro.setDisponivel(rs.getInt("disponivel"));
		//
		// if(novoCarro.getDisponivel() == 1)
		// carros.add(novoCarro);
		//
		// }
		//
		// } catch (SQLException e) {
		// System.out.println("Erro ao obter lista de carros disponiveis");
		// System.out.println(e.getMessage());
		// }*/

	

	// GETTERS

	public List<Carro> getobterDisponivel(String categoria) {

		List<Carro> carros = new ArrayList<Carro>();

		try {

			PreparedStatement stmt = this.connection.prepareStatement(
					"SELECT min(id) as 'id' , modelo, categoria FROM carros where categoria like ? and disponivel=1  group  by modelo, categoria;");
			stmt.setString(1, categoria);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Carro novoCarro = new Carro();
				novoCarro.setId(Integer.parseInt(rs.getString("id")));
				novoCarro.setModelo(rs.getString("modelo"));
				novoCarro.setCategoria(rs.getString("categoria"));

				carros.add(novoCarro);

			}

		} catch (SQLException e) {
			System.out.println("Erro ao obter lista de carros disponiveis");
			System.out.println(e.getMessage());

		}

		return carros;

	}

	public List<Carro> getObterListaCarrosCompleta() {

		List<Carro> carros = new ArrayList<Carro>();

		try {

			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM carros where disponivel=1");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Carro novoCarro = new Carro();

				novoCarro.setId(rs.getInt("id"));
				novoCarro.setModelo(rs.getString("modelo"));
				novoCarro.setCategoria(rs.getString("categoria"));
				novoCarro.setRenavan(rs.getString("renavan"));
				novoCarro.setAnoFabricacao(rs.getString("anoFabricacao"));
				novoCarro.setTarifaDia(rs.getDouble("tarifaDia"));
				novoCarro.setDisponivel(rs.getInt("disponivel"));

				carros.add(novoCarro);

			}

		} catch (SQLException e) {
			System.out.println("Erro ao obter lista de carros completa");
			System.out.println(e.getMessage());
		}

		return carros;

	}

	public Carro obterCarro(int id) {

		Carro novoCarro = new Carro();

		try {

			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM carros WHERE ID = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				novoCarro.setId(rs.getInt("id"));
				novoCarro.setModelo(rs.getString("modelo"));
				novoCarro.setCategoria(rs.getString("categoria"));
				novoCarro.setRenavan(rs.getString("renavan"));
				novoCarro.setAnoFabricacao(rs.getString("anoFabricacao"));
				novoCarro.setTarifaDia(rs.getDouble("tarifaDia"));

			}

		} catch (SQLException e) {
			System.out.println("Erro ao obter um carro");
			System.out.println(e.getMessage());
		}

		return novoCarro;

	}

	// SETTERs

	public void adicionaCarro(String modelo, String categoria, String renavan, String anoFabricacao, double tarifaDia,
			int quantidadeMax, int quantidadeDisponivel) {

		try {

			PreparedStatement stmt = this.connection.prepareStatement(
					"INSERT INTO carros(modelo, categoria, renavan, anoFabricacao,tarifaDia) VALUES (?, ?, ?, ?, ?)");

			stmt.setString(1, modelo);
			stmt.setString(2, categoria);
			stmt.setString(3, renavan);
			stmt.setString(4, anoFabricacao);
			stmt.setDouble(5, tarifaDia);

			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo carro");
			System.out.println(e.getMessage());
		}

	}

	public void removerCarro(int id) {
		try {
			System.out.println(id);
			PreparedStatement stmt = this.connection.prepareStatement("Delete  from carros where id=" + id + ";");
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// retorna a quantidade de carros armazenados por modelo
	public List<Object> getconsultarQuantidade() {

		try {

			PreparedStatement stmt = this.connection.prepareStatement(
					"SELECT COUNT(id) as 'quantidade', modelo, categoria FROM carros group by modelo, categoria;");

			ResultSet rs = stmt.executeQuery();

			List<Object> lista = new ArrayList<Object>();

			while (rs.next()) {

				Object[] c = new Object[3];

				c[0] = rs.getString("quantidade");
				c[1] = rs.getString("modelo");
				c[2] = rs.getString("categoria");

				lista.add(c);

			}

			return lista;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
