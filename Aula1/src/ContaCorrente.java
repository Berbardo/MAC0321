
public class ContaCorrente {
	Titular titular;
	
	public static void main(String args[]) {
		Endereco casaDeCasal = new Endereco(); 
		Endereco apartamento = new Endereco(); 
		
		casaDeCasal.gerarEndereco();
		apartamento.gerarEndereco();
		
		Titular fulana = new Titular();
		Titular ciclana = new Titular();
		Titular beltrana = new Titular();
		
		fulana.gerarCPF();
		fulana.gerarRG();
		ciclana.gerarCPF();
		ciclana.gerarRG();
		beltrana.gerarCPF();
		beltrana.gerarRG();
		
		fulana.endereco = casaDeCasal;
		beltrana.endereco = casaDeCasal;
		ciclana.endereco = apartamento;		
		
		ContaCorrente conta1 = new ContaCorrente();
		ContaCorrente conta2 = new ContaCorrente();
		ContaCorrente conta3 = new ContaCorrente();
		
		conta1.titular = fulana;
		conta2.titular = ciclana;
		conta3.titular = beltrana;
		
		conta1.imprimirConta();
		conta2.imprimirConta();
		conta3.imprimirConta();
	}
	
	void imprimirConta() {
		System.out.println("Conta:");
		System.out.println("RG: " + titular.rg);
		System.out.println("CPF: " + titular.cpf);
		titular.endereco.imprimeEndereco();
		System.out.println(" ");
	}
}