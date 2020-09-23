package org.fatec;

public class Cliente {
	public String nome;
	public String telefone;
	public String dataNasc;
	public String genero;
	
	@Override
	public String toString() {
		String delimitador = "-------------------------";
		String info = "Nome: " + nome + "\nTelefone: " + telefone + "\nData de Nascimento: " + dataNasc + "\nGênero: " + genero;
		return "\n" + delimitador + "\n" + info + "\n" + delimitador + "\n";
	}
}
