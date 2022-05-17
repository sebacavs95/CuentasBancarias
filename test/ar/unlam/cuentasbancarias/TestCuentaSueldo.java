package ar.unlam.cuentasbancarias;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaSueldo {

	@Test
	public void queSePuedaCrearUnaCuentaSueldo() {
		Double saldo = 0.0;
		
		CuentaSueldo cuentaSueldo = new CuentaSueldo(saldo);
		
		assertNotNull(cuentaSueldo);
	}
	
	@Test
	public void queSePuedaDepositarDinero() {
		Double saldo = 0.0;
		
		CuentaSueldo cuentaSueldo = new CuentaSueldo(saldo);
		
		Double monto = 100.0;
		
		Double ve = monto + cuentaSueldo.getSaldo();
		
		cuentaSueldo.depositar(monto);
		
		assertEquals(ve,cuentaSueldo.getSaldo(),0.01);
	}
	
	@Test
	public void queSePuedaExtraerDinero() {
		Double saldo = 200.0;
		
		CuentaSueldo cuentaSueldo = new CuentaSueldo(saldo);
		
		Double monto = 100.0;
		
		Double ve = cuentaSueldo.getSaldo() - monto;
		
		cuentaSueldo.extraer(monto);
		
		assertEquals(ve,cuentaSueldo.getSaldo(),0.01);
	}
	
	@Test
	public void queNoSePuedaExtraerDineroSiElSaldoEsMenorALaExtraccion() {
		Double saldo = 0.0;
		
		CuentaSueldo cuentaSueldo = new CuentaSueldo(saldo);
		
		Double monto = 100.0;
		
		Double ve = cuentaSueldo.getSaldo();
		
		cuentaSueldo.extraer(monto);
		
		assertEquals(ve,cuentaSueldo.getSaldo(),0.01);
	}

}
