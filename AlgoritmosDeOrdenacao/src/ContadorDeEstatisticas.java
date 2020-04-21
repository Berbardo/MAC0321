import java.io.IOException;
import java.util.ArrayList;

public class ContadorDeEstatisticas {
	private static ArrayList<ArrayList<Double>> temposOrdenagem = new ArrayList<>();
	private static ArrayList<ArrayList<Double>> temposTamanho = new ArrayList<>();
	private static ArrayList<ArrayList<Double>> temposTipo = new ArrayList<>();
	
	private static void avaliarAlgoritmo(AlgoritmoDeOrdenacao algoritmo) {
		avaliarTemposOrdenagem(algoritmo);
		avaliarTemposTamanho(algoritmo);
		avaliarTemposTipo(algoritmo);
	}
	
	private static void avaliarTemposOrdenagem(AlgoritmoDeOrdenacao algoritmo) {
		ArrayList<Double> temposAlgoritmo = new ArrayList<>();
		
		double tempoAleatoria = 0;
		double tempoSemiOrdenada = 0;
		double tempoReversa = 0;
		
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> listaAleatoria = CriadorDeListas.criaListaAleatoria(() -> (int) (Math.random() * 1000), 1000);
			ArrayList<Integer> listaSemiOrdenada = CriadorDeListas.criaListaSemiOrdenada(() -> (int) (Math.random() * 1000), 1000);
			ArrayList<Integer> listaReversa = CriadorDeListas.criaListaReversa(() -> (int) (Math.random() * 1000), 1000);
		
			tempoAleatoria += calculaDuracao(algoritmo, listaAleatoria)/10;
			tempoSemiOrdenada += calculaDuracao(algoritmo, listaSemiOrdenada)/10;
			tempoReversa += calculaDuracao(algoritmo, listaReversa)/10;
		}
		
		temposAlgoritmo.add(tempoAleatoria);
		temposAlgoritmo.add(tempoSemiOrdenada);
		temposAlgoritmo.add(tempoReversa);
		
		temposOrdenagem.add(temposAlgoritmo);
	}
	
	private static void avaliarTemposTamanho(AlgoritmoDeOrdenacao algoritmo) {
		ArrayList<Double> temposAlgoritmo = new ArrayList<>();
		
		for (int ordem = 1; ordem <= 6; ordem++) {
			ArrayList<Integer> listaInts = CriadorDeListas.criaListaAleatoria(() -> (int) (Math.random() * 1000), (int) Math.pow(10, ordem));
			temposAlgoritmo.add(calculaDuracao(algoritmo, listaInts));
		}
		
		temposTamanho.add(temposAlgoritmo);
	}
	
	private static void avaliarTemposTipo(AlgoritmoDeOrdenacao algoritmo) {
		ArrayList<Double> temposAlgoritmo = new ArrayList<>();
		
		double tempoInts = 0;
		double tempoFloats = 0;
		double tempoDoubles = 0;
		
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> listaInts = CriadorDeListas.criaListaAleatoria(() -> (int) (Math.random() * 1000), 1000);
			ArrayList<Float> listaFloats = CriadorDeListas.criaListaAleatoria(() -> (float) (Math.random() * 1000), 1000);
			ArrayList<Double> listaDoubles = CriadorDeListas.criaListaAleatoria(() -> (double) (Math.random() * 1000), 1000);
			
			tempoInts += calculaDuracao(algoritmo, listaInts)/10;
			tempoFloats += calculaDuracao(algoritmo, listaFloats)/10;
			tempoDoubles += calculaDuracao(algoritmo, listaDoubles)/10;
		}
		
		temposAlgoritmo.add(tempoInts);
		temposAlgoritmo.add(tempoFloats);
		temposAlgoritmo.add(tempoDoubles);
		
		temposTipo.add(temposAlgoritmo);
	}
	
	private static <T extends Comparable<T>> double calculaDuracao(AlgoritmoDeOrdenacao algoritmo, ArrayList<T> array) {
		long tempons = 0;
		algoritmo.ordena(array);
		tempons = algoritmo.pegaTempo();
		double tempoms = (double) tempons / 1000000;
		System.out.println(tempoms);
		return tempoms;
	}
	
	public static void main(String args[]) throws IOException {
		BubbleSort bubbleSort = new BubbleSort();
		HeapSort heapSort = new HeapSort();
		QuickSort quickSort = new QuickSort();
		InsertionSort insertionSort = new InsertionSort();
		
		AlgoritmoDeOrdenacao[] algoritmos = {quickSort, heapSort, insertionSort, bubbleSort};
		
		for (AlgoritmoDeOrdenacao algoritmo: algoritmos) {
			avaliarAlgoritmo(algoritmo);
			System.out.println("Terminado!");
		}
		
		GeradorDeCSV.criaCSVOrdenagem(temposOrdenagem);
		GeradorDeCSV.criaCSVTipo(temposTipo);
		GeradorDeCSV.criaCSVTamanho(temposTamanho);
		
		System.out.println("Final!");
	}
	
}
