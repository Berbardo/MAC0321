import java.io.InputStream;
import java.util.Scanner;

public class CopiaTeclado implements EstrategiaCopia {
	InputStream input = null;
	
	@Override
	public String copia() {
		Scanner teclado = new Scanner(System.in);
		String copia = teclado.nextLine();
		teclado.close();
		return copia;
	}

	@Override
	public InputStream recebeInput() {
		return this.input;
	}

	@Override
	public void defineInput(InputStream input) {
		this.input = input;
	}

}
