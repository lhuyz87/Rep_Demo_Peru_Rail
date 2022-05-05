package bcp.test.xpath;



public class DatosPasajerosXpath {

    // singleton
    private static DatosPasajerosXpath obj = null;

    private DatosPasajerosXpath() {
    }

    public static DatosPasajerosXpath getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new DatosPasajerosXpath();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

   

    
   public String getXpathPasajero(String pasajero) {
	   final String  lblPasajero="//*[contains(text(),'PASSENGER "+pasajero+"')]";
	   return lblPasajero;
   }
   
   public String getXpathPasajeroxCabina(int numCabina, String tipoPasajero) {
	   
	   final String lblPasajero="//*[contains(text(),'CABIN"+numCabina+"')]/ following :: div[1]//*[contains(text(),'PASSENGER "+tipoPasajero+"')]";
	   return lblPasajero;
   }
   
   public String getXpathCabina(int numCabina) {
	   final String lblCabina="//*[contains(text(),'CABIN"+numCabina+"')]";
	   System.out.println("lblCabina " + lblCabina);
	   return lblCabina;
	   
   }
   
 //input[@id='formPasajero2-apePasajero' and contains(text(),'Surname')]
   
   public String getXpathNombrePasajero(int numCabina, int numPasajero) {
	   
	   
	   final String txtprimerNombre="//input[@placeholder='First name' and @name='txt_nombre[suite][cab"+numCabina+"]["+numPasajero+"]']";
	   System.out.println("Primer Nombre " +txtprimerNombre);
	   return txtprimerNombre;
   }
   
   public String getXpathApellidoPasajero(int numCabina, int numPasajero) {
	   final String txtApePasajero="//input[@placeholder='Last name' and @name='txt_apellido[suite][cab"+numCabina+"]["+numPasajero+"]']";
	   return txtApePasajero;
   }
   
    
   public String getXpathFecNac(int numCabina, int numPasajero) {
	   final String txtFecNac="//input[@name='txt_fecha_nacimiento[suite][cab"+numCabina+"]["+numPasajero+"]']";
	   System.out.println("caja fecha de nacimiento "  + txtFecNac);
	   return txtFecNac;
   }
   
   public String getXpathNacion(int numCabina, int numPasajero) {
	   final String selNacion="//select[@name='sel_nacion[suite][cab"+numCabina+"]["+numPasajero+"]']"; 
	   return selNacion;
   }
   
   public String getXpathTipoDoc(int numCabina, int numPasajero) {
	   final String selTipoDoc="//select[@name='sel_tpdoc[suite][cab"+numCabina+"]["+numPasajero+"]']";
	   return selTipoDoc;
	}
     
   public String getXpathNumDoc(int numCabina, int numPasajero) {
	   final String txtNumDoc="//input[@name='txt_nroid[suite][cab"+numCabina+"]["+numPasajero+"]']";
	   return txtNumDoc;
	}
   
  public String getXpathSexo(int numCabina, int numPasajero) {
	   final String selSexo="//select[@name='sel_sexo[suite][cab"+numCabina+"]["+numPasajero+"]']";
	   return selSexo;
	}
   
  
  public String getXpathTelefono(int numCabina, int numPasajero) {
	   final String txtTelefono="//input[@name='txt_telefono[suite][cab"+numCabina+"]["+numPasajero+"]']";
	   return txtTelefono;
	}
  
	  public String getXpathMail(int numCabina, int numPasajero) {
		   final String txtMail="//input[@name='txt_mail[suite][cab"+numCabina+"]["+numPasajero+"]']";
		   return txtMail;
		}
	  
	  public String getXpathConfMail(int numCabina, int numPasajero) {
		   final String txtConfMail="//input[@name='txt_mail_conf[suite][cab"+numCabina+"]["+numPasajero+"]']";
		   return txtConfMail;
		}
   
  
	  public String getXpathDiaCalendario(int dia) {
		  final String lblDia="//*[@class='ui-state-default' and text()='"+dia+"']";
		  return lblDia;
		  
	  }
	  
	  public final String lstAnoNac="//*[@class='ui-datepicker-year']";
	  	
	  public final String lstMesNac="//*[@class='ui-datepicker-month']";
	  
	  public final String btnContinuar="//button[text()='  Continue']";


   
   //Xpath Expedition
   
   public String getXpathNombrePasajeroExp(int numPasajero) {
	   final String txtNombrePasajero="//input[@id='formPasajero"+numPasajero+"-nomPasajero' and contains(text(),'Name')]";
	   System.out.println("TxtNombre " + txtNombrePasajero);
	   return txtNombrePasajero;
   }
   
   public String getXpathApellidoPasajeroExp(int numPasajero) {
	   final String txtApePasajero="//input[@id='formPasajero"+numPasajero+"-apePasajero' and contains(text(),'Surname')]";
	   return txtApePasajero;
   }
   
   
   public String getXpathFechaNacimientoExp(int numPasajero) {
	   final String txtFechaNacimiento="//input[@id='formPasajero"+numPasajero+"-fecNacimiento' and contains(text(),'Date of Birth')]";
	   System.out.println("Fecha Nacimiento xpath "  + txtFechaNacimiento);
	   return txtFechaNacimiento;
   }
   
   
   public String getXpathDiaNacimientoExp(int dia) {
	   final String txtDiaNacimiento="//*[@href=\"javascript:js_calendario_asignar_fecha('5');\"]";
	   return txtDiaNacimiento;
   }
   
   
   
   public final String lstAnoNacExp="//select[@id='calendario_anio']";
   public final String lstMesNacExp="//select[@id='calendario_mes']";
   
   public String getXpathNacionalidadExp(int numPasajero) {
	   final String lstNacionalidad="//select[@id='formPasajero"+numPasajero+"-idPais']";
	   return lstNacionalidad;
   }
   
   public String getXpathTipoDocumentoExp(int numPasajero) {
	   
	   final String lstTipoDocumento="//select[@id='formPasajero"+numPasajero+"-idDocumentoIdentidad']";
	   return lstTipoDocumento;
   }
   
   public String getXpathNumDocumentoExp(int numPasajero) {
	   
	   final String txtNumDocumento="//input[@id='formPasajero"+numPasajero+"-numDocumentoIdentidad']";
	   return txtNumDocumento;
   }
   
   
   public String getXpathSexoExp(int numPasajero) {
	   final String lstSexo="//select[@id='formPasajero"+numPasajero+"-idSexo']";
	   return lstSexo;
 
   }
   
   
   public String getXpathTelefonoExp(int numPasajero) {
	   final String txtTelefono="//input[@id='formPasajero"+numPasajero+"-numTelefono']";
	   return txtTelefono;
   }
   
   public String getXpathCorreoExp(int numPasajero) {
	   final String txtCorreo="//input[@id='formPasajero"+numPasajero+"-desEmail']";
	   return txtCorreo;
   }
   
   
   public String getXpathCorreoConfiExp(int numPasajero) {
	   final String txtCorreoConf="//input[@id='formPasajero"+numPasajero+"-desEmailConfirmacion']";
	   return txtCorreoConf;
   }
   
 //select[@id='formPasajero2-idPais']//*[contains(text(),'Nationality')]
   
   
   public final String btnContinuarExp="//input[@value='Continue']";
   

   
   
   }
