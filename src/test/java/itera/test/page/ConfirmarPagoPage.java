package itera.test.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import itera.test.util.GeneralUtil;
import itera.test.util.PageObjectUtil;
import itera.test.util.Variables;
import itera.test.xpath.ConfirmarPagoXpath;
import itera.test.xpath.EscogerCabinaXpath;
import itera.test.xpath.HomePeruRailXpath;
import itera.test.xpath.ResumenCompraXpath;


public class ConfirmarPagoPage extends PageObject {

	private WebDriverWait wdw = null;
	private long wdwTimeOut = 300L;
	
    // xpath
    protected ConfirmarPagoXpath confirmarPagoXpath = ConfirmarPagoXpath.getInstancia();
    protected ResumenCompraXpath resumenCompraXpath = ResumenCompraXpath.getInstancia();

    // util
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    
    protected GeneralUtil generalUtil = GeneralUtil.getInstancia();
    
    public long getWdwTimeOut() {
		return wdwTimeOut;
	}

 
	 public void seleccionarMedioPago(String medioPago) {
		 
		 pageObjectUtil.seleniumClick(getDriver(), confirmarPagoXpath.getXpathMedioPago(medioPago), 0);
		 pageObjectUtil.seleniumClick(getDriver(), confirmarPagoXpath.chkAceptarTerm, 0);
		 pageObjectUtil.seleniumClick(getDriver(), confirmarPagoXpath.btnEntrarTarjeta, 0);
		 pageObjectUtil.sleep(5);
	 }
    
	 
	 public void ingresarDatosTc() {
		 
//		pageObjectUtil.escribirConJS(getDriver(),pageObjectUtil.convertirAWebElement(getDriver(), confirmarPagoXpath.txtNumTarjeta) , Variables.numTarjeta); 
		 WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("global"));
		pageObjectUtil.waitForElementVisible(getDriver(), confirmarPagoXpath.txtNumTarjeta);
		pageObjectUtil.seleniumEscribir(getDriver(), confirmarPagoXpath.txtNumTarjeta, Variables.numTarjeta);
		pageObjectUtil.seleccionarCombo(getDriver(), confirmarPagoXpath.lstMesExpiracion, Variables.mesVencimiento);
		pageObjectUtil.seleccionarCombo(getDriver(), confirmarPagoXpath.lstAnoExpiracion, Variables.anoVencimiento);
		pageObjectUtil.seleniumEscribir(getDriver(), confirmarPagoXpath.txtCodigoSeguridad, Variables.codigoSeguridad); 
		pageObjectUtil.seleniumEscribir(getDriver(), confirmarPagoXpath.txtNombreTarjeta, Variables.nombreTarjeta);
		
		
		getDriver().switchTo().defaultContent();
//		pageObjectUtil.seleniumClick(getDriver(), confirmarPagoXpath.btnContinuar, 0);
	 }
	 
	 public String[] obtenerValoresResumenCompra() {
		 
		 String[] datosMostrados= new String[4];
		 pageObjectUtil.seleniumClick(getDriver(), resumenCompraXpath.btnResumenCompra, 0);
		 datosMostrados[0]= pageObjectUtil.obtenerTexto(getDriver(), resumenCompraXpath.lblDestino);
		 datosMostrados[1]=pageObjectUtil.obtenerTexto(getDriver(), resumenCompraXpath.lblDetTren);
		 datosMostrados[2]=pageObjectUtil.obtenerTexto(getDriver(), resumenCompraXpath.lblDiaSalida);
		 datosMostrados[3]=pageObjectUtil.obtenerTexto(getDriver(), resumenCompraXpath.lblMonto);
		 
		 return  datosMostrados;
		 
		 
	 }


	public double[] obtenerMontosExpedite() {
		// TODO Auto-generated method stub
		
		double[] montos=generalUtil.obtenerMontosExpedite(getDriver());
		return montos;
	}


	public void seleccionarMedioPagoExp(String medioPago) {
		 pageObjectUtil.seleniumClick(getDriver(), confirmarPagoXpath.getXpathMedioPago(medioPago), 0);
		 pageObjectUtil.seleniumClick(getDriver(), confirmarPagoXpath.chkAceptarTermExp, 0);
		 pageObjectUtil.seleniumClick(getDriver(), confirmarPagoXpath.chkAceptarEntenExp, 0);
		 pageObjectUtil.seleniumClick(getDriver(), confirmarPagoXpath.btnPagar, 0);
		 pageObjectUtil.sleep(5);
		
	}


	public void ingresarDatosTcExp() {
		// TODO Auto-generated method stub
		
		 WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeGC"));
		pageObjectUtil.waitForElementVisible(getDriver(), confirmarPagoXpath.txtNumTarjeta);
		pageObjectUtil.seleniumEscribir(getDriver(), confirmarPagoXpath.txtNumTarjeta, Variables.numTarjeta);
		pageObjectUtil.seleccionarCombo(getDriver(), confirmarPagoXpath.lstMesExpiracion, Variables.mesVencimiento);
		pageObjectUtil.seleccionarCombo(getDriver(), confirmarPagoXpath.lstAnoExpiracion, Variables.anoVencimiento);
		pageObjectUtil.seleniumEscribir(getDriver(), confirmarPagoXpath.txtCodigoSeguridad, Variables.codigoSeguridad); 
		pageObjectUtil.seleniumEscribir(getDriver(), confirmarPagoXpath.txtNombreTarjeta, Variables.nombreTarjeta);
		
		
		getDriver().switchTo().defaultContent();
		
	}
	 
//	 public void esperar() {
//		 pageObjectUtil.sleep(6000);
//	 }
   
}
