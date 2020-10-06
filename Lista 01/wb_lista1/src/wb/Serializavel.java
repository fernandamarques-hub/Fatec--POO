package wb;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializavel {
	
	String caminho = "C:\\Users\\Feh\\Documents\\ADS - Fatec\\3º semestre\\Programação Orientada à Objetos\\Lista 1 - POO\\unidades.ser";
	
//	List<Unidade> unidades = new ArrayList<>();
	
	
//	public Serializavel(List<Unidade> unidades) {
//		this.unidades = unidades;
//	}

	public void salvar(List<Unidade> unidades) throws Exception {
		FileOutputStream canal = new FileOutputStream(caminho);
		ObjectOutputStream escritor = new ObjectOutputStream(canal);
		escritor.writeObject(unidades);
		escritor.close();
		System.out.println("Cadastros salvos com sucesso!");
	}
	
	@SuppressWarnings("unchecked")
	public List<Unidade> carregar() throws Exception {
		FileInputStream canal = new FileInputStream(caminho);
		ObjectInputStream leitor = new ObjectInputStream(canal);
		List<Unidade> unidades = (List<Unidade>) leitor.readObject();
		leitor.close();
		System.out.println("Cadastros lidos com sucesso!");
		return unidades;
	}
}
