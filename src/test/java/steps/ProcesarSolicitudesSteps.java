package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ProcesarSolicitudesSteps extends genericGrid{

    /**
     * Método para llenar form editar linea
     */
    public void llenarFormProcesarSolicitudesFiltroSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String solicitud)
    				throws InterruptedException{
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("comprador"));
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("solicitud"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("solicitud"), solicitud);
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton buscar
     */
    public void clickBtnBuscar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la fila de la solicitud
     */
    public void clickFilaSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String solicitud)
    				throws InterruptedException{
    	String locator = sobreEscribirLocator(Elementos.getProperty("fila_solicitud"), solicitud);
    	clickJS(driver, "xpath",locator);
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton agregar generador documentos
     */
    public void clickBtnAgregarGeneradorDoc(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath",Elementos.getProperty("btn_generador_doc"));
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
  
    /**
     * Método para seleccionar el boton crear
     */
    public void clickBtnCrear(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath",Elementos.getProperty("btn_crear"));
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton Aceptar el mensaje de informacion
     */
    public void clickBtnAceptarMsjInfo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath",Elementos.getProperty("btn_aceptar_info"));
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
  
    
    
   
   
    
}
