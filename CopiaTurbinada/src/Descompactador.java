import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Descompactador extends CopiaDecorador{
	private final String extensao = ".zip";
	
	public Descompactador(EstrategiaCopia estrategiaCopia) {
		super(estrategiaCopia);
	}

	@Override
	public String copia() {
		this.descompacta();
		return super.copia();
	}
	
	private void descompacta() {
		try {		
			ZipInputStream input = null;
			
			try {
				input = new ZipInputStream(new FileInputStream(super.origem + this.extensao));
				
				ZipEntry zipEntry = input.getNextEntry();
				byte[] buffer = new byte[1024];
				
				while (zipEntry != null) {
					FileOutputStream output = new FileOutputStream(zipEntry.getName());
		            int len;
		            while ((len = input.read(buffer)) > 0) {
		            	output.write(buffer, 0, len);
		            }
		            output.close();
		            zipEntry = input.getNextEntry();
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
	}

	@Override
	public String recebeOrigem() {
		return this.origem;
	}
}
