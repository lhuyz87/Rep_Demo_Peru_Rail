package itera.test.step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;

import itera.test.page.*;
import itera.test.util.PageObjectUtil;

public class SeleccionarTrenStep {

@Steps
private static SeleccionarTrainPage seleccionarTrainPage;


//	public static String montoIda="";
//	public static String montoVuelta="";
	public static double montoIda=0;
	public static double montoVuelta=0;

	@Step
	public static void seleccionarTren(String trenPartida, String trenRegreso) {
		// TODO Auto-generated method stub
		seleccionarTrainPage.seleccionarResumenCompra();
		
		if(trenPartida.compareTo("NA")!=0) {
			montoIda=seleccionarTrainPage.seleccionarTrainSalida(trenPartida);
			
		}
		
		if(trenRegreso.compareTo("NA")!=0) {
			montoVuelta=seleccionarTrainPage.seleccionarTrainRegreso(trenRegreso);
		}
		
		seleccionarTrainPage.seleccionarContinuar();
			
	}
	

	

  
}