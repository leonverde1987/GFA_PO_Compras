package steps;


import generic.genericGrid;
import steps.GenericSteps;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GestionarAcuerdosSteps extends genericGrid {
    public GenericSteps genericSteps = new GenericSteps();
    
    /**
     * Este método va al menú Tareas: Gestionar Acuerdos.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void menuGestionarAcuerdos(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("lk_tareas"));
        clickJS(driver, "xpath", Elementos.getProperty("lk_gestionar_acuerdos"));
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método selecciona la Unidad de negocios a filtrar.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param acuerdo Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void seleccionarUnidadNegocios(RemoteWebDriver driver, Properties Elementos, 
    		String bu, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
    	this.seleccionarComboByText(driver, "xpath", Elementos.getProperty("sel_unidad_negocios"), bu);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método selecciona el registro de la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param acuerdo Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void ingresarAcuerdo(RemoteWebDriver driver, Properties Elementos, 
    		String acuerdo, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
    	dormirSeg(3);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("txt_acuerdo"), acuerdo);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método va al menú Tareas: Gestionar Acuerdos.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void buscarAcuerdo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
         
     /**
     * Este método selecciona el registro del Acuerdo.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param texto Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void seleccionarRegistroAcuerdo(RemoteWebDriver driver, Properties Elementos, 
    		String texto, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
    	dormirSeg(3);
        String elem = Elementos.getProperty("div_resultados");
        genericSteps.presionarTextoEnTablaResponse(driver, "td", texto, elem, Config, Elementos, contador, Escenario, navegador);
        dormirSeg(2);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite eliminar el Acuerdo.
     * @param driver Elemento WebDriver de la prueba.
     * @param advertencia Es el mensaje de Advertencia a validar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarSuprimirAcuerdo(RemoteWebDriver driver, String advertencia, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
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
    public void confirmarSuprimirAcuerdo(RemoteWebDriver driver, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        clickJS(driver, "xpath", Elementos.getProperty("btn_si"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método valida que se haya eliminado el Acuerdo.
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es la leyenda a validar en la notificación.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarAcuerdoEliminado(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
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
    
    /**
     * Este método permite retener el Acuerdo.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarRetenerAcuerdo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("lk_acciones"));
            dormirSeg(2);
            clickJS(driver,"xpath", Elementos.getProperty("lk_retener"));
            dormirSeg(3);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
     /**
     * Este método permite congelar el Acuerdo.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarCongelarAcuerdo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("lk_acciones"));
            dormirSeg(2);
            clickJS(driver,"xpath", Elementos.getProperty("lk_congelar"));
            dormirSeg(3);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite cancelar el Acuerdo.
     * @param driver Elemento WebDriver de la prueba.
     * @param advertencia Es el mensaje de Advertencia a validar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarCancelarAcuerdo(RemoteWebDriver driver, String advertencia, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("lk_acciones"));
            dormirSeg(2);
            clickJS(driver,"xpath", Elementos.getProperty("lk_cancelar"));
            dormirSeg(3);
            String mensaje = Elementos.getProperty("div_mensaje_advertencia_cancelar");
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
    public void confirmarCancelarAcuerdo(RemoteWebDriver driver, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        clickJS(driver, "xpath", Elementos.getProperty("btn_si_cancelar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite dar clic en Aceptar para el Motivo Cancelación.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarAceptarMotivoCancelacion(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_motivo_retencion"));
            dormirSeg(3);    
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite cerrar definitivamente el Acuerdo.
     * @param driver Elemento WebDriver de la prueba.
     * @param advertencia Es el mensaje de Advertencia a validar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarCerrarDefinitivamenteAcuerdo(RemoteWebDriver driver, String advertencia, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("lk_acciones"));
            dormirSeg(2);
            clickJS(driver,"xpath", Elementos.getProperty("lk_cerrar_definitivamente"));
            dormirSeg(3);
            String mensaje = Elementos.getProperty("div_msj_advertencia_cerrar");
            genericSteps.ValidarTextoEnObjetoResponse(driver, "td", advertencia, mensaje, Config, Elementos, contador, Escenario, navegador);
            dormirSeg(3);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite cerrar definitivamente el Acuerdo.
     * @param driver Elemento WebDriver de la prueba.
     * @param advertencia Es el mensaje de Advertencia a validar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void confirmarCierreDefinitivoAcuerdo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("btn_confirmar_cierre_definitivo"));
            dormirSeg(2);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método ingresa el Motivo de Retención.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param acuerdo Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void ingresarMotivoRetencion(RemoteWebDriver driver, Properties Elementos, 
    		String acuerdo, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("txa_motivo_retencion"), acuerdo);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite dar clic en Aceptar para el Motivo Retención.
     * @param driver Elemento WebDriver de la prueba.
     * @param confirmacion Es el mensaje de Advertencia a validar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarAceptarMotivoRetencion(RemoteWebDriver driver, String confirmacion, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_motivo_retencion"));
            dormirSeg(5);
            String mensaje = Elementos.getProperty("div_mensaje_confirmacion");
            genericSteps.ValidarTextoEnObjetoResponse(driver, "td", confirmacion, mensaje, Config, Elementos, contador, Escenario, navegador);
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
    public void presionarAceptarMensajeConfirmacionRetencion(RemoteWebDriver driver, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_mensaje"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite dar clic en Aceptar para el Motivo Retención.
     * @param driver Elemento WebDriver de la prueba.
     * @param estado Es el mensaje de Advertencia a validar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    
    public String validarEstadoAcuerdo(RemoteWebDriver driver, String estado, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("tab_estado_acuerdo");
        String text = this.buscarTextoTabla(driver, estado, "span", elem);
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
     * Este método permite dar clic en Listo.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarListo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("btn_listo"));
            dormirSeg(3);    
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
}