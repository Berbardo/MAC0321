
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
		Animal totó = new Cachorro();
		Cachorro rex = new Cachorro(12000);
				
//		totó.lata();
		rex.lata();
		
		Cachorro totó_catioro = (Cachorro) totó;
		
		totó_catioro.lata();
	}
	
	void lata() {
		System.out.println("Au au!");
	}
}
