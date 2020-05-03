import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class CopiaRede implements EstrategiaCopia {
	private ServerSocket serverSocket = null;
	private Socket clientSocket = null;
	private BufferedReader input = null;

	CopiaRede(int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
			clientSocket = serverSocket.accept();
			input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			System.out.println("Erro na Conexao de Rede");
			System.out.println(e);
		}
	}
	
	@Override
	public String copia() {
		String inputLine = null;
		String copia = "";
				
		try {
			while ((inputLine = input.readLine()) != null) {
				copia += inputLine;
				copia += "\n";
			}
		} catch (IOException e) {
			System.out.println("Erro na Conexao de Rede");
			System.out.println(e);
		}
		try {
			serverSocket.close();
			clientSocket.close();
			input.close();
		} catch (IOException e) {
			System.out.println("Nao foi possivel concluir a conexao");
			System.out.println(e);
		}
		
		return copia;
	}

	@Override
	public InputStream recebeInput() {
		return null;
	}

	@Override
	public void defineInput(InputStream input) {
	}

}
