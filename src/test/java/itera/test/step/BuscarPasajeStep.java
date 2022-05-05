package itera.test.step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;

import itera.test.page.*;
import itera.test.util.PageObjectUtil;

public class BuscarPasajeStep {

@Steps
private PaginaPrincipalPage paginaPrincipalPage;
	
	@Step
	public void ingresarTipoViaje(String tipoViaje) {
		paginaPrincipalPage.ingresarTipoViaje(tipoViaje);
	}
	
	@Step
	public void seleccionarRutaDestino(String destino, String ruta) {
		
		paginaPrincipalPage.seleccinarDestino(destino);
		paginaPrincipalPage.seleccinarRuta(ruta);
		
	}
	
	@Step
	public void seleccionarTipoTren(String tren) {
		paginaPrincipalPage.seleccinarTren(tren);
	}
	
	@Step
	public void seleccionarFechasDeReserva(String fecSalida,String fecRegreso) {
		paginaPrincipalPage.seleccionarFechaSalida(fecSalida);
		paginaPrincipalPage.seleccionarDia(fecSalida);
		if(fecRegreso.compareTo("NA")!=0) {
		paginaPrincipalPage.seleccionarFechaRetorno(fecRegreso);
		paginaPrincipalPage.seleccionarDia(fecRegreso);
		}
		
	}
	@Step
	public void realizarBusqueda() {
	  
		paginaPrincipalPage.seleccionarBuscar();
	}
	
	@Step
	public void seleccionarPasajeros(String numAdulto, String numNinos) {
		
		int numeAdulto=Integer.parseInt(numAdulto);
		int numeNinos=Integer.parseInt(numNinos);
		
		paginaPrincipalPage.ingresarNumeroPasajeros(numeAdulto,numeNinos);
	
		
	}
	@Step
	public void soloSeleccionarPasajeros(String numAdulto, String numNinos) {
		
		int numeAdulto=Integer.parseInt(numAdulto);
		int numeNinos=Integer.parseInt(numNinos);
		
		paginaPrincipalPage.soloIngresarNumeroPasajeros(numeAdulto,numeNinos);
	
		
	}
	
	@Step
	public void esperar(String tiempo) {

		paginaPrincipalPage.esperar(Integer.parseInt(tiempo));
		
	}
	@Step
	public String validarNumeroMaximoPasajeros() {

		String mensajeMostrado= paginaPrincipalPage.obtenerMensajeNumMax();
		
		return mensajeMostrado;
	}
	
	
	
	

  
}