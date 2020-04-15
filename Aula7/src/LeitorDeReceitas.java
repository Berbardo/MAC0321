import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LeitorDeReceitas extends LeitorDeArquivos {

	static ArrayList<String[]> lerReceita(String caminhoDoArquivo, ArrayList<String[]> listaDeIngredientes) throws Exception {
		char[] arquivo = new char[8192];
		ArrayList<String[]> quantidadeDosIngredientes = new ArrayList<>();
		int indice;
		String quantidade;
		
		try {
			FileReader leitor = new FileReader(caminhoDoArquivo);
			leitor.read(arquivo);
			
			String receita = new String(arquivo);
			
			// Procura algum ingrediente desconhecido na receita
			procuraIngredienteDesconhecido(receita, listaDeIngredientes);
			
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
						throw new IngredientQuantityNotFoundException("Nao foi encontrada uma quantidade do ingrediente " + ingrediente[0]);
					}
					
					procuraQuantidade.close();
					
					String[] quantIngrediente = {ingrediente[0], quantidade};
					quantidadeDosIngredientes.add(quantIngrediente);
				}
			}
						
			leitor.close();
		} catch (IngredientNotFoundException e) {
			System.out.println("Um ingrediente da lista nao foi encontrado!");
			System.out.println(e);
			return null;
		} catch (Exception e) {
			if (!caminhoDoArquivo.endsWith(".txt")) {
				String format = caminhoDoArquivo.substring(caminhoDoArquivo.indexOf('.'));
				throw new WrongFileFormatException("Formato de arquivo incorreto! Deveria ser '.txt', porém recebeu " + format);
			}
			throw e;
		}
		
		return quantidadeDosIngredientes;
	}
	
	static public void procuraIngredienteDesconhecido(String receita, ArrayList<String[]> listaDeIngredientes) throws IngredientNotFoundException {
		String[] linhas = receita.split("\\r?\\n");
		for(String linha: linhas) {
			if (!linha.contains("-")) {
				continue;
			}
			
			String ingrediente = linha.substring(0, linha.indexOf('-')).trim();
			
			boolean encontrado = false;
			for (String[] ingredienteDaLista: listaDeIngredientes) {
				if (ingrediente.contentEquals(ingredienteDaLista[0])) {
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {				
				throw new IngredientNotFoundException("O ingrediente " + ingrediente + " nao foi encontrado na lista de ingredientes");
			}
		}
	}
}
