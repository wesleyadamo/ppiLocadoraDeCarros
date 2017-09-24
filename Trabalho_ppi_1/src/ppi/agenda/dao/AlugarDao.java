package ppi.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ppi.agenda.jdbc.ConnectionFactory;
import ppi.agenda.model.Aluguel;
import ppi.agenda.model.Carro;


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

			while(rs.next()) {

				Aluguel novoAluguel = new Aluguel();

				novoAluguel.setId(rs.getInt("id"));
				novoAluguel.setIdDoCarro(rs.getInt("idDoCarro"));
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

		System.out.println(alugueis.size()+" tamanho");

		return alugueis;
		
		

	}
	
	
	// Retorna o aluguel selecionado, o objeto aluguel de retorno possui um valor extra que e o valor exato
	// a ser pago por quem alugou na hora de devolver, tera tbm as informações como o carro alugado e o nome e cpf de quem alugou
	public Aluguel obterAluguel(int idTransacao) {


		Aluguel novoAluguel = new Aluguel();

		try {
			PreparedStatement stmt;
			ResultSet rs;
			
			stmt = this.connection.prepareStatement("SELECT * FROM alugueis WHERE id = ?");
			stmt.setInt(1, idTransacao);
			rs = stmt.executeQuery();

			if(rs.next()) {

				novoAluguel.setId(rs.getInt("id"));
				novoAluguel.setIdDoCarro(rs.getInt("idDoCarro"));
				novoAluguel.setIdDoCliente(rs.getInt("idDoCliente"));
				novoAluguel.setDataInicioAluguelFromSQL(rs.getDate("dataInicioAluguel"));
				novoAluguel.setDataFinalAluguelFromSQL(rs.getDate("dataFinalAluguel"));
				novoAluguel.setTarifaBase(rs.getDouble("tarifaBase"));
				
				
				Calendar dataHoje = Calendar.getInstance();
				
				novoAluguel.gerarValorTotal(dataHoje);
				
				//Acessa o banco de clientes para obter as info de nome e cpf
				stmt = this.connection.prepareStatement("SELECT nome, cpf FROM clientes WHERE ID = ?");
				stmt.setInt(1, novoAluguel.getIdDoCliente());
				rs = stmt.executeQuery();
				
				rs.next();
				novoAluguel.setNomeCliente(rs.getString("nome"));
				novoAluguel.setCpfCliente(rs.getString("cpf"));
				
				//Acessa o banco de carros para obter a info do modelo
				stmt = this.connection.prepareStatement("SELECT modelo, renavan FROM carros WHERE ID = ?");
				stmt.setInt(1, novoAluguel.getIdDoCarro());
				rs = stmt.executeQuery();
				
				rs.next();
				novoAluguel.setModeloDoCarro(rs.getString("modelo"));
				novoAluguel.setModeloDoCarro(rs.getString("renavan"));
				


			}

		} catch (SQLException e) {
			System.out.println("Erro ao obter aluguel");
			System.out.println(e.getMessage());
		}


		return novoAluguel;

	}
	
	
	
	
	// SETTERs
	
	public int alugaCarro(int idDoCarro, int idDoCliente, String dataInicioAluguel, String dataFinalAluguel, double tarifaBase) {
		
		int idTransacao = -1;
		
		Aluguel novoAluguel = new Aluguel();
		
		
		System.out.println(idDoCarro+" "+ idDoCliente+" "+ dataInicioAluguel+" "+ dataFinalAluguel+" "+tarifaBase);
		
		novoAluguel.setIdDoCarro(idDoCarro);
		novoAluguel.setIdDoCliente(idDoCliente);
		novoAluguel.setDataInicioAluguelString(dataInicioAluguel);
		novoAluguel.setDataFinalAluguelString(dataFinalAluguel);
		novoAluguel.setTarifaBase(tarifaBase);
		
		
		
		
		// Obtem o carro para saber se tem disponivel
		// Apenas um tratamento no back
		Carro carro = new CarrosDao().obterCarro(idDoCarro);
		
		
		
		
			
		try {

			PreparedStatement stmt;

			// Cria o registro 
			stmt = this.connection.prepareStatement("INSERT INTO aluguel(idDoCliente, idDoCarro, dataInicioAluguel, dataFinalAluguel, tarifaBase) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(2, novoAluguel.getIdDoCarro());
			stmt.setInt(1, novoAluguel.getIdDoCliente());
			stmt.setDate(3, novoAluguel.getDataInicioAluguelToSQL());
			stmt.setDate(4, novoAluguel.getDataFinalAluguelToSQL());
			stmt.setDouble(5, novoAluguel.getTarifaBase());

			int ok = stmt.executeUpdate();
			System.out.println("CARRO");
			System.out.println(novoAluguel.getIdDoCarro());
			System.out.println(novoAluguel.getIdDoCliente());

			
			
			stmt =  this.connection.prepareStatement("select * from aluguel where idDoCliente = ? and idDoCarro = ? ; ");
			stmt.setInt(1, novoAluguel.getIdDoCliente());
			stmt.setInt(2, novoAluguel.getIdDoCarro());


			//Recupera o ID da transacao recem gerado
		/*	ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
				idTransacao = rs.getInt("id");*/
			
			ResultSet rs = stmt.executeQuery();
			int idAluguel=0;

			if(rs.next()) {
				idAluguel = rs.getInt("id");
				System.out.println("entrou aqui no get id");
			}
			
			
			
			return idAluguel;


		}catch (SQLException e) {
			System.out.println("Erro ao alugar carro");
			System.out.println(e.getMessage());
		}


		return idTransacao;
		
	}
	
	
	
	
	
	
	public void devolveCarro(int idTransacao) {

		try {
			
			PreparedStatement stmt;
			ResultSet rs;
			
			//SELECT idDoCarro FROM alugueis WHERE ID = ?");
			stmt = this.connection.prepareStatement("SELECT id, quantidadeDisponivel  FROM carros WHERE ID = (SELECT idDoCarro FROM alugueis WHERE ID = ?)");
			stmt.setInt(1, idTransacao);
			rs = stmt.executeQuery();

			if(rs.next()) {

				
				int idDoCarro = rs.getInt("id");
				int quantidadeDisponivel = rs.getInt("quantidadeDisponivel");
				
				stmt = this.connection.prepareStatement("UPDATE carros SET quantidadeDisponivel = ? WHERE ID = ?");
				stmt.setInt(1, (quantidadeDisponivel + 1));
				stmt.setInt(2, idDoCarro);
				stmt.executeUpdate();
				
						
			}

		} catch (SQLException e) {
			System.out.println("Erro ao devolver um carro");
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	//-----

}