import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Descompactador extends CopiaDecorador {
	private InputStream input = null;
	
	public Descompactador(EstrategiaCopia estrategiaCopia) {
		super(estrategiaCopia);
		this.input = super.recebeInput();
	}

	@Override
	public String copia() {
		this.descompacta();
		return super.copia();
	}
	
	private void descompacta() {
		byte[] bytes = null;
		
		try {		
			ZipInputStream input = null;
			
			try {
				input = new ZipInputStream(this.input);
				
				ZipEntry zipEntry;
				byte[] buffer = new byte[1024];
				
				while ((zipEntry = input.getNextEntry()) != null) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
		            int len;
		            while ((len = input.read(buffer)) > 0) {
		            	baos.write(buffer, 0, len);
		            }
		            bytes = baos.toByteArray();
		            baos.close();
				}
				input.closeEntry();
			} finally {
				if (input != null) {
					input.close();
				}	
			}
		} catch(IOException e) {
			System.out.println("Erro na descompactacao");
		}
		
		super.defineInput(new ByteArrayInputStream(bytes));
	}

	@Override
	public InputStream recebeInput() {
		return this.input;
	}

	@Override
	public void defineInput(InputStream input) {
		this.input = input;		
	}

}
