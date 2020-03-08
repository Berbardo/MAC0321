// Bernardo Rocha Coutinho - 11288235

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CampeonatoTest {

	@Test
	void testeTimeVitoria() {
		System.out.println("Teste Time Vitoria:");
		Time time = new Time();
		time.gerarNome();
		
		// Testar Vitoria
		time.contabilizarPartida(3, 1);
		assertEquals(time.pontosGanhos, 3);
		assertEquals(time.golsPro, 3);
		assertEquals(time.saldoDeGols, 2);
		time.imprimeTime();
		System.out.println();
	}
	
	@Test
	void testeTimeEmpate() {
		System.out.println("Teste Time Empate:");
		Time time = new Time();
		time.gerarNome();
		
		// Testar Empate
		time.contabilizarPartida(3, 3);
		assertEquals(time.pontosGanhos, 1);
		assertEquals(time.golsPro, 3);
		assertEquals(time.saldoDeGols, 0);
		time.imprimeTime();
		System.out.println();
	}
	
	@Test
	void testeTimeDerrota() {
		System.out.println("Teste Time Derrota:");
		Time time = new Time();
		time.gerarNome();
		
		// Testar Derrota
		time.contabilizarPartida(1, 3);
		assertEquals(time.pontosGanhos, 0);
		assertEquals(time.golsPro, 1);
		assertEquals(time.saldoDeGols, -2);
		time.imprimeTime();
		System.out.println();
	}
	
	@Test
	void testeTimeCompleto() {
		System.out.println("Teste Time Completo:");
		Time time = new Time();
		time.gerarNome();
		
		// Testar Vitoria
		time.contabilizarPartida(1, 0);
		assertEquals(time.pontosGanhos, 3);
		assertEquals(time.golsPro, 1);
		assertEquals(time.saldoDeGols, 1);
		time.imprimeTime();
		
		// Testar Empate
		time.contabilizarPartida(1, 1);
		assertEquals(time.pontosGanhos, 4);
		assertEquals(time.golsPro, 2);
		assertEquals(time.saldoDeGols, 1);
		time.imprimeTime();
		
		// Testar Derrota
		time.contabilizarPartida(0, 1);
		assertEquals(time.pontosGanhos, 4);
		assertEquals(time.golsPro, 2);
		assertEquals(time.saldoDeGols, 0);
		time.imprimeTime();
		System.out.println();
	}
	
	@Test
	void testePartidaVitoria() {
		Time time1 = new Time();
		time1.gerarNome();
		Time time2 = new Time();
		time2.gerarNome();
		
		Partida partida1 = new Partida(time1, time2);
		partida1.jogarPartida(7, 1);
		partida1.atualizarTimes();
		assertEquals(time1.jogosDisputados, 1);
		assertEquals(time1.golsPro, 7);
		assertEquals(time1.saldoDeGols, 6);
		assertEquals(time2.jogosDisputados, 1);
		assertEquals(time2.golsPro, 1);
		assertEquals(time2.saldoDeGols, -6);
	}
	
	@Test
	void testePartidaEmpate() {
		Time time1 = new Time();
		time1.gerarNome();
		Time time2 = new Time();
		time2.gerarNome();
		
		Partida partida2 = new Partida(time1, time2);
		partida2.jogarPartida(4, 4);
		partida2.atualizarTimes();		
		assertEquals(time1.jogosDisputados, 1);
		assertEquals(time1.golsPro, 4);
		assertEquals(time1.saldoDeGols, 0);
		assertEquals(time2.jogosDisputados, 1);
		assertEquals(time2.golsPro, 4);
		assertEquals(time2.saldoDeGols, 0);
	}
	
	@Test
	void testePartidaDerrota() {
		Time time1 = new Time();
		time1.gerarNome();
		Time time2 = new Time();
		time2.gerarNome();
		
		Partida partida2 = new Partida(time1, time2);
		partida2.jogarPartida(3, 5);
		partida2.atualizarTimes();		
		assertEquals(time1.jogosDisputados, 1);
		assertEquals(time1.golsPro, 3);
		assertEquals(time1.saldoDeGols, -2);
		assertEquals(time2.jogosDisputados, 1);
		assertEquals(time2.golsPro, 5);
		assertEquals(time2.saldoDeGols, 2);
	}
	
	@Test
	void testePartidaAleatoria() {
		Time time1 = new Time();
		time1.gerarNome();
		int golsTime1 = 0;
		Time time2 = new Time();
		time2.gerarNome();
		int golsTime2 = 0;
		
		Partida partida1 = new Partida(time1, time2);
		partida1.jogarPartida();
		partida1.atualizarTimes();
		golsTime1 += partida1.recebeGolsMandante();
		golsTime2 += partida1.recebeGolsVisitante();
		assertEquals(time1.jogosDisputados, 1);
		assertEquals(time1.golsPro, golsTime1);
		assertEquals(time1.saldoDeGols, golsTime1 - golsTime2);
		assertEquals(time2.jogosDisputados, 1);
		assertEquals(time2.golsPro, golsTime2);
		assertEquals(time2.saldoDeGols, golsTime2 - golsTime1);
		
		Partida partida2 = new Partida(time2, time1);
		partida2.jogarPartida();
		partida2.atualizarTimes();		
		golsTime1 += partida2.recebeGolsVisitante();
		golsTime2 += partida2.recebeGolsMandante();
		assertEquals(time1.golsPro, golsTime1);
		assertEquals(time1.saldoDeGols, golsTime1 - golsTime2);
		assertEquals(time2.golsPro, golsTime2);
		assertEquals(time2.saldoDeGols, golsTime2 - golsTime1);
	}
	
	
	@Test
	void testeCalendarioJogos() {
		// Checa se todos os times jogaram a mesma quantidade de partidas
		Calendario calendario = new Calendario(10);
		for (Partida partida: calendario.partidas) {
			partida.jogarPartida();
			partida.atualizarTimes();
		}
		
		for (Time time: calendario.times) {
			assertEquals(time.jogosDisputados, 18);
		}
	}
	
	@Test
	void testeCalendarioDefinido() {
		System.out.println("Teste Calendario Definido:");
		Calendario calendario = new Calendario(4);
		int golsMandante[] = {1, 3, 5, 0, 1, 2, 0, 1, 0, 2, 1, 3};
		int golsVisitante[] = {0, 2, 1, 4, 0, 0, 2, 1, 2, 1, 1, 0};
		for (int numeroDeJogos = 0; numeroDeJogos < 12; numeroDeJogos++) {
			calendario.partidas[numeroDeJogos].jogarPartida(golsMandante[numeroDeJogos], golsVisitante[numeroDeJogos]);
			calendario.partidas[numeroDeJogos].atualizarTimes();
		}
		
		for (Time time: calendario.times) {
			time.imprimeTime();
		}
		assertEquals(calendario.times[0].jogosDisputados, 6);
		assertEquals(calendario.times[0].pontosGanhos, 15);
		assertEquals(calendario.times[0].golsPro, 16);
		assertEquals(calendario.times[0].saldoDeGols, 11);
		System.out.println();
	}
	
	@Test
	void testeContabilizadorUmaPartida() {
		System.out.println("Teste Contabilizador Uma Partida:");
		Calendario calendario = new Calendario(2);
		
		calendario.partidas[0].jogarPartida(4, 3);
		Contabilizador.contabilizarEstatisticas(calendario);
		Contabilizador.obterClassificacao(calendario);
		
		assertEquals(calendario.times[0].jogosDisputados, 1);
		assertEquals(calendario.times[0].pontosGanhos, 3);
		assertEquals(calendario.times[0].golsPro, 4);
		assertEquals(calendario.times[0].saldoDeGols, 1);
		assertEquals(calendario.times[1].jogosDisputados, 1);
		assertEquals(calendario.times[1].pontosGanhos, 0);
		assertEquals(calendario.times[1].golsPro, 3);
		assertEquals(calendario.times[1].saldoDeGols, -1);
		System.out.println();
	}
	
	@Test
	void testeCompleto() {
		System.out.println("Teste Completo (Brasileirão):");
		Calendario calendario = new Calendario(20);
		
		calendario.jogarCalendario();
		Contabilizador.contabilizarEstatisticas(calendario);
		Contabilizador.obterClassificacao(calendario);
		
		int saldoTotal = 0;
		for (Time time: calendario.times) {
			assertEquals(time.jogosDisputados, 38);
			saldoTotal += time.saldoDeGols;
		}
		
		// Checa se a soma de todos os saldos de gol é nula
		assertEquals(saldoTotal, 0);

		System.out.println();
	}
}
