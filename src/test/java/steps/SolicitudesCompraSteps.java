package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SolicitudesCompraSteps extends genericGrid{

    /**
     * Método para desplegar el menu comprar por categoria
     */
    public void clickListaComprarCategoria(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_comprar_por_categoria"));
        dormirSeg(1);
        clickJS(driver, "xpath", Elementos.getProperty("btn_comprar_por_categoria"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar una categoria
     */
    public void selectCategoria(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String categoria) throws InterruptedException{
    	String locator = sobreEscribirLocator(Elementos.getProperty("categoria"), categoria);
    	clickJS(driver, "xpath", locator);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para ingresar cantidad de producto al primer producto del plp compras
     */
    public void ingresarCantProdPlp(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String cantidad) throws InterruptedException{
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("cant_producto_1_plp_compras"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("cant_producto_1_plp_compras"), cantidad);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton agregar al carro del producto uno plp
     */
    public void selectBtnAddCarUno(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_1_add_car"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para llenar formulario de solicitud de compra 
     */
    public void llenarFormSolicitudCompra(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String gfaSupervisor, String categoria) throws InterruptedException{
    	
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_supervisor"), gfaSupervisor);
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_lider_categoria"), categoria);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para verificar que se haya guardado la solicitud
     */
    public void clickBtnAceptarConfirmacionSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_confirmacion_solicitud"));
    	
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    public void clickBtnSiAdvertencia(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_si"));
    	
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    
    
    /**
     * Método para aceptar advertencia
     */
    public void clickBtnAceptarAdvertencia(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_advertencia"));
    	
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar el boton si del mensaje
     */
    public void clickBtnSiMsj(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_si"));
    	
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar el menu mas tareas
     */
    public void clickBtnMasTareas(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_mas_tareas"));
    	
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar el menu Gestionar solicitudes
     */
    public void clickGestionarSolicitudes(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_gestionar_solicitud"));
    	
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    
    /**
     * Método para seleccionar opcion solicitar articulo no incluido
     */
    public void clickOpcSolicitarArtNoIncluido(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("opc_articulo_no_incluido_catalogo"));
    	
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
   
    
    /**
     * Método para seleccionar opcion Introducir linea de solicitud
     */
    public void clickOpcIntroducirLineaSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("opc_introducir_linea_solicitud"));
    	
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
}
