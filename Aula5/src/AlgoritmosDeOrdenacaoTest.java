import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;

class AlgoritmosDeOrdenacaoTest {
	
	ArrayList<Integer> listaInts;
	ArrayList<Float> listaFloats;
	ArrayList<Double> listaDoubles;
	ArrayList<Double> listaPequena;
	ArrayList<Double> listaSemiOrdenada;
	
	ArrayList<Integer> gabaritoInts;
	ArrayList<Float> gabaritoFloats;
	ArrayList<Double> gabaritoDoubles;
	ArrayList<Double> gabaritoPequena;
	ArrayList<Double> gabaritoSemiOrdenada;
	
	BubbleSort bubbleSort = new BubbleSort();
	HeapSort heapSort = new HeapSort();
	InsertionSort insertionSort = new InsertionSort();
	QuickSort quickSort = new QuickSort();
	
    @BeforeEach
    void init() {
    	listaInts = CriadorDeListas.criaListaAleatoria(() -> (int) (Math.random() * 1000), 1000);
    	listaFloats = CriadorDeListas.criaListaAleatoria(() -> (float) (Math.random() * 1000), 1000);
    	listaDoubles = CriadorDeListas.criaListaAleatoria(() -> (double) (Math.random() * 1000), 1000);
    	listaPequena = CriadorDeListas.criaListaAleatoria(() -> (double) (Math.random() * 1000), 5);
    	listaSemiOrdenada = CriadorDeListas.criaListaSemiOrdenada(() -> (double) (Math.random() * 1000), 1000);
    	
    	gabaritoInts = new ArrayList<>(listaInts);
    	Collections.sort(gabaritoInts);
    	gabaritoFloats = new ArrayList<>(listaFloats);
    	Collections.sort(gabaritoFloats);
    	gabaritoDoubles = new ArrayList<>(listaDoubles);
    	Collections.sort(gabaritoDoubles);
    	gabaritoPequena = new ArrayList<>(listaPequena);
    	Collections.sort(gabaritoPequena);
    	gabaritoSemiOrdenada = new ArrayList<>(listaSemiOrdenada);
    	Collections.sort(gabaritoSemiOrdenada);
    }

	@Test
	void bubbleSortIntTest() {		
		listaInts = bubbleSort.ordena(listaInts);
		
		assertEquals(listaInts, gabaritoInts);
	}
	
	@Test
	void bubbleSortFloatTest() {		
		listaFloats = bubbleSort.ordena(listaFloats);
		
		assertEquals(listaFloats, gabaritoFloats);
	}
	
	@Test
	void bubbleSortDoubleTest() {		
		listaDoubles = bubbleSort.ordena(listaDoubles);
		
		assertEquals(listaDoubles, gabaritoDoubles);
	}
	
	@Test
	void bubbleSortPequenaTest() {		
		listaPequena = bubbleSort.ordena(listaPequena);
		
		assertEquals(listaPequena, gabaritoPequena);
	}
	
	@Test
	void bubbleSortSemiOrdenadaTest() {		
		listaSemiOrdenada = bubbleSort.ordena(listaSemiOrdenada);
		
		assertEquals(listaSemiOrdenada, gabaritoSemiOrdenada);
	}

	@Test
	void heapSortIntTest() {		
		listaInts = heapSort.ordena(listaInts);
		
		assertEquals(listaInts, gabaritoInts);
	}
	
	@Test
	void heapSortFloatTest() {		
		listaFloats = heapSort.ordena(listaFloats);
		
		assertEquals(listaFloats, gabaritoFloats);
	}
	
	@Test
	void heapSortDoubleTest() {		
		listaDoubles = heapSort.ordena(listaDoubles);
		
		assertEquals(listaDoubles, gabaritoDoubles);
	}
	
	@Test
	void heapSortPequenaTest() {		
		listaPequena = heapSort.ordena(listaPequena);
		
		assertEquals(listaPequena, gabaritoPequena);
	}
	
	@Test
	void heapSortSemiOrdenadaTest() {		
		listaSemiOrdenada = heapSort.ordena(listaSemiOrdenada);
		
		assertEquals(listaSemiOrdenada, gabaritoSemiOrdenada);
	}
	
	@Test
	void insertionSortIntTest() {		
		listaInts = insertionSort.ordena(listaInts);
		
		assertEquals(listaInts, gabaritoInts);
	}
	
	@Test
	void insertionSortFloatTest() {		
		listaFloats = insertionSort.ordena(listaFloats);
		
		assertEquals(listaFloats, gabaritoFloats);
	}
	
	@Test
	void insertionSortDoubleTest() {
		listaDoubles = insertionSort.ordena(listaDoubles);

		assertEquals(listaDoubles, gabaritoDoubles);
	}
	
	@Test
	void insertionSortPequenaTest() {		
		listaPequena = insertionSort.ordena(listaPequena);
		
		assertEquals(listaPequena, gabaritoPequena);
	}
	
	@Test
	void insertionSortSemiOrdenadaTest() {		
		listaSemiOrdenada = insertionSort.ordena(listaSemiOrdenada);
		
		assertEquals(listaSemiOrdenada, gabaritoSemiOrdenada);
	}
	
	@Test
	void quickSortIntTest() {		
		listaInts = quickSort.ordena(listaInts);
		
		assertEquals(listaInts, gabaritoInts);
	}
	
	@Test
	void quickSortFloatTest() {
		listaFloats = quickSort.ordena(listaFloats);

		assertEquals(listaFloats, gabaritoFloats);
	}
	
	@Test
	void quickSortDoubleTest() {
		listaDoubles = quickSort.ordena(listaDoubles);

		assertEquals(listaDoubles, gabaritoDoubles);
	}

	@Test
	void quickSortPequenaTest() {		
		listaPequena = quickSort.ordena(listaPequena);
		
		assertEquals(listaPequena, gabaritoPequena);
	}
	
	@Test
	void quickSortSemiOrdenadaTest() {		
		listaSemiOrdenada = quickSort.ordena(listaSemiOrdenada);
		
		assertEquals(listaSemiOrdenada, gabaritoSemiOrdenada);
	}
}
