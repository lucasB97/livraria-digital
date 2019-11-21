package br.edu.unibratec.livrariadigital.servico;

import java.util.List;

import br.edu.unibratec.livrariadigital.excecoes.servicoException;
import br.edu.unibratec.livrariadigital.model.Livro;
import br.edu.unibratec.livrariadigital.repositorio.RepositorioLivro;

public class ServicoLivro implements IServicoLivro {

	private RepositorioLivro repositorio = new RepositorioLivro();

	public Livro create(Livro pLivro) throws servicoException {
		Livro vLivro = null;

		if (repositorio.livroExistente(pLivro)) {
			throw new servicoException("Não foi possível adicionar livro, item ja existente!");
		} else {
			vLivro = repositorio.create(pLivro);
			System.out.println("Livro adicionado com sucesso!");
		}

		return vLivro;
	}

	public List<Livro> read() throws servicoException {
		List<Livro> vLivros = null;

		vLivros = repositorio.read();
		if (vLivros == null) {
			throw new servicoException("Ainda não existem livros cadastrados!");
		}

		return vLivros;
	}

	public Livro update(Livro pLivro) throws servicoException {
		Livro vLivro = null;

		vLivro = repositorio.update(pLivro);
		if (vLivro == null) {
			throw new servicoException("Ainda não existem livros para ser atualizado!");
		}
		return vLivro;
	}

	
	public Boolean delete(Livro vLivro) throws servicoException {
		Boolean vDeletado = false;

		vDeletado = repositorio.delete(vLivro);

		if (vLivro == null) {
			throw new servicoException("Ainda não existe livro para ser deletado!");
		}

		return vDeletado;
	}

	public List<Livro> readTitulo(String titulo) throws servicoException {
		List<Livro> vLivros = null;

		vLivros = repositorio.readTitulo(titulo);
		if ((vLivros == null)||(vLivros.size() == 0)) {
			throw new servicoException("Não foi encontrado nenhum livro com esse título!");
		}

		return vLivros;
	}

	public List<Livro> readAutor(String autor) throws servicoException {
		List<Livro> vLivros = null;

		vLivros = repositorio.readAutor(autor);
		if ((vLivros == null)||(vLivros.size() == 0)) {
			throw new servicoException("Não foi encontrado nenhum autor com esse título!");
		}

		return vLivros;
	}

	public List<Livro> readAno(Integer ano) throws servicoException {
		List<Livro> vLivros = null;

		vLivros = repositorio.readAno(ano);
		if ((vLivros == null)||(vLivros.size() == 0)) {
			throw new servicoException("Não foi encontrado nenhum livro com esse ano!");
		}

		return vLivros;
	}

	public List<Livro> readId(Integer id) {
		List<Livro> vLivros = null;

		vLivros = repositorio.readId(id);
		
		return vLivros;
	}

	public Boolean delete(Integer id) throws servicoException {
		// TODO Auto-generated method stub
		return null;
	}

}
