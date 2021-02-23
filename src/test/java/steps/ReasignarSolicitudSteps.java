package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReasignarSolicitudSteps extends genericGrid{

    /**
     * Esté método llena dialogo de crear acuerdo
    */
    public void llenarFormReasignarSolicitud(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String reasignarA) throws InterruptedException{
        
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("reasignar_a"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("reasignar_a"), reasignarA);
       
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    

    /**
     * Esté método selecciona el boton aceptar
    */
    public void clickBtnAceptar(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    		 throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar"));
     
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    

    
}
