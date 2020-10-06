package wb;

public class Servico {
	public String nome;

	public Servico(String nome) {
		this.nome = nome;
	}
	
	 @Override
	public String toString() {
		String info = this.nome;
		return info;
	}
}
