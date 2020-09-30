package br.com.gabriel.treinamento.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/formulario";
	private static final String USERNAME = "root";
	private static final String PASSWORD  = "";
	
	public static Connection createConnectionToMySQL() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = createConnectionToMySQL();
		if(conn != null) {
			System.out.println("conexao com bd feita com sucesso");
		}
	}
}
