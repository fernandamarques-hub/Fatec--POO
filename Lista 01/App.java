package org.fatec;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		// caminho onde vai salvar o cadastro de clientes
		String caminho = "D:\\Documentos\\ADS - Fatec\\3� semestre\\Programa��o Orientada � Objetos\\Lista 1 - POO";
		
		Controle controle = new Controle();
		
		List<Cliente> cadastros = new ArrayList<>();
		
		int escolha, escolhaEdit;
		
		do {
			Menu.mostrarMenu();
			escolha = controle.opcao();
			
			switch(escolha) {
			case 1:
				Cliente c = new Cliente();
				System.out.println("Insira o nome: ");
				c.nome = controle.texto();
				System.out.println("Insira o telefone: ");
				c.telefone = controle.texto();
				System.out.println("Insira a data de nascimento (dd/mm/aaaa): ");
				c.dataNasc = controle.texto();
				System.out.println("Insira o g�nero (F/M): ");
				c.genero = controle.texto();
				cadastros.add(c);
				break;
				
			case 2:
				String nomeEdit;
				System.out.println("Digite o nome para edi��o: ");
				nomeEdit = controle.texto();
				for(Cliente cli: cadastros) {
					if(cli.nome == nomeEdit) {
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
								System.out.println("Digite o novo g�nero (F/M): ");
								cli.genero = controle.texto();
								break;
							case 0: break;
							default: System.out.println("Op��o inv�lida!");
							}
						}while(escolhaEdit != 0);
					}
				}
				break;
			case 3:
				System.out.println("Excluir!");
				break;
			case 4:
				System.out.println("Listar!");
				break;
			case 5:
				System.out.println("Listar por g�nero!");
				break;
			case 6: 
				System.out.println("Listar servi�os");
				break;
			case 7: 
				System.out.println("Relat�rios!");
				break;
			case 0: 
				break;
			default: System.out.println("Op��o inv�lida!"); 
				}
			
			}while(escolha != 0);
	}

}
