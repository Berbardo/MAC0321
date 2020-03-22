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
		
		ArrayList<Integer> listaAleatoria = CriadorDeListas.criaListaAleatoria(() -> (int) (Math.random() * 1000), 1000);
		ArrayList<Integer> listaSemiOrdenada = CriadorDeListas.criaListaSemiOrdenada(() -> (int) (Math.random() * 1000), 1000);
		ArrayList<Integer> listaReversa = CriadorDeListas.criaListaReversa(() -> (int) (Math.random() * 1000), 1000);
		
		temposAlgoritmo.add(calculaDuracao(algoritmo, listaAleatoria));
		temposAlgoritmo.add(calculaDuracao(algoritmo, listaSemiOrdenada));
		temposAlgoritmo.add(calculaDuracao(algoritmo, listaReversa));
		
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
		
		ArrayList<Integer> listaInts = CriadorDeListas.criaListaAleatoria(() -> (int) (Math.random() * 1000), 1000);
		ArrayList<Float> listaFloats = CriadorDeListas.criaListaAleatoria(() -> (float) (Math.random() * 1000), 1000);
		ArrayList<Double> listaDoubles = CriadorDeListas.criaListaAleatoria(() -> (double) (Math.random() * 1000), 1000);
		
		temposAlgoritmo.add(calculaDuracao(algoritmo, listaInts));
		temposAlgoritmo.add(calculaDuracao(algoritmo, listaFloats));
		temposAlgoritmo.add(calculaDuracao(algoritmo, listaDoubles));
		
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
