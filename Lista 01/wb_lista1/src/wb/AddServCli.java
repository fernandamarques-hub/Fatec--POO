package wb;

import java.util.Map;

public class AddServCli {
	public Unidade u;

	public AddServCli(Unidade u) {
		this.u = u;
	}
	
	public int cont1=0, cont2=0, cont3=0, cont4=0, cont5=0, cont6=0, cont7=0, cont8=0, cont9=0, cont10=0, cont11=0, cont12=0;
	
	public void addServico(Map <String, Integer> servico) {
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
						cont1++;
						System.out.println(cont1);
						servico.put("Manicure", cont1);
						break;
					case 2:
						cli.servicosCli.add("Pedicure");
						cont2++;
						servico.put("Pedicure", cont2);
						break;
					case 3:
						cli.servicosCli.add("Design de sobrancelhas");
						cont3++;
						servico.put("Design de sobrancelhas", cont3);
						break;
					case 4:
						cli.servicosCli.add("Corte de cabelo");
						cont4++;
						servico.put("Corte de cabelo", cont4);
						break;
					case 5:
						cli.servicosCli.add("Pintura de cabelo");
						cont5++;
						servico.put("Pintura de cabelo", cont5);
						break;
					case 6:
						cli.servicosCli.add("Remoção de rugas");
						cont6++;
						servico.put("Remoção de rugas", cont6);
						break;
					case 7:
						cli.servicosCli.add("Remoção de manchas na pele");
						cont7++;
						servico.put("Remoção de manchas na pele", cont7);
						break;
					case 8:
						cli.servicosCli.add("Aplicação de botox");
						cont8++;
						servico.put("Aplicação de botox", cont8);
						break;
					case 9:
						cli.servicosCli.add("Tratamento para emagrecimento e redução de medidas");
						cont9++;
						servico.put("Tratamento para emagrecimento e redução de medidas", cont9);
						break;
					case 10:
						cli.servicosCli.add("Modelagem e corte de barba");
						cont10++;
						servico.put("Modelagem e corte de barba", cont10);
						break;
					case 11:
						cli.servicosCli.add("Tratamento para queda de cabelo");
						cont11++;
						servico.put("Tratamento para queda de cabelo", cont11);
						break;
					case 12:
						cli.servicosCli.add("Produtos especializados");
						cont12++;
						servico.put("Produtos especializados", cont12);
						break;
					default: System.out.println("Opção inválida");
						break;
					}
				}
			}
		}
	}
}
