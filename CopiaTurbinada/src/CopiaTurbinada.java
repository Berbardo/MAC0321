
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
		EstrategiaCopia estrategiaCopia;
		String parametros = "";
		
		for (String parametro: args) {
			if (parametro.contains("-destino")) {
				break;
			} else if (parametro.contains("-origem")) {
				continue;
			}
			
			parametros += " " + parametro;
		}
		
		estrategiaCopia = retornaEstrategiaCopia(parametros);
		
		return estrategiaCopia;
	}

	private static EstrategiaCopia retornaEstrategiaCopia(String parametros) {
		if (parametros.contains("-arquivo")) {
			parametros.replace("-arquivo ", "");
			
			String[] args = parametros.split(" ");
			String origem = args[args.length -1];
			try {
				origem = origem.substring(0, origem.indexOf('.'));				
			} catch(Exception e) {
				System.out.println("Arquivo nao encontrado");
			}
			EstrategiaCopia estrategiaCopia = new CopiaArquivo(origem);
			
			if (parametros.contains("-comprimido")) {
				estrategiaCopia = new Descompactador(estrategiaCopia);
			}
			
			if (parametros.contains("-criptografado")) {
				try {
					String numeros[] = parametros.substring(parametros.indexOf("-senha")).split("\\D+");
					int senha = Integer.parseInt(numeros[1]);					
				} catch(Exception e) {
					System.out.println("Senha nao encontrada");
				}
//				estrategiaCopia = new Decodificador(estrategiaCopia, senha);
			}
			
			return estrategiaCopia;
		} else if (parametros.contains("-teclado")) {
			return new CopiaTeclado();
		} else {
			return null;
		}
	}

	private static EstrategiaCola defineDestino(String[] args) {
		EstrategiaCola estrategiaCola;
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
		
		estrategiaCola = retornaEstrategiaCola(parametros);
		
		return estrategiaCola;
	}
	
	private static EstrategiaCola retornaEstrategiaCola(String parametros) {
		if (parametros.contains("-arquivo")) {
			parametros.replace("-arquivo ", "");
			
			String[] args = parametros.split(" ");
			String destino = args[args.length -1];
			try {
				destino = destino.substring(0, destino.indexOf('.'));				
			} catch(Exception e) {
				System.out.println("Arquivo nao encontrado");
			}
			EstrategiaCola estrategiaCola = new ColaArquivo(destino);
			
			if (parametros.contains("-comprimido")) {
				System.out.println("comprimido");
	//			estrategiaCola = new Compressor(estrategiaCola);
			}
			
			if (parametros.contains("-criptografado")) {
				try {
					String numeros[] = parametros.substring(parametros.indexOf("-senha")).split("\\D+");
					int senha = Integer.parseInt(numeros[1]);		
				} catch(Exception e) {
					System.out.println("Senha nao encontrada");
				}
	//			estrategiaCola = new Codificador(estrategiaCola, senha);
			}
			
			return estrategiaCola;
		} else if (parametros.contains("-tela")) {
			return new ColaTela();
		} else {
			return null;
		}
	}
}
