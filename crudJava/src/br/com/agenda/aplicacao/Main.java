package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		  for (int i = 1; i <= 10; i++) {
	            Contato contato = new Contato();
	            contato.setNome("Contact name " + i);
	            contato.setIdade(20 + i); // Apenas um exemplo para idade variável
	            contato.setDataCadastro(new Date());

	            contatoDAO.save(contato);
	        }
		
		 
		for(Contato c: contatoDAO.getContatos()) {
			System.out.println("Contato " + c.getId() +": " + c.getNome());
		} 
	}

}
