package itera.test.xpath;



public class EscogerCabinaXpath {

    // singleton
    private static EscogerCabinaXpath obj = null;

    private EscogerCabinaXpath() {
    }

    public static EscogerCabinaXpath getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new EscogerCabinaXpath();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

   

    
    public String getXpathLstTipoCabina(String tipoCabina) {
    	final String lstTipoCabina="//div[@class='detalle-cabina']//*[text()='"+tipoCabina+"']// following :: select[1]";
		return lstTipoCabina;
    }
    
    public final String numCabina ="";
    
    
    public String getXpathCabinaAdultoNino(String tipoCabina, int numCabina,int tipoPasejero) {
    	final String selNumPasajeros="//*[@class='box-cabina']/div[@class='detalle-cabina']//*[contains(text(),'"+tipoCabina+"')]// following :: div[2]//*[text()='CABIN "+numCabina+"']//following :: select["+tipoPasejero+"]";
    	System.out.println("selNumPasajeros");
    	return selNumPasajeros;
    }
    
    public String getXpathMontoDolares(String tipoCabina) {
    	
    	final String lblMontoDolares="//*[@class='box-cabina']/div[@class='detalle-cabina']//*[contains(text(),'"+tipoCabina+"')]// following :: div[2]//*[text()='SUBTOTAL:']// following :: span[2]";
    	return lblMontoDolares;
    }
    
    public String getXpathMontoSoles(String tipoCabina) {
    	
    	final String lblMontoDolares="//*[@class='box-cabina']/div[@class='detalle-cabina']//*[contains(text(),'"+tipoCabina+"')]// following :: div[2]//*[text()='SUBTOTAL:']// following :: span[3]";
    	return lblMontoDolares;
    }
    
      
    public final String btnPassenger="//input[@name='countParentsChildren']";
    public final String btnDisminuirAdulto="//a[@id='adultsDism']";
    public final String btnAumentarAdulto="//a[@id='adultsAume']";
    public final String btnDisminuirNino="//a[@id='childrenDism']";
    public final String btnAumentarNino="//a[@id='childrenAume']";
    public final String btnCerrarPassenger="//a[@class='cerrar-passanger']";
    
    public final String lblMesActual="//span[@class='ui-datepicker-month']";
    public final String btnSigMes="//span[text()='Next']";
    public final String lblDia="//td[@data-handler='selectDay']";
    
    public final String lstTipoTren="//select[@name='cbTrenSelect']";
    
    public final String btnBuscarTicket="//span[text()='Find Train tickets']";
    
    public final String btnContinuar="//input[@value='Continue']";
    
    
   
}
