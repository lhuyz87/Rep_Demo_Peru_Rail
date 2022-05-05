package itera.test.step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;

import itera.test.page.*;
import itera.test.util.PageObjectUtil;

public class IngresarPaginaPrincipalStep {

	@Steps
	private PaginaPrincipalPage paginaPrincipalPage;
	
	

	@Step
    public void abrirPaginaPrincipal() {
        PageObjectUtil.getInstancia().fechaFormatoLatinoLargo();
       
			paginaPrincipalPage.inicializar();
		
    }
    
    


  
}