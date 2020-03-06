
public class ConversorFarenheitCelsius {
	public static void main(String args[]) {
		System.out.println("Conversão iniciada!");
		ConversorFarenheitCelsius conversor = new ConversorFarenheitCelsius();
		if (args[1].equals("Celsius")) {
			@SuppressWarnings("unused")
			float FtoC = conversor.conversaoFarenheitCelsius(Float.valueOf(args[0]));
		}
		else {
			@SuppressWarnings("unused")
			float CtoF = conversor.conversaoCelsiusFarenheit(Float.valueOf(args[0]));
		}
	}
	
	float conversaoFarenheitCelsius(float farenheit) {
		float celsius = 5 * (farenheit - 32)/9;
		System.out.println(farenheit + "°F em Celsius é " + celsius + "°C.");
		return celsius;
	}
	
	float conversaoCelsiusFarenheit(float celsius) {
		float farenheit = (9 * celsius) / 5 + 32;
		System.out.println(celsius + "°C em Farenheit é " + farenheit + "°F.");
		return farenheit;
	}
}
