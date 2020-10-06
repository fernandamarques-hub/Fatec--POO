package wb;

public class RemovedorCli {
	public Unidade u;

	public RemovedorCli(Unidade u) {
		super();
		this.u = u;
	}
	
	public void removercliente() {
		Controle controle = new Controle();
		String nomeEdit, resp;
		Cliente c = new Cliente();
		System.out.println("Digite o nome para exclusão de cadastro: ");
		nomeEdit = controle.texto().toLowerCase();
		for(int i=0; i < u.agenda.size(); i++){
			c = u.agenda.get(i);
			if(c.getNome().toLowerCase().equals(nomeEdit)) {
				System.out.println(c);
				System.out.println("\nDeseja excluir esse cliente? (S/N)");
				resp = controle.texto().toLowerCase();
				if(resp.equals("s")) {
					u.agenda.remove(c);
					break;
				}
				else {break;}
			}
		}
	}
}
