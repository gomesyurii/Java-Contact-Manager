package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//Standard MYSQL Username 
	private static final String USERNAME = "root";
	
	//MYSQL password defined (can be any)
	private static final String PASSWORD = "123321";
	
	//BD Path
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
