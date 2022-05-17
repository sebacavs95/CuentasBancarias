package ar.unlam.cuentasbancarias;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaCorriente {

	@Test
	public void queSePuedaCrearUnaCuentaCorriente() {
		Double saldo = 0.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(saldo);
		
		assertNotNull(cuentaCorriente);
	}
	
	@Test
	public void queSePuedaDepositarDinero() {
		Double saldo = 0.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(saldo);
		
		Double monto = 100.0;
		
		Double ve = monto + cuentaCorriente.getSaldo();
		
		cuentaCorriente.depositar(monto);
		
		assertEquals(ve,cuentaCorriente.getSaldo(),0.01);
	}
	
	@Test
	public void queSePuedaExtraerDinero() {
		Double saldo = 200.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(saldo);
		
		Double monto = 100.0;
		
		Double ve = cuentaCorriente.getSaldo() - monto;
		
		cuentaCorriente.extraer(monto);
		
		assertEquals(ve,cuentaCorriente.getSaldo(),0.01);
	}
	
	@Test
	public void queSePuedaExtraerDineroConPrestamo() {
		Double saldo = 100.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(saldo);
		
		Double monto = 200.0;
		
		Double ve = -105.0;
		
		cuentaCorriente.extraer(monto);
		
		assertEquals(ve,cuentaCorriente.getSaldo(),0.01);
	}
	
	@Test
	public void queNoSePuedaExtraerDineroConPrestamoMayorAlLimite() {
		Double saldo = 100.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(saldo);
		
		Double monto = 200.0;
		
		Double ve = -105.0;
		
		cuentaCorriente.extraer(monto);
		
		assertEquals(ve,cuentaCorriente.getSaldo(),0.01);
	}


}
