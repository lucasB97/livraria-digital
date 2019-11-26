
package br.edu.unibratec.livrariadigital.view;

import java.util.Scanner;

import br.edu.unibratec.livrariadigital.excecoes.servicoException;
import br.edu.unibratec.livrariadigital.model.Livro;
import br.edu.unibratec.livrariadigital.model.TYPE;
import br.edu.unibratec.livrariadigital.servico.Facade;

public class App {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		Facade fachada = Facade.getInstancia();
	

		
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
				fachada.createLivro(v2Livro);	
				break;
			case 2:
				try {
					System.out.println(fachada.readLivro());
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Digite o título:");
				try {
					System.out.println(fachada.readTitulo(s.next()));
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Digite o autor:");
				try {
					System.out.println(fachada.readAutor(s.next()));
					
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Digite o ano:");
				try {
					System.out.println(fachada.readAno(s.nextInt()));	
				} catch (servicoException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 6:	
				System.out.println("Digite o ID do livro para edição: ");
				v2Livro.setId(s.nextInt());
				System.out.println("Digite o novo Título:");
				v2Livro.setTitulo(s.next());
				System.out.println("Digite o novo Autor:");
				v2Livro.setAutor(s.next());
				System.out.println("Digite a nova Editora:");
				v2Livro.setEditora(s.next());
				System.out.println("Digite o novo Ano:");
				v2Livro.setAno(s.nextInt());
				System.out.println("Digite o novo tipo de Mídia:");
				System.out.println("--Digital(D) ou Física(F)--\n");
				tipo = s.next();
				if(tipo.equalsIgnoreCase("física") || tipo.equalsIgnoreCase("f")){
					v2Livro.setType(TYPE.FISICO);}
				else if(tipo.equalsIgnoreCase("digital")|| tipo.equalsIgnoreCase("d")){
					System.out.println("Digite a url do livro:\n");
				    v2Livro.setUrl(s.next());
				    System.out.println("Digite o tamanho do arquivo:\n");
				    v2Livro.setTamanho(s.nextFloat());
					v2Livro.setType(TYPE.DIGITAL);};
				fachada.updateLivro(v2Livro);
				break;
			case 7:	
				System.out.println("Selecione o ID do livro à ser excluído: ");
				v2Livro.setId(s.nextInt());
				fachada.deleteLivro(v2Livro);
				break;
				
			}
		} while (opcao != 0);
	}

}
