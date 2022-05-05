package itera.test.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import net.serenitybdd.core.annotations.findby.By;

public class GeneralUtil {


    // singleton
    private static GeneralUtil obj = null;

    public GeneralUtil() {
    }

    public static GeneralUtil getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new GeneralUtil();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    // singleton

    public String fechaAgregarTiempo(String fecha, String formato, int cale, int cant) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
            Date date = simpleDateFormat.parse(fecha);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(cale, cant);
            date = calendar.getTime();
            fecha = simpleDateFormat.format(date);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return fecha;
    }

    public String concatenarFechaHora(String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        string += " " + simpleDateFormat.format(new Date());

        return string;
    }

    

    public List<List<String>> listaPosicion(List<List<String>> lista, int[] arrPos) {
        List<List<String>> listaFinal = new ArrayList<List<String>>();
        List<String> reg = null;

        for (List<String> list : lista) {
            reg = new ArrayList<String>();

            for (int i = 0; i < arrPos.length; i++) {
                reg.add(list.get(arrPos[i]));
            }

            listaFinal.add(reg);
        }

        return listaFinal;
    }

    public String numSinComa(String num) {
        num = num.replace(",", "");
        num = String.valueOf(Double.parseDouble(num));

        return num;
    }

    public String eliminaTabuladoresEspacios(String cadena) {
        return cadena.replaceAll("\\s", "");
    }

    public String anyItem(String[] listaAsegurados, String nombre) {
        String[] aseguradosExcluidos = nombre.split(";");
        List<String> aseguradosActivos = new ArrayList<String>();

        for (int i = 0; i < listaAsegurados.length; i++) {
            for (int j = 0; j < aseguradosExcluidos.length; j++) {
                if (listaAsegurados[i].trim().equals(aseguradosExcluidos[j].trim())) {
                    System.out.println("Asegurados Excluido: " + aseguradosExcluidos[j].trim());
                } else {
                    aseguradosActivos.add(listaAsegurados[i]);
                }
            }
        }

        int randomIndex = (int) (Math.random() * aseguradosActivos.size());

        return aseguradosActivos.get(randomIndex).trim();
    }

    public String fechaMesAnioActual(String formato) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);

        return simpleDateFormat.format(new Date());
    }

    public String identificarCelda(WebElement we, int pos) {
        List<WebElement> tr = we.findElements(By.tagName("tr"));
        List<WebElement> td = tr.get(0).findElements(By.tagName("td"));
        List<WebElement> div = td.get(pos).findElements(By.tagName("div"));

        return div.get(0).getText().trim();
    }

    public String sumarDecimal(String num, double val) {
        num = num.replace(",", "");
        double d = Double.parseDouble(num);
        d += val;
        DecimalFormat df = new DecimalFormat("#0.00");
        String s = df.format(d);
        s = s.replace(",", ".");

        return s;
    }

    public List<String> buscarLista(List<List<String>> listaPrevia, List<String> data) {
        for (List<String> dataPrevia : listaPrevia) {
            if (dataPrevia.get(0).equals(data.get(0))) {
                return dataPrevia;
            }
        }

        return new ArrayList<String>();
    }

    public String reemplazar(String string, String repOld, String repNew) {
        return string.replace(repOld, repNew);
    }

  
    public String sumarAnios(String fecha, int anios) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
        fechaLocal = fechaLocal.plusYears(anios);
        return fechaLocal.format(formateador);
    }

    public String obtenerMontoFormateado(String valor) {
        String[] cadena = valor.split("\\.");
        String part1 = cadena[0];
        String part2 = cadena[1];
        String monto = "";

        if (part2.equals("00")) {
            monto = "S/ " + part1;
        } else {

            String valor1 = Character.toString(part2.charAt(0));
            String valor2 = Character.toString(part2.charAt(1));

            if (valor1 != "0" && valor2.equals("0")) {
                monto = "S/ " + part1 + "." + valor1;
            } else {
                if ((valor1.equals("0") && valor2 != "0") || (valor1 != "0" && valor2 != "0")) {
                    monto = "S/ " + valor;
                }
            }
        }
        return monto;
    }

    public static String obtenerMes(String mes) {

        String mesString = "";
        switch (mes) {
            case "01":
                mesString="January";
                break;
            case "02":
                mesString="February";
                break;
            case "03":
                mesString="March";
                break;
            case "04":
                mesString="April";
                break;
            case "05":
                mesString="May";
                break;
            case "06":
                mesString="June";
                break;
            case "07":
                mesString="July";
                break;
            case "08":
                mesString="August";
                break;
            case "09":
                mesString="September";
                break;
            case "10":
                mesString="October";
                break;
            case "11":
                mesString="November";
                break;
            case "12":
                mesString="December";
                break;
        }

        return mesString;
    }
    
    public static String obtenerMesAbreviado(String mes) {

        String mesString = "";
        switch (mes) {
            case "01":
                mesString="Jan";
                break;
            case "02":
                mesString="Feb";
                break;
            case "03":
                mesString="Mar";
                break;
            case "04":
                mesString="Apr";
                break;
            case "05":
                mesString="May";
                break;
            case "06":
                mesString="Jun";
                break;
            case "07":
                mesString="Jul";
                break;
            case "08":
                mesString="Aug";
                break;
            case "09":
                mesString="Sep";
                break;
            case "10":
                mesString="Oct";
                break;
            case "11":
                mesString="Nov";
                break;
            case "12":
                mesString="Dec";
                break;
        }

        return mesString;
    }
    
    public static boolean esPar(int numero) {
        if (numero % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean esParDouble(double numero) {
        if (numero % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public double calcularMonto(String tipoCabina, int numPasajero) {
    	double montoTotal=0;
    	
    	switch (tipoCabina) {
		case "SUITE CABINS":
			if(numPasajero==1)
				montoTotal=2415;
			if(numPasajero==2)
				montoTotal=2760;
			if(numPasajero==3)
				montoTotal=5175;
			if(numPasajero==4)
				montoTotal=5520;
			if(numPasajero==5)
				montoTotal=7935;
			if(numPasajero==6)
				montoTotal=8280;
			if(numPasajero==7)
				montoTotal=10695;
			if(numPasajero==8)
				montoTotal=11040;
			if(numPasajero==9)
				montoTotal=13455;
			
			return  montoTotal;
	
	
		case "TWIN BED CABINS":
			if(numPasajero==1)
				montoTotal=2154;
			if(numPasajero==2)
				montoTotal=2460;
			if(numPasajero==3)
				montoTotal=4614;
			if(numPasajero==4)
				montoTotal=4920;
			if(numPasajero==5)
				montoTotal=7074;
			if(numPasajero==6)
				montoTotal=7380;
			if(numPasajero==7)
				montoTotal=9534;
			if(numPasajero==8)
				montoTotal=9840;
			if(numPasajero==9)
				montoTotal=11994;					
			return  montoTotal;
			
		case "UNK BED CABINS":
			if(numPasajero==1)
				montoTotal=1944;
			if(numPasajero==2)
				montoTotal=2220;
			if(numPasajero==3)
				montoTotal=4164;
			if(numPasajero==4)
				montoTotal=4440;
			if(numPasajero==5)
				montoTotal=6384;
			if(numPasajero==6)
				montoTotal=6660;
			if(numPasajero==7)
				montoTotal=8604;
			if(numPasajero==8)
				montoTotal=8880;
			if(numPasajero==9)
				montoTotal=10824;
			return  montoTotal;
		
		default:
			return  montoTotal;
		}
    	
    	
    }
    
    public int numPasajeros(String adultos, String ninos) {
    	int numPasajeros=0;
    	String pasajeros=adultos.concat("-").concat(ninos);
    	String[] slipPasajeros=pasajeros.split("-");
    	for(int i=0;i<slipPasajeros.length;i++) {
    		numPasajeros=Integer.parseInt(slipPasajeros[i]) + numPasajeros;
    	}
    	System.out.println("Numero de pasajeron " + numPasajeros);
    	return numPasajeros;
    }
    
    
    public String SelPasajero(WebDriver driver,String tipoPajero, int numPasajero) {
        int contador=1;
        String resultado = "";
        
//        System.out.println("Entra Contador Global  "   + Variables.contadorPasajero);
        
        try {
            List<WebElement> elements = driver.findElements(By.xpath("//*[@placeholder='"+tipoPajero+"']"));
            
           for (WebElement row : elements) {
                
                if (contador==numPasajero) {
                	System.out.println("Contador "  + contador + " NumPasajero " + numPasajero);
                	row.click();
                	break;
                }
                contador++;
            }
        } catch (Exception e) {
           
           
        }
        return resultado;
    }
    
    public double[] calcularMontoExpedite(int numAdulto, int numNino, double montoIda, double montoVuelta) {
    	
    	double montoIdaNino=montoIda;
    	double montoVueltaNino=montoVuelta;
    	double totales[] = new double[2];
    	
    	if(esParDouble(montoIda)==false) {
    		montoIdaNino=(montoIda+1)/2;
    	}else {
    		montoIdaNino=(montoIda)/2;
    	}
    	
    	if(esParDouble(montoVuelta)==false) {
    		montoVueltaNino=(montoVuelta+1)/2;
    	}else {
    		montoVueltaNino=(montoVuelta)/2;
    	}
//    	System.out.println("-" +montoIda +"-" +numAdulto +"-" +montoIdaNino +"-" +numNino );
    	totales[0]= montoIda*numAdulto + montoIdaNino*numNino;
    	totales[1]= montoVuelta*numAdulto + montoVueltaNino*numNino;
    	return totales;
    	
    }

	public double[] obtenerMontosExpedite(WebDriver driver) {
		
		//*[@src='/ecommerce/www/img/carrito.png'] /following :: div[2]//*[contains(text(),'Total: ')]
		
			int columnaClic = 0;
	        String resultado = "";
	        int contador = 0;
	        double[] montos = new double[2];
	        try {
	            List<WebElement> elements = driver.findElements(By.xpath("//*[@src='/ecommerce/www/img/carrito.png'] /following :: div[2]//*[contains(text(),'Total: ')]"));
	            for (WebElement row : elements) {
	            	
	            	System.out.println("Monto " + contador + " " + row.getText().replace("\n", "").substring(14,19));
	            	montos[contador]= Double.parseDouble(row.getText().replace("\n", "").substring(14,19));
	            	contador++;
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            Assert.fail("Excepcion en la tabla de resultado de busquedas: "  );
	        }
	        
	        return montos;
	        
	    }
		
		
	}

    
    


