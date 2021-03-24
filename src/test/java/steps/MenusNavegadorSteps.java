package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MenusNavegadorSteps extends genericGrid{


    /**
     * Est´s método abre el menu COMPRAS - PROVEEDORES 
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void clickMenuHamburguesa(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("menu_hamburguesa"));
    }
    
    /**
     * Este método abre el menu COMPRAS - PROVEEDORES 
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void abrirMenuComprasProveedores(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("proveedores"));
    }
    
    /**
     * Este método abre el menu Mi empresa - Configuracion y Mantenimiento
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void abrirMenuConfiguracionMantenimiento(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("configuracion_mantenimiento"));
    }
    
    
    
    /**
     * Este método da click en el icono de notificaciones
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void abrirNotificaciones(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("img_notificaciones"));
            dormirSeg(4);
    }
    
    /**
     * Este método abre el menu Mi empresa - Configuracion y Mantenimiento
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void abrirMenuFacturas(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("ap_factura"));
    }
    
    /**
     * Este método abre el menú COMPRAS - SOLICITUDES DE COMPRA 
     * @param driver Elemento WebDriver de la prueba.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @throws InterruptedException 
     */
    public void abrirMenuComprasSolicitudesCompra(RemoteWebDriver driver, int contador, Properties Config, String Escenario, String navegador, Properties Elementos) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("solicitudes_compra"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método abre el menú COMPRAS - ACUERDOS DE COMPRA 
     * @param driver Elemento WebDriver de la prueba.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @throws InterruptedException 
     */
    public void abrirMenuComprasAcuerdosCompra(RemoteWebDriver driver, int contador, Properties Config, String Escenario, String navegador, Properties Elementos) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("acuerdos_compra"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método abre el menú COMPRAS - ÓRDENES DE COMPRA 
     * @param driver Elemento WebDriver de la prueba.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @throws InterruptedException 
     */
    public void abrirMenuComprasOrdenesCompra(RemoteWebDriver driver, int contador, Properties Config, String Escenario, String navegador, Properties Elementos) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("ordenes_compra"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }

   
    /**
     * Este método abre el menú hamburguesa 
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return VOID
     * @throws InterruptedException 
     */
    public void clickMenuHamburguesa(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("menu_hamburguesa"));
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    
    //*
    public void abrirMenuInformacionProductos(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("menu_info_productos"));
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    //*
    public void abrirMenuSolicitudesCompra(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("menu_solicitudes_compra"));
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    //*
    public void abrirMenuOrdenesCompra(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("menu_ordenes_compra"));
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    //*
    public void abrirMenuAcuerdosCompra(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("menu_acuerdos_compra"));
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    //*
    public void abrirMenuMisRecepciones(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("menu_mis_recepciones"));
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método la campana de notificaciones
     */
    public void presionarCampanaNotificaciones(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) 
    		throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_guardar_cabecera"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método texto de busqueda en notificaciones
     */
    public void ingresarFiltroNotificacion(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String filtroBusqueda) 
    		throws InterruptedException{
    	ingresarTexto(driver, "xpath", Elementos.getProperty("txt_filtro_notificacion"), filtroBusqueda);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método selecciona la primera opcion del filtro aplicado al buscador de notificaciones
     */
    public void selectFiltroNotificacion(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String filtroBusqueda) 
    		throws InterruptedException{
    	String locator = sobreEscribirLocator(Elementos.getProperty("txt_opc_uno_filtro_noti"), filtroBusqueda);
    	clickJS(driver, "xpath", locator);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }


}
