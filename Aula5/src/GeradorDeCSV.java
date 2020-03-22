import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GeradorDeCSV {
	
	public static void criaCSVOrdenagem(ArrayList<ArrayList<Double>> temposOrdenagem) throws IOException {
		FileWriter csvWriter = new FileWriter("AnaliseAlgoritmosOrdenagem.csv");
		
		csvWriter.append("Algoritmo");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista Aleatoria");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista Quase Ordenada");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista Revertida");
		csvWriter.append("\n");
		
		int i = 0;

		for (ArrayList<Double> temposOrdenagemAlgoritmo : temposOrdenagem) {
			if (i == 0) {
				csvWriter.append("Quick Sort");
			} else if (i == 1) {
				csvWriter.append("Heap Sort");
			} else if (i == 2) {
				csvWriter.append("Insertion Sort");
			} else {
				csvWriter.append("Bubble Sort");
			}
			
			csvWriter.append(",");
			i++;
			
			for (double tempo: temposOrdenagemAlgoritmo) {
				csvWriter.append(String.valueOf(tempo));
				csvWriter.append(",");
			}
		    csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();
	}
	
	public static void criaCSVTipo(ArrayList<ArrayList<Double>> temposTipo) throws IOException {
		FileWriter csvWriter = new FileWriter("AnaliseAlgoritmosTipo.csv");
		
		csvWriter.append("Algoritmo");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista de Ints");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista de Floats");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista de Doubles");
		csvWriter.append("\n");
		
		int i = 0;

		for (ArrayList<Double> temposTipoAlgoritmo : temposTipo) {
			if (i == 0) {
				csvWriter.append("Quick Sort");
			} else if (i == 1) {
				csvWriter.append("Heap Sort");
			} else if (i == 2) {
				csvWriter.append("Insertion Sort");
			} else {
				csvWriter.append("Bubble Sort");
			}
			
			csvWriter.append(",");
			i++;
			
			for (double tempo: temposTipoAlgoritmo) {
				csvWriter.append(String.valueOf(tempo));
				csvWriter.append(",");
			}
		    csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();
	}
	
	public static void criaCSVTamanho(ArrayList<ArrayList<Double>> temposTamanho) throws IOException {
		FileWriter csvWriter = new FileWriter("AnaliseAlgoritmosTamanho.csv");
		
		csvWriter.append("Algoritmo");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista de Tamanho 1e1");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista de Tamanho 1e2");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista de Tamanho 1e3");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista de Tamanho 1e4");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista de Tamanho 1e5");
		csvWriter.append(",");
		csvWriter.append("Tempo Lista de Tamanho 1e6");
		csvWriter.append("\n");
		
		int i = 0;

		for (ArrayList<Double> temposTamanhoAlgoritmo : temposTamanho) {
			if (i == 0) {
				csvWriter.append("Quick Sort");
			} else if (i == 1) {
				csvWriter.append("Heap Sort");
			} else if (i == 2) {
				csvWriter.append("Insertion Sort");
			} else {
				csvWriter.append("Bubble Sort");
			}
			
			csvWriter.append(",");
			i++;
			
			for (double tempo: temposTamanhoAlgoritmo) {
				csvWriter.append(String.valueOf(tempo));
				csvWriter.append(",");
			}
		    csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();
	}
	
}
