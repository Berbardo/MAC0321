
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class Decodificador extends CopiaDecorador {
	private SecretKey senha = null;
	private byte[] salt = "ABCDEFGH".getBytes();

	public Decodificador(EstrategiaCopia estrategiaCopia, String senha) {
		super(estrategiaCopia);
		PBEKeySpec pbeKeySpec = new PBEKeySpec(senha.toCharArray());
		
		try {
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndTripleDES");
			this.senha = secretKeyFactory.generateSecret(pbeKeySpec);
		} catch (Exception e) {
			System.out.println("Erro na criacao da senha");
			System.out.println(e);
		}
	}

	@Override
	public String copia() {
		String copia = super.copia();
		return this.decodifica(copia);
	}
	
	private String decodifica(String texto) {
		String descriptografado = "";
		Cipher cipher;
		try {			
			cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
			cipher.init(Cipher.DECRYPT_MODE, senha, new PBEParameterSpec(salt, 100));
			
			byte[] bytes = Base64.getMimeDecoder().decode(texto);
			byte[] cipherText = cipher.doFinal(bytes);
			descriptografado = new String(cipherText, "UTF8");
		} catch (Exception e) {
			System.out.println("Erro na decodificacao do arquivo");
			System.out.println(e);
		}
		return descriptografado;
	}
}
