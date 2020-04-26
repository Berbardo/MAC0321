import java.io.OutputStream;

public interface EstrategiaCola {
	
	void cola(String copia);
	
	OutputStream recebeOutput();
	
	void defineOutput(OutputStream output);
}
