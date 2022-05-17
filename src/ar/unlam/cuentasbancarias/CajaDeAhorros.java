package ar.unlam.cuentasbancarias;

public class CajaDeAhorros extends Cuenta{
	
	private Integer limiteDeExtracciones;
	private Integer contadorDeExtracciones;
	private Double adicionalPorExtraccion;

	public CajaDeAhorros(Double saldo) {
		super(saldo);
		this.limiteDeExtracciones = 5;
		this.contadorDeExtracciones = 0;
		this.adicionalPorExtraccion = 6.0;
	}
	
	@Override
	public void extraer(Double monto) {
		if(contadorDeExtracciones > limiteDeExtracciones) {
			if(this.saldo >= monto + adicionalPorExtraccion) {
				this.saldo -= monto + adicionalPorExtraccion;
				}
			} else {
				if(this.saldo >= monto) {
				this.saldo -= monto;
				contadorDeExtracciones++;
				}
			}
	}

}
