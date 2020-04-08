import java.io.FileReader;
import java.util.ArrayList;

public class LeitorDeReceitas extends LeitorDeArquivos {

	static ArrayList<String[]> lerReceita(String caminhoDoArquivo, ArrayList<String[]> ingredientes) {
		char[] arquivo = new char[1024];
		ArrayList<String[]> quantidadeDosIngredientes = new ArrayList<>();
		int indice;
		String quantidade;
		
		try {
			FileReader leitor = new FileReader(caminhoDoArquivo);
			leitor.read(arquivo);
			
			String receita = new String(arquivo);
			
			for (String[] ingrediente: ingredientes) {
				indice = receita.indexOf(ingrediente[0]);
				if (indice != -1) {
					indice = receita.indexOf('-', indice);
					quantidade = receita.substring(indice + 1, receita.indexOf('\n', indice)).trim();
					
					String[] quantIngrediente = {ingrediente[0], quantidade};
					quantidadeDosIngredientes.add(quantIngrediente);
				}
			}
						
			leitor.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return quantidadeDosIngredientes;
	}
}
