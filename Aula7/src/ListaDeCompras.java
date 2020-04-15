import java.io.PrintWriter;
import java.util.ArrayList;

public class ListaDeCompras {
	ArrayList<String[]> listaDeCompras = new ArrayList<>();
	
	
	public static void main(String[] args) {
		String caminhoDaListaDeIngredientes = "./receitas/ingredientes.txt";
		
		ListaDeCompras listaDeCompras = new ListaDeCompras();
		
		ArrayList<String[]> listaDeIngredientes;
		try {
			listaDeIngredientes = LeitorDeIngredientes.lerListaDeIngredientes(caminhoDaListaDeIngredientes);
		} catch (Exception e) {
			System.out.println("Nao foi possivel importar a lista de ingredientes!");
			System.out.println("Erro:");
			System.out.println(e);
			return;
		}
		
		listaDeCompras.criaListaDeCompras(listaDeIngredientes);
		
		CriadorDePDF criadorDePDF = new CriadorDePDF();
		criadorDePDF.criaPDF();	
		
		for (String receita: args) {
			ArrayList<String[]> quantIngredientes;
			
			try {
				quantIngredientes = LeitorDeReceitas.lerReceita(receita, listaDeIngredientes);
			} catch (Exception e) {
				System.out.println("Nao foi possivel ler a receita " + receita);
				System.out.println("Erro:");
				System.out.println(e);
				continue;
			}
			
			for (String[] quantIngrediente: quantIngredientes) {
				listaDeCompras.adicionaIngrediente(quantIngrediente);				
			}
			
			// Adiciona a receita ao PDF
			criadorDePDF.adicionaReceitaPDF(receita);
		}
		
		criadorDePDF.terminaPDF();
		
		listaDeCompras.adicionaUnidades(listaDeIngredientes);
		listaDeCompras.exportaListaDeCompras("receitas/ListaDeCompras.txt");
	}
	
	void criaListaDeCompras(ArrayList<String[]> listaDeIngredientes) {
		for (String[] ingrediente: listaDeIngredientes) {
			String[] quantIngrediente = {ingrediente[0], "0"};
			this.listaDeCompras.add(quantIngrediente);
		}
	}
	
	void adicionaIngrediente(String[] quantIngrediente) {
		for (String[] ingrediente: this.listaDeCompras) {
			if (ingrediente[0] == quantIngrediente[0]) {
				int quantidade = Integer.parseInt(ingrediente[1]) + Integer.parseInt(quantIngrediente[1]);
				ingrediente[1] = Integer.toString(quantidade);
			}
		}
	}
	
	void adicionaUnidades(ArrayList<String[]> listaDeIngredientes) {
		for (String[] ingredienteLista: listaDeIngredientes) {
			for (String[] ingredienteCompras: this.listaDeCompras) {
				if (ingredienteCompras[0] == ingredienteLista[0]) {
					ingredienteCompras[1] += " " + ingredienteLista[1];
				}
			}
		}
		
	}
	
	void exportaListaDeCompras(String caminho) {
		String listaDeCompras = new String();
		listaDeCompras += "Lista De Compra: \n\n";
		for (String[] ingrediente: this.listaDeCompras) {
			listaDeCompras += "   - " + ingrediente[0] + " ".repeat(Integer.max(0,(20 - ingrediente[0].length()))) + "- " + ingrediente[1] + "\n";
		}
		
		try {
			PrintWriter arquivo = new PrintWriter(caminho);
			arquivo.println(listaDeCompras);
			arquivo.close();
		} catch(Exception e) {
			System.out.println(e);
		}

	}
}
