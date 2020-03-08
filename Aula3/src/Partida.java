// Bernardo Rocha Coutinho - 11288235

public class Partida {
	private Time timeMandante;
	private Time timeVisitante;
	private boolean terminado = false;
	private int golsMandante;
	private int golsVisitante;
	
	Partida(Time timeMandante, Time timeVisitante) {
		this.timeMandante = timeMandante;
		this.timeVisitante = timeVisitante;
	}
	
	void jogarPartida() {
		if (terminado) {
			System.out.println("Partida já foi jogada");
			return;
		}
		
		double poderTimeMandante = 1.1;	
		double poderTimeVisitante = 0.9;
		
		if (timeMandante.jogosDisputados != 0) {
			poderTimeMandante *= timeMandante.golsPro/timeMandante.jogosDisputados;
		}
		
		if (timeVisitante.jogosDisputados != 0) {
			poderTimeVisitante *= timeVisitante.golsPro/timeVisitante.jogosDisputados;
		}
		
		golsMandante = (int) (Math.random() * 4.5 * poderTimeMandante);
		golsVisitante = (int) (Math.random() * 4.5 * poderTimeVisitante);
		
		terminado = true;
	}
	
	void jogarPartida(int golsMandante, int golsVisitante) {
		if (terminado) {
			System.out.println("Partida já foi jogada");
			return;
		}
		this.golsMandante = golsMandante;
		this.golsVisitante = golsVisitante;
		
		terminado = true;
	}
	
	void atualizarTimes() {
		if (terminado) {
			timeMandante.contabilizarPartida(golsMandante, golsVisitante);
			timeVisitante.contabilizarPartida(golsVisitante, golsMandante);	
		}
	}
	
	// Metodos para Teste
	
	int recebeGolsMandante() {
		return golsMandante;
	}
	
	int recebeGolsVisitante() {
		return golsVisitante;
	}
}
