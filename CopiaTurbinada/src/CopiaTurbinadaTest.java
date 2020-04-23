import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

}
