package itera.test.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import com.sun.org.apache.xpath.internal.operations.Variable;

import itera.test.util.GeneralUtil;
import itera.test.util.PageObjectUtil;
import itera.test.util.Variables;
import itera.test.xpath.DatosPasajerosXpath;
import itera.test.xpath.EscogerCabinaXpath;
import itera.test.xpath.HomePeruRailXpath;





public class DatosPasajerosPage extends PageObject {
	
	@Steps
	GeneralUtil generalUtil;
	
	int auxAdultos=0;

	private WebDriverWait wdw = null;
	private long wdwTimeOut = 300L;
	
    // xpath
    protected DatosPasajerosXpath datosPasajerosXpath = DatosPasajerosXpath.getInstancia();

    // util
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    public long getWdwTimeOut() {
		return wdwTimeOut;
	}

 
 
    public void ingresarDatoPasajero(int numCabina, int numPasajero, String tipoPasajero) {
    	
    	String numTipoPasajero=numPasajero + " " + tipoPasajero;
    	
    	System.out.println("numVCabina " + numCabina + "numPasajero " + numPasajero + "tipo Pasajero " + tipoPasajero);
    	
    	if(numCabina!=1&&numPasajero==1) {
    		System.out.println("Entra 1 ");
    		pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathCabina(numCabina), 0);
    		pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathPasajeroxCabina(numCabina, numTipoPasajero),0);
    	}
    	
    	if(numCabina!=1&&numPasajero!=1) {
    		System.out.println("Entra 2 ");
    		pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathPasajeroxCabina(numCabina, numTipoPasajero),0);
    	}
    	
    	if(numCabina==1&&numPasajero!=1) {
    		System.out.println("Entra 3 ");
    		pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathPasajero(numTipoPasajero), 0);	
    	}
    	
    	if(tipoPasajero.compareTo("(ADULT)")==0) {
    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathNombrePasajero(numCabina, numPasajero), Variables.nomAdulto);
    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathApellidoPasajero(numCabina, numPasajero), Variables.apeAdulto);
    	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathFecNac(numCabina,numPasajero), 0);
    	String []datosFecha = Variables.fecNacAdulto.split("-");
    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.lstAnoNac, datosFecha[2]);
    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.lstMesNac, generalUtil.obtenerMesAbreviado(datosFecha[1]));
    	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathDiaCalendario(Integer.parseInt(datosFecha[0])), 0);
    	
    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathNacion(numCabina, numPasajero), Variables.NacionAdulto);
    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathTipoDoc(numCabina, numPasajero), Variables.tipoDocumentoAdulto);
    	int auxNumDocAdult = (int)(Math.random()*(999-100+1)+100);
    	
    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathNumDoc(numCabina, numPasajero), Variables.numDocAdulto+auxNumDocAdult);
    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathSexo(numCabina, numPasajero), Variables.sexAdulto);

    	
    	
    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathTelefono(numCabina, numPasajero), Variables.telAdulto);
    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathMail(numCabina, numPasajero), Variables.mailAdulto);
    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathConfMail(numCabina, numPasajero), Variables.mailAdulto);
    	}else {
    		System.out.println("ENTRA A NIÑOS");
    		pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathNombrePasajero(numCabina, numPasajero), Variables.nomNino);
        	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathApellidoPasajero(numCabina, numPasajero), Variables.apeNino);
        	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathFecNac(numCabina,numPasajero), 0);
        	String []datosFechaNino = Variables.fecNacNino.split("-");
        	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.lstAnoNac, datosFechaNino[2]);
        	System.out.println("xparh " + datosPasajerosXpath.lstMesNac + "Mes Nino " + generalUtil.obtenerMesAbreviado(datosFechaNino[1]));
//        	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.lstMesNac, 0);
//        	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.lstMesNac, "3");
        	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.lstMesNac, generalUtil.obtenerMesAbreviado(datosFechaNino[1]));
