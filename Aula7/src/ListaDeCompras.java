import java.util.ArrayList;

public class ListaDeCompras {

	public static void main(String[] args) {
		ArrayList<String[]> ingredientes = LeitorDeIngredientes.lerListaDeIngredientes(args[0]);
		
		for (String[] ingrediente: ingredientes) {
			System.out.println(ingrediente[0]);
			System.out.println(ingrediente[1]);
		}
		
		ArrayList<String[]> quantIngredientes = LeitorDeReceitas.lerReceita(args[1], ingredientes);
		
		for (String[] ingrediente: quantIngredientes) {
			System.out.println(ingrediente[0]);
			System.out.println(ingrediente[1]);
		}
	}
	
}
