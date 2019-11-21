package br.edu.unibratec.livrariadigital.servico;

import java.util.List;

import br.edu.unibratec.livrariadigital.excecoes.servicoException;
import br.edu.unibratec.livrariadigital.model.Livro;

public interface IServicoLivro {
	// Metodos do CRUD

	// Metodo Criacao ou inserir ( C )
	Livro create(Livro pLivro) throws servicoException;

	// Metoto Listar que retorna uma lista de Livros ( R )
	List<Livro> read() throws servicoException;

	// Metodo de atualizar ( U )
	Livro update(Livro pLivro) throws servicoException;

	// Metodo de delecao ( D )
	Boolean delete(Livro vLivro) throws servicoException;

	List<Livro> readTitulo(String titulo) throws servicoException;

	List<Livro> readAutor(String autor)throws servicoException;

	List<Livro> readAno(Integer ano)throws servicoException;
	
	List<Livro> readId(Integer id);
}
