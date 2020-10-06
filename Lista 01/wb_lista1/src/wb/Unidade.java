package wb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Unidade implements Serializable{
	public String nome;
	public List<Cliente> agenda = new ArrayList<>();
	public Map <String, Integer> servico = new HashMap<>();
	public Map <String, Integer> servicoF = new HashMap<>();
	public Map <String, Integer> servicoM = new HashMap<>();

	public Unidade(Map<String, Integer> servico, Map<String, Integer> servicoF, Map<String, Integer> servicoM) {
		this.servico = servico;
		this.servicoF = servicoF;
		this.servicoM = servicoM;
	}

	public String getNome() {
		return nome;
	}
	
@Override
	public String toString() {
		String delimitador = "-------------------------";
		String info = "Unidade: " + nome;
		return "\n" + delimitador + "\n" + info + "\n" + delimitador;
	}
}
