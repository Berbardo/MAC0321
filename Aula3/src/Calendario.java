// Bernardo Rocha Coutinho - 11288235

public class Calendario {
	Time[] times;
	Partida[] partidas;
		
	Calendario(int numeroDeTimes) {
		this.criarTimes(numeroDeTimes);
		this.criarPartidas();
	}
	
	void jogarCalendario() {
		for(Partida partida: partidas) {
			partida.jogarPartida();
		}
	}
	
	private void criarTimes(int numeroDeTimes) {	
		times = new Time[numeroDeTimes];
		for (int i = 0; i < numeroDeTimes; i++) {
			times[i] = new Time();
			times[i].gerarNome();
		}
	}
	
	private void criarPartidas() {	
		int numeroDePartidas = times.length * (times.length - 1);
		partidas = new Partida[numeroDePartidas];
		int numeroPartida = 0;
		for (Time timeMandante: times) {
			for (Time timeVisitante: times) {
				if (timeMandante != timeVisitante) {
					partidas[numeroPartida] = new Partida(timeMandante, timeVisitante);
					numeroPartida++;					
				}
			}
		}
	}
	
	// Simulacao Brasileirao
	public static void main(String args[]) {
		Calendario calendario = new Calendario(20);
		calendario.jogarCalendario();
		Contabilizador.contabilizarEstatisticas(calendario);
		Contabilizador.obterClassificacao(calendario);
	}
}
