package org.fatec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Cliente implements Serializable{
	public String nome;
	public String telefone;
	public String dataNasc;
	public String genero;
	List<String> servicos = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getDataNasc() {
		return dataNasc;
	}
	
	@Override
	public String toString() {
		String delimitador = "-------------------------";
		String info = "Nome: " + nome + "\nTelefone: " + telefone + "\nData de Nascimento: " + dataNasc + "\nGênero: " + genero + "\nServiços utilizados: " + servicos;
		return "\n" + delimitador + "\n" + info + "\n" + delimitador;
	}
}
