import java.io.FileReader;
import java.util.ArrayList;

public class LeitorDeIngredientes extends LeitorDeArquivos{

	static ArrayList<String[]> lerListaDeIngredientes(String caminhoDoArquivo) throws Exception {
		char[] arquivo = new char[8192];
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
			if (!caminhoDoArquivo.endsWith(".txt")) {
				String format = caminhoDoArquivo.substring(caminhoDoArquivo.lastIndexOf('.'));
				throw new WrongFileFormatException("Formato de arquivo incorreto! Deveria ser '.txt', porém recebeu " + format);
			}
			throw e;
		}
		
		return ingredientes;
	}
}
