package wb;

import java.util.ArrayList;
import java.util.List;

public class Cadastrador {
	public Unidade u;
	
	public List<Unidade> unidades = new ArrayList<>();
	
	public Cadastrador(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public Cadastrador(Unidade u) {
		this.u = u;
	}
	
	public void cadastrarCliente() {
		Controle controle = new Controle();
		Cliente c = new Cliente();
		System.out.println("Insira o nome: ");
		c.nome = controle.texto();
		System.out.println("Insira o telefone: ");
		c.telefone = controle.texto();
		System.out.println("Insira a data de nascimento (dd/mm/aaaa): ");
		c.dataNasc = controle.texto();
		System.out.println("Insira o gênero (F/M): ");
		c.genero = controle.texto();
		u.agenda.add(c);
	}
	
	public void cadastrarUnidade() {
		Controle controle = new Controle();
		Unidade u = new Unidade();
		System.out.println("Digite o nome da unidade: ");
		u.nome = controle.texto().toLowerCase();
		unidades.add(u);
	}
	
}
