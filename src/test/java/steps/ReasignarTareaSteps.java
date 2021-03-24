package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReasignarTareaSteps extends genericGrid{

    /**
     * Método para llenar form reasignar tarea
     */
    public void llenarFormReasignarTarea(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("check_avanzado"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("check_avanzado"), "gu.gonzalez.s@flecha-amarilla.com");
    	
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar boton aceptar
     */
    public void clickBtnAceptar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
    	
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar renglon
     */
    public void selectRenglon(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("renglon_fila"));
    	
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar boton aceptar
     */
    public void selectBtnAceptar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar"));
    	
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
 

  
    
    
   
   
    
}
