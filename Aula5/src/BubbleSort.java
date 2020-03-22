import java.util.ArrayList;

public class BubbleSort implements AlgoritmoDeOrdenacao {

	private long tempo;
	
	@Override
	public long pegaTempo() {
		return tempo;
	}
	
	@Override
	public <T extends Comparable<T>> ArrayList<T> ordena(ArrayList<T> array) {
		long tempoInicial = System.nanoTime();
		
        int tamanho = array.size(); 
        for (int i = 0; i < tamanho - 1; i++) 
            for (int j = 0; j < tamanho - i  -1; j++) 
                if (array.get(j).compareTo(array.get(j+1)) > 0) 
                { 
                    T temp = array.get(j); 
                    array.set(j, array.get(j+1)); 
                    array.set(j+1, temp); 
                } 
        
        long tempoFinal = System.nanoTime();
        
        this.tempo = tempoFinal - tempoInicial;
        
        return array;
    }
}
