package ar.unlam.cuentasbancarias;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuenta {

	@Test
	public void queSePuedaCrearUnaCuentaBancaria() {
		Double saldo = 0.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		assertNotNull(cuentaBancaria);
	}
	
	@Test
	public void queSePuedaDepositarDinero() {
		Double saldo = 0.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Double monto = 100.0;
		Double ve = monto + cuentaBancaria.getSaldo();
		cuentaBancaria.depositar(monto);
		assertEquals(ve,cuentaBancaria.getSaldo(),0.01);
	}
	
	@Test
	public void queSePuedaExtraerDinero() {
		Double saldo = 0.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Double monto = 100.0;
		Double extraccion = 50.0;
		cuentaBancaria.depositar(monto);
		Double ve = cuentaBancaria.getSaldo() - extraccion;
		cuentaBancaria.extraer(extraccion);
		assertEquals(ve,cuentaBancaria.getSaldo(),0.01);
	}
	
	@Test
	public void queNoSePuedaExtraerDineroSiElSaldoEsMenorALaExtraccion() {
		Double saldo = 0.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Double monto = 100.0;
		Double extraccion = 200.0;
		cuentaBancaria.depositar(monto);
		Double ve = monto;
		cuentaBancaria.extraer(extraccion);
		assertEquals(ve,cuentaBancaria.getSaldo(),0.01);
	}
	
	@Test
	public void queNoSePuedaDepositarDineroNegativo() {
		Double saldo = 0.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Double monto = -100.0;
		Double ve = cuentaBancaria.getSaldo();
		cuentaBancaria.depositar(monto);
		assertEquals(ve,cuentaBancaria.getSaldo(),0.01);
	}
	
	@Test
	public void queNoSePuedaExtraerDineroNegativo() {
		Double saldo = 0.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Double monto = 100.0;
		cuentaBancaria.depositar(monto);
		Double extraccion = -50.0;
		cuentaBancaria.extraer(extraccion);
		Double ve = cuentaBancaria.getSaldo();
		assertEquals(ve,cuentaBancaria.getSaldo(),0.01);
	}
	
	@Test
	public void queSePuedaTransferirDineroDeUnaCuentaAOtra() {
		Double saldo = 0.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Cuenta cuentaDestino = new Cuenta(saldo);
		Double monto = 100.0;
		cuentaBancaria.depositar(monto);
		cuentaBancaria.transferir(monto, cuentaDestino);
		Double ve = cuentaDestino.getSaldo();
		assertEquals(ve,cuentaDestino.getSaldo(),0.01);
	}
	
	@Test
	public void queNoSePuedaTransferirDineroNegativoDeUnaCuentaAOtra() {
		Double saldo = 100.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Cuenta cuentaDestino = new Cuenta(saldo);
		Double monto = -100.0;
		cuentaBancaria.transferir(monto, cuentaDestino);
		Double ve = cuentaDestino.getSaldo();
		assertEquals(ve,cuentaDestino.getSaldo(),0.01);
	}
	
	@Test
	public void queNoSePuedaTransferirDineroDeUnaCuentaAOtraSiElSaldoEsInsuficiente() {
		Double saldo = 100.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Cuenta cuentaDestino = new Cuenta(saldo);
		Double monto = 150.0;
		cuentaBancaria.transferir(monto, cuentaDestino);
		Double ve = cuentaDestino.getSaldo();
		assertEquals(ve,cuentaDestino.getSaldo(),0.01);
	}
	
	@Test
	public void queSeRegistrenTransaccionesPorDepositarDinero() {
		Double saldo = 0.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Double monto = 100.0;
		cuentaBancaria.depositar(monto);
		Integer vo = cuentaBancaria.getTransacciones().size();
		Integer ve = 1;
		
		assertEquals(ve,vo);
	}
	
	@Test
	public void queSeRegistrenTransaccionesPorExtraerDinero() {
		Double saldo = 0.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Double monto = 100.0;
		cuentaBancaria.depositar(monto);
		cuentaBancaria.depositar(monto);
		cuentaBancaria.extraer(monto);
		Integer vo = cuentaBancaria.getTransacciones().size();
		Integer ve = 3;
		
		assertEquals(ve,vo);
	}
	
	@Test
	public void queSeRegistrenTransaccionesPorTransferirDineroDeUnaCuentaALaOtra() {
		Double saldo = 100.0;
		Cuenta cuentaBancaria = new Cuenta(saldo);
		Cuenta cuentaDestino = new Cuenta(saldo);
		Double monto = 100.0;
		cuentaBancaria.transferir(monto, cuentaDestino);
		Integer vo = cuentaBancaria.getTransacciones().size();
		Integer ve = 1;
		
		assertEquals(ve,vo);
	
	}
}
