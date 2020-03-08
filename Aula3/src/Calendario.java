// Bernardo Rocha Coutinho - 11288235

public class Calendario {
	Partida[] partidas;
	int partidasJogadas = 0;
		
	Calendario(Time[] times) {
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
	
	private void jogarCalendario() {
		for(Partida partida: partidas) {
			partida.jogarPartida();
		}
	}
	
	public static void main(String args[]) {
		Time[] times = criarTimes(10);
		Calendario calendario = new Calendario(times);
		calendario.jogarCalendario();
		Contabilizador.contabilizarEstatisticas(calendario);
		Contabilizador.obterClassificacao(times);
	}
	
	static private Time[] criarTimes(int numeroDeTimes) {	
		Time[] times = new Time[numeroDeTimes];
		for (int i = 0; i < numeroDeTimes; i++) {
			times[i] = new Time();
			times[i].gerarNome();
		}
		
		return times;
	}

}
