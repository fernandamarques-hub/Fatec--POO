package wb;

import java.util.Map;

public class Relatorios {
	public Unidade u;

	public Relatorios(Unidade u) {
		this.u = u;
	}
	
	public void escolherRelatorio(Map <String, Integer> servico, Map <String, Integer> servicoF, Map <String, Integer> servicoM) {
		Controle controle = new Controle();
		Cliente c = new Cliente();
		int escolha3;
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
					for(int i = 0; i < u.agenda.size(); i++) {
						c = u.agenda.get(i);
						int idade = CalculadorIdade.calcIdade(c.dataNasc);
						media += idade;
						//System.out.println(idade);
					}
					media = media / (u.agenda.size());
					System.out.println("A média de idade dessa unidade é: " + media);
				}
				break;
				
			case 2: //Idade média do público para um determinado gênero
				int cont = 0;
				String generoList = "";
				System.out.println("Digite o gênero (F/M): ");
				generoList = controle.texto().toLowerCase();
				media = 0;
				for(int i = 0; i < u.agenda.size(); i++) {
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
				String serv = "";
				int valor = Integer.MIN_VALUE;
				for(Map.Entry<String, Integer> par : servico.entrySet()) {
					if(valor < par.getValue()) {
						serv = par.getKey();
						valor = par.getValue();
					}
				}
				System.out.println("Servico: " + serv + " " + valor);
				break;
				
			case 4: // Serviço mais procurado para um determinado gênero
				generoList = "";
				System.out.println("Digite o gênero (F/M): ");
				generoList = controle.texto().toLowerCase();
				if(generoList.equals("f")) {
					serv = "";
					valor = Integer.MIN_VALUE;
					for(Map.Entry<String, Integer> par : servicoF.entrySet()) {
						if(valor < par.getValue()) {
							serv = par.getKey();
							valor = par.getValue();
						}
					}
					System.out.println("Servico: " + serv + " " + valor);
				}
				else {
					if(generoList.equals("m")) {
						serv = "";
						valor = Integer.MIN_VALUE;
						for(Map.Entry<String, Integer> par : servicoM.entrySet()) {
							if(valor < par.getValue()) {
								serv = par.getKey();
								valor = par.getValue();
							}
						}
						System.out.println("Servico: " + serv + " " + valor);
					}
				}
				break;
				
			case 0: //Sair do Menu
				break;
				
			default: System.out.println("Opção inválida!");
			}
		}while(escolha3 != 0);
	}
}
