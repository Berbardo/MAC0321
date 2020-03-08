
public class Endereco {
	private String logradouro = "";
	private String numero = "";
	private String cidade = "";
	private String uf = "";
	
	Endereco() {
		this.gerarEndereco();
	}
	
	private void gerarEndereco() {
		int tipo_logradouro = (int) (Math.random() * 3);
		if (tipo_logradouro == 2) {
			logradouro = "Rua ";
		}
		else if (tipo_logradouro == 1){
			logradouro = "Avenida ";
		}
		else {
			logradouro = "Alameda ";
		}
		
		logradouro += (char) (Math.random() * 100 % 26 + 'A');
		
		for (int i = 0; i < Math.random() * 100 % 8; i++) {
			logradouro += (char) (Math.random() * 100 % 26 + 'a');			
		}
		
		numero += (int) (Math.random() * 10000 % 10000);
		
		cidade += (char) (Math.random() * 100 % 26 + 'A');
		
		for (int i = -3; i < Math.random() * 100 % 8; i++) {
			cidade += (char) (Math.random() * 100 % 26 + 'a');			
		}
		
		uf += (char) (Math.random() * 100 % 26 + 'A');
		uf += (char) (Math.random() * 100 % 26 + 'A');
	}
	
	public void imprimeEndereco() {
		System.out.println(logradouro + " " + numero + ", " + cidade + " - " + uf);
	}
}
