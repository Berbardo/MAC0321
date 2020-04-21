import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class CopiaArquivo implements EstrategiaCopia {
	private String origem = "";
	private String extensao = ".txt";
	
	CopiaArquivo(String origem) {
		this.origem = origem;
	}
	
	@Override
	public String copia() {
		String copia = "";
		
		try {		
			BufferedInputStream input = null;
			
			try {
				input = new BufferedInputStream(new FileInputStream(origem + extensao));
				
				while(input.available() > 0){             	
		              copia += (char) input.read();
		          }
				
			} finally {
				if (input != null) {
					input.close();
				}
			}
		} catch(IOException e) {
			// TODO
			System.out.println(e);
		}

		return copia;
	}

	@Override
	public String recebeOrigem() {
		return this.origem;
	}

}
