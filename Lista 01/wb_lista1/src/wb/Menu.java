package wb;

public class Menu {
	public static void cadastroUnidade() {
		System.out.println("\n*************************");
		System.out.println("\nSelecione a opção desejada:");
		System.out.println("\n1. Cadastrar unidade.");
		System.out.println("\n2. Listar unidades.");
		System.out.println("\n3. Entrar na Agenda de uma unidade.");
		System.out.println("\n0. Sair");
		System.out.println("\n*************************");
	}

	public static void mostrarMenu() {
		System.out.println("\n*************************");
		System.out.println("\nSelecione a opção desejada:");
		System.out.println("\n1. Cadastrar cliente.");
		System.out.println("\n2. Editar cliente.");
		System.out.println("\n3. Excluir cliente.");
		System.out.println("\n4. Listar clientes.");
		System.out.println("\n5. Listar clientes por gênero.");
		System.out.println("\n6. Listar serviços/produtos consumidos de um cliente.");
		System.out.println("\n7. Relatórios.");
		System.out.println("\n0. Sair");
		System.out.println("\n*************************");
	}
	
	public static void mostrarRelatorio() {
		System.out.println("\n*************************");
		System.out.println("\nSelecione a opção desejada:");
		System.out.println("\n1. Idade média de todo o público de uma unidade.");
		System.out.println("\n2. Idade média do público para um determinado gênero.");
		System.out.println("\n3. Serviço mais procurado.");
		System.out.println("\n4. Serviço mais procurado para um determinado gênero.");
		System.out.println("\n0. Voltar");
		System.out.println("\n*************************");
	}
	
	public static void mostrarEdicao() {
		System.out.println("\n*************************");
		System.out.println("\nSelecione a opção desejada:");
		System.out.println("\n1. Editar nome.");
		System.out.println("\n2. Editar telefone.");
		System.out.println("\n3. Editar data de nascimento.");
		System.out.println("\n4. Editar gênero.");
		System.out.println("\n5. Adicionar serviços.");
		System.out.println("\n0. Sair");
		System.out.println("\n*************************");
	}

}
