import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class Codificador extends ColaDecorador {
	private SecretKey senha = null;
	private byte[] salt = "ABCDEFGH".getBytes();

	public Codificador(EstrategiaCola estrategiaCola, String senha) {
		super(estrategiaCola);		
		try {
			PBEKeySpec pbeKeySpec = new PBEKeySpec(senha.toCharArray());
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndTripleDES");
			this.senha = secretKeyFactory.generateSecret(pbeKeySpec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	@Override
	public void cola(String copia) {
		String copiaCriptografada = criptografa(copia);
		super.cola(copiaCriptografada);
	}
	
	public String criptografa(String texto) {
		String criptografado = "";
	    try {			
	    	byte[] bytes = texto.getBytes("UTF-8");
	    	Cipher cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
			cipher.init(Cipher.ENCRYPT_MODE, senha, new PBEParameterSpec(salt, 100));
			byte[] cipherText = cipher.doFinal(bytes);
			criptografado = Base64.getMimeEncoder().encodeToString(cipherText);
	    } catch(Exception ex) {
	    	ex.printStackTrace();
		}
	    
	    return criptografado;
   }
	
}
