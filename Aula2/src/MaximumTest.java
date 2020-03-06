import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaximumTest {

	@Test
	void vetorConstante() {
		Maximum m = new Maximum();
		
		int[] v = {5, 5, 5, 5, 5, 5};
		assertEquals(5, m.max(v));
	}
	
	@Test
	void valorMaximoNegativo() {
		Maximum m = new Maximum();
		
		int[] v = {-5, -4, -3};
		assertEquals(-3, m.max(v));
	}
	
	@Test
	void vetorNormal() {
		Maximum m = new Maximum();
		
		int[] v = {1, 2, 3, 4, 5};
		assertEquals(5, m.max(v));
	}

	@Test
	void vetorVazio() {
		Maximum m = new Maximum();
		
		int[] v = {};
		assertEquals(0, m.max(v));
	}
	
	@Test
	void vetorUnitario() {
		Maximum m = new Maximum();
		
		int[] v = {1};
		assertEquals(1, m.max(v));
	}
}
