// Bernardo Rocha Coutinho - 11288235

public class Contabilizador {	
	
	static void contabilizarEstatisticas(Calendario calendario) {
		for(Partida partida: calendario.partidas) {
			partida.atualizarTimes();
		}
	}
	
	static void obterClassificacao(Time[] times) {
		Time timeVencedor;
		Time[] classificacao = times.clone();
		for (int quantidadeDeTimes = times.length; quantidadeDeTimes > 0; quantidadeDeTimes--) {
			timeVencedor = obterVencedor(classificacao);
			for (int indice = 0; indice < classificacao.length; indice++) {
				if (classificacao[indice] == timeVencedor) {
					classificacao = removerTime(classificacao, indice);
				}
			}
		}
	}
	
	static private Time obterVencedor(Time[] times) {
		Time timeVencedor = times[0];
		for (Time time: times) {
			if (time.pontosGanhos > timeVencedor.pontosGanhos) {
				timeVencedor = time;
			} else if (time.pontosGanhos == timeVencedor.pontosGanhos) {
				if (time.saldoDeGols > timeVencedor.saldoDeGols) {
					timeVencedor = time;
				} else if (time.saldoDeGols == timeVencedor.saldoDeGols) {
					if (time.golsPro > timeVencedor.golsPro) {
						timeVencedor = time;
					}
				}
			}
		}
		timeVencedor.imprimeTime();
		return timeVencedor;
	}
	
    static private Time[] removerTime(Time[] times, int indice){
    	Time[] timeFinal = new Time[times.length - 1];
        int timesSobrando = times.length - (indice + 1);
        System.arraycopy(times, 0, timeFinal, 0, indice);
        System.arraycopy(times, indice + 1, timeFinal, indice, timesSobrando);
        
        return timeFinal;
    }
}
