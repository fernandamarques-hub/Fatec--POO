package org.fatec;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class App {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// caminho onde vai salvar o cadastro de clientes
		String caminho = "D:\\Documentos\\ADS - Fatec\\3º semestre\\Programação Orientada à Objetos\\Lista 1 - POO\\unidades";
		
		Controle controle = new Controle();
		
		List<Unidade> unidades = new ArrayList<>();
		
		int escolha, escolha2, escolha3, escolhaEdit;
		String loja, resp;
		
		do {
			Menu.cadastroUnidade();
			escolha = controle.opcao();
			
			switch(escolha) {
			case 1: 
				Unidade u = new Unidade();
				System.out.println("Digite o nome da unidade: ");
				u.nome = controle.texto().toLowerCase();
				unidades.add(u);
				break;
			case 2:
				unidades.forEach(uni -> System.out.println(uni));
				if(unidades.isEmpty()) {
					System.out.println("Não há unidades cadastradas!");
				}
				break;
			case 3:
				System.out.println("Digite o nome da unidade, para visualizar agenda:");
				loja = controle.texto().toLowerCase();
				for(int i = 0; i < unidades.size(); i++) {
					u = unidades.get(i);

					if(u.getNome().toLowerCase().equals(loja)) {
						System.out.println("Essa é a unidade " + u.nome + " ?, digite S ou N:");
						resp = controle.texto().toLowerCase();
						if(resp.equals("s")) {
							do {
								Menu.mostrarMenu();
								escolha2 = controle.opcao();
								
								switch(escolha2) {
								case 1:
									Cliente c = new Cliente();
									System.out.println("Insira o nome: ");
									c.nome = controle.texto();
									System.out.println("Insira o telefone: ");
									c.telefone = controle.texto();
									System.out.println("Insira a data de nascimento (dd/mm/aaaa): ");
									c.dataNasc = controle.texto();
									System.out.println("Insira o gênero (F/M): ");
									c.genero = controle.texto();
									System.out.println("Insira os serviços utilizados: ");
									c.servicos.add(controle.texto());
									u.agenda.add(c);;
									break;
									
								case 2:
									String nomeEdit;
									System.out.println("Digite o nome para edição: ");
									nomeEdit = controle.texto().toLowerCase();
									String nomeFor = "";
									for(Cliente cli: u.agenda) {
										nomeFor = cli.getNome().toLowerCase();
										if(nomeFor.equals(nomeEdit)) {
											System.out.println(cli);
											System.out.println("\nDeseja editar esse cliente? (S/N)");
											resp = controle.texto().toLowerCase();
											if(resp.equals("s")) {
												do {
													Menu.mostrarEdicao();
													escolhaEdit = controle.opcao();
													switch(escolhaEdit) {
													case 1:
														System.out.println("Digite o novo nome: ");
														cli.nome = controle.texto();
														break;
													case 2:
														System.out.println("Digite o novo telefone: ");
														cli.telefone = controle.texto();
														break;
													case 3:
														System.out.println("Digite a nova data de nascimento (dd/mm/aaaa): ");
														cli.dataNasc = controle.texto();
														break;
													case 4:
														System.out.println("Digite o novo gênero (F/M): ");
														cli.genero = controle.texto();
														break;
													case 5:
														System.out.println("Digite os novos serviços adquiridos: ");
														cli.servicos.add(controle.texto());
													case 0: break;
													default: System.out.println("Opção inválida!");
													}
												}while(escolhaEdit != 0);
											}
											
										}
									}
									break;
								case 3:
									nomeEdit = "";
									System.out.println("Digite o nome para exclusão de cadastro: ");
									nomeEdit = controle.texto().toLowerCase();
									for(i=0; i < u.agenda.size(); i++){
										c = u.agenda.get(i);
										if(c.getNome().toLowerCase().equals(nomeEdit)) {
											System.out.println(c);
											System.out.println("\nDeseja excluir esse cliente? (S/N)");
											resp = controle.texto().toLowerCase();
											if(resp.equals("s")) {
												u.agenda.remove(c);
												break;
											}
											else {break;}
										}
									}
									break;
								case 4:
									u.agenda.forEach(pessoa -> System.out.println(pessoa));
									if(u.agenda.isEmpty()) {
										System.out.println("Não há cadastros!");
									}
									break;
								case 5:
									int cont = 0;
									String generoList;
									System.out.println("Digite o gênero (F/M): ");
									generoList = controle.texto().toLowerCase();
									for(i = 0; i < u.agenda.size(); i++) {
										c = u.agenda.get(i);
										if(c.getGenero().toLowerCase().equals(generoList)) {
											System.out.println(c);
											cont++;
										}
									}
									if(cont == 0) {
										System.out.println("Não há cadastros com esse gênero!");
									}
									break;
								case 6: 
									nomeEdit = "";
									System.out.println("Digite o nome do cliente: ");
									nomeEdit = controle.texto().toLowerCase();
									for(i = 0; i < u.agenda.size(); i++) {
										c = u.agenda.get(i);
										if(c.getNome().toLowerCase().equals(nomeEdit)) {
											System.out.println("Cliente: " + c.nome + "\nServiços: " + c.servicos);
										}
									}
									break;
								case 7: 
									do {
										Menu.mostrarRelatorio();
										escolha3 = controle.opcao();
										switch(escolha3) {
										case 1:
											int media = 0;
											if(u.agenda.isEmpty()) {
												System.out.println("Não há cadastros!");
											}
											else {
												for(i = 0; i < u.agenda.size(); i++) {
													c = u.agenda.get(i);
													int idade = calcIdade(c.dataNasc);
													media += idade;
													System.out.println(idade);
												}
												media = media / (u.agenda.size());
												System.out.println("A média de idade dessa unidade é: " + media);
											}
											break;
										case 2:
											cont = 0;
											generoList = "";
											System.out.println("Digite o gênero (F/M): ");
											generoList = controle.texto().toLowerCase();
											media = 0;
											for(i = 0; i < u.agenda.size(); i++) {
												c = u.agenda.get(i);
												if(c.getGenero().toLowerCase().equals(generoList)) {
													int idade = calcIdade(c.dataNasc);
													media += idade;
													cont++;
												}
											}
											if(cont == 0) {
												System.out.println("Não há cadastros desse gênero!");
											}
											else {
												media = media / cont;
												System.out.println("A média de idade do gênero " + generoList + " é: " + media);
											}
											break;
										case 0: 
											break;
										default: System.out.println("Opção inválida!");
										}
									}while(escolha3 != 0);
									break;
								case 0: 
									break;
								default: System.out.println("Opção inválida!"); 
									}
								}while(escolha2 != 0);
						}
					}
				}
			case 0:
				break;
			default: System.out.println("Opção inválida!"); 				
			}			
		}while(escolha != 0);
	}
	
	public static int calcIdade(String dataNasc) {
		String[] partes = dataNasc.split("/");
		int diaNasc = Integer.valueOf(partes[0]);
		int mesNasc = Integer.valueOf(partes[1]);
		int anoNasc = Integer.valueOf(partes[2]);
		
		GregorianCalendar hoje = new GregorianCalendar();
		int diaH = hoje.get(Calendar.DAY_OF_MONTH);
		int mesH = hoje.get(Calendar.MONTH)+ 1;
		int anoH = hoje.get(Calendar.YEAR);
		
		int idade;
		idade = anoH - anoNasc;
		if((mesH < mesNasc) || ((mesH == mesNasc) && (diaH < diaNasc))) {
			idade--;
		}
		return idade;
	}
}
