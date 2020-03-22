import java.util.ArrayList;

public class MergeSort implements AlgoritmoDeOrdenacao{

	@Override
	public <T extends Comparable<T>> ArrayList<T> ordena(ArrayList<T> array) {
        ArrayList<T> arrayInicio = new ArrayList<T>();
        ArrayList<T> arrayFinal = new ArrayList<T>();
        int meio;
 
        if (array.size() == 1) {    
            return array;
        } else {
            meio = array.size()/2;

            for (int i=0; i < meio; i++) {
                    arrayInicio.add(array.get(i));
            }
 
            for (int i=meio; i < array.size(); i++) {
                    arrayFinal.add(array.get(i));
            }
 
            arrayInicio  = ordena(arrayInicio);
            arrayFinal = ordena(arrayFinal);
 
            juntar(arrayInicio, arrayFinal, array);
        }
        
        return array;
    }
 
    private <T extends Comparable<T>> void juntar(ArrayList<T> arrayInicio, ArrayList<T> arrayFinal, ArrayList<T> array) {
        int indiceInicio = 0;
        int indiceFim = 0;
        int indiceArray = 0;
 
        while (indiceInicio < arrayInicio.size() && indiceFim < arrayFinal.size()) {
            if (arrayInicio.get(indiceInicio).compareTo(arrayFinal.get(indiceFim)) < 0) {
                array.set(indiceArray, arrayInicio.get(indiceInicio));
                indiceInicio++;
            } else {
                array.set(indiceArray, arrayFinal.get(indiceFim));
                indiceFim++;
            }
            indiceArray++;
        }
 
        ArrayList<T> resto;
        int restIndex;
        if (indiceInicio >= arrayInicio.size()) {
            // The left ArrayList has been use up...
            resto = arrayFinal;
            restIndex = indiceFim;
        } else {
            // The right ArrayList has been used up...
            resto = arrayInicio;
            restIndex = indiceInicio;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<resto.size(); i++) {
            array.set(indiceArray, resto.get(i));
            indiceArray++;
        }
    }
}
