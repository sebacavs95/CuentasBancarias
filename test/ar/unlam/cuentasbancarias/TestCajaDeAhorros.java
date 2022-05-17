package ar.unlam.cuentasbancarias;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCajaDeAhorros {

	@Test
	public void queSePuedaCrearUnaCajaDeAhorros() {
		Double saldo = 0.0;
		
		CajaDeAhorros cajaDeAhorros = new CajaDeAhorros(saldo);
		
		assertNotNull(cajaDeAhorros);
	}
	
	@Test
	public void queSePuedaDepositarDinero() {
		Double saldo = 0.0;
		
		CajaDeAhorros cajaDeAhorros = new CajaDeAhorros(saldo);
		
		Double monto = 100.0;
		
		Double ve = monto + cajaDeAhorros.getSaldo();
		
		cajaDeAhorros.depositar(monto);
		
		assertEquals(ve,cajaDeAhorros.getSaldo(),0.01);
	}
	
	@Test
	public void queSePuedaExtraerDinero() {
		Double saldo = 200.0;
		
		CajaDeAhorros cajaDeAhorros = new CajaDeAhorros(saldo);
		
		Double monto = 100.0;
		
		Double ve = cajaDeAhorros.getSaldo() - monto;
		
		cajaDeAhorros.extraer(monto);
		
		assertEquals(ve,cajaDeAhorros.getSaldo(),0.01);
	}
	
	@Test
	public void queNoSePuedaExtraerDineroSiElSaldoEsMenorALaExtraccion() {
		Double saldo = 0.0;
		
		CajaDeAhorros cajaDeAhorros = new CajaDeAhorros(saldo);
		
		Double monto = 100.0;
		
		Double ve = cajaDeAhorros.getSaldo();
		
		cajaDeAhorros.extraer(monto);
		
		assertEquals(ve,cajaDeAhorros.getSaldo(),0.01);
	}
	

}
