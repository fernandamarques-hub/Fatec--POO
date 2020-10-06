package wb;

import java.util.Map;

public class AddServCli {
	public Unidade u;

	public AddServCli(Unidade u) {
		this.u = u;
	}
	
	public void addServico(Map <String, Integer> servico, Map <String, Integer> servicoF, Map <String, Integer> servicoM) {
		Controle controle = new Controle();
		ListarServico serv = new ListarServico();
		String nomeEdit, resp, nomeFor;
		int opcao;
		System.out.println("Digite o nome do cliente para inclusão do serviço: ");
		nomeEdit = controle.texto().toLowerCase();
		for(Cliente cli: u.agenda) {
			nomeFor = cli.getNome().toLowerCase();
			
			if(nomeFor.equals(nomeEdit)) {
				System.out.println(cli);
				
				if(cli.getGenero().toLowerCase().equals("f")) {
					System.out.println("\nDeseja adicionar serviço para esse cliente? (S/N)");
					resp = controle.texto().toLowerCase();
					if(resp.equals("s")) {
						serv.Run();
						serv.listServico();
						
						System.out.println("Digite o número referente ao serviço: ");
						opcao = controle.opcao();
						switch(opcao) {
						case 1:
							cli.servicosCli.add("Manicure");
							int cont1 = servico.get("Manicure");
							int cont111 = servicoF.get("Manicure");
							cont1++;
							cont111++;
							servico.put("Manicure", cont1);
							servicoF.put("Manicure", cont111);
							break;
						case 2:
							cli.servicosCli.add("Pedicure");
							int cont2 = servico.get("Pedicure");
							int cont22 = servicoF.get("Pedicure");
							cont2++;
							cont22++;
							servico.put("Pedicure", cont2);
							servicoF.put("Pedicure", cont22);
							break;
						case 3:
							cli.servicosCli.add("Design de sobrancelhas");
							int cont3 = servico.get("Design de sobrancelhas");
							cont3++;
							servico.put("Design de sobrancelhas", cont3);
							int cont33 = servicoF.get("Design de sobrancelhas");
							cont33++;
							servicoF.put("Design de sobrancelhas", cont33);
							break;
						case 4:
							cli.servicosCli.add("Corte de cabelo");
							int cont4 = servico.get("Corte de cabelo");
							cont4++;
							servico.put("Corte de cabelo", cont4);
							int cont44 = servicoF.get("Corte de cabelo");
							cont44++;
							servicoF.put("Corte de cabelo", cont44);
							break;
						case 5:
							cli.servicosCli.add("Pintura de cabelo");
							int cont5 = servico.get("Pintura de cabelo");
							cont5++;
							servico.put("Pintura de cabelo", cont5);
							int cont55 = servicoF.get("Pintura de cabelo");
							cont55++;
							servicoF.put("Pintura de cabelo", cont55);
							break;
						case 6:
							cli.servicosCli.add("Remoção de rugas");
							int cont6 = servico.get("Remoção de rugas");
							cont6++;
							servico.put("Remoção de rugas", cont6);
							int cont66 = servicoF.get("Remoção de rugas");
							cont66++;
							servicoF.put("Remoção de rugas", cont66);
							break;
						case 7:
							cli.servicosCli.add("Remoção de manchas na pele");
							int cont7 = servico.get("Remoção de manchas na pele");
							cont7++;
							servico.put("Remoção de manchas na pele", cont7);
							int cont77 = servicoF.get("Remoção de manchas na pele");
							cont77++;
							servicoF.put("Remoção de manchas na pele", cont77);
							break;
						case 8:
							cli.servicosCli.add("Aplicação de botox");
							int cont8 = servico.get("Aplicação de botox");
							cont8++;
							servico.put("Aplicação de botox", cont8);
							int cont88 = servicoF.get("Aplicação de botox");
							cont88++;
							servicoF.put("Aplicação de botox", cont88);
							break;
						case 9:
							cli.servicosCli.add("Tratamento para emagrecimento e redução de medidas");
							int cont9 = servico.get("Tratamento para emagrecimento e redução de medidas");
							cont9++;
							servico.put("Tratamento para emagrecimento e redução de medidas", cont9);
							int cont99 = servicoF.get("Tratamento para emagrecimento e redução de medidas");
							cont99++;
							servicoF.put("Tratamento para emagrecimento e redução de medidas", cont99);
							break;
						case 10:
							cli.servicosCli.add("Modelagem e corte de barba");
							int cont10 = servico.get("Modelagem e corte de barba");
							cont10++;
							servico.put("Modelagem e corte de barba", cont10);
							int cont101 = servicoF.get("Modelagem e corte de barba");
							cont101++;
							servicoF.put("Modelagem e corte de barba", cont101);
							break;
						case 11:
							cli.servicosCli.add("Tratamento para queda de cabelo");
							int cont11 = servico.get("Tratamento para queda de cabelo");
							cont11++;
							servico.put("Tratamento para queda de cabelo", cont11);
							int cont112 = servicoF.get("Tratamento para queda de cabelo");
							cont112++;
							servicoF.put("Tratamento para queda de cabelo", cont112);
							break;
						case 12:
							cli.servicosCli.add("Produtos especializados");
							int cont12 = servico.get("Produtos especializados");
							cont12++;
							servico.put("Produtos especializados", cont12);
							int cont122 = servicoF.get("Produtos especializados");
							cont122++;
							servicoF.put("Produtos especializados", cont122);
							break;
						default: System.out.println("Opção inválida");
							break;
						}
					}
				}
				else {
					if(cli.getGenero().toLowerCase().equals("m")) {
						System.out.println("\nDeseja adicionar serviço para esse cliente? (S/N)");
						resp = controle.texto().toLowerCase();
						if(resp.equals("s")) {
							serv.Run();
							serv.listServico();
							
							System.out.println("Digite o número referente ao serviço: ");
							opcao = controle.opcao();
							switch(opcao) {
							case 1:
								cli.servicosCli.add("Manicure");
								int cont1 = servico.get("Manicure");
								int cont111 = servicoM.get("Manicure");
								cont1++;
								cont111++;
								servico.put("Manicure", cont1);
								servicoM.put("Manicure", cont111);
								break;
							case 2:
								cli.servicosCli.add("Pedicure");
								int cont2 = servico.get("Pedicure");
								int cont22 = servicoM.get("Pedicure");
								cont2++;
								cont22++;
								servico.put("Pedicure", cont2);
								servicoM.put("Pedicure", cont22);
								break;
							case 3:
								cli.servicosCli.add("Design de sobrancelhas");
								int cont3 = servico.get("Design de sobrancelhas");
								cont3++;
								servico.put("Design de sobrancelhas", cont3);
								int cont33 = servicoM.get("Design de sobrancelhas");
								cont33++;
								servicoM.put("Design de sobrancelhas", cont33);
								break;
							case 4:
								cli.servicosCli.add("Corte de cabelo");
								int cont4 = servico.get("Corte de cabelo");
								cont4++;
								servico.put("Corte de cabelo", cont4);
								int cont44 = servicoM.get("Corte de cabelo");
								cont44++;
								servicoM.put("Corte de cabelo", cont44);
								break;
							case 5:
								cli.servicosCli.add("Pintura de cabelo");
								int cont5 = servico.get("Pintura de cabelo");
								cont5++;
								servico.put("Pintura de cabelo", cont5);
								int cont55 = servicoM.get("Pintura de cabelo");
								cont55++;
								servicoM.put("Pintura de cabelo", cont55);
								break;
							case 6:
								cli.servicosCli.add("Remoção de rugas");
								int cont6 = servico.get("Remoção de rugas");
								cont6++;
								servico.put("Remoção de rugas", cont6);
								int cont66 = servicoM.get("Remoção de rugas");
								cont66++;
								servicoM.put("Remoção de rugas", cont66);
								break;
							case 7:
								cli.servicosCli.add("Remoção de manchas na pele");
								int cont7 = servico.get("Remoção de manchas na pele");
								cont7++;
								servico.put("Remoção de manchas na pele", cont7);
								int cont77 = servicoM.get("Remoção de manchas na pele");
								cont77++;
								servicoM.put("Remoção de manchas na pele", cont77);
								break;
							case 8:
								cli.servicosCli.add("Aplicação de botox");
								int cont8 = servico.get("Aplicação de botox");
								cont8++;
								servico.put("Aplicação de botox", cont8);
								int cont88 = servicoM.get("Aplicação de botox");
								cont88++;
								servicoM.put("Aplicação de botox", cont88);
								break;
							case 9:
								cli.servicosCli.add("Tratamento para emagrecimento e redução de medidas");
								int cont9 = servico.get("Tratamento para emagrecimento e redução de medidas");
								cont9++;
								servico.put("Tratamento para emagrecimento e redução de medidas", cont9);
								int cont99 = servicoM.get("Tratamento para emagrecimento e redução de medidas");
								cont99++;
								servicoM.put("Tratamento para emagrecimento e redução de medidas", cont99);
								break;
							case 10:
								cli.servicosCli.add("Modelagem e corte de barba");
								int cont10 = servico.get("Modelagem e corte de barba");
								cont10++;
								servico.put("Modelagem e corte de barba", cont10);
								int cont101 = servicoM.get("Modelagem e corte de barba");
								cont101++;
								servicoM.put("Modelagem e corte de barba", cont101);
								break;
							case 11:
								cli.servicosCli.add("Tratamento para queda de cabelo");
								int cont11 = servico.get("Tratamento para queda de cabelo");
								cont11++;
								servico.put("Tratamento para queda de cabelo", cont11);
								int cont112 = servicoM.get("Tratamento para queda de cabelo");
								cont112++;
								servicoM.put("Tratamento para queda de cabelo", cont112);
								break;
							case 12:
								cli.servicosCli.add("Produtos especializados");
								int cont12 = servico.get("Produtos especializados");
								cont12++;
								servico.put("Produtos especializados", cont12);
								int cont122 = servicoM.get("Produtos especializados");
								cont122++;
								servicoM.put("Produtos especializados", cont122);
								break;
							default: System.out.println("Opção inválida");
								break;
							}
						}
					}
				}
			}
		}
	}
}
