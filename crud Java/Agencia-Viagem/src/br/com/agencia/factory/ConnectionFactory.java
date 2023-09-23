package br.com.agencia.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Uc6j0(ym5769";
	
	private static final String DATABASE_URL="jdbc:mysql://localhost:3306/agencia_viagem";
	
	public static Connection createConnectionToMySQL() throws Exception {
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	};
	
	public static void main(String[] args) throws Exception {
		Connection conn = createConnectionToMySQL();
		
		if(conn!= null) {
			System.out.println("Conexão bem sucedida");
		} else {
			System.out.println("Erro de conexão");
		}
	}
}