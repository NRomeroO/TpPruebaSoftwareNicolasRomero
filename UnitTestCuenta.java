package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Cuenta;

class UnitTestCuenta {

	private Cuenta cuenta;
	private Vector movimientos;

	@BeforeEach
	public void setUp() throws Exception
	{
		cuenta = new Cuenta("20356298-33", "Garcia Enrique");
		movimientos=null;
	}
	
	@Test
	public void testIngresarSaldoNegativo() {
		double saldoAnterior = cuenta.getSaldo();
		try {
			cuenta.ingresar(-1000);
			assertEquals(cuenta.getSaldo(),saldoAnterior-1000.0,"Paso: No permite ingresar saldo en negativo.");
			
		}
		catch (Exception e) 
		{
			fail("No deberia haber fallado");
		}
	}
	
	@Test
	public void testRetirarConSaldoNegativo() {
		double saldoAnterior = cuenta.getSaldo();
		try {
			cuenta.retirar(-1000);
			assertEquals(cuenta.getSaldo(),saldoAnterior-1000.0,"Paso: No permite retirar saldo en negativo.");
			
		}
		catch (Exception e) 
		{
			fail("No deberia haber fallado");
		}
	}

}
