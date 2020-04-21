
abstract class CopiaDecorador implements EstrategiaCopia {
	private final EstrategiaCopia estrategiaCopia;
	final String origem;
	
	public CopiaDecorador(EstrategiaCopia estrategiaCopia) {
		this.estrategiaCopia = estrategiaCopia;
		this.origem = estrategiaCopia.recebeOrigem();
	}
	
	@Override
	public String copia() {
		return estrategiaCopia.copia();
	}

}
