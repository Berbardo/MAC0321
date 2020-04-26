import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.jupiter.api.Test;

class CopiaTurbinadaTest {

	@Test
	void copiaArquivoTest() {
		try {
			EstrategiaCopia estrategiaCopia = new CopiaArquivo(new FileInputStream("resources/test/copiaArquivoTest.txt"));
			String copia = estrategiaCopia.copia();
			assertEquals(copia, "copiaArquivoTest");
		} catch (FileNotFoundException e) {
			fail();
		}
	}
	
	@Test
	void colaArquivoTest() {
		try {
			String colaArquivoTeste = "colaArquivoTeste";
			EstrategiaCola estrategiaCola = new ColaArquivo(new FileOutputStream("resources/test/colaArquivoTeste.txt"));
			estrategiaCola.cola(colaArquivoTeste);

			EstrategiaCopia estrategiaCopia = new CopiaArquivo(new FileInputStream("resources/test/colaArquivoTeste.txt"));
			String copia = estrategiaCopia.copia();
			assertEquals(copia, "colaArquivoTeste");
		} catch (FileNotFoundException e) {
			fail();
		}
	}
	
	@Test
	void descompactadorTest() {
		try {
			EstrategiaCopia estrategiaCopia = new CopiaArquivo(new FileInputStream("resources/test/descompactadorTest.zip"));
			estrategiaCopia = new Descompactador(estrategiaCopia);
			String copia = estrategiaCopia.copia();
			assertEquals(copia, "descompactadorTest");
		} catch (FileNotFoundException e) {
			fail();
		}
	}
	
	@Test
	void compactadorTest() {
		try {
			String compactadorTeste = "compactadorTeste";
			EstrategiaCola estrategiaCola = new ColaArquivo(new FileOutputStream("resources/test/compactadorTest.zip"));
			estrategiaCola = new Compactador(estrategiaCola);
			estrategiaCola.cola(compactadorTeste);
			
			EstrategiaCopia estrategiaCopia = new CopiaArquivo(new FileInputStream("resources/test/compactadorTest.zip"));
			estrategiaCopia = new Descompactador(estrategiaCopia);
			String copia = estrategiaCopia.copia();
			assertEquals(copia, "compactadorTeste");
		} catch (FileNotFoundException e) {
			fail();
		}
	}

	@Test
	void decodificadorTest() {
		try {			
			EstrategiaCopia estrategiaCopia = new CopiaArquivo(new FileInputStream("resources/test/decodificadorTeste.cript"));
			estrategiaCopia = new Decodificador(estrategiaCopia, "123");
			String copia = estrategiaCopia.copia();
			assertEquals(copia, "decodificadorTeste");
		} catch (FileNotFoundException e) {
			fail();
		}
	}
	
	@Test
	void codificadorTest() {
		try {
			String codificadorTeste = "codificadorTeste";
			EstrategiaCola estrategiaCola = new ColaArquivo(new FileOutputStream("resources/test/codificadorTeste.cript"));
			estrategiaCola = new Codificador(estrategiaCola, "1");
			estrategiaCola.cola(codificadorTeste);
			
			EstrategiaCopia estrategiaCopia = new CopiaArquivo(new FileInputStream("resources/test/codificadorTeste.cript"));
			estrategiaCopia = new Decodificador(estrategiaCopia, "1");
			String copia = estrategiaCopia.copia();
			assertEquals(copia, "codificadorTeste");
		} catch (FileNotFoundException e) {
			fail();
		}
	}
	
	@Test
	void completeTest() {
		try {
			String completeTeste = "completeTeste";
			EstrategiaCola estrategiaCola = new ColaArquivo(new FileOutputStream("resources/test/completeTeste.zip.cript"));
			estrategiaCola = new Compactador(estrategiaCola);
			estrategiaCola = new Codificador(estrategiaCola, "163");
			estrategiaCola.cola(completeTeste);
			
			EstrategiaCopia estrategiaCopia = new CopiaArquivo(new FileInputStream("resources/test/completeTeste.zip.cript"));
			estrategiaCopia = new Descompactador(estrategiaCopia);
			estrategiaCopia = new Decodificador(estrategiaCopia, "163");
			String copia = estrategiaCopia.copia();
			assertEquals(copia, "completeTeste");
		} catch (FileNotFoundException e) {
			fail();
		}
	}
}
