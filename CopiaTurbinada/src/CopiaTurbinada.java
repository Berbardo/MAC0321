import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CopiaTurbinada {
	public static void main(String[] args) {
		String origem = "resources/origem.txt";
		String destino = "resources/destino.txt";
		
		EstrategiaCopia estrategiaCopia = defineOrigem(args);
		EstrategiaCola estrategiaCola = defineDestino(args);
		
		String copia = estrategiaCopia.copia();
		estrategiaCola.cola(copia);
	}
	
	private static EstrategiaCopia defineOrigem(String[] args) {
		EstrategiaCopia estrategiaCopia = null;
		String parametros = "";
		
		for (String parametro: args) {
			if (parametro.contains("-destino")) {
				break;
			} else if (parametro.contains("-origem")) {
				continue;
			}
			
			parametros += " " + parametro;
		}
		
		try {
			estrategiaCopia = retornaEstrategiaCopia(parametros);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado:");
			System.out.println(e);
		}
		
		return estrategiaCopia;
	}

	private static EstrategiaCopia retornaEstrategiaCopia(String parametros) throws FileNotFoundException {
		if (parametros.contains("-arquivo")) {
			parametros.replace("-arquivo ", "");
			
			String[] args = parametros.split(" ");
			String origem = args[args.length -1];

			EstrategiaCopia estrategiaCopia = new CopiaArquivo(new FileInputStream(origem));
			
			if (parametros.contains("-comprimido")) {
				estrategiaCopia = new Descompactador(estrategiaCopia);
			}
			
			if (parametros.contains("-criptografado")) {
				String senha = "123";
				try {
					String numeros[] = parametros.substring(parametros.indexOf("-senha")).split("\\D+");
					senha = numeros[1];					
				} catch(Exception e) {
					System.out.println("Senha nao encontrada");
				}
				estrategiaCopia = new Decodificador(estrategiaCopia, senha);
			}
			
			return estrategiaCopia;
		} else if (parametros.contains("-teclado")) {
			return new CopiaTeclado();
		} else {
			return null;
		}
	}

	private static EstrategiaCola defineDestino(String[] args) {
		EstrategiaCola estrategiaCola = null;
		String parametros = "";
		boolean flag = false;
		
		for (String parametro: args) {
			if (parametro.contains("-destino")) {
				flag = true;
				continue;
			}
			
			if (flag) {
				parametros += " " + parametro;
			}			
		}
		
		try {
			estrategiaCola = retornaEstrategiaCola(parametros);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return estrategiaCola;
	}
	
	private static EstrategiaCola retornaEstrategiaCola(String parametros) throws FileNotFoundException {
		if (parametros.contains("-arquivo")) {
			parametros.replace("-arquivo ", "");
			
			String[] args = parametros.split(" ");
			String destino = args[args.length -1];

			EstrategiaCola estrategiaCola = new ColaArquivo(new FileOutputStream(destino));
			
			if (parametros.contains("-comprimido")) {
				System.out.println("comprimido");
				estrategiaCola = new Compactador(estrategiaCola);
			}
			
			if (parametros.contains("-criptografado")) {
				String senha = "123";
				try {
					String numeros[] = parametros.substring(parametros.indexOf("-senha")).split("\\D+");
					senha = numeros[1];
				} catch(Exception e) {
					System.out.println("Senha nao encontrada");
				}
				estrategiaCola = new Codificador(estrategiaCola, senha);
			}
			
			return estrategiaCola;
		} else if (parametros.contains("-tela")) {
			return new ColaTela();
		} else {
			return null;
		}
	}
}
