package mecanica;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import mecanica.Cliente; //Importação das classes utilizadas
import mecanica.Controle;
import mecanica.Menu;

public class App {

	public static void main(String[] args)  throws Exception{
		
			String caminho = "D:\\Documentos\\Desktop\\Tarefas 3ADS\\lista1";//Caminho onde ficará salvo o arquivo de registro
		
		Controle controle = new Controle();//Criação de leitor de input através da classe Controle
		
		List<Cliente> cadastros = new ArrayList<>();
		
		String escolha;
		
		do {
			Menu.mostrarMenu();//Chamada da classe Menu
			escolha = controle.opcao();
			
			switch(escolha) {//Operações consequentes do Menu
			case "1"://Opção Cadastro de Cliente
				Cliente c = new Cliente();
				System.out.println("Insira o nome: ");
				c.nome = controle.texto();
				System.out.println("Insira o telefone: ");
				c.telefone = controle.texto();
				System.out.println("Insira o Endereço: ");
				c.endereco = controle.texto();
				System.out.println("Insira o CPF: ");
				c.cpf = controle.texto();
				cadastros.add(c);//Adicionando cliente ao cadastro
				System.out.println("Cadastro realizado com sucesso!!");
				Thread.sleep(2000);//Timer de 2 segundos
				
				break;
				
			case "2"://Opção Cadastro de Veículo
				String cpfOwn1;
				System.out.println("Insira o CPF do proprietário do veículo: ");
				cpfOwn1 = controle.texto();
				String cpfFor1 = "";
				for(Cliente cli: cadastros) {//Busca pelo CPF do cliente...
					cpfFor1 = cli.getCpf();
					if(cpfFor1.equals(cpfOwn1)) {
						Veiculo vei = new Veiculo();
						System.out.println("Insira a placa do veículo: ");
						vei.placa = controle.texto();
						System.out.println("Insira o modelo do veículo: ");
						vei.modelo = controle.texto();
						System.out.println("Insira o ano de fabricação do veículo: ");
						vei.anofabricacao = controle.texto();
						System.out.println("Insira o preço do veículo: ");
						vei.preco = controle.texto();
						cli.veiculos.add(vei);//Adicionando veículo ao cadastro
						System.out.println("Cadastro realizado com sucesso!!");
						Thread.sleep(2000);}}
				
				break;
				
			case "3"://Opção de Agendamento
				String cpfOwn2;
				String placaVei1;
				System.out.println("Insira o CPF do proprietário do veículo: ");
				cpfOwn2 = controle.texto();
				String cpfFor2 = "";
				String placaFor1 = "";
				for(Cliente cli: cadastros) {
					cpfFor2 = cli.getCpf();
					if(cpfFor2.equals(cpfOwn2)) {
						System.out.println("Insira a placa do veículo: ");
						placaVei1 = controle.texto();
						for(Veiculo vei: cli.veiculos) {//Busca pela placa do veículo...
							placaFor1 = vei.getPlaca();
							if(placaFor1.equals(placaVei1)) {
								Servico serv = new Servico();
								String a;
								System.out.println("Qual serviço deseja agendar?(m-manuntenção/r-revisão): ");
								a="";
								while(!a.equals("m")&&!a.equals("r")) {//Verificação de tipo de serviço válido
									a = controle.texto();
									if(!a.equals("m")&&!a.equals("r")) {
										System.out.println("**Escolha Inválida!!**");
										System.out.println("Qual serviço deseja agendar?(m-manuntenção/r-revisão): ");
									}
								}
								serv.tipo = a;
								System.out.println("Insira a data para agendamento: ");
								serv.data = controle.texto();
								System.out.println("Insira o horario para agendamento: ");
								serv.horario = controle.texto();
								vei.servicos.add(serv);//Adicionando serviço ao cadastro
								System.out.println("Agendamento realizado com sucesso!!");
								Thread.sleep(2000);
								}
							}
						}
					}
				
				break;
				
			case "4"://Alterar agendamento
				String tipofor1;
				String cpfOwn3;
				String placaVei2;
				System.out.println("Insira o CPF do proprietário do veículo: ");
				cpfOwn3 = controle.texto();
				String cpfFor3 = "";
				String placaFor2 = "";
				for(Cliente cli: cadastros) {
					cpfFor3 = cli.getCpf();
					if(cpfFor3.equals(cpfOwn3)) {
						System.out.println("Insira a placa do veículo: ");
						placaVei2 = controle.texto();
						for(Veiculo vei: cli.veiculos) {
							placaFor2 = vei.getPlaca();
							if(placaFor2.equals(placaVei2)) {
								String a;
								System.out.println("Qual serviço deseja reagendar?(m-manuntenção/r-revisão): ");
								a="";
								while(!a.equals("m")&&!a.equals("r")) {//Verificação de tipo de serviço válido
									a = controle.texto();
									if(!a.equals("m")&&!a.equals("r")) {
										System.out.println("**Escolha Inválida!!**");
										System.out.println("Qual serviço deseja reagendar?(m-manuntenção/r-revisão): ");
									}
								}
								for(Servico serv: vei.servicos) {//Busca pelo tipo do serviço
									tipofor1 = serv.getTipo();
									if(tipofor1.equals(a)) {
										System.out.println("Insira a nova data para agendamento: ");
										serv.data = controle.texto();
										System.out.println("Insira o novo horario para agendamento: ");
										serv.horario = controle.texto();
										System.out.println("Reagendamento realizado com sucesso!!");
										Thread.sleep(2000);										
									}
								}

								}
							}
						}
					}
				
				break;
				
			case "5"://Cancelar agendamento
				String tipofor2;
				String cpfOwn4;
				String placaVei3;
				System.out.println("Insira o CPF do proprietário do veículo: ");
				cpfOwn4 = controle.texto();
				String cpfFor4 = "";
				String placaFor3 = "";
				for(Cliente cli: cadastros) {
					cpfFor4 = cli.getCpf();
					if(cpfFor4.equals(cpfOwn4)) {
						System.out.println("Insira a placa do veículo: ");
						placaVei3 = controle.texto();
						for(Veiculo vei: cli.veiculos) {
							placaFor3 = vei.getPlaca();
							if(placaFor3.equals(placaVei3)) {
								String a;
								System.out.println("Qual serviço deseja cancelar?(m-manuntenção/r-revisão): ");
								a="";
								while(!a.equals("m")&&!a.equals("r")) {
									a = controle.texto();
									if(!a.equals("m")&&!a.equals("r")) {
										System.out.println("**Escolha Inválida!!**");
										System.out.println("Qual serviço deseja cancelar?(m-manuntenção/r-revisão): ");
									}
								}
								for(Servico serv: vei.servicos) {
									tipofor2 = serv.getTipo();
									if(tipofor2.equals(a)) {
										vei.servicos.remove(serv);//Remoção do serviço agendado
										System.out.println("Serviço cancelado com sucesso!!");
										Thread.sleep(2000);
										
										break;

									}
								}

								}
							}
						}
					}
				break;
			case "6"://Relatório de serviços
				String cpfOwn5;
				String placaVei4;
				System.out.println("Insira o CPF do proprietário do veículo: ");
				cpfOwn5 = controle.texto();
				String cpfFor5 = "";
				String placaFor4 = "";
				for(Cliente cli: cadastros) {
					cpfFor5 = cli.getCpf();
					if(cpfFor5.equals(cpfOwn5)) {
						System.out.println("Insira a placa do veículo: ");
						placaVei4 = controle.texto();
						for(Veiculo vei: cli.veiculos) {
							placaFor4 = vei.getPlaca();
							if(placaFor4.equals(placaVei4)) {
								for(Servico serv: vei.servicos) {//Exibição dos serviços agendados
									System.out.println("Tipo do serviço: "+serv.tipo);
									System.out.println("Data do serviço: "+serv.data);
									System.out.println("Horário do serviço: "+serv.horario);
								}

								}
							}
						}
					}
				break;
				
				case "0":
					
					break;
				default: System.out.println("Opção Inválida!"); //Mensagem de Erro
				}
			
			}while(!escolha.equals("0"));
		
		FileOutputStream canal = new FileOutputStream(caminho);
		ObjectOutputStream escritor = new ObjectOutputStream(canal);
		escritor.writeObject(cadastros);
		escritor.close();
		System.out.println("Cadastros salvos com sucesso!");
		
		
	}
		
	}


