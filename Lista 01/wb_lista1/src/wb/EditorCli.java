package wb;

public class EditorCli {
	public Unidade u;

	public EditorCli(Unidade u) {
		this.u = u;
	}
	
	public void editarCliente() {
		Controle controle = new Controle();
		int escolhaEdit;
		String nomeEdit, resp;
		System.out.println("Digite o nome para edição: ");
		nomeEdit = controle.texto().toLowerCase();
		String nomeFor = "";
		for(Cliente cli: u.agenda) {
			nomeFor = cli.getNome().toLowerCase();
			if(nomeFor.equals(nomeEdit)) {
				System.out.println(cli);
				System.out.println("\nDeseja editar esse cliente? (S/N)");
				resp = controle.texto().toLowerCase();
				if(resp.equals("s")) {
					do {
						Menu.mostrarEdicao();
						escolhaEdit = controle.opcao();
						switch(escolhaEdit) {
						case 1: //Editar nome
							System.out.println("Digite o novo nome: ");
							cli.nome = controle.texto();
							//serial.salvar(unidades);
							break;
							
						case 2: //Editar telefone
							System.out.println("Digite o novo telefone: ");
							cli.telefone = controle.texto();
							//serial.salvar(unidades);
							break;
							
						case 3: //Editar data de nascimento
							System.out.println("Digite a nova data de nascimento (dd/mm/aaaa): ");
							cli.dataNasc = controle.texto();
							//serial.salvar(unidades);
							break;
							
						case 4: //Editar gênero
							System.out.println("Digite o novo gênero (F/M): ");
							cli.genero = controle.texto();
							//serial.salvar(unidades);
							break;
							
						case 0: break;
						
						default: System.out.println("Opção inválida!");
						}
					}while(escolhaEdit != 0);
				}
			}
		}
	}
	
}
