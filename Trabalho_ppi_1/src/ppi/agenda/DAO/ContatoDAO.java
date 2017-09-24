package ppi.agenda.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ppi.agenda.jdbc.Connect;
import ppi.agenda.model.Carro;
import ppi.agenda.model.Contato;


public class ContatoDAO {

	private Connection connection;
	
	public ContatoDAO() {
		this.connection = new Connect().getConnection();
	}
	
	public String aqui() {
		return "ksjdksdjksj";
	}
	
	public void adiciona(Contato contato) {

		String sql = "insert into contatos (nome, email, endereco, dataNascimento, telefone) values (?,?,?,?,?)";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, contato.getTelefone());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	
	public void altera(Contato contato) {
		
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=?, telefone=? where id=?";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, contato.getTelefone());
			stmt.setLong(6, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
	
	
	
	public void remove(Contato contato) {
		
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public List<Contato> getLista() {

		try {

			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos order by nome asc");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setTelefone(rs.getString("telefone"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				// adicionando o objeto � lista
				contatos.add(contato);
			}

			rs.close();
			stmt.close();

			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public Contato buscar(long id) {
		Contato contato = new Contato();
		
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				// criando o objeto Contato
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setTelefone(rs.getString("telefone"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				rs.close();
				stmt.close();				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return contato;
	}
	
	
	
	public List<Contato> buscarNome(String nome) {
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where nome like ? or telefone like ?");
			stmt.setString(1, "%"+nome+"%");
			stmt.setString(2, "%"+nome+"%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Contato contato = new Contato();
				
				// criando o objeto Contato
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setTelefone(rs.getString("telefone"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
				
							
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return contatos;
	}
	
	
	public List<Carro> getListaCarro(){
		
		List<Carro> c = new ArrayList<Carro>();
		
       Carro c1 = new Carro();
       
       c1.setId(1);
       c1.setModelo("fiat uno");
       c1.setAnoFabricacao("1990");
       c1.setCategoria("economico");
       c1.setRenavan("1121212121");
       c1.setTarifaDia(70);
       
Carro c2 = new Carro();
       
       c2.setId(2);
       c2.setModelo("corolla");
       c2.setAnoFabricacao("1992");
       c2.setCategoria("suv");
       c2.setRenavan("545454");
       c2.setTarifaDia(120);
       
       
       c.add(c1);
       c.add(c2);
       
       
       return c;
		       
      		
	}
	
	
}
