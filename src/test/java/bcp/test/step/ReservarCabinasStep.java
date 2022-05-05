package bcp.test.step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;

import bcp.test.page.*;
import bcp.test.util.PageObjectUtil;

public class ReservarCabinasStep {

@Steps
private EscogerCabinaPage escogerCabinaPage;

	public static String auxTipoCabina="";
	public static String auxNumCabina="";
	
	@Step
	public void seleccionarCabina(String tipoCabina, String numCabina) {
		escogerCabinaPage.seleccinarCabina(tipoCabina, numCabina);
		auxTipoCabina=tipoCabina;
		auxNumCabina=numCabina;
	}
	@Step
	public void seleccionarPasajeros(String numAdulto, String numNinos) {
		
//		1-2  1-0
//		
		String[] detAdulto=numAdulto.split("-");
		String[] detNinos=numNinos.split("-");
		
		for(int i=0; i<detAdulto.length;i++) {
			if(detAdulto[i].compareTo("0")!=0)
			escogerCabinaPage.ingresarPasajero(auxTipoCabina,i+1,detAdulto[i],1);
		}
		
		for(int i=0; i<detNinos.length;i++) {
			if(detNinos[i].compareTo("0")!=0)
			escogerCabinaPage.ingresarPasajero(auxTipoCabina,i+1,detNinos[i],2);
		}
		
		escogerCabinaPage.seleccionarContinuar();
		
	}
	

	

  
}