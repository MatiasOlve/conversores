package conversor.modelo;

public abstract class Convertible {

	private double factorConversion;

	public Convertible(double factorConversion) {
		super();
		this.factorConversion = factorConversion;
	}

	public double getFactorConversion() {
		return this.factorConversion;
	}

	public void setFactorConversion(double factorConversion) {
		this.factorConversion = factorConversion;
	}
}
