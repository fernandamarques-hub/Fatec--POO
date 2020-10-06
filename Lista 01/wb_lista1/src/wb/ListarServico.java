package wb;

import java.util.ArrayList;
import java.util.List;

public class ListarServico {
	List<Servico> servicos = new ArrayList<>();
	
	public ListarServico() {
		
	}
	public void Run() {
		this.servicos.add(new Servico("[1] - Manicure"));		
		this.servicos.add(new Servico("[2] - Pedicure"));
		this.servicos.add(new Servico("[3] - Design de sobrancelhas"));
		this.servicos.add(new Servico("[4] - Corte de cabelo"));
		this.servicos.add(new Servico("[5] - Pintura de cabelo"));
		this.servicos.add(new Servico("[6] - Remoção de rugas"));
		this.servicos.add(new Servico("[7] - Remoção de manchas na pele"));
		this.servicos.add(new Servico("[8] - Aplicação de botox"));
		this.servicos.add(new Servico("[9] - Tratamento para emagrecimento e redução de medidas"));	
		this.servicos.add(new Servico("[10] - Modelagem e corte de barba"));
		this.servicos.add(new Servico("[11] - Tratamento para queda de cabelo"));
		this.servicos.add(new Servico("[12] - Produtos especializados"));	
	}
	
	public void listServico() {
		this.servicos.forEach(service -> System.out.println(service));
	}

}
