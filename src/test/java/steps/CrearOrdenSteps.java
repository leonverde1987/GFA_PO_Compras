package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CrearOrdenSteps extends genericGrid{

    /**
     * Esté método llena dialogo de crear acuerdo
    */
    public void llenarDialogoCrearOrden(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String estilo, String udNegocioCompras,  String udNegocioSolicitante, String proveedor, String ubicacion,
    		String moneda, String comprador ) throws InterruptedException{
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("estilo"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("estilo"), estilo);
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("ud_negocio_compras"));
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("ud_negocio_compras"), udNegocioCompras);
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("ud_negocio_solicitante"));
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("ud_negocio_solicitante"), udNegocioSolicitante);
        ingresarTexto(driver, "xpath", Elementos.getProperty("proveedor"), proveedor);
        ingresarTexto(driver, "xpath", Elementos.getProperty("ubicacion"), ubicacion);
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("moneda"));
        seleccionarComboByValue(driver, "xpath", Elementos.getProperty("moneda"), moneda);
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("comprador"));
        seleccionarComboByValue(driver, "xpath", Elementos.getProperty("comprador"), comprador);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método seleccionar el boton crear
    */
    public void clickBtnCrear(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
       clickJS(driver, "xpath", Elementos.getProperty("btn_crear"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    

   
    
   
    
}
