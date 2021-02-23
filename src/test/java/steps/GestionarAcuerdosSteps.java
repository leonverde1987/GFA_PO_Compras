package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GestionarAcuerdosSteps extends genericGrid{

    /**
     * Método para llenar el formulario de buscar de gestionar solicitudes
     */
    public void ingresarAcuerdo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String acuerdo)
    				throws InterruptedException{
       borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("txt_acuerdo"));
       ingresarTexto(driver, "xpath", Elementos.getProperty("txt_acuerdo"), acuerdo);
      
        
    }
    
    /**
     * Método para seleccionar el boton buscar
     */
    public void clickBtnBuscar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
      clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
      
        
    }
    
  
   
    
}
