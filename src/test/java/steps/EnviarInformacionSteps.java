package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EnviarInformacionSteps extends genericGrid{

    /**
     * Esté método enviar dialogo de crear acuerdo
    */
    public void llenarFormEnviarInfo(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String nombre, String comentario, String opcDevolucion) throws InterruptedException{
    
        ingresarTexto(driver, "xpath", Elementos.getProperty("comentario"), comentario);
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
