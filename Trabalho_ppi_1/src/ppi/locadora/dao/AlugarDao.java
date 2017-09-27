package ppi.locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

import ppi.locadora.jdbc.ConnectionFactory;
import ppi.locadora.model.Aluguel;
import ppi.locadora.model.Carro;

public class AlugarDao {

	private Connection connection;

	public AlugarDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// GETTERs

	public List<Aluguel> obterListaAlugueisCompleta() {

		List<Aluguel> alugueis = new ArrayList<Aluguel>();

		try {

			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM aluguel");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Aluguel novoAluguel = new Aluguel();

				novoAluguel.setId(rs.getInt("id"));
				novoAluguel.setRenavanDoCarro(rs.getLong("renavanDoCarro"));
				novoAluguel.setIdDoCliente(rs.getInt("idDoCliente"));
				novoAluguel.setDataInicioAluguelFromSQL(rs.getDate("dataInicioAluguel"));
				novoAluguel.setDataFinalAluguelFromSQL(rs.getDate("dataFinalAluguel"));
				novoAluguel.setTarifaBase(rs.getDouble("tarifaBase"));

				alugueis.add(novoAluguel);

			}

		} catch (SQLException e) {
			System.out.println("Erro ao obter lista de alugueis completa");
			System.out.println(e.getMessage());
		}

		System.out.println(alugueis.size() + " tamanho");

