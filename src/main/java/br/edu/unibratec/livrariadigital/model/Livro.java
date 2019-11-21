package br.edu.unibratec.livrariadigital.model;

import javax.persistence.Entity;

@Entity
public class Livro extends Produto {

	private String autor;
    private String url;
    private float tamanho;
	
	public Livro(String titulo, String editora, Integer ano, TYPE type, String autor,String url, float tamanho) {
		super(titulo, editora, ano, type);
		this.getTitulo();
		this.getEditora();
		this.getAno();
		this.getAutor();
		this.getType();
		this.autor = autor;
		this.url = url;
		this.tamanho = tamanho;
	}

	public Livro() {
		
	}
	
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public float getTamanho() {
		return tamanho;
	}

	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [getUrl()=" + getUrl() + ", getTamanho()=" + getTamanho() + ", getAutor()=" + getAutor()
				+ ", getType()=" + getType() + ", getId()=" + getId() + ", getTitulo()=" + getTitulo()
				+ ", getEditora()=" + getEditora() + ", getAno()=" + getAno() + "]";
	}
    //Antigo toString
	/*
	@Override
	public String toString() {
		return "Produto [id=" + getId() + ", titulo=" + getTitulo() + " autor= " + getAutor() + ", editora=" + getEditora() + ", ano=" + getAno() + ", tipo=" + getTipo()
				+ "]";
	}
	*/
	
}
