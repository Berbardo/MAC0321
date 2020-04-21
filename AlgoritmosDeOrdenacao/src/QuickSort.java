import java.util.ArrayList;

public class QuickSort implements AlgoritmoDeOrdenacao {

	private long tempo;
	
	@Override
	public long pegaTempo() {
		return tempo;
	}
	
	@Override
	public <T extends Comparable<T>> ArrayList<T> ordena(ArrayList<T> array) {
		long tempoInicial = System.nanoTime();
		
		array = quickSort(array, 0, array.size() - 1);
		
        long tempoFinal = System.nanoTime();
        
        this.tempo = tempoFinal - tempoInicial;
        
		return array;
	}
	
	public static <T extends Comparable<T>> ArrayList<T> quickSort(ArrayList<T> array, int inicio, int fim) 
    { 
        if (inicio < fim) 
        { 
            int pi = particiona(array, inicio, fim); 
  
            array = quickSort(array, inicio, pi - 1); 
            array = quickSort(array, pi + 1, fim); 
        } 
        
        return array;
    } 

    private static <T extends Comparable<T>> int particiona(ArrayList<T> array, int inicio, int fim) 
    { 
        T pivo = array.get(fim);  
        int i = (inicio - 1);
        for (int j = inicio; j < fim; j++) { 
            if (array.get(j).compareTo(pivo) < 0) 
            { 
                i++; 
  
                T temp = array.get(i); 
                array.set(i, array.get(j)); 
                array.set(j, temp); 
            } 
        } 
  
        T temp = array.get(i + 1); 
        array.set(i + 1, array.get(fim)); 
        array.set(fim, temp); 
  
        return i + 1; 
    } 
}
