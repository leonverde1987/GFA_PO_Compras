package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GeneradorDocumentos extends genericGrid{

    /**
     * Método para llenar form editar linea
     */
    public void llenarFormGeneradorDoc(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String tipo, String acuerdoOrigen, String estilo, String proveedor,
    		String sitioProveedor, String moneda)
    				throws InterruptedException{
    	dormirSeg(2);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("tipo"), tipo);
    	
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("acuerdo_origen"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("acuerdo_origen"), acuerdoOrigen);
    	
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("estilo"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("estilo"), estilo);
    	
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("proveedor"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("proveedor"), proveedor);
    	
    	//borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("sitio_proveedor"));
    	//seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("sitio_proveedor"), sitioProveedor);
    	
    	//borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("moneda"));
    	//seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("moneda"), moneda);
    	
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton aceptar
     */
    public void clickBtnAceptar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton editar
     */
    public void clickBtnEditar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_editar"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
  
    
   
   
    
}
