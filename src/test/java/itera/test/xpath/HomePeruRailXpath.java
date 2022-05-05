package itera.test.xpath;



public class HomePeruRailXpath {

    // singleton
    private static HomePeruRailXpath obj = null;

    private HomePeruRailXpath() {
    }

    public static HomePeruRailXpath getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new HomePeruRailXpath();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

   
    public final String lstDestino = "//select[@name='destinoSelect']";
    public final String lstRuta="//select[@name='rutaSelect']";
    
    public String getXpathChkTipoViaje(String tipoViaje) {
    	final String chkTipoViaje="//label[text()='"+tipoViaje+"']//span";
    	System.out.println(chkTipoViaje);
		return chkTipoViaje;
    }
    
    public String gestXpathFechaDia(String dia) {
    	
    	final String lblDia="//td[@data-handler='selectDay']//*[text()="+dia+"]";
    	return lblDia;
    }
    
    public final String btnPassenger="//input[@name='countParentsChildren']";
    public final String btnDisminuirAdulto="//a[@id='adultsDism']";
    public final String btnAumentarAdulto="//a[@id='adultsAume']";
    public final String btnDisminuirNino="//a[@id='childrenDism']";
    public final String btnAumentarNino="//a[@id='childrenAume']";
    public final String btnCerrarPassenger="//a[@class='cerrar-passanger']";
    
    public final String lblMesActual="//span[@class='ui-datepicker-month']";
    public final String btnSigMes="//span[text()='Next']";
//    public final String lblDia="//td[@data-handler='selectDay']";
    
    public final String lstTipoTren="//select[@name='cbTrenSelect']";
    
    public final String btnBuscarTicket="//span[text()='Find Train tickets']";
    
    
    public final String lblMes="//span[@class='ui-datepicker-month']";
    public final String lblSalida="//input[@name='salida']";
    public final String lblRetorno="//input[@name='regreso']";
    
    public final String lblErrorMaxPasajeros="//*[@id='error-pasajeros']";
    
   
}
