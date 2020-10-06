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
		Controle controle = new Controle();
		Cliente c = new Cliente();
		int cont = 0;
		List<Cliente> lista = new ArrayList<>();
		String generoList = "";
		if(u.agenda.isEmpty()) {
			System.out.println("Não há cadastros!");
		}
		else {
			Collections.sort(u.agenda);
			System.out.println("Digite o gênero (F/M): ");
			generoList = controle.texto().toLowerCase();
			for(int i = 0; i < u.agenda.size(); i++) {
				c = u.agenda.get(i);
				if(c.genero.toLowerCase().equals(generoList)) {
					lista.add(c);
					System.out.println(c.nome);
					cont++;
				}
			}
			for(int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i));
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
