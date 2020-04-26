import java.io.OutputStream;

public class ColaTela implements EstrategiaCola {

	@Override
	public void cola(String copia) {
		System.out.println(copia);
	}

	@Override
	public OutputStream recebeOutput() {
		return null;
	}

	@Override
	public void defineOutput(OutputStream output) {		
	}

}
