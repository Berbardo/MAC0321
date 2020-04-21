import java.util.Scanner;

public class CopiaTeclado implements EstrategiaCopia {

	@Override
	public String copia() {
		Scanner teclado = new Scanner(System.in);
		String copia = teclado.nextLine();
		teclado.close();
		return copia;
	}

	@Override
	public String recebeOrigem() {
		return null;
	}

}
