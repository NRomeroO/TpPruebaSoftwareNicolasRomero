package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Credito;
import modelo.Cuenta;

public class UnitTestCredito {
	private Date fecha;
	private Credito credito;
	private Cuenta unaCuenta;
	
	@BeforeEach
	public void setUp() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2020-09-15";
		dateInString = "2020-09-15";
		try {
			fecha = sdf.parse(dateInString);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		credito = new Credito("06-456213-33","Alfredo Hernandez",fecha,5000.00);
		unaCuenta=new Cuenta("06-456213-33","Alfredo Hernandez");
	}
	
	@Test
	public void testNoPermitePagoConLimiteInsuficiente() throws Exception {
		double saldoAnterior = credito.getCreditoDisponible();
		try {
			credito.pagoEnEstablecimiento("Gimnasio",6000.00);
			
		} catch (Exception e) {
			
			assertTrue(saldoAnterior==credito.getCreditoDisponible(),"Fallo - Permitio pagar sin limite suficiente");
		}
	}
	
	@Test
	public void testNoPermitePagoConSaldoNegativo() throws Exception {
		double saldoAnterior = credito.getCreditoDisponible();
		try {
			credito.pagoEnEstablecimiento("Gimnasio",-6000.00);
			
		} catch (Exception e) {
			
			assertTrue(saldoAnterior==credito.getCreditoDisponible(),"Fallo - Permitio pagar con saldo negativo");
		}
	}
	
	@Test
	public void testNoPermitePagoConImporteCero() throws Exception {
		double saldoAnterior = credito.getCreditoDisponible();
		try {
			credito.pagoEnEstablecimiento("Gimnasio",0);
			
		} catch (Exception e) {
			
			assertTrue(saldoAnterior==credito.getCreditoDisponible(),"Fallo - Permitio pagar con saimporte en 0");
		}
	}


}
