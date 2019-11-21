package br.edu.unibratec.livrariadigital.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.unibratec.livrariadigital.model.Livro;

public class RepositorioLivro implements IRepositorioLivro<Object> {


	List<Livro> livros = new ArrayList<Livro>();
	private SessionFactory sessionFactory;
	
	public RepositorioLivro() {
		sessionFactory = new Configuration()
				.configure().buildSessionFactory();
	}
	
	
	public Livro create(Livro pLivro) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		if (this.livros.size() == 0) {

			pLivro.setId(1);
		} else {

			pLivro.setId(this.livros.size() + 1);
		}

		session.save(pLivro);
		session.getTransaction().commit();
		session.close();

		return pLivro;
	}

	public List<Livro> read() {
		List<Livro> result = new ArrayList<Livro>();
		Session session = sessionFactory.openSession();
		 	
		result = session.createQuery("from Produto").list();
		
		session.close();
		
		return result;
	}

	public Livro update(Livro pLivro) {	
       
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(pLivro);		
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Livro atualizado com Sucesso!");

		return pLivro;
	}
	
	public Boolean delete(Livro pLivro) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for(int i = 0; i < livros.size(); i++)
		{
			pLivro = livros.get(i);

			if(pLivro.getId().equals(livros))
			{        
				session.delete(pLivro);	
				break;
			}
		}
		session.getTransaction().commit();
		session.close();
		System.out.println("Livro deletado com Sucesso!");

		return true;
	} 

	public Boolean livroExistente(Livro pLivro) {
		return this.livros.contains(pLivro);
	}
	

	public List<Livro> readTitulo(String titulo) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Livro> livroTitulo = null;
		livroTitulo = new ArrayList<Livro>();
		for (Livro livro : this.livros) {
			if (livro.getTitulo().equals(titulo)) {
				livro = session.get(Livro.class, titulo);
			}
		}
		
		session.getTransaction().commit();
		session.close();

		return livroTitulo;
	}

	public List<Livro> readAutor(String autor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Livro> livroAutor = null;
		livroAutor = new ArrayList<Livro>();
		for (Livro livro : this.livros) {
			if (livro.getAutor().equals(autor)) {
				livro = session.get(Livro.class, autor);
			}
		}
		session.getTransaction().commit();
		session.close();
		
		return livroAutor;
	}

	public List<Livro> readAno(Integer ano) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Livro> livroAno = null;
		livroAno = new ArrayList<Livro>();

		for (Livro livro : this.livros) {
			if (livro.getAno().equals(ano)) {
				livro = session.get(Livro.class, ano);
			}
		}
		session.getTransaction().commit();
		session.close();
		
		return livroAno;
	}

	public List<Livro> readId(Integer id) {
		List<Livro> livroId = null;
		livroId = new ArrayList<Livro>();

		for (Livro livro : this.livros) {
			if (livro.getId().equals(id)) {
				livroId.add(livro);
			}
		}

		return livroId;
	}




	
}