//        	pageObjectUtil.seleccionarListaConJS(getDriver(),datosPasajerosXpath.lstMesNac , generalUtil.obtenerMesAbreviado(datosFechaNino[1]));
        	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathDiaCalendario(Integer.parseInt(datosFechaNino[0])), 0);
        	
        	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathNacion(numCabina, numPasajero), Variables.NacioNino);
        	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathTipoDoc(numCabina, numPasajero), Variables.tipoDocumentoNino);
        	int auxNumDocNino = (int)(Math.random()*(999-100+1)+100);
        	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathNumDoc(numCabina, numPasajero), Variables.numDocNino+auxNumDocNino);
        	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathSexo(numCabina, numPasajero), Variables.sexNino);
	
    	}
    	
    }
    
	    public void seleccionarContinuar() {
	    	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.btnContinuar,0);
	    }
	    
	    
	    public void llenarDatosPasajerosExpedite(String tipoPasajero, int numPasajero) {
	    	
	    	if(numPasajero>1||tipoPasajero.compareTo("ADULT")!=0) {
	    		System.out.println("ENTRA " + numPasajero);
	    		pageObjectUtil.sleep(2);
	    		generalUtil.SelPasajero(getDriver(), tipoPasajero, numPasajero);
	    	}
	    	
	    	if(tipoPasajero.compareTo("ADULT")==0) {
	    		auxAdultos++;
	    		
	    		String anoNacAdulto=Variables.fecNacAdulto.split("-")[2];
		    	String mesNacAdulto=generalUtil.obtenerMes(Variables.fecNacAdulto.split("-")[1]);
		    	String diaNacAdulto=Variables.fecNacAdulto.split("-")[0];
		    	
		    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathNombrePasajeroExp(numPasajero), Variables.nomAdulto);
		    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathApellidoPasajeroExp(numPasajero), Variables.apeAdulto);
		    	pageObjectUtil.sleep(2);
		    	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathFechaNacimientoExp(numPasajero), 0);
		    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.lstAnoNacExp, anoNacAdulto);
		     	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.lstMesNacExp, mesNacAdulto);
		       	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathDiaNacimientoExp(Integer.parseInt(diaNacAdulto)),0);
		    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathNacionalidadExp(numPasajero),Variables.NacionAdulto);
		    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathTipoDocumentoExp(numPasajero),Variables.tipoDocumentoAdulto); 
		    	int auxNumDocAdult = (int)(Math.random()*(999-100+1)+100);
		    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathNumDocumentoExp(numPasajero), Variables.numDocAdulto+auxNumDocAdult);
		    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathSexoExp(numPasajero),Variables.sexAdulto); 
		    	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathTelefonoExp(numPasajero),0);
		    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathTelefonoExp(numPasajero), Variables.telAdulto);
		    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathCorreoExp(numPasajero), Variables.mailAdulto);
		    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathCorreoConfiExp(numPasajero), Variables.mailAdulto);
		    	
		    	
	    	}else {
	    		
	    		String anoNacNino=Variables.fecNacNino.split("-")[2];
		    	String mesNacNino=generalUtil.obtenerMes(Variables.fecNacNino.split("-")[1]);
		    	String diaNacNino=Variables.fecNacNino.split("-")[0];
		    	
		    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathNombrePasajeroExp(numPasajero+auxAdultos), Variables.nomNino);
		    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathApellidoPasajeroExp(numPasajero+auxAdultos), Variables.apeNino);
		    	pageObjectUtil.sleep(2);
		    	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathFechaNacimientoExp(numPasajero+auxAdultos), 0);
		     	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.lstAnoNacExp, anoNacNino);
		     	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.lstMesNacExp, mesNacNino);
		     	pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.getXpathDiaNacimientoExp(Integer.parseInt(diaNacNino)),0);
		    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathNacionalidadExp(numPasajero+auxAdultos),Variables.NacioNino);
		    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathTipoDocumentoExp(numPasajero+auxAdultos),Variables.tipoDocumentoNino); 
		    	int auxNumDocNino = (int)(Math.random()*(999-100+1)+100);
		    	pageObjectUtil.seleniumEscribir(getDriver(), datosPasajerosXpath.getXpathNumDocumentoExp(numPasajero+auxAdultos), Variables.numDocNino+auxNumDocNino);
		    	pageObjectUtil.seleccionarCombo(getDriver(), datosPasajerosXpath.getXpathSexoExp(numPasajero+auxAdultos),Variables.sexNino); 
		    			    
	    		
	    	}
	    	
	    		
	    	
	    }



		public void seleccionarContinuarExp() {
			pageObjectUtil.seleniumClick(getDriver(), datosPasajerosXpath.btnContinuarExp,0);
			
		}
    
   
}