		return alugueis;

	}

	// Retorna o aluguel selecionado, o objeto aluguel de retorno possui um valor
	// extra que e o valor exato
	// a ser pago por quem alugou na hora de devolver, tera tbm as informações como
	// o carro alugado e o nome e cpf de quem alugou
	public Aluguel obterAluguel(int idTransacao , int idCliente) {

		Aluguel novoAluguel = new Aluguel();

		try {
			PreparedStatement stmt;
			ResultSet rs;

			stmt = this.connection.prepareStatement("SELECT * FROM aluguel WHERE id = ? and idDoCliente = ? ;");
			stmt.setInt(1, idTransacao);
			stmt.setInt(2, idCliente);
			rs = stmt.executeQuery();

			System.out.println("aqui1");
			if (rs.next()) {
				System.out.println("aqui2");

				novoAluguel.setId(rs.getInt("id"));
				novoAluguel.setRenavanDoCarro(rs.getInt("renavanDoCarro"));
				novoAluguel.setIdDoCliente(rs.getInt("idDoCliente"));
				novoAluguel.setDataInicioAluguelFromSQL(rs.getDate("dataInicioAluguel"));
				novoAluguel.setDataFinalAluguelFromSQL(rs.getDate("dataFinalAluguel"));
				novoAluguel.setTarifaBase(rs.getDouble("tarifaBase"));

				Calendar dataHoje = Calendar.getInstance();

				novoAluguel.gerarValorTotal(dataHoje);

				// Acessa o banco de clientes para obter as info de nome e cpf
				stmt = this.connection.prepareStatement("SELECT nome, cpf FROM clientes WHERE ID = ?");
				stmt.setInt(1, novoAluguel.getIdDoCliente());
				rs = stmt.executeQuery();

				rs.next();
				novoAluguel.setNomeCliente(rs.getString("nome"));
				novoAluguel.setCpfCliente(rs.getString("cpf"));

				// Acessa o banco de carros para obter a info do modelo
				stmt = this.connection.prepareStatement("SELECT modelo FROM carros WHERE RENAVAN = ?");
				stmt.setLong(1, novoAluguel.getRenavanDoCarro());
				rs = stmt.executeQuery();

				rs.next();
				novoAluguel.setModeloDoCarro(rs.getString("modelo"));

			}

		} catch (SQLException e) {
			System.out.println("Erro ao obter aluguel");
			System.out.println(e.getMessage());
		}

		return novoAluguel;

	}

	// SETTERs

	public int alugaCarro(int id, long renavanDoCarro, int idDoCliente, String dataInicioAluguel, String dataFinalAluguel,
			double tarifaBase) {

		int idTransacao = -1;

		Aluguel novoAluguel = new Aluguel();

		novoAluguel.setRenavanDoCarro(renavanDoCarro);
		novoAluguel.setIdDoCliente(idDoCliente);
		novoAluguel.setDataInicioAluguelString(dataInicioAluguel);
		novoAluguel.setDataFinalAluguelString(dataFinalAluguel);
		novoAluguel.setTarifaBase(tarifaBase);

		// Obtem o carro para saber se tem disponivel
		// Apenas um tratamento no back
		Carro carro = new CarrosDao().obterCarro(renavanDoCarro);

		try {

			PreparedStatement stmt;

			// Cria o registro
			stmt = this.connection.prepareStatement(
					"INSERT INTO aluguel(idDoCliente, renavanDoCarro, dataInicioAluguel, dataFinalAluguel, tarifaBase) VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, novoAluguel.getIdDoCliente());
			stmt.setLong(2, novoAluguel.getRenavanDoCarro());
			stmt.setDate(3, novoAluguel.getDataInicioAluguelToSQL());
			stmt.setDate(4, novoAluguel.getDataFinalAluguelToSQL());
			stmt.setDouble(5, novoAluguel.getTarifaBase());

			int ok = stmt.executeUpdate();

			stmt = this.connection
					.prepareStatement("select * from aluguel where idDoCliente = ? and renavanDoCarro = ? ; ");
			stmt.setInt(1, novoAluguel.getIdDoCliente());
			stmt.setLong(2, novoAluguel.getRenavanDoCarro());

			// Recupera o ID da transacao recem gerado
			/*
			 * ResultSet rs = stmt.getGeneratedKeys(); if(rs.next()) idTransacao =
			 * rs.getInt("id");
			 */

			ResultSet rs = stmt.executeQuery();
			int idAluguel = 0;

			if (rs.next()) {
				idAluguel = rs.getInt("id");
				System.out.println("entrou aqui no get id");
			}

			return idAluguel;

		} catch (SQLException e) {
			System.out.println("Erro ao alugar carro");
			System.out.println(e.getMessage());
		}

		return idTransacao;

	}
	
	
	
public String[] alugaCarro(long renavanDoCarro, int idDoCliente, String dataInicioAluguel, String dataFinalAluguel, double tarifaBase) {
		
		int idTransacao = -1;
		String [] resultAluguel = new String[6];
		Aluguel novoAluguel = new Aluguel();
		
		
		novoAluguel.setRenavanDoCarro(renavanDoCarro);
		novoAluguel.setIdDoCliente(idDoCliente);
		novoAluguel.setDataInicioAluguelString(dataInicioAluguel);
		novoAluguel.setDataFinalAluguelString(dataFinalAluguel);
		novoAluguel.setTarifaBase(tarifaBase);
		
				
		
			
		try {

			PreparedStatement stmt;

			// Cria o registro 
			stmt = this.connection.prepareStatement("INSERT INTO aluguel(idDoCliente, renavanDoCarro, dataInicioAluguel, dataFinalAluguel, tarifaBase) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, novoAluguel.getIdDoCliente());
			stmt.setLong(2, novoAluguel.getRenavanDoCarro());
			stmt.setDate(3, novoAluguel.getDataInicioAluguelToSQL());
			stmt.setDate(4, novoAluguel.getDataFinalAluguelToSQL());
			stmt.setDouble(5, novoAluguel.getTarifaBase());

			stmt.executeUpdate();
			
			
			
			
			
			stmt =  this.connection.prepareStatement("select * from aluguel where idDoCliente = ? and renavanDoCarro = ? and dataInicioAluguel =? and dataFinalAluguel = ?; ");
			stmt.setInt(1, novoAluguel.getIdDoCliente());
			stmt.setLong(2, novoAluguel.getRenavanDoCarro());
			stmt.setDate(3, novoAluguel.getDataInicioAluguelToSQL());
			stmt.setDate(4, novoAluguel.getDataFinalAluguelToSQL());



			
			ResultSet rs = stmt.executeQuery();
			int idAluguel = 0;

			if(rs.next()) {
				idAluguel = rs.getInt("id");
				System.out.println("entrou aqui no get id");
			}
			
			
			System.out.println("ID DO ALUGUEL: "+ idAluguel);
			
			DateTime dataInicial = new DateTime(novoAluguel.getDataInicioAluguel());
			DateTime dataFinal = new DateTime(novoAluguel.getDataFinalAluguel());
			int dias = Days.daysBetween(dataInicial, dataFinal).getDays();
			
			
			
			resultAluguel[0] = String.valueOf(idAluguel);			// Id do aluguel
			resultAluguel[1] = dataInicioAluguel;					// Data de inicio
			resultAluguel[2] = dataFinalAluguel;					// Data do final
			resultAluguel[3] = String.valueOf(tarifaBase);			// Tarifa por dia
			resultAluguel[4] = String.valueOf(dias * tarifaBase);	// Total a ser pago na devolução
			resultAluguel[5] = String.valueOf(Double.parseDouble(resultAluguel[4]) * 0.30); 	// Multa por dia de atraso
			
			
			
		}catch (SQLException e) {
			System.out.println("Erro ao alugar carro");
			System.out.println(e.getMessage());
		}


		return resultAluguel;
		
	}

	public void devolveCarro(int idTransacao) {

		try {

			PreparedStatement stmt;

			stmt = this.connection.prepareStatement("DELETE FROM aluguel  WHERE id = ?");
			stmt.setInt(1, idTransacao);
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao devolver um carro");
			System.out.println(e.getMessage());
		}

	}
	// -----

}