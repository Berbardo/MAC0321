import java.util.ArrayList;

public class InsertionSort implements AlgoritmoDeOrdenacao {

	private long tempo;
	
	@Override
	public long pegaTempo() {
		return tempo;
	}
	
	@Override
	public <T extends Comparable<T>> ArrayList<T> ordena(ArrayList<T> array) {
		long tempoInicial = System.nanoTime();
   
        for (int i = 1; i < array.size(); ++i) { 
            T temp = array.get(i); 
            int j = i - 1; 
  
            while (j >= 0 && array.get(j).compareTo(temp) > 0) { 
            	array.set(j + 1, array.get(j)); 
                j = j - 1; 
            } 
            array.set(j+1, temp); 
        } 
        
        long tempoFinal = System.nanoTime();
        
        this.tempo = tempoFinal - tempoInicial;
        
        return array;
    } 
}
