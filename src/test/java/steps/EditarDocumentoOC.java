package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EditarDocumentoOC extends genericGrid{

    /**
     * Método para llenar form editar docuemnto OC
     */
    public void llenarFormEditarDocOC(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String editDocDescripcion, String editDocGfaSupervisor, String editDocGfaLiderCatego) throws InterruptedException{
    	
    	ingresarTexto(driver, "xpath", Elementos.getProperty("descripcion"), editDocDescripcion);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("gfa_supervisor"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_supervisor"), editDocGfaSupervisor);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("gfa_lider_categoria"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_lider_categoria"), editDocGfaLiderCatego);
    	
    	
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para dar click en el importe del impuesto
     */
    public void clickImporteImp(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	
    	clickJS(driver, "xpath", Elementos.getProperty("importe_impuesto"));
    	
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
 

    /**
     * Método para dar click sobre el boton listo
     */
    public void clickBtnListo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	
    	clickJS(driver, "xpath", Elementos.getProperty("btn_listo"));
    	
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
 
  
    
    
   
   
    
}
