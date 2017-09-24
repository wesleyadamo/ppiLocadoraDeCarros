package ppi.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	
	private String banco = "jdbc:mysql://localhost:3306/aluguel?verifyServerCertificate=false&useSSL=true";
	private String driver = "com.mysql.jdbc.Driver";
	private String user = "root";
	private String pass = "apo01mpa";
	
	

	public Connection getConnection() {
		
		try {
			
			Class.forName(driver);
			return DriverManager.getConnection(banco, user, pass);
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
