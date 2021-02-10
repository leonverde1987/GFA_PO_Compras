package steps;


import generic.genericGrid;
import steps.GenericSteps;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GestionarSolicitudes extends genericGrid {
    public GenericSteps genericSteps = new GenericSteps();
    
    /**
     * Este método hace clic en la opción Gestionar Solicitudes
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void menuGestionarSolicitudes(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("lk_gestionar_solicitudes"));
            dormirSeg(3);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
       
    /**
     * Este metodo hace clic en la notificación del Anticipo a aprobar
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarFacturaAutoaprobada(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("div_lista_notificaciones");
        String text = this.buscarTextoTabla(driver, texto, "a", elem);
        String msj = "";
        try{
            msj = this.AssertComparaMensajes(text, "Exitoso");
        }catch(ComparisonFailure e){
            msj = "Fallido, Resultado Esperado: "+e;
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
    
     /**
     * Este metodo hace clic en la notificación del Anticipo a aprobar
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param texto Es la leyenda a validar para la notificación.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickNotificacionFacturaAprobacion(RemoteWebDriver driver, Properties Elementos, 
    		String texto, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
    	dormirSeg(3);
        String elem = Elementos.getProperty("div_lista_notificaciones");
        //genericSteps.presionarTextoEnTablaResponse(driver, "a", texto, elem, Config, Elementos, contador, Escenario, navegador);
        System.out.println(driver.getWindowHandle());
        driver.getWindowHandle();
        String ventanaOriginal = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        driver.findElement(By.linkText(texto)).click();
        System.out.println(driver.getWindowHandle());
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!ventanaOriginal.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //driver.switchTo().newWindow(WindowType.WINDOW);
        dormirSeg(5);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en la Campana de Notificaciones
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickBtnAprobar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("btn_aprobar"));
            dormirSeg(3);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en la Campana de Notificaciones
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickBtnEjecutar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("btn_ejecutar"));
            dormirSeg(3);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este metodo valida que se haya aprobado el Acuerdo por el Dueño CECO
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es la leyenda a validar en la notificación.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarAcuerdoAprobadoDueñoCECO(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("tab_acuerdo_aprobado");
        String text = this.buscarTextoTabla(driver, texto, "span", elem);
        String msj = "";
        try{
            msj = this.AssertComparaMensajes(text, "Exitoso");
        }catch(ComparisonFailure e){
            msj = "Fallido, Resultado Esperado: "+e;
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
}