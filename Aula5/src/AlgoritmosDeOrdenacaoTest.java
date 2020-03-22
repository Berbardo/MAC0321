import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;

class AlgoritmosDeOrdenacaoTest {
	
	ArrayList<Integer> listaInts;
	ArrayList<Float> listaFloats;
	ArrayList<Double> listaDoubles;
	
	ArrayList<Integer> gabaritoInts;
	ArrayList<Float> gabaritoFloats;
	ArrayList<Double> gabaritoDoubles;
	
    @BeforeEach
    void init() {
    	listaInts = CriadorDeListas.criaListaAleatoria(() -> (int) (Math.random() * 1000), 1000);
    	listaFloats = CriadorDeListas.criaListaAleatoria(() -> (float) (Math.random() * 1000), 1000);
    	listaDoubles = CriadorDeListas.criaListaAleatoria(() -> (double) (Math.random() * 1000), 1000);
    	
    	gabaritoInts = new ArrayList<>(listaInts);
    	Collections.sort(gabaritoInts);
    	gabaritoFloats = new ArrayList<>(listaFloats);
    	Collections.sort(gabaritoFloats);
    	gabaritoDoubles = new ArrayList<>(listaDoubles);
    	Collections.sort(gabaritoDoubles);
    	
    }

	@Test
	void mergeSortTest() {
		MergeSort mergeSort = new MergeSort();
		
		listaInts = mergeSort.ordena(listaInts);
		listaFloats = mergeSort.ordena(listaFloats);
		listaDoubles = mergeSort.ordena(listaDoubles);
		
		assertEquals(listaInts, gabaritoInts);
		assertEquals(listaFloats, gabaritoFloats);
		assertEquals(listaDoubles, gabaritoDoubles);
	}

}
