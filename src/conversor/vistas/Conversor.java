package conversor.vistas;

import java.util.ArrayList;
import java.util.List;

import conversor.modelo.Moneda;

public abstract class Conversor {
	
	private static List<Moneda> monedas = new ArrayList<>();

	public static void inicializacion() {
		Moneda dolar = new Moneda(174.25);
		Moneda euro = new Moneda(184.91);
		Moneda libra = new Moneda(210.99);
		Moneda yen = new Moneda(1.32);
		Moneda won = new Moneda(0.14);
		
		monedas.add(dolar);
		monedas.add(euro);
		monedas.add(libra);
		monedas.add(yen);
		monedas.add(won);
	}

	public static double convertir(int index, double valor) {
		double resultado;
		inicializacion();
		
		if(index < 5) {
			Moneda cambio = monedas.get(index);
			resultado = cambio.PesoAMoneda(valor);
		}
		
		else {
			index = index % 5;
			Moneda cambio = monedas.get(index);
			resultado = cambio.MonedaAPeso(valor);
		}
		
		return resultado;
	}
	
	public static double convertirTemperatura(String tipo, double temperatura) {
		switch(tipo) {
			case "Celsius a Farenheit":
				temperatura = temperatura * 9/5 + 32;
				break;
			
			case "Farenheit a Celsius":
				temperatura = (temperatura -32) * 5/9;
				break;
				
			case "Celsius a Kelvin":
				temperatura += 273;
				break;
				
			case "Kelvin a Celsius":
				temperatura -= 273;
				break;
				
			case "Farenheit a Kelvin":
				temperatura = (temperatura -32) * 5/9 + 273;
				break;
				
			case "Kelvin a Farenheit":
				temperatura = (temperatura - 273) * 9/5 + 32;
				break;
				
			default:
				break;
		}
		return temperatura;
	}
}
