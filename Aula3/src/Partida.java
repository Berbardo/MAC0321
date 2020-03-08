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
		golsMandante = (int) (Math.random() * 10);
		golsVisitante = (int) (Math.random() * 10);
		
		terminado = true;
	}
	
	void atualizarTimes() {
		timeMandante.contabilizarPartida(golsMandante, golsVisitante);
		timeVisitante.contabilizarPartida(golsVisitante, golsMandante);
	}
}
