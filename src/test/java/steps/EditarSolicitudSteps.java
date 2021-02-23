package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EditarSolicitudSteps extends genericGrid{

    /**
     * Método para llenar form editar linea
     */
    public void llenarFormEditarSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String editSolDescripcion, String editSolGfaSupervisor, String editSolGfaLiderCatego)
    		throws InterruptedException{
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("descripcion"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("descripcion"), editSolDescripcion);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("gfa_supervisor"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_supervisor"), editSolGfaSupervisor);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("gfa_lider_categoria"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_lider_categoria"), editSolGfaLiderCatego);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
 

  
    
    
   
   
    
}
