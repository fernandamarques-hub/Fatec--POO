package wb;

import java.util.Map;

public class Relatorios {
	public Unidade u;

	public Relatorios(Unidade u) {
		this.u = u;
	}
	
	public void escolherRelatorio(Map <String, Integer> servico) {
		Controle controle = new Controle();
		Cliente c = new Cliente();
		int escolha3;
		do {
			Menu.mostrarRelatorio();
			escolha3 = controle.opcao();
			switch(escolha3) {
			case 1: //Idade m�dia de todo o p�blico de uma unidade
				int media = 0;
				if(u.agenda.isEmpty()) {
					System.out.println("N�o h� cadastros!");
				}
				else {
					for(int i = 0; i < u.agenda.size(); i++) {
						c = u.agenda.get(i);
						int idade = CalculadorIdade.calcIdade(c.dataNasc);
						media += idade;
						System.out.println(idade);
					}
					media = media / (u.agenda.size());
					System.out.println("A m�dia de idade dessa unidade �: " + media);
				}
				break;
				
			case 2: //Idade m�dia do p�blico para um determinado g�nero
				int cont = 0;
				String generoList = "";
				System.out.println("Digite o g�nero (F/M): ");
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
					System.out.println("N�o h� cadastros desse g�nero!");
				}
				else {
					media = media / cont;
					System.out.println("A m�dia de idade do g�nero " + generoList + " �: " + media);
				}
				break;
			case 3: //Servi�o mais procurado
				for(Map.Entry<String, Integer> par : servico.entrySet()) {
					System.out.println(par.getKey());
					System.out.println(par.getValue());
				}
				break;
				
			case 4: // Servi�o mais procurado para um determinado g�nero
				break;
				
			case 0: //Sair do Menu
				break;
				
			default: System.out.println("Op��o inv�lida!");
			}
		}while(escolha3 != 0);
	}
}
