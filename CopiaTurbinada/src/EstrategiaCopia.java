import java.io.InputStream;

public interface EstrategiaCopia {

	String copia();
	
	InputStream recebeInput();
	
	void defineInput(InputStream input);
}
