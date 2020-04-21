import java.util.ArrayList;

public class HeapSort implements AlgoritmoDeOrdenacao {

	private long tempo;
	
	@Override
	public long pegaTempo() {
		return tempo;
	}
	
	@Override
	public <T extends Comparable<T>> ArrayList<T> ordena(ArrayList<T> array) {
		long tempoInicial = System.nanoTime();
		
        int tamanho = array.size(); 
  
        for (int i = tamanho / 2 - 1; i >= 0; i--) 
            array = heapify(array, tamanho, i); 
  
        for (int i = tamanho - 1; i >= 0; i--) 
        { 
            T temp = array.get(0); 
            array.set(0, array.get(i)); 
            array.set(i, temp); 
  
            array = heapify(array, i, 0); 
        } 
        
        long tempoFinal = System.nanoTime();
        
        this.tempo = tempoFinal - tempoInicial;
        
        return array;
    } 
  
	private static <T extends Comparable<T>> ArrayList<T> heapify(ArrayList<T> array, int n, int i) 
    { 
        int maior = i;
        int inicio = 2*i + 1;
        int fim = 2*i + 2;
  
        if (inicio < n && array.get(inicio).compareTo(array.get(maior)) > 0) 
            maior = inicio; 
  
        if (fim < n && array.get(fim).compareTo(array.get(maior)) > 0) 
            maior = fim; 
  
        if (maior != i) 
        { 
            T temp = array.get(i); 
            array.set(i, array.get(maior)); 
            array.set(maior, temp); 
  
            array = heapify(array, n, maior); 
        } 
        
        return array;
    }
	
}
