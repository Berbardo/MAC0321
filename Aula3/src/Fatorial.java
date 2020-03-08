
public class Fatorial {
	static int fatorial(int xn) {
		if (xn < 0 || xn > 12) {
			return -1;
		}
		int fat = 1;
		for (int i = xn; i > 0; i--) {
			fat *= i;
		}
		return fat;
	}
}
