package br.edu.unibratec.livrariadigital.servico;

import java.util.List;

import br.edu.unibratec.livrariadigital.excecoes.servicoException;
import br.edu.unibratec.livrariadigital.model.Livro;

public class Facade {

	private static Facade instancia;
	private static ServicoLivro servico;

	private Facade() {
	}
	
	//Implementação singleton
	public static Facade getInstancia() {
		if(instancia == null) {
			instancia = new Facade();
			servico = new ServicoLivro();
		}
		return instancia;
	}
	
	public void createLivro(Livro livro) {
				
		try {
			 servico.create(livro);
		} catch (servicoException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public List<Livro> readLivro() throws servicoException{
		 
		return servico.read();
	}
	
	public void updateLivro(Livro livro) {
		
		try {
			servico.update(livro);
		} catch (servicoException e) {
			
			e.printStackTrace();
		}
				
	}
	
	public void deleteLivro(Livro livro) {
             try {
					servico.delete(livro);
				} catch (servicoException e) {
					
					e.printStackTrace();
				}
	
	}
	
	public List<Livro> readTitulo(String titulo) throws servicoException{
		
		return servico.readTitulo(titulo);
		
	}
	
    public List<Livro> readAutor(String autor) throws servicoException{
		
		return servico.readTitulo(autor);
		
	}
    
   public List<Livro> readAno(Integer ano) throws servicoException{
		
		return servico.readAno(ano);
		
	}
	

	
	
	

}
