package br.edu.unibratec.livrariadigital.repositorio;



import java.util.List;

import br.edu.unibratec.livrariadigital.model.Livro;

public interface IRepositorioLivro<Object>{
	
	//Metodos do CRUD
	
	//Metodo Criacao ou inserir 					( C )
	Livro create(Livro pLivro);
	
	//Metoto Listar que retorna uma lista de Livros ( R )
	List<Livro> read();
	
	//Metodo de atualizar 							( U )
	Livro update(Livro pLivro);
	
	//Metodo de delecao  							( D )
	Boolean delete(Livro pLivro);

	Boolean livroExistente(Livro pLivro);
	
	List<Livro> readTitulo(String titulo);
	
	List<Livro> readAutor(String autor);
	
	List<Livro> readAno(Integer ano);
	
	List<Livro> readId(Integer id);
	
	
}

