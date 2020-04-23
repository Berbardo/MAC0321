import java.io.InputStream;

abstract class CopiaDecorador implements EstrategiaCopia {
	private final EstrategiaCopia estrategiaCopia;
	
	public CopiaDecorador(EstrategiaCopia estrategiaCopia) {
		this.estrategiaCopia = estrategiaCopia;
	}
	
	@Override
	public String copia() {
		return estrategiaCopia.copia();
	}
	
	@Override
	public InputStream recebeInput() {
		return this.estrategiaCopia.recebeInput();
	}
	
	@Override
	public void defineInput(InputStream input) {
		this.estrategiaCopia.defineInput(input);
	}

}
