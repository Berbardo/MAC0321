
public class Animal {
	int peso;
	Animal() {
		System.out.println("Eu respiro e me mexo");
	}
	
	Animal(int peso) {
		this.peso = peso;
		System.out.println("Eu respiro e me mexo e peso " + peso + " kg");
	}
}
