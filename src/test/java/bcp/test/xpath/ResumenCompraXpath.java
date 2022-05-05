package bcp.test.xpath;



public class ResumenCompraXpath {

    // singleton
    private static ResumenCompraXpath obj = null;

    private ResumenCompraXpath() {
    }

    public static ResumenCompraXpath getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ResumenCompraXpath();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
  
  public final String btnResumenCompra="//*[@src='https://pax3.perurail.com/ecommerceaep/images/carrito-be.png']"; 
  public final String lblDestino="//*[@class='destino']//following::div[1]";
  public final String lblDetTren="//*[@class='firts' and contains(text(),'Train:')]//following::div[1]";
  public final String lblDiaSalida="//*[@class='firts' and contains(text(),'Departure Date:')]//following::div[1]";
  public final String lblMonto="//*[@src='https://pax3.perurail.com/ecommerceaep/images/carrito-be.png'] /following :: div[1]//*[contains(text(),'Total: ')]";
 
}
