package wb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		
		String caminho = "C:\\Users\\Feh\\Documents\\ADS - Fatec\\3� semestre\\Programa��o Orientada � Objetos\\Lista 1 - POO\\unidades.ser";
				
		// iniciando o controle para receber as informa��es pelo teclado
		Controle controle = new Controle();
		
		// Lista para armazenar todas as unidades (lojas)
		List<Unidade> unidades = new ArrayList<>();
		
		//Criando vari�veis do tipo Serializavel para chamar dentro dos menus
		Serializavel serial = new Serializavel();
		
		//vari�veis de controle para sair dos menus
		int escolha, escolha2;
		String loja, resp;
		
		
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
					System.out.println("N�o h� unidades cadastradas!");
				}
				break;
				
			case 3: //Entrar na Agenda de uma unidade
				System.out.println("Digite o nome da unidade, para visualizar agenda:");
				loja = controle.texto().toLowerCase();
				Unidade u = new Unidade();
				for(int i = 0; i < unidades.size(); i++) {
					u = unidades.get(i);

					if(u.getNome().toLowerCase().equals(loja)) {
						System.out.println("Essa � a unidade " + u.nome + " ?, digite S ou N:");
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
									
								case 4: //Adicionar servi�o � um cliente
									AddServCli adicionar = new AddServCli(u);
									adicionar.addServico(u.servico);
									serial.salvar(unidades);
									break;
									
								case 5: //Listar clientes
									ListarCli list = new ListarCli(u);
									list.listarCliente();
									break;
									
								case 6: //Listar clientes por g�nero
									ListarCli list2 = new ListarCli(u);
									list2.listarPorGenero();
									break;
									
								case 7:  //Listar servi�os/produtos consumidos de um cliente
									ListarCli list3 = new ListarCli(u);
									list3.listarServ();
									break;
									
								case 8: //Entrar no Menu de Relat�rios
									Relatorios relat = new Relatorios(u);
									relat.escolherRelatorio(u.servico);
									break;
									
								case 0: //Sair do Menu
									break;
									
								default: System.out.println("Op��o inv�lida!"); 
									}
								}while(escolha2 != 0);
						}
					}
				}
			case 0: //Sair do Menu
				break;
				
			default: System.out.println("Op��o inv�lida!"); 				
			}			
		}while(escolha != 0);
	}
}
