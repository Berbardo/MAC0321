
public class MusicaLP extends Musica{
	private int velocidadeRPM;
	
	MusicaLP(String titulo, String nomeDoAlbum, String compositor, String interprete, int ano, int velocidadeRPM) {
		super(titulo, nomeDoAlbum, compositor, interprete, ano);
		this.velocidadeRPM = velocidadeRPM;
	}
	
	void imprimeMusica() {
		System.out.println(titulo + " " + nomeDoAlbum + " "  + compositor + " "  + interprete + " "  + ano + " " + velocidadeRPM + " RPM");
	}
}
