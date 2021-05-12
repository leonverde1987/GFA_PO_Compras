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
        clickJS(driver, "xpath", Elementos.getProperty("casilla_gestionar_solicitudes"));
        dormirSeg(1);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("gestionar_solicitudes"), gestionarSolicitudes);
        
    	clickJS(driver, "xpath", Elementos.getProperty("casilla_gestionar_ordenes_compra"));
    	dormirSeg(1);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("gestionar_ordenes_compra"), gestionarOrdenesCompra);
        
    	clickJS(driver, "xpath", Elementos.getProperty("casilla_gestionar_acuerdos_compra"));
    	dormirSeg(1);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("gestionar_acuerdos_compra"), gestionarAcuerdosCompra);
        
    	clickJS(driver, "xpath", Elementos.getProperty("casilla_gestionar_negociaciones"));
    	dormirSeg(1);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("gestionar_negociaciones"), gestionarNegociaciones);
        
    	clickJS(driver, "xpath", Elementos.getProperty("casilla_gestionar_programas_abastecimientos"));
    	dormirSeg(1);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("gestionar_programas_abastecimientos"), gestionarProgramas);
        
        
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    

  
    
    

    
}
