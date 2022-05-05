package itera.test.xpath;



public class SeleccionarTrainXpath {

    // singleton
    private static SeleccionarTrainXpath obj = null;

    private SeleccionarTrainXpath() {
    }

    public static SeleccionarTrainXpath getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new SeleccionarTrainXpath();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

   

    
   
   public String getXpathTipoTrenSalida(String tren) {
	   final String chkMedioPago="//div[@id='viajeIdaBimodal']//div[contains(text(),'"+tren +"')]//following::div[2]";
	   System.out.println("xpath: " +chkMedioPago);
	    return chkMedioPago;
   }
   
   public String getXpathTipoTrenRegreso(String tren) {
	   final String chkMedioPago="//div[@id='viajeRegresoBimodal']//div[contains(text(),'"+tren+"')]//following::div[2]";
	   System.out.println("xpath: " +chkMedioPago);
	    return chkMedioPago;
   }
   
 
   public String getXpathMontoIndividualSalida(String tren) {
	   
	   final String lblMontoIndividual="//div[@id='viajeIdaBimodal']//div[contains(text(),'"+tren +"')]//following :: div[4]";
	   return lblMontoIndividual;  
   }
   
 public String getXpathMontoIndividualRegreso(String tren) {
	   
	   final String lblMontoIndividual="//div[@id='viajeRegresoBimodal']//div[contains(text(),'"+tren +"')]//following :: div[5]";
	   return lblMontoIndividual;  
   }
   
   public final String btnCerrar="//*[@title='Close']";
   public final String btnResumenCompra="//*[@class='logo-tren-normal']//*[@src='/ecommerce/www/img/carrito.png']";
   public final String btnContinuar="//input[@class='btn  btn-continuar']";
   

}
