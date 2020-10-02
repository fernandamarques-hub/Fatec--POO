package wb;

import java.util.Collections;

public class ListarCli {
	public Unidade u;

	public ListarCli(Unidade u) {
		this.u = u;
	}
	
	public void listarCliente() {
		if(u.agenda.isEmpty()) {
			System.out.println("Não há cadastros!");
		}
		else {
			Collections.sort(u.agenda);
			for(int i = 0; i < u.agenda.size(); i++) {
				System.out.println(u.agenda.get(i));
			}
		}
	}
}
