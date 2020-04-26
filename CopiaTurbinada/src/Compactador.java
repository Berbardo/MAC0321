import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compactador extends ColaDecorador {
	private OutputStream output = null;
	
	public Compactador(EstrategiaCola estrategiaCola) {
		super(estrategiaCola);
		this.output = new ZipOutputStream(super.recebeOutput());
	}

	@Override
	public void cola(String copia) {
		this.compacta(copia);
	}
	
	private void compacta(String copia) {
		ZipOutputStream output = new ZipOutputStream(super.recebeOutput());
		try {
			output.putNextEntry(new ZipEntry("arquivo.txt"));
			output.write(copia.getBytes());
			output.closeEntry();
			output.close();
		} catch (IOException e) {
			System.out.println("Erro na compactacao do arquivo");
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
