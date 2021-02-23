package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CrearSolicitudNoIncluidaCatalogoSteps extends genericGrid{

   
    /**
     * Esté método llena formulario de Crear solicitud no incluida en catalogo 
    */
    public void llenarFormCSNoIncluidaCatalogo(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String tipoArticulo, String descripcion,
    		String nombreCategoria, String nombreUM, String precio, String moneda, String proveedor,
    		String articuloProveedor) throws InterruptedException{
    	
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("tipo_articulo"), tipoArticulo);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("descripcion"), descripcion);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("nombre_categoria"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("nombre_categoria"), nombreCategoria);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("nombre_um"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("nombre_um"), nombreUM);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("precio"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("precio"), precio);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("moneda"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("moneda"), moneda);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("proveedor"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("proveedor"), proveedor);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("articulo_proveedor"), articuloProveedor);
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método llena formulario de introducir linea de solicitud 
    */
    public void llenarFormIntroducirLineaSoli(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String tipoArticulo, String articulo,
    	    String nombreUM, String precio, String moneda, String proveedor) throws InterruptedException{
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("tipo_articulo"), tipoArticulo);
    	
    	ingresarTexto(driver, "xpath", Elementos.getProperty("articulo"), articulo);
    	dormirSeg(5);    
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("nombre_um"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("nombre_um"), nombreUM);
    	dormirSeg(2);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("precio"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("precio"), precio);
    	dormirSeg(2);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("moneda"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("moneda"), moneda);
    	dormirSeg(2);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("proveedor"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("proveedor"), proveedor);
    	
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
  
    
   
    
}
