package org.fatec;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		// caminho onde vai salvar o cadastro de clientes
		String caminho = "D:\\Documentos\\ADS - Fatec\\3º semestre\\Programação Orientada à Objetos\\Lista 1 - POO\\clientes.docx";
		
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
				System.out.println("Insira o gênero (F/M): ");
				c.genero = controle.texto();
				cadastros.add(c);
				break;
				
			case 2:
				String nomeEdit;
				System.out.println("Digite o nome para edição: ");
				nomeEdit = controle.texto();
				//Cliente cli = new Cliente();
				for(Cliente cli: cadastros) {
					System.out.println("entrou no for");
					if(cli.nome == nomeEdit) {
						System.out.println("Entrou no IF");
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
							case 0: break;
							default: System.out.println("Opção inválida!");
							}
						}while(escolhaEdit != 0);
					}
				}
				break;
			case 3:
				System.out.println("Excluir!");
				break;
			case 4:
				cadastros.forEach(pessoa -> System.out.println(pessoa));
				if(cadastros.isEmpty()) {
					System.out.println("Não há cadastros!");
				}
				break;
			case 5:
				System.out.println("Listar por gênero!");
				break;
			case 6: 
				System.out.println("Listar serviços");
				break;
			case 7: 
				System.out.println("Relatórios!");
				break;
			case 0: 
				break;
			default: System.out.println("Opção inválida!"); 
				}
			
			}while(escolha != 0);
		
		FileOutputStream canal = new FileOutputStream(caminho);
		ObjectOutputStream escritor = new ObjectOutputStream(canal);
		escritor.writeObject(cadastros);
		escritor.close();
		System.out.println("Cadastros salvos com sucesso!");
		
		
	}
}
