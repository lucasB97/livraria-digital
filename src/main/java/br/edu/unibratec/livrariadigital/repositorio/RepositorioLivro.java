package br.edu.unibratec.livrariadigital.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import br.edu.unibratec.livrariadigital.model.Livro;

public class RepositorioLivro implements IRepositorioLivro<Object> {


	private SessionFactory sessionFactory;
	
	public RepositorioLivro() {
		sessionFactory = new Configuration()
				.configure().buildSessionFactory();
	}
	
	
	public Livro create(Livro pLivro) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
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
		
		if (findId(pLivro.getId())) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(pLivro);
			System.out.println("Livro deletado com Sucesso!");
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
		
	} 

	public Boolean livroExistente(Livro pLivro) {
		List<Livro> result = new ArrayList<Livro>();
		Session session = sessionFactory.openSession();
		 	
		Query query = session.createQuery("from Produto");
		result = query.getResultList();
		session.close();
	
		return result.contains(pLivro);
		
		
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

	//Novo método abaixo: Criado para deletar por ID.
		public Boolean findId(Integer livroId) {
			List<Livro> result = new ArrayList<Livro>();
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Produto where Id = :produto_id");
			query.setParameter("produto_id", livroId);
			result = query.getResultList();
			session.close();
		
			return !result.isEmpty();
			
		}




	
}
