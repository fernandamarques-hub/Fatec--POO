package wb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Unidade implements Serializable{
	public String nome;
	public List<Cliente> agenda = new ArrayList<>();
	
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
