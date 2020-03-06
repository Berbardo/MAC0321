
public class Endereco {
	String rua = "";
	String numero = "";
	String cidade = "";
	String uf = "";
	
	void gerarEndereco() {
		if ((int) (Math.random() * 2) == 1) {
			rua = "Rua ";
		}
		else {
			rua = "Avenida ";
		}
		
		rua += (char) (Math.random() * 100 % 26 + 'A');
		
		for (int i = 0; i < Math.random() * 100 % 8; i++) {
			rua += (char) (Math.random() * 100 % 26 + 'a');			
		}
		
		numero += (int) (Math.random() * 10000 % 10000);
		
		cidade += (char) (Math.random() * 100 % 26 + 'A');
		
		for (int i = -3; i < Math.random() * 100 % 8; i++) {
			cidade += (char) (Math.random() * 100 % 26 + 'a');			
		}
		
		uf += (char) (Math.random() * 100 % 26 + 'A');
		uf += (char) (Math.random() * 100 % 26 + 'A');
	}
	
	void imprimeEndereco() {
		System.out.println(rua + " " + numero + ", " + cidade + " - " + uf);
	}
}
