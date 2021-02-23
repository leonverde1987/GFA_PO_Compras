package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MenuTareasSteps extends genericGrid{

    /**
     * Esté método nos ayuda a presionar el botón tareas menú izquierda
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void clickBtnTareas(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_tareas"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }   
    
    /**
     * Método para seleccionar la opcion Crear Pago
     */
    public void clickBtnCrearArticulo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_crear_articulo"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion Crear acuerdo
     */
    public void clickBtnCrearAcuerdo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_crear_acuerdo"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion Crear acuerdo
     */
    public void clickBtnProcesarSolicitudes(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_procesar_solicitudes"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion Crear orden
     */
    public void clickBtnCrearOrden(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_crear_orden"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion gestionar  ordenes
     */
    public void clickBtnGestionarOrdenes(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_gestionar_ordenes"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion gestionar  agentes de compras
     */
    public void clickGestionarAgentesCompras(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_gestionar_agentes_compras"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion gestionar  acuerdos
     */
    public void clickBtnGestionarAcuerdos(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_gestionar_acuerdos"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método nos ayuda a presionar el botón busqueda menú izquierda
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void clickBtnBusqueda(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    } 
    
    /**
     * Esté método nos ayuda a seleccionar el concepto por el cual se realizara la busqueda
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void clickOpcFiltroBusqueda(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("btn_opc_busqueda"), "Órdenes");
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    } 
    
    /**
     * Esté método nos ayuda a ingresar la orden
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void ingresarOrden(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String orden) throws InterruptedException{
    
    	ingresarTexto(driver, "xpath", Elementos.getProperty("txt_orden"), orden);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    } 
    
    /**
     * Esté método seleccionar el boton buscar orden
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void clickLupita2(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("buscar_filtro"));
    	 this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    
   
    
}
