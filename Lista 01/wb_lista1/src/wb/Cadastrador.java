package wb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map <String, Integer> servico = new HashMap<>();
		servico.put("Manicure", 0);
		servico.put("Pedicure", 0);
		servico.put("Design de sobrancelhas", 0);
		servico.put("Corte de cabelo", 0);
		servico.put("Pintura de cabelo", 0);
		servico.put("Remoção de rugas", 0);
		servico.put("Remoção de manchas na pele", 0);
		servico.put("Aplicação de botox", 0);
		servico.put("Tratamento para emagrecimento e redução de medidas", 0);
		servico.put("Modelagem e corte de barba", 0);
		servico.put("Tratamento para queda de cabelo", 0);
		servico.put("Produtos especializados", 0);
		
		Map <String, Integer> servicoF = new HashMap<>();
		servicoF.put("Manicure", 0);
		servicoF.put("Pedicure", 0);
		servicoF.put("Design de sobrancelhas", 0);
		servicoF.put("Corte de cabelo", 0);
		servicoF.put("Pintura de cabelo", 0);
		servicoF.put("Remoção de rugas", 0);
		servicoF.put("Remoção de manchas na pele", 0);
		servicoF.put("Aplicação de botox", 0);
		servicoF.put("Tratamento para emagrecimento e redução de medidas", 0);
		servicoF.put("Modelagem e corte de barba", 0);
		servicoF.put("Tratamento para queda de cabelo", 0);
		servicoF.put("Produtos especializados", 0);
		
		Map <String, Integer> servicoM = new HashMap<>();
		servicoM.put("Manicure", 0);
		servicoM.put("Pedicure", 0);
		servicoM.put("Design de sobrancelhas", 0);
		servicoM.put("Corte de cabelo", 0);
		servicoM.put("Pintura de cabelo", 0);
		servicoM.put("Remoção de rugas", 0);
		servicoM.put("Remoção de manchas na pele", 0);
		servicoM.put("Aplicação de botox", 0);
		servicoM.put("Tratamento para emagrecimento e redução de medidas", 0);
		servicoM.put("Modelagem e corte de barba", 0);
		servicoM.put("Tratamento para queda de cabelo", 0);
		servicoM.put("Produtos especializados", 0);
		
		Unidade u = new Unidade(servico, servicoF, servicoM);
		System.out.println("Digite o nome da unidade: ");
		u.nome = controle.texto().toLowerCase();
		u.servico.put("Manicure", 0);
		unidades.add(u);
	}
	
}
