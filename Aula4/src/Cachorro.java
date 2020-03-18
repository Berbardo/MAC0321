
public class Cachorro extends AnimalVertebrado{
	Cachorro() {
		super();
		System.out.println("Eu lato");
	}
	
	Cachorro(int peso) {
		super(peso);
		System.out.println("Eu lato");
	}
	
	public static void main(String args[]) {
		Animal toto = new Cachorro();
		Cachorro rex = new Cachorro(12000);
				
//		toto.lata();
		rex.lata();
		
		Cachorro toto_catioro = (Cachorro) toto;
		
		toto_catioro.lata();
	}
	
	void lata() {
		System.out.println("Au au!");
	}
}
