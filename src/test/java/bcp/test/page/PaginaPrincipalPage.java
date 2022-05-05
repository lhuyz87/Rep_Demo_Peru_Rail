package bcp.test.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

import bcp.test.util.PageObjectUtil;
import bcp.test.xpath.HomePeruRailXpath;

@DefaultUrl("http://test-geo.rimac.com/geo/login")
public class PaginaPrincipalPage extends PageObject {
	@Managed(clearCookies = ClearCookiesPolicy.BeforeEachTest)
	private WebDriverWait wdw = null;
	private long wdwTimeOut = 300L;
	
    // xpath
    protected HomePeruRailXpath xpathHomePeruRailPage = HomePeruRailXpath.getInstancia();

    // util
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    public long getWdwTimeOut() {
		return wdwTimeOut;
	}

    public void inicializar() {
//        open();
        getDriver().get("https://www.perurail.com/");
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
//        pageObjectUtil.waitForPageLoad(getDriver());
    }

    public void ingresarTipoViaje(String tipoViaje) {
    	pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRailPage.getXpathChkTipoViaje(tipoViaje),0);
    	
    }
    
    public void seleccinarDestino(String destino) {
    	
    	pageObjectUtil.seleccionarCombo(getDriver(), xpathHomePeruRailPage.lstDestino, destino);
    	
    }
    
    public void seleccinarRuta(String ruta) {
    	
    	pageObjectUtil.seleccionarCombo(getDriver(), xpathHomePeruRailPage.lstRuta, ruta);
    	
    }
    
    public void seleccinarTren(String tren) {
    	
    	pageObjectUtil.seleccionarCombo(getDriver(), xpathHomePeruRailPage.lstTipoTren, tren);
    	
    }
  
    
    public void seleccionarFechaSalida(String fecha) {
    	
    	pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRailPage.lblSalida, 0);
    	pageObjectUtil.seleccionarMes(getDriver(), xpathHomePeruRailPage.lblMes, fecha);
    	
    }
    
    
    
    public void seleccionarFechaRetorno(String fecha) {
    	pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRailPage.lblRetorno, 0);
    	pageObjectUtil.seleccionarMes(getDriver(), xpathHomePeruRailPage.lblMes, fecha);
    	
    }
    
	public void seleccionarDia(String fecha) {
	    	
		 	pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRailPage.gestXpathFechaDia(fecha.split("-")[0]), 0);
	    	
	    }
	
	public void seleccionarBuscar() {
		
		pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRailPage.btnBuscarTicket, 0);
		
	}
	
	public void ingresarNumeroPasajeros(int numAdulto, int numNinos) {
		
		pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRailPage.btnPassenger,0);
		if(numAdulto>2) {
			for(int i=0; i<numAdulto-2;i++) {
				pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRailPage.btnAumentarAdulto,0);
			}
		}
		
		if(numNinos>0) {
			for(int i=0; i<numNinos;i++) {
				pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRailPage.btnAumentarNino,0);
			}
		}
		
		pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRailPage.btnCerrarPassenger,0);
		
	}
	
	public void soloIngresarNumeroPasajeros(int numAdulto, int numNinos) {
		
		pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRailPage.btnPassenger,0);
		if(numAdulto>2) {
			for(int i=0; i<numAdulto-2;i++) {
				pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRailPage.btnAumentarAdulto,0);
			}
		}
		
		if(numNinos>0) {
			for(int i=0; i<numNinos;i++) {
				pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRailPage.btnAumentarNino,0);
			}
		}
		
				
	}

	public void esperar(int parseInt) {
		// TODO Auto-generated method stub
		
		pageObjectUtil.sleep(parseInt);
	}

	public String obtenerMensajeNumMax() {
		String mensaje = pageObjectUtil.obtenerTexto(getDriver(), xpathHomePeruRailPage.lblErrorMaxPasajeros);
		return mensaje;
	}
  
  

   
}
