
public class Titular {
	String cpf;
	String rg;
	Endereco endereco;
	
	void gerarCPF() {
		String cpfProvisorio = "";
		for (int i = 0; i < 14; i++) {
			if (i % 4 == 3) {
				if (i == 11) {
					cpfProvisorio += "-";
				}
				else {
					cpfProvisorio += ".";
				}
			}
			else {
				cpfProvisorio += (int) (Math.random() * 10);
			}
		}
		
		cpf = cpfProvisorio;
	}
	
	void gerarRG() {
		String rgProvisorio = "";
		for (int i = 0; i < 9; i++) {
			if (i % 4 == 1) {
				rgProvisorio += ".";
			}
			else {
				rgProvisorio += (int) (Math.random() * 10);
			}
		}
		
		rg = rgProvisorio;
	}
}
