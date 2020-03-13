
public class Biblioteca {
	Musica[] musicas;
	
	Biblioteca(Musica[] musicas) {
		this.musicas = musicas;
	}
	
	public static void main(String args[]) {
		MusicaLP roundabout = new MusicaLP("Roundabout", "Fragile", "Yes", "Yes", 1971, 45);
		MusicaLP onceInALifetime = new MusicaLP("Once In a Lifetime", "Remain in Light", "Talking Heads", "Talking Heads", 1980, 33);
		MusicaLP enjoyTheSilence = new MusicaLP("Enjoy The Silence", "Violator", "Depeche Mode", "Depeche Mode", 1990, 78);

		MusicaCD prelude = new MusicaCD("Prelude", "Final Fantasy VII Original Soundtrack", "Nobuo Uematsu", "Nobuo Uematsu", 1997);
		MusicaCD resposta = new MusicaCD("Resposta", "Siderado", "Skank", "Nando Reis", 1998);
		MusicaCD epitafio = new MusicaCD("Epitáfio", "A Melhor Banda de Todos os Tempos da Última Semana", "Titãs", "Titãs", 2002);

		
		MusicaMP3 dare = new MusicaMP3("DARE", "Demon Days", "Gorillaz", "Gorillaz", 2005, 4582277);
		MusicaMP3 electricFeel = new MusicaMP3("Electric Feel", "Oracular Spetacular", "MGMT", "MGMT", 2007, 3670016);
		MusicaMP3 home = new MusicaMP3("Home", "This is Happening", "LCD Soundsystem", "LCD Soundsystem", 2010, 11324620);
		MusicaMP3 gone = new MusicaMP3("Gone", "Charli", "Charli XCX", "Charli XCX", 2019, 3911188);
		
		Musica[] musicas = {roundabout, onceInALifetime, enjoyTheSilence, prelude, resposta, epitafio, dare, electricFeel, home, gone};
		Biblioteca biblioteca = new Biblioteca(musicas);
		biblioteca.procuraMusicas(1990, 1999);
	}
	
	void imprimeBiblioteca() {
		for(Musica musica: musicas) {
			musica.imprimeMusica();
		}
	}
	
	Musica[] procuraArquivosGrandes(int Bytes) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for (Musica musica: musicas) {
			if (musica.tamanhoBytes > Bytes) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();
			}				
		}
		
		return listaMusicas;
	}

	Musica[] procuraMusicas(int anoInicio, int anoFim) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for (Musica musica: musicas) {
			if (musica.ano >= anoInicio && musica.ano <= anoFim) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();	
			}
		}
		
		return listaMusicas;
	}
	
	Musica[] procuraMusicasTitulo(String titulo) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for (Musica musica: musicas) {
			if (musica.titulo.contains(titulo)) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();				
			}
		}
		
		return listaMusicas;
	}
	
	Musica[] procuraMusicasCompositor(String compositor) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for (Musica musica: musicas) {
			if (musica.compositor.contains(compositor)) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();				
			}
		}
		
		return listaMusicas;
	}
	
	Musica[] procuraMusicasInterprete(String interprete) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for (Musica musica: musicas) {
			if (musica.interprete.contains(interprete)) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();				
			}
		}
		
		return listaMusicas;
	}
	
	Musica[] procuraMusicasAlbum(String nomeDoAlbum) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for (Musica musica: musicas) {
			if (musica.nomeDoAlbum.contains(nomeDoAlbum)) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();				
			}
		}
		
		return listaMusicas;
	}
	
	Musica[] procuraMusicas(String nome) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for (Musica musica: musicas) {
			if (musica.titulo.contains(nome) || musica.nomeDoAlbum.contains(nome) || musica.compositor.contains(nome) || musica.interprete.contains(nome)) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();				
			}
		}
		
		return listaMusicas;
	}
}
