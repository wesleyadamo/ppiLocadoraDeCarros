package ppi.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

public class Connect {

	/*
	 * 
	 * create database agenda; use agenda;
	 * 
	 * create table contatos ( id BIGINT NOT NULL AUTO_INCREMENT, nome VARCHAR(255),
	 * email VARCHAR(255), endereco VARCHAR(255), dataNascimento DATE, telefone
	 * VARCHAR(20), primary key (id) );
	 * 
	 */

	private String banco = "jdbc:mysql://localhost:3306/?verifyServerCertificate=false&useSSL=true";
	private String driver = "com.mysql.jdbc.Driver";
	private String user = "root";
	private String pass = "apo01mpa";

	public Connection getConnection() {
		try {

			// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName(driver);

			return DriverManager.getConnection(banco, user, pass);

		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
