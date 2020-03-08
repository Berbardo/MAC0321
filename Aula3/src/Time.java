// Bernardo Rocha Coutinho - 11288235

public class Time {
	private String nome = "";
	int pontosGanhos = 0;
	int jogosDisputados = 0;
	int golsPro = 0;
	int saldoDeGols = 0;
	
	void gerarNome() {
		nome += (char) (Math.random() * 100 % 26 + 'A');
		
		for (int i = 0; i < Math.random() * 100 % 8 + 2; i++) {
			nome += (char) (Math.random() * 100 % 26 + 'a');			
		}
	}
	
	void contabilizarPartida(int golsPro, int golsContra) {
		jogosDisputados++;
		this.golsPro += golsPro;
		saldoDeGols += golsPro - golsContra;
		
		if (golsPro > golsContra) {
			pontosGanhos += 3;
		} else if (golsPro == golsContra) {
			pontosGanhos += 1;
		}
	}
	
	void imprimeTime() {
		System.out.println(nome + ": PG" + pontosGanhos + " J" + jogosDisputados + " GP" + golsPro + " SG" + saldoDeGols);
	}
}
