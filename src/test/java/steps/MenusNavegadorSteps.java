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
}
