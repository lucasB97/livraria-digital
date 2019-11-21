
package br.edu.unibratec.livrariadigital.view;

import java.util.Scanner;

import br.edu.unibratec.livrariadigital.excecoes.servicoException;
import br.edu.unibratec.livrariadigital.model.Livro;
import br.edu.unibratec.livrariadigital.model.TYPE;
import br.edu.unibratec.livrariadigital.servico.ServicoLivro;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		// Chamada do tipo Digital
		
		// Chamada do tipo Fisico
		

		// Chamada do Livro acrescentando o TIPO Digital
		//Livro vLivro = new Livro("Title", "editora", 2018, vDigital, "autor");

		// Chamada do Livro acrescentando o TIPO Fisico
		

		
		//Chamada do CRUD
		ServicoLivro servicoLivro = new ServicoLivro();
		int opcao = 0;
		String tipo = "";
		do {
			System.out.println("### Catálogo digital de livros ###");
			System.out.println("|=================================|");
			System.out.println("|     1 - Incluir Livro           |");
			System.out.println("|     2 - Listar  Todos os Livros |");
			System.out.println("|     3 - Listar  Livro por Título|");
			System.out.println("|     4 - Listar  Livro por Autor |");
			System.out.println("|     5 - Listar  Livro por Ano   |");
			System.out.println("|     6 - Editar  Livro           |");
			System.out.println("|     7 - Excluir Livro           |");
			System.out.println("|     0 - Sair                    |");
			System.out.println("|=================================|\n");

			System.out.println("Opção -> ");
			Livro v2Livro = new Livro();
			opcao = s.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Insira um livro\n");
				System.out.println("Titulo:\n");
				v2Livro.setTitulo(s.next());
				System.out.println("Autor:\n");
				v2Livro.setAutor(s.next());
				System.out.println("Editora:\n");
				v2Livro.setEditora(s.next());
				System.out.println("Ano:\n");
				v2Livro.setAno(s.nextInt());
				System.out.println("Tipo de mídia");
				System.out.println("--Digital ou Física--\n");
				tipo = s.next();
				if(tipo.equalsIgnoreCase("física") || tipo.equalsIgnoreCase("f")){
					v2Livro.setType(TYPE.FISICO);}
				else if(tipo.equalsIgnoreCase("digital")|| tipo.equalsIgnoreCase("d")){
					System.out.println("Digite a url do livro:\n");
				    v2Livro.setUrl(s.next());
				    System.out.println("Digite o tamanho do arquivo:\n");
				    v2Livro.setTamanho(s.nextFloat());
					v2Livro.setType(TYPE.DIGITAL);};		
				try {
					servicoLivro.create(v2Livro);
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}	
				break;
			case 2:
				try {
					System.out.println(servicoLivro.read());
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Digite o título:");
				try {
					System.out.println(servicoLivro.readTitulo(s.next()));
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Digite o autor:");
				try {
					System.out.println(servicoLivro.readAutor(s.next()));
					
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Digite o ano:");
				try {
					System.out.println(servicoLivro.readAno(s.nextInt()));	
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 6:	
				System.out.println("Digite o novo id:");
				v2Livro.setId(s.nextInt());;
				System.out.println("Digite o novo Título:");
				v2Livro.setTitulo(s.next());
				System.out.println("Digite o novo Autor:");
				v2Livro.setAutor(s.next());
				System.out.println("Digite a nova Editora:");
				v2Livro.setEditora(s.next());
				System.out.println("Digite o novo Ano:");
				v2Livro.setAno(s.nextInt());
				System.out.println("Digite o novo tipo de Mídia:");
				System.out.println("--Dgitial ou Física-1-\n");
				tipo = s.next();
				if(tipo.equalsIgnoreCase("física"))
					//v2Livro.setTipo(new Fisico());
				if(tipo.equalsIgnoreCase("digital"))
					//v2Livro.setTipo(new Digital());	
				try {
			
					System.out.println(servicoLivro.update(v2Livro));
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 7:	
				
				try {
					System.out.println(servicoLivro.delete(v2Livro));
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}
				break;
				
			}
		} while (opcao != 0);
		
	
		
		/*
		System.out.println(
				"-----------------------------Criando Livro Digital + Erro --------------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		try {
			System.out.println(servicoLivro.create(vLivro));
			System.out.println(servicoLivro.create(vLivro));
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(
				"------------------------------Criando Livro Físico + Erro --------------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		try {
			System.out.println(servicoLivro.create(v2Livro));
			System.out.println(servicoLivro.create(v2Livro));
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}

		System.out.println(
				"---------------------------Lista Completa com 2 livros, 1 físico e 1 digital ---------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		try {
			System.out.println(servicoLivro.read());
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}

		System.out.println(
				"-------------------------------------Atualizando o Livro Digital ---------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		vLivro.setId(1);
		vLivro.setTitulo("André");
		vLivro.setAno(1900);
		try {
			System.out.println(servicoLivro.update(vLivro));
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");

		System.out.println(
				"--------------------------------------------Lista Atualizada -------------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		try {
			System.out.println(servicoLivro.read());
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}

		System.out.println(
				"----------------------------------------Deletar Livro Digital -------------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		try {
			System.out.println(servicoLivro.delete(vLivro));
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}

		System.out.println(
				"--------------------------------------Lista Atualizada sem Livro Digital -------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		try {
			System.out.println(servicoLivro.read());
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}

		System.out.println(
				"--------------------------------------------Lista Atualizada -------------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		try {
			System.out.println(servicoLivro.read());
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(
				"--------------------------------------------Procurar Livro Por Título-------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		try {
			System.out.println(servicoLivro.readTitulo("Title2"));
			System.out.println(servicoLivro.readTitulo("Deco"));
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(
				"--------------------------------------------Procurar Livro Por Autor-------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		try {
			System.out.println(servicoLivro.readAutor("Autor2"));
			System.out.println(servicoLivro.readAutor("Deco"));
			
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(
				"--------------------------------------------Procurar Livro Por Ano -------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		try {
			System.out.println(servicoLivro.readAno(2019));
			System.out.println(servicoLivro.readAno(190));
			
			
		} catch (servicoException e) {
			System.err.println(e.getMessage());
		}
		*/
	}

}
