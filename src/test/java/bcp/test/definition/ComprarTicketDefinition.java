package bcp.test.definition;

import com.ibm.icu.impl.InvalidFormatException;

import bcp.test.step.BuscarPasajeStep;
import bcp.test.step.InformacionPasajerosStep;
import bcp.test.step.IngresarPaginaPrincipalStep;
import bcp.test.step.RealizarPagoStep;
import bcp.test.step.ReservarCabinasStep;
import bcp.test.step.SeleccionarTrenStep;
import bcp.test.util.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ComprarTicketDefinition {
    @Steps
    private BuscarPasajeStep buscarPasajeStep;
    @Steps
    private IngresarPaginaPrincipalStep ingresarPaginaPrincipalStep;
    @Steps
    private ReservarCabinasStep reservarCabinasStep;
    @Steps
    private ReporteSerenityUtil reporteSerenityUtil;
    @Steps
    private InformacionPasajerosStep informacionPasajerosStep;
    @Steps
    private RealizarPagoStep realizarPagoStep; 
    @Steps
    private GeneralUtil generalUtil;
    @Steps
    private SeleccionarTrenStep seleccionarTrenStep;
    
    String requisito = "";
    String numDoc = "";
    String numSoli="";
    String auxNumAdult="";
    String auxNumNino="";
    String auxTipoCabina="";
    String auxTren="";
    
    
    
    @Given("^que accedo a la página principal de Perú Rail$")
    public void que_accedo_a_la_página_principal_de_Perú_Rail() {
    	ingresarPaginaPrincipalStep.abrirPaginaPrincipal();
        
    }

    @Given("^ingreso el tipo de pasaje ida o vuelta \"([^\"]*)\"$")
    public void ingreso_el_tipo_de_pasaje_ida_o_vuelta(String tipoViaje) {
    	buscarPasajeStep.ingresarTipoViaje(tipoViaje);
        
    }

    @And("^ingreso los datos del destino: \"([^\"]*)\", \"([^\"]*)\" y \"([^\"]*)\"$")
    public void ingreso_los_datos_del_destino_y(String destino, String ruta, String tren) {
    	buscarPasajeStep.seleccionarRutaDestino(destino, ruta);
    	if(tren.compareTo("NA")!=0)
    		buscarPasajeStep.seleccionarTipoTren(tren);   
    	auxTren=tren;
    }

    @And("^selecciona la fecha de ida y/o regreso: \"([^\"]*)\" y/o \"([^\"]*)\"$")
    public void selecciona_la_fecha_de_ida_y_regreso_y(String fecIda, String fecRegreso) {
    	buscarPasajeStep.seleccionarFechasDeReserva(fecIda, fecRegreso);
        
    }
    
    @And("^realizo la busqueda$")
    public void realizo_busqueda() {
    	buscarPasajeStep.realizarBusqueda();
        
    }
    
    
    @And("^selecciono el tipo \"([^\"]*)\" y número de cabinas \"([^\"]*)\" a reservar$")
    public void selecciono_cabina_a_reservar(String tipoCabina, String numCabina) {
        reservarCabinasStep.seleccionarCabina(tipoCabina, numCabina);
        auxTipoCabina=tipoCabina;
    }
    

    @And("^selecciono la cantidad de pasajeros \"([^\"]*)\" y \"([^\"]*)\"$")
    public void selecciono_la_cantidad_de_pasajeros_y(String numAdulto, String numNinos) {
    	reservarCabinasStep.seleccionarPasajeros(numAdulto,  numNinos);
    	auxNumAdult=numAdulto;
    	auxNumNino=numNinos;
        
    }
    
    @And("^ingreso la cantidad de pasajeros \"([^\"]*)\" y \"([^\"]*)\"$")
    public void ingreso_la_cantidad_de_pasajeros_y(String numAdulto, String numNinos) {
    	auxNumAdult=numAdulto;
    	auxNumNino=numNinos;
    	buscarPasajeStep.seleccionarPasajeros(numAdulto, numNinos);
        
    }
    
    @And("^ingreso más de la cantidad máxima de pasajeros \"([^\"]*)\" y \"([^\"]*)\"$")
    public void ingreso_la_cantidad_maxima_de_pasajeros_y(String numAdulto, String numNinos) {
    	auxNumAdult=numAdulto;
    	auxNumNino=numNinos;
    	buscarPasajeStep.soloSeleccionarPasajeros(numAdulto, numNinos);
        
    }
    
    

    @And("^ingreso los datos de los pasajeros$")
    public void selecciono_la_opción_buscar_ticket() {
        
    	informacionPasajerosStep.llenarDatoPorPasajero(auxNumAdult, auxNumNino);
        
    }
    
   
    @And("^realizo la compra con medio de pago \"([^\"]*)\"$")
    public void realizo_compra(String medioPago) {
    	
    	realizarPagoStep.realizarPago(medioPago);
    }
    
    @Then("^valido el detalle de la compra$")
    public void valido_detalle_compra() {
    	
    	double monto=generalUtil.calcularMonto(auxTipoCabina,generalUtil.numPasajeros(auxNumAdult, auxNumNino));
    	realizarPagoStep.validarDatosCompra(auxTren, monto);
    }
    
    @And("^selecciono el tren de partida \"([^\"]*)\" y regreso \"([^\"]*)\"$")
    public void selecciono_el_tren_de_partida_y_regreso(String trenPartida, String trenRegreso) {


    	SeleccionarTrenStep.seleccionarTren(trenPartida, trenRegreso);
        
    }
    
    @And("^ingreso los datos de los pasajeros expedite$")
    public void ingreso_datos_pasajeros_expedite() {
    	
//    	int numPasajeros = Integer.parseInt(auxNumAdult) + Integer.parseInt(auxNumNino);
    	informacionPasajerosStep.llenarDatosPasajerosExp(auxNumAdult, auxNumNino);
    	
    	
    }
    
    @Then("^valido los montos de la compra y realizo pago \"([^\"]*)\"$")
    public void valido_monto_compra_exp(String tipo_pago) {
    	
    	realizarPagoStep.compararMonto(auxNumAdult, auxNumNino);
    	realizarPagoStep.realizarPagoExp(tipo_pago);
     }
    
    
    @Then("^valido que se muestre mensaje de error \"([^\"]*)\"$")
    public void valido_mensaje_num_maximo_pasajeros(String mensaje) {
    	
    	String mensajeMostrado = buscarPasajeStep.validarNumeroMaximoPasajeros();
    	System.out.println(" :" + mensajeMostrado);
    	Assert.assertEquals(mensajeMostrado.toUpperCase().trim(), mensaje.toUpperCase().trim());
    	
     }
    
    
    @And("^esperar \"([^\"]*)\"$")
    public void esperar(String tiempo) {
    	
    	buscarPasajeStep.esperar(tiempo);
    }

}
