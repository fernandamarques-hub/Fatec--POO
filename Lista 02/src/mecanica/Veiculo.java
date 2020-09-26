package mecanica;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
	public String placa;
	public String modelo;
	public String anofabricacao;
	public String preco;
	List <Servico> servicos = new ArrayList<>();
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnofabricacao() {
		return anofabricacao;
	}
	public void setAnofabricacao(String anofabricacao) {
		this.anofabricacao = anofabricacao;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	

}
