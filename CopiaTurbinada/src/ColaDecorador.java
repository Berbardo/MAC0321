import java.io.OutputStream;

public class ColaDecorador implements EstrategiaCola {
	private final EstrategiaCola estrategiaCola;
	
	public ColaDecorador(EstrategiaCola estrategiaCola) {
		this.estrategiaCola = estrategiaCola;
	}
	
	@Override
	public void cola(String copia) {
		this.estrategiaCola.cola(copia);
	}

	@Override
	public OutputStream recebeOutput() {
		return this.estrategiaCola.recebeOutput();
	}

	@Override
	public void defineOutput(OutputStream output) {
		this.estrategiaCola.defineOutput(output);
	}

}
