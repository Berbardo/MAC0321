import java.util.ArrayList;

public interface AlgoritmoDeOrdenacao {
	
	public <T extends Comparable<T>> ArrayList<T> ordena(ArrayList<T> array);
}
