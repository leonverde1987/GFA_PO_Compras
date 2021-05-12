package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RecibirArticulosSteps extends genericGrid{

    /**
     * Método para llenar form recibir articulos
     */
    public void llenarRecibirArticulos(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String introducidaPor, String solicitud)
    				throws InterruptedException{
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("solicitante"));
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("orden_compra"));
    	//seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("introducida_por"), introducidaPor);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("solicitud"), solicitud);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para Seleccionar el boton buscar
     */
    public void clickBtnBuscar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para Seleccionar registro de la solicitud
     */
    public void clickRegSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String solicitud)
    				throws InterruptedException{
    	String locator = sobreEscribirLocator(Elementos.getProperty("registro_solicitud"), solicitud);
    	clickJS(driver, "xpath", locator);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para Seleccionar noton rebibir
     */
    public void clickBtnRecibir(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_recibir"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para Seleccionar boton mostrar cantidad de recepcion
     */
    public void clickBtnMostrarCantRec(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_mostrar_cantidad_recepcion"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para ingresar informacion de repcion
     */
    public void ingresarCantRepcion(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String cantidad, String notaEmbarque, String notaEmpaquetado)
    				throws InterruptedException{
    	ingresarTexto(driver, "xpath", Elementos.getProperty("cantidad"), cantidad);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("nota_embarque"), notaEmbarque);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("nota_empaquetado"), notaEmpaquetado);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
 

  
    
    
   
   
    
}
