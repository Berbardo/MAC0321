import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ColaArquivo implements EstrategiaCola {
	private OutputStream output = null;
	
	ColaArquivo(OutputStream output) {
		this.output = new BufferedOutputStream(output);
	}
	
	@Override
	public void cola(String copia) {
		
		try {
			OutputStream output = null;
			
			try {
				output = this.output;
				
				output.write(copia.getBytes());
			} finally {
				if (output != null) {
					output.close();					
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	@Override
	public OutputStream recebeOutput() {
		return this.output;
	}

	@Override
	public void defineOutput(OutputStream output) {
		this.output = output;	
	}

}
