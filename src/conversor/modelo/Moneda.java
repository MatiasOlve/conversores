package conversor.modelo;

public class Moneda extends Convertible{

	public Moneda(double factorConversion) {
		super(factorConversion);
		// TODO Auto-generated constructor stub
	}

	public double MonedaAPeso(double valor) {
		// TODO Auto-generated method stub
		return valor * this.getFactorConversion();
	}

	public double PesoAMoneda(double valor) {
		// TODO Auto-generated method stub
		return valor / this.getFactorConversion();
	}
	
}
