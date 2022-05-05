package itera.test.step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import itera.test.page.*;
import itera.test.util.GeneralUtil;
import itera.test.util.PageObjectUtil;

public class RealizarPagoStep {

@Steps
private ConfirmarPagoPage confirmarPagoPage;



	GeneralUtil generalUtil = new GeneralUtil();

	@Step
	public void realizarPago(String medioPago) {
		
		confirmarPagoPage.seleccionarMedioPago(medioPago);
		confirmarPagoPage.ingresarDatosTc();
	}
	@Step
	public void realizarPagoExp(String medioPago) {
		confirmarPagoPage.seleccionarMedioPagoExp(medioPago);
		confirmarPagoPage.ingresarDatosTcExp();
	}
	
	@Step
	public void validarDatosCompra(String tren, double montoEsperado) {
		String[] valorMostrado=confirmarPagoPage.obtenerValoresResumenCompra();
		
		for(int i=0; i<valorMostrado.length;i++) {
			System.out.println("Valor " + i + " " + valorMostrado[i]);
		}
		String montoTotal=valorMostrado[3].substring(11,valorMostrado[3].length());
		System.out.println("Monto Mostrado " + Double.parseDouble(montoTotal.replace(",", "")));
		
//		Assert.assertEquals(valorMostrado[1], tren);
		Assert.assertEquals(Double.parseDouble(montoTotal.replace(",", "")), montoEsperado);
		
	}
	@Step
	public void compararMonto(String auxNumAdult, String auxNumNino) {
		
		int numAdulto=Integer.parseInt(auxNumAdult);
		int numNino=Integer.parseInt(auxNumNino);
		
		double montoEsperado[] = generalUtil.calcularMontoExpedite(numAdulto, numNino, SeleccionarTrenStep.montoIda, SeleccionarTrenStep.montoVuelta);
		double montoMostrado[] = confirmarPagoPage.obtenerMontosExpedite();
		
		Assert.assertEquals(montoEsperado[0], montoMostrado[0]);
		Assert.assertEquals(montoEsperado[1], montoMostrado[1]);
		
		
	}
	
	

  
}