package bcp.test.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

import bcp.test.util.PageObjectUtil;
import bcp.test.xpath.EscogerCabinaXpath;
import bcp.test.xpath.HomePeruRailXpath;


public class EscogerCabinaPage extends PageObject {

	private WebDriverWait wdw = null;
	private long wdwTimeOut = 300L;
	
    // xpath
    protected EscogerCabinaXpath escogerCabinaXpath = EscogerCabinaXpath.getInstancia();

    // util
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    public long getWdwTimeOut() {
		return wdwTimeOut;
	}

 
    public void seleccinarCabina(String tipoCabina, String numCabina) {
    	pageObjectUtil.seleccionarCombo(getDriver(), escogerCabinaXpath.getXpathLstTipoCabina(tipoCabina), numCabina);
    	
    }


	public void ingresarPasajero(String auxTipoCabina, int numCabina, String numPasajero, int tipoPasajero) {
		pageObjectUtil.seleccionarCombo(getDriver(), escogerCabinaXpath.getXpathCabinaAdultoNino(auxTipoCabina, numCabina, tipoPasajero), numPasajero);
		
		
	}
	
	public void seleccionarContinuar() {
		pageObjectUtil.seleniumClick(getDriver(), escogerCabinaXpath.btnContinuar,0);
	}
    
    
   
}
