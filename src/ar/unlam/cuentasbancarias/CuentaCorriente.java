package ar.unlam.cuentasbancarias;

public class CuentaCorriente extends Cuenta{

	private Double limiteCubierto;

	public CuentaCorriente(Double saldo) {
		super(saldo);
		this.limiteCubierto = 200.00;
	}
	
	@Override 
	public void extraer(Double monto) {
		if(this.saldo >= monto) {
		this.saldo -= monto;
		} else {
			if(monto < this.saldo) {
				
			}
			
		}
	}
}
