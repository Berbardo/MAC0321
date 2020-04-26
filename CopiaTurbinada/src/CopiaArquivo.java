import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopiaArquivo implements EstrategiaCopia {
	private InputStream input = null;
	
	CopiaArquivo(InputStream input) {
		this.input = input;
	}
	
	@Override
	public String copia() {
		String copia = "";
		
		try {		
			BufferedInputStream input = null;
			
			try {
				input = new BufferedInputStream(this.input);
				
				while(input.available() > 0){             	
		              copia += (char) input.read();
		          }
				
			} finally {
				if (input != null) {
					input.close();
				}
			}
		} catch(IOException e) {
			System.out.println("Arquivo nao encontrado");
			System.out.println(e);
		}

		return copia;
	}

	@Override
	public InputStream recebeInput() {
		return this.input;
	}
	
	public void defineInput(InputStream input) {
		this.input = input;
	}

}
