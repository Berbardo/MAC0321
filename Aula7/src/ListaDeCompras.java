import java.io.PrintWriter;
import java.util.ArrayList;

public class ListaDeCompras {
	ArrayList<String[]> listaDeCompras = new ArrayList<>();
	
	
	public static void main(String[] args) {
		ListaDeCompras listaDeCompras = new ListaDeCompras();
		
		ArrayList<String[]> listaDeIngredientes = LeitorDeIngredientes.lerListaDeIngredientes(args[0]);
		
		listaDeCompras.criaListaDeCompras(listaDeIngredientes);
		
		for (String receita: args) {
			if (receita == args[0])
				continue;
			ArrayList<String[]> quantIngredientes = LeitorDeReceitas.lerReceita(receita, listaDeIngredientes);
			
			for (String[] quantIngrediente: quantIngredientes) {
				listaDeCompras.adicionaIngrediente(quantIngrediente);				
			}
		}
		
		listaDeCompras.adicionaUnidades(listaDeIngredientes);
		listaDeCompras.exportaListaDeCompras();
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
	
	void exportaListaDeCompras() {
		String listaDeCompras = new String();
		listaDeCompras += "Lista De Compra: \n\n";
		for (String[] ingrediente: this.listaDeCompras) {
			listaDeCompras += "   - " + ingrediente[0] + " ".repeat(Integer.max(0,(20 - ingrediente[0].length()))) + "- " + ingrediente[1] + "\n";
		}
		
		try {
			PrintWriter arquivo = new PrintWriter("ListaDeCompras.txt");
			arquivo.println(listaDeCompras);
			arquivo.close();
		} catch(Exception e) {
			System.out.println(e);
		}

	}
}
