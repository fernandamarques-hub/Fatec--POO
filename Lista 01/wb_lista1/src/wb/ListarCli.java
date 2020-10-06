package wb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListarCli {
	public Unidade u;

	public ListarCli(Unidade u) {
		this.u = u;
	}
	
	public void listarCliente() {
		if(u.agenda.isEmpty()) {
			System.out.println("Não há cadastros!");
		}
		else {
			Collections.sort(u.agenda);
			for(int i = 0; i < u.agenda.size(); i++) {
				System.out.println(u.agenda.get(i));
			}
		}
	}
	
	public void listarPorGenero() {
		String nomeEdit;
		Controle controle = new Controle();
		Cliente c = new Cliente();
		int cont = 0;
		List <String> lista3 = new ArrayList<String>();
		String generoList;
		if(u.agenda.isEmpty()) {
			System.out.println("Não há cadastros!");
		}
		else {
			System.out.println("Digite o gênero (F/M): ");
			generoList = controle.texto().toLowerCase();
			for(int i = 0; i < u.agenda.size(); i++) {
				c = u.agenda.get(i);
				if(c.getGenero().toLowerCase().equals(generoList)) {
					lista3.add(c.nome);
					cont++;
				}
			}
			Collections.sort(lista3);
			nomeEdit = "";
			for(int i = 0; i < lista3.size(); i++) {
				nomeEdit = lista3.get(i);
				nomeEdit.toLowerCase();
				for(int j = 0; j < u.agenda.size(); j++) {
					c = u.agenda.get(j);
					if(c.nome.toLowerCase().equals(nomeEdit)) {
						System.out.println(c);
					}
				}
			}
			if(cont == 0) {
				System.out.println("Não há cadastros com esse gênero!");
			}
		}
	}
	
	public void listarServ() {
		Controle controle = new Controle();
		Cliente c = new Cliente();
		String nomeEdit;
		System.out.println("Digite o nome do cliente: ");
		nomeEdit = controle.texto().toLowerCase();
		for(int i = 0; i < u.agenda.size(); i++) {
			c = u.agenda.get(i);
			if(c.getNome().toLowerCase().equals(nomeEdit)) {
				System.out.println("Cliente: " + c.nome + "\nServiços: " + c.servicosCli);
			}
		}
	}
}
