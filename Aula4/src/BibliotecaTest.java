import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BibliotecaTest {

	@Test
	void testeTitulo() {
		MusicaLP roundabout = new MusicaLP("Roundabout", "Fragile", "Yes", "Yes", 1971, 45);
		MusicaLP onceInALifetime = new MusicaLP("Once In a Lifetime", "Remain in Light", "Talking Heads", "Talking Heads", 1980, 33);
		MusicaLP enjoyTheSilence = new MusicaLP("Enjoy The Silence", "Violator", "Depeche Mode", "Depeche Mode", 1990, 78);
		
		Musica[] musicas = {roundabout, onceInALifetime, enjoyTheSilence};
		Biblioteca biblioteca = new Biblioteca(musicas);
		Musica[] listaMusicas = biblioteca.procuraMusicasTitulo("e");
		assertEquals(listaMusicas[0], onceInALifetime);
		assertEquals(listaMusicas[1], enjoyTheSilence);
	}
	
	@Test
	void testeInterprete() {
		MusicaCD prelude = new MusicaCD("Prelude", "Final Fantasy VII Original Soundtrack", "Nobuo Uematsu", "Nobuo Uematsu", 1997);
		MusicaCD resposta = new MusicaCD("Resposta", "Siderado", "Skank", "Nando Reis", 1998);
		MusicaCD epitafio = new MusicaCD("Epitáfio", "A Melhor Banda de Todos os Tempos da Última Semana", "Titãs", "Titãs", 2002);
		
		Musica[] musicas = {prelude, resposta, epitafio};
		Biblioteca biblioteca = new Biblioteca(musicas);
		Musica[] listaMusicas = biblioteca.procuraMusicasInterprete("i");
		assertEquals(listaMusicas[0], resposta);
		assertEquals(listaMusicas[1], epitafio);
	}

	@Test
	void testeCompositor() {
		MusicaMP3 dare = new MusicaMP3("DARE", "Demon Days", "Gorillaz", "Gorillaz", 2005, 4582277);
		MusicaMP3 electricFeel = new MusicaMP3("Electric Feel", "Oracular Spetacular", "MGMT", "MGMT", 2007, 3670016);
		MusicaMP3 home = new MusicaMP3("Home", "This is Happening", "LCD Soundsystem", "LCD Soundsystem", 2010, 11324620);
		MusicaMP3 gone = new MusicaMP3("Gone", "Charli", "Charli XCX", "Charli XCX", 2019, 3911188);
		
		Musica[] musicas = {dare, electricFeel, home, gone};
		Biblioteca biblioteca = new Biblioteca(musicas);
		Musica[] listaMusicas = biblioteca.procuraMusicasInterprete("l");
		assertEquals(listaMusicas[0], dare);
		assertEquals(listaMusicas[1], gone);
	}
	
	@Test
	void testeTamanho() {
		int MB = 1048576;
		
		MusicaCD prelude = new MusicaCD("Prelude", "Final Fantasy VII Original Soundtrack", "Nobuo Uematsu", "Nobuo Uematsu", 1997);
		MusicaLP roundabout = new MusicaLP("Roundabout", "Fragile", "Yes", "Yes", 1971, 45);
		MusicaMP3 electricFeel = new MusicaMP3("Electric Feel", "Oracular Spetacular", "MGMT", "MGMT", 2007, 3670016);
		MusicaMP3 home = new MusicaMP3("Home", "This is Happening", "LCD Soundsystem", "LCD Soundsystem", 2010, 11324620);
		
		Musica[] musicas = {prelude, roundabout, electricFeel, home};
		Biblioteca biblioteca = new Biblioteca(musicas);
		Musica[] listaMusicas = biblioteca.procuraArquivosGrandes(6*MB); // Imprime arquivos maiores que 6 MB
		assertEquals(listaMusicas[0], home);

	}
}
