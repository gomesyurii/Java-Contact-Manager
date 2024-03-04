package br.com.agenda.dao;

import java.sql.Connection;

import java.sql.Date;

import com.mysql.cj.jdbc.ClientPreparedStatement;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	
	
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?, ?, ?)";
		
		Connection conn = null;
		ClientPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			 
			//Add valores esperados para query
			pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			pstm.execute();
			
			
		} 
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally {
			try {
				if(pstm!=null) {
					pstm.close();
					
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
}
