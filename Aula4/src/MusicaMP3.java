
public class MusicaMP3 extends Musica{
	
	MusicaMP3(String titulo, String nomeDoAlbum, String compositor, String interprete, int ano, int tamanhoBytes) {
		super(titulo, nomeDoAlbum, compositor, interprete, ano);
		this.tamanhoBytes = tamanhoBytes;
	}
	
	void imprimeMusica() {
		System.out.println(titulo + " " + nomeDoAlbum + " "  + compositor + " "  + interprete + " "  + ano + " " + tamanhoBytes + "B");
	}
}
