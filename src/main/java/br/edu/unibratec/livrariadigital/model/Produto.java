package br.edu.unibratec.livrariadigital.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produto {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer id;
	private String titulo;
	private String editora;
	private Integer ano;
	@Enumerated(EnumType.STRING)
	private TYPE type;
	
	
	public Produto() {

	}

	public Produto(String titulo, String editora, Integer ano,TYPE type) {
		super();
		this.titulo = titulo;
		this.editora = editora;
		this.ano = ano;
		this.type = type;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}
