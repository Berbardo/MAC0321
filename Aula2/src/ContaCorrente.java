
public class ContaCorrente {
	private Titular[] titulares;
	
	ContaCorrente(Titular[] titular) {
		this.titulares = titular;
	}
	
	ContaCorrente(Titular titular) {
		Titular[] titular_placeholder = {titular};
		this.titulares = titular_placeholder;
	}
	
	public static void main(String args[]) {
		Endereco casaDeCasal = new Endereco(); 
		Endereco apartamentoSolteiro = new Endereco();
		
		Titular fulana = new Titular(casaDeCasal);
		Titular ciclana = new Titular(apartamentoSolteiro);
		Titular beltrana = new Titular(casaDeCasal);
		
		Titular[] casal_titular = {fulana, beltrana};
		
		ContaCorrente conta_conjunta = new ContaCorrente(casal_titular);
		ContaCorrente conta_única1 = new ContaCorrente(fulana);
		ContaCorrente conta_única2 = new ContaCorrente(ciclana);
		
		conta_conjunta.imprimirConta();
		conta_única1.imprimirConta();
		conta_única2.imprimirConta();
	}
	
	public void imprimirConta() {
		System.out.println("Conta:");
		int i = 1;
		for (Titular titular: titulares) {
			System.out.println("Titular " + i + ": ");
			i++;
			titular.imprimirTitular();
		}

		System.out.println(" ");
	}
}