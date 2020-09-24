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
				System.out.println("Insira os serviços utilizados: ");
				c.servicos.add(controle.texto());
				cadastros.add(c);
				break;
				
			case 2:
				String nomeEdit;
				System.out.println("Digite o nome para edição: ");
				nomeEdit = controle.texto();
				String nomeFor = "";
				for(Cliente cli: cadastros) {
					nomeFor = cli.getNome();
					if(nomeFor.equals(nomeEdit)) {
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
				break;
			case 3:
				nomeEdit = "";
				System.out.println("Digite o nome para exclusão de cadastro: ");
				nomeEdit = controle.texto();
				for(int i=0; i < cadastros.size(); i++){
					c = cadastros.get(i);
					
					if(c.getNome().equals(nomeEdit)) {
						cadastros.remove(c);
						break;
					}
				}
				break;
			case 4:
				cadastros.forEach(pessoa -> System.out.println(pessoa));
				if(cadastros.isEmpty()) {
					System.out.println("Não há cadastros!");
				}
				break;
			case 5:
				String generoList;
				System.out.println("Digite o gênero (F/M): ");
				generoList = controle.texto();
				for(int i = 0; i < cadastros.size(); i++) {
					c = cadastros.get(i);
					if(c.getGenero().equals(generoList)) {
						System.out.println(c);
					}
				}
				break;
			case 6: 
				String nomeServ;
				System.out.println("Digite o nome do cliente: ");
				nomeServ = controle.texto();
				for(int i = 0; i < cadastros.size(); i++) {
					c = cadastros.get(i);
					if(c.getNome().equals(nomeServ)) {
						System.out.println("Cliente: " + c.nome + "\nServiços: " + c.servicos);
					}
				}
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
