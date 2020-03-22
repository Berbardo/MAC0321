import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Supplier;

public class CriadorDeListas {
	
	public static <T> ArrayList<T> criaListaAleatoria(Supplier<T> funcao, int tamanho) {
		ArrayList<T> array = new ArrayList<>();
				
		for (int i = 0; i < tamanho; i++) {
			T objeto = funcao.get();
			
			array.add((T) objeto);
		}
		return array;
	}
	
	public static <T> ArrayList<T> criaListaReversa(Supplier<T> funcao, int tamanho) {
		ArrayList<T> array = criaListaAleatoria(funcao, tamanho);
		
		Comparator<T> c = Collections.reverseOrder();
		Collections.sort(array, c);
		
		return array;
	}
	
	public static <T> ArrayList<T> criaListaSemiOrdenada(Supplier<T> funcao, int tamanho) {
		ArrayList<T> array = criaListaAleatoria(funcao, tamanho);
		
		Comparator<T> c = Collections.reverseOrder();
		Collections.sort(array, c);
		
		return array;
	}
}
