
public class Exemplo {
	int i;
	double d;
	String s;
	boolean b;
	private String secreto = "Segredo";
	static String statics = "BzzbZBZbZbZzzZzBZzbZBzBzBzbzzzz";
	
	Exemplo() {}
	
	Exemplo(int i1, double d1, String s1, boolean b1) {
		i = i1;
		d = d1;
		s = s1;
		b = b1;
	}
	
	void imprime() {
		System.out.println(i);
		System.out.println(d);
		System.out.println(s);
		System.out.println(b);
		System.out.println(statics);
		System.out.println("");
	}
	
	private void imprimeSecreto() {
		System.out.println("Mensagem secreta: " + secreto);
		System.out.println("");
	}
	
	static void respostaUniversal() {
		System.out.println("42");
	}
	
	public static void main(String[] args) {
		Exemplo ex1 = new Exemplo();
		Exemplo ex2 = new Exemplo(1, 2.5, "oi", true);
		
		Exemplo.statics = "KrrRKRrkrRKrRKRKRrr";
		
		ex1.imprime();
		ex2.imprime();
		
		ex1.secreto = "oi";
		ex1.imprimeSecreto();	
		
		respostaUniversal();
	}
}
