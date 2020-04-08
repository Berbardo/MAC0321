import java.io.FileReader;
import java.util.ArrayList;

public class LeitorDeIngredientes extends LeitorDeArquivos{

	static ArrayList<String[]> lerListaDeIngredientes(String caminhoDoArquivo) {
		char[] arquivo = new char[1024];
		ArrayList<Character> listaDeIngredientes = new ArrayList<>();
		ArrayList<String[]> ingredientes = new ArrayList<>();
		
		try {
			FileReader leitor = new FileReader(caminhoDoArquivo);
			leitor.read(arquivo);
			
			listaDeIngredientes = transformarEmLista(arquivo);
			
			while(!listaDeIngredientes.isEmpty()) {
				String[] ingrediente = new String[2];
				ingrediente[0] = lerIngrediente(listaDeIngredientes);
				ingrediente[1] = lerUnidade(listaDeIngredientes);
				ingredientes.add(ingrediente);
			}
			
			leitor.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ingredientes;
	}
}
