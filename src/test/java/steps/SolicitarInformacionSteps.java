package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SolicitarInformacionSteps extends genericGrid{

    /**
     * Esté método llena dialogo de crear acuerdo
    */
    public void llenarFormSolicitarInfo(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String nombre, String comentario, String opcDevolucion) throws InterruptedException{
        
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("nombre"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("nombre"), nombre);
        ingresarTexto(driver, "xpath", Elementos.getProperty("comentario"), comentario);
        String locator = sobreEscribirLocator(Elementos.getProperty("opc_devolucion"), opcDevolucion);
        clickJS(driver, "xpath", locator);
        
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    


    
    /**
     * Esté método selecciona el boton ejecutar
    */
    public void clickBtnEjecutar(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        
        clickJS(driver, "xpath", Elementos.getProperty("btn_ejecutar"));
        
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
 
   
    
}
