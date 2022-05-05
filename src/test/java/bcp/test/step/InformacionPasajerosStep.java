package bcp.test.step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;

import bcp.test.page.*;
import bcp.test.util.GeneralUtil;
import bcp.test.util.PageObjectUtil;

public class InformacionPasajerosStep {

@Steps
private DatosPasajerosPage datosPasajerosPage;


	String auxTipoCabina="";
	String auxNumCabina="";
	
	GeneralUtil generalUtil = new GeneralUtil();

	@Step
	public void llenarDatoPorPasajero(String numAdulto, String numNino) {
  	
        String numPasajeros= numAdulto.concat("-").concat(numNino);
		String[] splitNumPasajeros=numPasajeros.split("-");
		String[] detAdulto= new String[splitNumPasajeros.length/2];
		String[] detNino= new String[splitNumPasajeros.length/2];
		int contadorAdulto=0;
		int contadorNino=0;
		int contadorLimite=0;
		System.out.println(detAdulto.length+" - "+ splitNumPasajeros.length );
 		for(int i=0; i<splitNumPasajeros.length;i++) {
 			if(contadorLimite<splitNumPasajeros.length/2) {
 				detAdulto[contadorAdulto]=splitNumPasajeros[i];
 				System.out.println("Contador " +i + detAdulto[contadorAdulto]+" - "+ splitNumPasajeros[i] );
 				contadorAdulto++;
 				contadorLimite++;
 			}else {
 				detNino[contadorNino]=splitNumPasajeros[i];
 				System.out.println("Contador " +i + detNino[contadorNino]+" - "+ splitNumPasajeros[i] );
 				contadorNino++;
 				contadorLimite++;
 			}
 			
 		}
		
	for(int i=0;i<detAdulto.length;i++) {
			
			System.out.println("Contador " +i);
//			1-2-1
//			1-0-1
			if(Integer.parseInt(detAdulto[i])>0) {
				
				for(int j=0;j<Integer.parseInt(detAdulto[i]);j++) {
					datosPasajerosPage.ingresarDatoPasajero(i+1, 1+j, "(ADULT)");
				}
			}
			
			if(Integer.parseInt(detNino[i])>0) {
				for(int j=0;j<Integer.parseInt(detNino[i]);j++) {
					datosPasajerosPage.ingresarDatoPasajero(i+1, 2+j, "(CHILD)");
				}
			}

		}
		
		
		datosPasajerosPage.seleccionarContinuar();	
		
		
	}

	@Step
	public void llenarDatosPasajerosExp(String auxNumAdult, String auxNumNino) {
		int contPasajeros=1;
		for(int i=0; i<Integer.parseInt(auxNumAdult);i++) {
			datosPasajerosPage.llenarDatosPasajerosExpedite("ADULT",contPasajeros);
			contPasajeros++;
		}
		
		contPasajeros=1;
		
		for(int i=0; i<Integer.parseInt(auxNumNino);i++) {
			datosPasajerosPage.llenarDatosPasajerosExpedite("CHILD",contPasajeros);
			contPasajeros++;
		}
		
		datosPasajerosPage.seleccionarContinuarExp();
		
		
	}
	

  
}