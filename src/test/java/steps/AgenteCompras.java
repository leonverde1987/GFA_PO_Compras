package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AgenteCompras extends genericGrid{

    /**
     * Esté método llena formulario de agente de compras
    */
    public void llenarFormAgenteCompras(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("unidad_negocio_compra"), "CD UN API");
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("agente"), "TEST, UAT");
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("solicitante_por_defecto"), "CD UN API");
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("impresora_por_defecto"), "");
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("estado"), "Activa");
       
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método llena formulario de agente de compras
    */
    public void llenarFormAgenteCompras2(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("solicitante_por_defecto"), "CD UN API");
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("impresora_por_defecto"), "");
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("estado"), "Activa");
       
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método llena formulario de acceso de agente
    */
    public void llenarFormAccesoAgente(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String gestionarSolicitudes, String gestionarOrdenesCompra, String gestionarAcuerdosCompra,
    		String gestionarNegociaciones, String gestionarProgramas) throws InterruptedException{
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("gestionar_solicitudes"), gestionarSolicitudes);
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("gestionar_ordenes_compra"), gestionarOrdenesCompra);
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("gestionar_acuerdos_compra"), gestionarAcuerdosCompra);
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("gestionar_negociaciones"), gestionarNegociaciones);
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("gestionar_programas_abastecimientos"), gestionarProgramas);
        
        
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    

  
    
    

    
}
