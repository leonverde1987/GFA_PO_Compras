package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GestionarSolicitudesSteps extends genericGrid{

    /**
     * Método para llenar el formulario de buscar de gestionar solicitudes
     */
    public void llenarFormGestionarSolBuscar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String introducidaPor, String solicitud, String proveedor, String articulo)
    				throws InterruptedException{
       borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("introducida_por"));
       //seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("introducida_por"), introducidaPor);
       ingresarTexto(driver, "xpath", Elementos.getProperty("solicitud"), solicitud);
       //seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("solicitud"), solicitud);
       //seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("proveedor"), proveedor);
       //seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("articulo"), articulo);
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
     * Método para seleccionar el registro de la solicitud
     */
    public void selectRegSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String solicitud)
    				throws InterruptedException{
    	String locator = sobreEscribirLocator(Elementos.getProperty("registro_solicitud"), solicitud);
    	clickJS(driver, "xpath", locator);
    	 this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    /**
     * Método para seleccionar el registro de la solicitud
     */
    public void selectRegSolicitudDetalle(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String solicitud)
    				throws InterruptedException{
    	String locator = sobreEscribirLocator(Elementos.getProperty("detalle_registro_solicitud"), solicitud);
    	clickJS(driver, "xpath", locator);
    	 this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    
    /**
     * Método para ingresar el numero de orden
     */
    public void ingresarNumeroOrden(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador,String noOrden)
    				throws InterruptedException{
    	 borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("comprador"));
    	 ingresarTexto(driver, "xpath", Elementos.getProperty("numero_orden"), noOrden);
    	 this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    /**
     * Método para seleccionar el boton buscar
     */
    public void clickBtnBuscar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador,String noOrden)
    				throws InterruptedException{
    	 clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
    	
    	 this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    
    
    
   
    
   
   
    
}
