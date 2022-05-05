package bcp.test.xpath;



public class ConfirmarPagoXpath {

    // singleton
    private static ConfirmarPagoXpath obj = null;

    private ConfirmarPagoXpath() {
    }

    public static ConfirmarPagoXpath getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ConfirmarPagoXpath();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

   

    
   
   public String getXpathMedioPago(String medioPago) {
	   final String chkMedioPago="//input[@id='"+medioPago+"']";
	    return chkMedioPago;
   }
   
   public final String chkAceptarTerm="//input[@name='tipo-manera']";
   public final String chkAceptarTermExp="//input[@name='terms']";
   public final String chkAceptarEntenExp="//input[@name='termsBimodal']";
   public final String btnPagar="//input[@value='PAY']";
   public final String btnEntrarTarjeta="//input[@value='Enter your card number']";
   public final String txtNumTarjeta="//input[@name='CREDITCARDNUMBER']";
   public final String lstMesExpiracion="//label[contains(text(),'Expiration date:')]//following :: select[1]";
   public final String lstAnoExpiracion="//label[contains(text(),'Expiration date:')]//following :: select[2]";
   public final String txtCodigoSeguridad="//label[contains(text(),'Security code:')]//following :: input[1]";
   public final String txtNombreTarjeta="//label[contains(text(),'Name (as on card):')]//following :: input[1]";
   public final String btnContinuar="//input[@value='Continue']";
   
   
   

}
