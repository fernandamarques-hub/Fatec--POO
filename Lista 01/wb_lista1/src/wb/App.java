package wb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class App {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// caminho onde vai salvar o cadastro de clientes
		String caminho = "D:\\Documentos\\ADS - Fatec\\3º semestre\\Programação Orientada à Objetos\\Lista 1 - POO\\unidades";
		
		// iniciando o controle para receber as informações pelo teclado
		Controle controle = new Controle();
		
		// Lista para armazenar todas as unidades (lojas)
		List<Unidade> unidades = new ArrayList<>();
		
		//variáveis de controle para sair dos menus
		int escolha, escolha2, escolha3, escolhaEdit;
		String loja, resp;
		
		do {
			Menu.cadastroUnidade();
			escolha = controle.opcao();
			
			switch(escolha) {
			case 1: //cadastrar Unidade
				Unidade u = new Unidade();
				System.out.println("Digite o nome da unidade: ");
				u.nome = controle.texto().toLowerCase();
				unidades.add(u);
				break;
				
			case 2: //Listar Unidades
				unidades.forEach(uni -> System.out.println(uni));
				if(unidades.isEmpty()) {
					System.out.println("Não há unidades cadastradas!");
				}
				break;
				
			case 3: //Entrar na Agenda de uma unidade
				System.out.println("Digite o nome da unidade, para visualizar agenda:");
				loja = controle.texto().toLowerCase();
				for(int i = 0; i < unidades.size(); i++) {
					u = unidades.get(i);

					if(u.getNome().toLowerCase().equals(loja)) {
						System.out.println("Essa é a unidade " + u.nome + " ?, digite S ou N:");
						resp = controle.texto().toLowerCase();
						if(resp.equals("s")) {
							do {
								Menu.mostrarMenu(); //Menu dentro da agenda da unidade selecionada
								escolha2 = controle.opcao();
								
								switch(escolha2) {
								case 1: //Cadastrar Clientes
									Cliente c = new Cliente();
									System.out.println("Insira o nome: ");
									c.nome = controle.texto();
									System.out.println("Insira o telefone: ");
									c.telefone = controle.texto();
									System.out.println("Insira a data de nascimento (dd/mm/aaaa): ");
									c.dataNasc = controle.texto();
									System.out.println("Insira o gênero (F/M): ");
									c.genero = controle.texto();
									u.agenda.add(c);;
									break;
									
								case 2: //Editar cadastro de cliente
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
													case 1: //Ediatr nome
														System.out.println("Digite o novo nome: ");
														cli.nome = controle.texto();
														break;
														
													case 2: //Editar telefone
														System.out.println("Digite o novo telefone: ");
														cli.telefone = controle.texto();
														break;
														
													case 3: //Editar data de nascimento
														System.out.println("Digite a nova data de nascimento (dd/mm/aaaa): ");
														cli.dataNasc = controle.texto();
														break;
														
													case 4: //Editar gênero
														System.out.println("Digite o novo gênero (F/M): ");
														cli.genero = controle.texto();
														break;
														
													case 0: break;
													
													default: System.out.println("Opção inválida!");
													}
												}while(escolhaEdit != 0);
											}
										}
									}
									break;
									
								case 3: //Remover cadastro de um cliente
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
									
								case 4: //Adicionar serviço à um cliente
									nomeEdit = "";
									System.out.println("Digite o nome do cliente para inclusão do serviço: ");
									nomeEdit = controle.texto().toLowerCase();
									for(i=0; i < u.agenda.size(); i++){
										c = u.agenda.get(i);
										if(c.getNome().toLowerCase().equals(nomeEdit)) {
											System.out.println("Digite o serviço: ");
											c.servicosCli.add(controle.texto());
										}	
									}
									break;
									
								case 5: //Listar clientes
//									u.agenda.forEach(pessoa -> System.out.println(pessoa));
									if(u.agenda.isEmpty()) {
										System.out.println("Não há cadastros!");
									}
									else {
										List <String> lista = new ArrayList<String>();
										for(i = 0; i < u.agenda.size(); i++) {
											c = u.agenda.get(i);
											lista.add(c.nome);
										}
										Collections.sort(lista);
										System.out.println(lista);
										nomeEdit = "";
										for(i = 0; i < lista.size(); i++) {
											nomeEdit = lista.get(i);
											nomeEdit.toLowerCase();
											//System.out.println(nomeEdit);
											for(int j = 0; j < u.agenda.size(); j++) {
												c = u.agenda.get(j);
												//System.out.println(c.nome);
												if(c.nome.toLowerCase().equals(nomeEdit)) {
													System.out.println(c);
												}
											}
										}
									}
									break;
									
								case 6: //Listar clientes por gênero
									int cont = 0;
									List <String> lista3 = new ArrayList<String>();
									String generoList;
									if(u.agenda.isEmpty()) {
										System.out.println("Não há cadastros!");
									}
									else {
										System.out.println("Digite o gênero (F/M): ");
										generoList = controle.texto().toLowerCase();
										for(i = 0; i < u.agenda.size(); i++) {
											c = u.agenda.get(i);
											if(c.getGenero().toLowerCase().equals(generoList)) {
												lista3.add(c.nome);
												cont++;
											}
										}
										Collections.sort(lista3);
										nomeEdit = "";
										for(i = 0; i < lista3.size(); i++) {
											nomeEdit = lista3.get(i);
											nomeEdit.toLowerCase();
											for(int j = 0; j < u.agenda.size(); j++) {
												c = u.agenda.get(j);
												if(c.nome.toLowerCase().equals(nomeEdit)) {
													System.out.println(c);
												}
											}
										}
										if(cont == 0) {
											System.out.println("Não há cadastros com esse gênero!");
										}
									}
									break;
									
								case 7:  //Listar serviços/produtos consumidos de um cliente
									nomeEdit = "";
									System.out.println("Digite o nome do cliente: ");
									nomeEdit = controle.texto().toLowerCase();
									for(i = 0; i < u.agenda.size(); i++) {
										c = u.agenda.get(i);
										if(c.getNome().toLowerCase().equals(nomeEdit)) {
											System.out.println("Cliente: " + c.nome + "\nServiços: " + c.servicosCli);
										}
									}
									break;
									
								case 8: //Entrar no Menu de Relatórios
									do {
										Menu.mostrarRelatorio();
										escolha3 = controle.opcao();
										switch(escolha3) {
										case 1: //Idade média de todo o público de uma unidade
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
											
										case 2: //Idade média do público para um determinado gênero
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
										case 3: //Serviço mais procurado
											cont = 0;
											List<String> lista2 = new ArrayList<>();
											for(i = 0; i < u.agenda.size(); i++) {
												c = u.agenda.get(i);
												lista2.addAll(c.servicosCli);
											}
											Collections.sort(lista2);
											for(i = 0; i < lista2.size(); i++) {
												cont = Collections.frequency(lista2, lista2.get(i));
												System.out.println(lista2.get(i) + " - " + cont);
											}
											
											break;
											
										case 4: // Serviço mais procurado para um determinado gênero
											break;
											
										case 0: //Sair do Menu
											break;
											
										default: System.out.println("Opção inválida!");
										}
									}while(escolha3 != 0);
									break;
									
								case 0: //Sair do Menu
									break;
									
								default: System.out.println("Opção inválida!"); 
									}
								}while(escolha2 != 0);
						}
					}
				}
			case 0: //Sair do Menu
				break;
				
			default: System.out.println("Opção inválida!"); 				
			}			
		}while(escolha != 0);
	}
	
	//método para calcular idade:
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
