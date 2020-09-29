package mecanica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable{
	public String nome;
	public String telefone;
	public String endereco;
	public String cpf;
	
	List<Veiculo> veiculos = new ArrayList<>();
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		String delimitador = "-------------------------";
		String info = "Nome: " + nome + "\nTelefone: " + telefone + "\nEndereço: " + endereco + "\nCPF: " + cpf;
		return "\n" + delimitador + "\n" + info + "\n" + delimitador + "\n";
	}
}


