import java.util.ArrayList;

public class LeitorDeArquivos {
	
	static ArrayList<Character> transformarEmLista(char[] arquivo) {
		ArrayList<Character> listaArquivo = new ArrayList<>();
		
		for (char caractere: arquivo) {
			listaArquivo.add(caractere);
		}
		
		return listaArquivo;
	}
	
	static String lerIngrediente(ArrayList<Character> listaDeIngredientes) throws NoUnitOfMeasurementException {
		String ingrediente = new String();
		
		while (listaDeIngredientes.get(0) != '-') {
			ingrediente += listaDeIngredientes.remove(0);
			
			if (listaDeIngredientes.isEmpty()) {
				ingrediente = ingrediente.trim();
				throw new NoUnitOfMeasurementException("O ingrediente " + ingrediente + " não foi seguido de uma unidade de medida.");
			}
		}
		
		listaDeIngredientes.remove(0);
		
		// Remove espacos
		ingrediente = ingrediente.trim();
		
		return ingrediente;
	}
	
	static String lerUnidade(ArrayList<Character> listaDeIngredientes) {
		String unidade = new String();
		
		while (listaDeIngredientes.get(0) != '\n') {
			unidade += listaDeIngredientes.remove(0);
			
			if (listaDeIngredientes.isEmpty()) {
				unidade = unidade.trim();
				return unidade;
			}
		}
		
		listaDeIngredientes.remove(0);
		
		// Remove espacos
		unidade = unidade.trim();
		
		return unidade;
	}
}
