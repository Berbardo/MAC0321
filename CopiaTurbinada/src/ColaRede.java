import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ColaRede implements EstrategiaCola {
	private Socket outputSocket = null;
	private PrintWriter output = null;
	
	ColaRede(String hostName, int portNumber) {
		try {
			outputSocket = new Socket(hostName, portNumber);
			output = new PrintWriter(outputSocket.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("Erro na Conexao de Rede");
			System.out.println(e);
		}
	}
	
	@Override
	public void cola(String copia) {
		output.println(copia);
		
		try {
			outputSocket.close();
			output.close();
		} catch (IOException e) {
			System.out.println("Erro ao fechar o soquete de saida");
			System.out.println(e);
		}
		
		System.out.println("Conexao feita com sucesso");
	}

	@Override
	public OutputStream recebeOutput() {
		return null;
	}

	@Override
	public void defineOutput(OutputStream output) {
	}

}
