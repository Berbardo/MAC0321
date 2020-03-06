
public class ClasseLegal {
	String nome = "Sem nome";
	String descricao = "Sem descrição.";
	boolean legal = false;
	int quao_legal = 5;
	
	public static void main(String args[]) {
		System.out.println("Legal aferition started!");
				
		System.out.println("Argumento 1: " + args[0]);
		System.out.println("Argumento 2: " + args[1]);
		
		ClasseLegal caneca = new ClasseLegal();
		caneca.legal = args[0].equals("true");
		caneca.quao_legal = 7;
		caneca.nome = "Caneca";
		caneca.descricao = "Apenas uma caneca.";
		
		caneca.quemSouEu();
		caneca.legal();
	}
	
	void quemSouEu() {
		System.out.println(descricao);
	}
	
	void legal() {
		if (legal) {
			System.out.println(nome + " é legal :D");
		}
		else {
			System.out.println(nome + " não é legal >:C");
		}
	}
}
