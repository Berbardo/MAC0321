import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ColaArquivo implements EstrategiaCola {
	private String destino = "";
	
	ColaArquivo(String destino) {
		this.destino = destino;
	}
	
	@Override
	public void cola(String copia) {
		
		try {
			BufferedOutputStream output = null;
			
			try {
				output = new BufferedOutputStream(new FileOutputStream(destino));
				
				output.write(copia.getBytes());
			} finally {
				if (output != null) {
					output.close();					
				}
			}
		} catch (IOException e) {
			// TODO
			System.out.println(e);
		}

	}

}
