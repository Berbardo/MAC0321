
public class Maximum {
		
	public int max(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int i = 0;
		int max = array[i++];
		while (i < array.length) {
			if (array[i] > max) {
				max = array[i];
			}
			i++;
		}
		return max;
	}
}
