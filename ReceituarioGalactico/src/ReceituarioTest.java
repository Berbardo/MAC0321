import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileReader;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReceituarioTest {
	
	char[] arquivo;
	FileReader leitor;
	ArrayList<String[]> listaDeIngredientes;
	ListaDeCompras listaDeCompras;
	
    @BeforeEach
    void init() {
    	arquivo = new char[8192];
    	listaDeIngredientes = new ArrayList<>();
    	String[] ingrediente1 = {"achocolatado", "g"};
    	String[] ingrediente2 = {"leite", "ml"};
    	listaDeIngredientes.add(ingrediente1);
    	listaDeIngredientes.add(ingrediente2);
    	listaDeCompras = new ListaDeCompras();
    }
    
    // Testes do Leitor de Arquivos
    
	@Test
	void lerIngredienteTest() {
		try {
			leitor = new FileReader("testes/lerIngrediente.txt");
			leitor.read(arquivo);
			
			ArrayList<Character> texto = LeitorDeArquivos.transformarEmLista(arquivo);
			String ingrediente = LeitorDeArquivos.lerIngrediente(texto);
			leitor.close();
	
			assertEquals(ingrediente, "achocolatado");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	void lerIngredienteExceptionTest() {
		try {
			leitor = new FileReader("testes/lerIngredienteException.txt");
			leitor.read(arquivo);
			
			ArrayList<Character> texto = LeitorDeArquivos.transformarEmLista(arquivo);
			assertThrows(NoUnitOfMeasurementException.class, () -> {LeitorDeArquivos.lerIngrediente(texto);});
			leitor.close();
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	void lerUnidadeTest() {
		try {
			leitor = new FileReader("testes/lerUnidade.txt");
			leitor.read(arquivo);
			
			ArrayList<Character> texto = LeitorDeArquivos.transformarEmLista(arquivo);
			LeitorDeArquivos.lerIngrediente(texto);
			String unidade = LeitorDeArquivos.lerUnidade(texto);
			
			assertEquals(unidade, "ml");
			
			leitor.close();
		} catch(Exception e) {
			fail();
		}
	}
	
	// Testes do Leitor de Ingredientes
	
	@Test
	void lerListaDeIngredientesTest() {
		try {
			ArrayList<String[]> ingredientes = LeitorDeIngredientes.lerListaDeIngredientes("testes/lerListaDeIngredientes.txt");
			
			assertArrayEquals(ingredientes.get(0), listaDeIngredientes.get(0));
			assertArrayEquals(ingredientes.get(1), listaDeIngredientes.get(1));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	void lerListaDeIngredientesExceptionTest() {
		try {
			assertThrows(WrongFileFormatException.class, 
					() -> {LeitorDeIngredientes.lerListaDeIngredientes("testes/lerListaDeIngredientesException.text");});
		} catch (Exception e) {
			fail();
		}
	}

	// Testes do Leitor de Receitas
	
	@Test
	void lerReceitaTest() {
		try {
			ArrayList<String[]> ingredientes = LeitorDeReceitas.lerReceita("testes/lerReceita.txt", listaDeIngredientes);
			
			String[] gabarito1 = {"achocolatado", "3"};
			String[] gabarito2 = {"leite", "500"};
						
			assertArrayEquals(ingredientes.get(0), gabarito1);
			assertArrayEquals(ingredientes.get(1), gabarito2);
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
	}
	
	@Test
	void lerReceitaExceptionTest() {
		try {
			assertThrows(WrongFileFormatException.class, 
					() -> {LeitorDeReceitas.lerReceita("testes/lerReceitaException.text", listaDeIngredientes);});
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	void procuraIngredienteDesconhecidoTest() {
		try {
			leitor = new FileReader("testes/procuraIngredienteDesconhecido.txt");
			leitor.read(arquivo);
			String receita = new String(arquivo);
			
			assertThrows(IngredientNotFoundException.class, 
					() -> {LeitorDeReceitas.procuraIngredienteDesconhecido(receita, listaDeIngredientes);});
		} catch (Exception e) {
			fail();
		}
	}
	
	// Teste da Lista de Compras
	
	@Test
	void listaDeComprasTest() {
		try {
			ArrayList<String[]> ingredientes = LeitorDeIngredientes.lerListaDeIngredientes("testes/lerListaDeIngredientes.txt");
			listaDeCompras.criaListaDeCompras(ingredientes);
			
			ArrayList<String[]> quantIngredientes = LeitorDeReceitas.lerReceita("testes/lerReceita.txt", ingredientes);
		
			for (String[] quantIngrediente: quantIngredientes) {
				listaDeCompras.adicionaIngrediente(quantIngrediente);				
			}
			
			listaDeCompras.adicionaUnidades(ingredientes);
			
			String[] gabarito1 = {"achocolatado", "3 g"};
			String[] gabarito2 = {"leite", "500 ml"};
			assertArrayEquals(listaDeCompras.listaDeCompras.get(0), gabarito1);
			assertArrayEquals(listaDeCompras.listaDeCompras.get(1), gabarito2);
		} catch (Exception e) {
			fail();
		}
	}
}
