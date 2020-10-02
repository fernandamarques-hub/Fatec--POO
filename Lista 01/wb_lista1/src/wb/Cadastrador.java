package wb;

public class Cadastrador {
	public Unidade u;

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
	
}
