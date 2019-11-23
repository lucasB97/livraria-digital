package br.edu.unibratec.livrariadigital.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
		List<Livro> result = new ArrayList<Livro>();
		Session session = sessionFactory.openSession();
		 	
		Query query = session.createQuery("from Produto where titulo = :produto_titulo");
		query.setParameter("produto_titulo", titulo);
		result = query.getResultList();
		session.close();
	
		return result;

	}

	public List<Livro> readAutor(String autor) {
		List<Livro> result = new ArrayList<Livro>();
		Session session = sessionFactory.openSession();
		 	
		Query query = session.createQuery("from Produto where autor = :produto_autor");
		query.setParameter("produto_autor", autor);
		result = query.getResultList();
		session.close();
	
		return result;
	}

	public List<Livro> readAno(Integer ano) {
		List<Livro> result = new ArrayList<Livro>();
		Session session = sessionFactory.openSession();
		 	
		Query query = session.createQuery("from Produto where ano = :produto_ano");
		query.setParameter("produto_ano", ano);
		result = query.getResultList();
		session.close();
	
		return result;
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
