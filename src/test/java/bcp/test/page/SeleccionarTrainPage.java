package bcp.test.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

import bcp.test.util.PageObjectUtil;
import bcp.test.xpath.EscogerCabinaXpath;
import bcp.test.xpath.HomePeruRailXpath;
import bcp.test.xpath.SeleccionarTrainXpath;


public class SeleccionarTrainPage extends PageObject {

	private WebDriverWait wdw = null;
	private long wdwTimeOut = 300L;
	
	
    // xpath
    protected SeleccionarTrainXpath seleccionarTrainXpath = SeleccionarTrainXpath.getInstancia();

    // util
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    public long getWdwTimeOut() {
		return wdwTimeOut;
	}

 


	public double seleccionarTrainSalida(String tren) {
		pageObjectUtil.seleniumClick(getDriver(), seleccionarTrainXpath.getXpathTipoTrenSalida(tren),0);
		String montoIndividual=pageObjectUtil.obtenerTexto(getDriver(), seleccionarTrainXpath.getXpathMontoIndividualSalida(tren));

//		System.out.println(" :" +montoIndividual.substring(4,10));
		return Double.parseDouble(montoIndividual.substring(4,10));
	}
	
	public double seleccionarTrainRegreso(String tren) {
		pageObjectUtil.seleniumClick(getDriver(), seleccionarTrainXpath.getXpathTipoTrenRegreso(tren),0);
		String montoIndividual=pageObjectUtil.obtenerTexto(getDriver(), seleccionarTrainXpath.getXpathMontoIndividualRegreso(tren));
		return Double.parseDouble(montoIndividual.substring(4,10));
		
	}




	public void seleccionarResumenCompra() {
		pageObjectUtil.sleep(3);
		pageObjectUtil.seleniumClick(getDriver(), seleccionarTrainXpath.btnResumenCompra, 0);
		
	}




	public void seleccionarContinuar() {
		pageObjectUtil.seleniumClick(getDriver(), seleccionarTrainXpath.btnContinuar, 0);
		
	}
    
    
   
}
