package steps;


import generic.genericGrid;
import steps.GenericSteps;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GestionarOrdenesSteps extends genericGrid {
    public GenericSteps genericSteps = new GenericSteps();
    
    /**
     * Este método va al menú Tareas: Gestionar Órdenes.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void menuGestionarOrdenes(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("lk_tareas"));
        clickJS(driver, "xpath", Elementos.getProperty("lk_gestionar_ordenes"));
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite ingresar el número de la Orden.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param acuerdo Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void ingresarOrden(RemoteWebDriver driver, Properties Elementos, 
    		String acuerdo, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
    	dormirSeg(3);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("txt_orden"), acuerdo);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método busca la Orden de Compra.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void buscarOrden(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
         
     /**
     * Este método selecciona el registro de la Orden.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param texto Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void seleccionarRegistroOrden(RemoteWebDriver driver, Properties Elementos, 
    		String texto, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
    	dormirSeg(3);
        String elem = Elementos.getProperty("div_resultados");
        genericSteps.presionarTextoEnTablaResponse(driver, "td", texto, elem, Config, Elementos, contador, Escenario, navegador);
        dormirSeg(2);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite eliminar la Orden.
     * @param driver Elemento WebDriver de la prueba.
     * @param advertencia Es el mensaje de Advertencia a validar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarSuprimirOrden(RemoteWebDriver driver, String advertencia, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("lk_acciones"));
            dormirSeg(2);
            clickJS(driver,"xpath", Elementos.getProperty("lk_suprimir"));
            dormirSeg(3);
            String mensaje = Elementos.getProperty("td_msj_advertencia");
            genericSteps.ValidarTextoEnObjetoResponse(driver, "td", advertencia, mensaje, Config, Elementos, contador, Escenario, navegador);
            dormirSeg(3);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en el botón Sí.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void confirmarSuprimirOrden(RemoteWebDriver driver, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        clickJS(driver, "xpath", Elementos.getProperty("btn_si"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método valida que se haya eliminado la Orden.
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es la leyenda a validar en la notificación.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarOrdenEliminada(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("div_resultados");
        String text = this.buscarTextoTabla(driver, texto, "td", elem);
        String msj = "";
        try{
            msj = this.AssertComparaMensajes(text, "Fallido");
        }catch(ComparisonFailure e){
            msj = "Exitoso, Resultado Esperado: "+e;
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
}