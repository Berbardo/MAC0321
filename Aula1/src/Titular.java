
public class Titular {
	private String cpf;
	private String rg;
	private Endereco endereco;
	
	Titular(Endereco endereco) {
		this.gerarCPF();
		this.gerarRG();
		this.endereco = endereco;
	}
	
	private void gerarCPF() {
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
	
	private void gerarRG() {
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
	
	public void imprimirTitular() {
		System.out.println("RG: " + this.rg);
		System.out.println("CPF: " + this.cpf);
		this.endereco.imprimeEndereco();
	}
}
