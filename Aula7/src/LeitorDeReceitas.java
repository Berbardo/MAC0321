import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LeitorDeReceitas extends LeitorDeArquivos {

	static ArrayList<String[]> lerReceita(String caminhoDoArquivo, ArrayList<String[]> listaDeIngredientes) {
		char[] arquivo = new char[1024];
		ArrayList<String[]> quantidadeDosIngredientes = new ArrayList<>();
		int indice;
		String quantidade;
		
		try {
			FileReader leitor = new FileReader(caminhoDoArquivo);
			leitor.read(arquivo);
			
			String receita = new String(arquivo);
			
			// Procura cada ingrediente na receita
			for (String[] ingrediente: listaDeIngredientes) {
				indice = receita.indexOf(ingrediente[0]);
				
				// Procura a quantidade do ingrediente, caso ele esteja na receita
				if (indice != -1) {
					Scanner procuraQuantidade = new Scanner(receita.substring(indice));
					procuraQuantidade.skip("[^0-9]*");
					
					try {
						quantidade = Integer.toString(procuraQuantidade.nextInt());  						
					} catch(Exception e) {
						procuraQuantidade.close();
						System.out.println("Nao foi encontrada uma quantidade do ingrediente " + ingrediente[0]);
						throw e;
					}
					
					
					procuraQuantidade.close();
					
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
