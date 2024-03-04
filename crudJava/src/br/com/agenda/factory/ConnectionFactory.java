package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//Nome do usuário do BD
	private static final String USERNAME = "root";
	
	//Senha do BD
	private static final String PASSWORD = "123321";
	
	//Caminho BD
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	//Conexão com o BD
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
	}
	
	
	public static void main(String[] args) throws Exception{
		//Singleton
		Connection con = createConnectionToMySQL();
		
		if(con!= null) {
			con.close();
		}
	}
	
}
