import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FatorialTest {

	@Test
	void testeNormal() {		
		int fat = Fatorial.fatorial(5);
		assertEquals(120, fat);
	}

	@Test
	void testeNormal2() {		
		int fat = Fatorial.fatorial(2);
		assertEquals(2, fat);
	}

	@Test
	void testeNormal3() {		
		int fat = Fatorial.fatorial(8);
		assertEquals(40320, fat);
	}
	
	@Test
	void testeUm() {		
		int fat = Fatorial.fatorial(1);
		assertEquals(1, fat);
	}

	@Test
	void testeZero() {		
		int fat = Fatorial.fatorial(0);
		assertEquals(1, fat);
	}

	@Test
	void testeNegativo() {
		int fat = Fatorial.fatorial(-1);
		assertEquals(-1, fat);
	}

	@Test
	void testeNegativo2() {
		int fat = Fatorial.fatorial(-15235);
		assertEquals(-1, fat);
	}
	
	@Test
	void testeGigante() {		
		// Fatoriais acima de 12! não cabem em um inteiro
		int fat = Fatorial.fatorial(12);
		assertEquals(479001600, fat);
	}

	@Test
	void testeMaior() {
		// Retorna -1 para fatoriais maiores que um inteiro
		int fat = Fatorial.fatorial(13);
		assertEquals(-1, fat);
	}

	@Test
	void testeMaior2() {
		// Retorna -1 para fatoriais maiores que um inteiro
		int fat = Fatorial.fatorial(7535);
		assertEquals(-1, fat);
	}
}
