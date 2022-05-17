package ar.unlam.cuentasbancarias;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Cuenta {

	protected Double saldo;
	protected List<Transaccion> transacciones;

	public Cuenta(Double saldo) {
		this.saldo = saldo;
		this.transacciones = new LinkedList<Transaccion>();
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void depositar(Double monto) {
		if(monto > 0) {
		this.saldo += monto;
		this.transacciones.add(new Transaccion (monto, TipoDeMotivos.DEPOSITO, new Date()));
		}
	}

	public void extraer(Double monto) {
		if(this.saldo >= monto && monto > 0) {
		this.saldo -= monto;
		this.transacciones.add(new Transaccion (monto, TipoDeMotivos.EXTRACCION, new Date()));
//		System.out.println(new Date());
		} 
		
	}

	public void transferir(Double monto, Cuenta cuentaDestino) {
		if(this.saldo >= monto && monto > 0) {
			this.saldo -= monto;
			cuentaDestino.depositar(monto);
			this.transacciones.add(new Transaccion (monto, TipoDeMotivos.TRANSFERENCIA, new Date()));
			} 
	}

	public List<Transaccion> getTransacciones() {
		return this.transacciones;
	}

}
