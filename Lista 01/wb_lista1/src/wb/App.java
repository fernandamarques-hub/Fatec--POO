package wb;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		
		String caminho = "C:\\Users\\Feh\\Documents\\ADS - Fatec\\3º semestre\\Programação Orientada à Objetos\\Lista 1 - POO\\unidades.ser";
				
		// iniciando o controle para receber as informações pelo teclado
		Controle controle = new Controle();
		
		//Criando um objeto Cliente c para usar dentro do código
		Cliente c = new Cliente();
		
		// Lista para armazenar todas as unidades (lojas)
		List<Unidade> unidades = new ArrayList<>();
		
		//Criando variáveis do tipo Serializavel para chamar dentro dos menus
		Serializavel serial = new Serializavel();
		
		//variáveis de controle para sair dos menus
		int escolha, escolha2, escolha3;
		String loja, resp, nomeEdit;
		
		
		do {
			File f = new File(caminho);
			if(f.exists()) {
				unidades = serial.carregar();
			}
			
			Menu.cadastroUnidade();
			escolha = controle.opcao();
			
			switch(escolha) {
			case 1: //cadastrar Unidade
				Cadastrador cad = new Cadastrador(unidades);
				cad.cadastrarUnidade();
				serial.salvar(unidades);
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
				Unidade u = new Unidade();
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
									Cadastrador cad1 = new Cadastrador(u);
									cad1.cadastrarCliente();
									serial.salvar(unidades);
									break;
									
								case 2: //Editar cadastro de cliente
									EditorCli edit = new EditorCli(u);
									edit.editarCliente();
									serial.salvar(unidades);
									break;
									
								case 3: //Remover cadastro de um cliente
									RemovedorCli remove = new RemovedorCli(u);
									remove.removercliente();
									serial.salvar(unidades);
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
											serial.salvar(unidades);
										}	
									}
									break;
									
								case 5: //Listar clientes
									ListarCli list = new ListarCli(u);
									list.listarCliente();
									break;
									
								case 6: //Listar clientes por gênero
									ListarCli list2 = new ListarCli(u);
									list2.listarPorGenero();
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
													int idade = CalculadorIdade.calcIdade(c.dataNasc);
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
													int idade = CalculadorIdade.calcIdade(c.dataNasc);
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
}
