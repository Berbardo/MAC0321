
public class CopiaTurbinada {
	public static void main(String[] args) {
		String origem = "resources/origem.txt";
		String destino = "resources/destino.txt";
		
		EstrategiaCopia estrategiaCopia = defineOrigem(args);
		EstrategiaCola estrategiaCola = new ColaArquivo(destino);
		
		String copia = estrategiaCopia.copia();
		estrategiaCola.cola(copia);
		
		System.out.println(copia);
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
		
		System.out.println(parametros);
		
		estrategiaCopia = retornaEstrategiaCopia(parametros);
		
		return estrategiaCopia;
	}

	private static EstrategiaCopia retornaEstrategiaCopia(String parametros) {
		if (parametros.contains("-arquivo")) {
			parametros.replace("-arquivo ", "");
			
			String[] args = parametros.split(" ");
			String origem = args[args.length -1];
			origem = origem.substring(0, origem.indexOf('.'));
			EstrategiaCopia estrategiaCopia = new CopiaArquivo(origem);
			
			if (parametros.contains("-comprimido")) {
				System.out.println("comprimido");
//				estrategiaCopia = new Descompressor(estrategiaCopia);
			}
			
			if (parametros.contains("-criptografado")) {
				String numeros[] = parametros.substring(parametros.indexOf("-senha")).split("\\D+");
				int senha = Integer.parseInt(numeros[0]);
				System.out.println("senha");
//				estrategiaCopia = new Decodificador(estrategiaCopia, senha);
			}
			
			return estrategiaCopia;
		} else if (parametros.contains("-teclado")) {
			
		} else {
			
		}
		return null;
	}
}
