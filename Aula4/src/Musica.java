
public class Musica {
	String titulo;
	String nomeDoAlbum;
	String compositor;
	String interprete;
	int ano;
	int tamanhoBytes = 0;
	
	Musica(String titulo, String nomeDoAlbum, String compositor, String interprete, int ano) {
		this.titulo = titulo;
		this.nomeDoAlbum = nomeDoAlbum;
		this.compositor = compositor;
		this.interprete = interprete;
		this.ano = ano;
	}
	
	void imprimeMusica() {
		System.out.println(titulo + " " + nomeDoAlbum + " "  + compositor + " "  + interprete + " "  + ano);
	}
}
