package steps;


import generic.genericGrid;
import steps.GenericSteps;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcesarSolicitudesSteps extends genericGrid {
    public GenericSteps genericSteps = new GenericSteps();
    
    /**
     * Este método va al menú Tareas: Procesar Solicitudes.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void menuProcesarSolicitudes(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("lk_tareas"));
        clickJS(driver, "xpath", Elementos.getProperty("lk_procesar_solicitudes"));
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite ingresar los filtros de la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param bu Es la Unidad de Negocios.
     * @param solicitud Es la solicitud a buscar.
     * @param comprador Es el comprador a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void ingresarFiltros(RemoteWebDriver driver, Properties Elementos, 
    		String bu, String solicitud, String comprador, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
    	this.seleccionarComboByText(driver, "xpath", Elementos.getProperty("sel_bu1"), bu);
        dormirSeg(2);
        this.seleccionarComboByText(driver, "xpath", Elementos.getProperty("sel_bu2"), bu);
        dormirSeg(2);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("txt_solicitud"), solicitud);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("txt_comprador"), comprador);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método busca la Solicitud de Compra.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void buscarSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
         
     /**
     * Este método selecciona el registro de la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param texto Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void seleccionarRegistroSolicitud(RemoteWebDriver driver, Properties Elementos, 
    		String texto, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
        /*String elem = Elementos.getProperty("div_resultados");
        genericSteps.presionarTextoEnTablaResponse(driver, "td", texto, elem, Config, Elementos, contador, Escenario, navegador);*/
        this.clickJS(driver, "xpath", Elementos.getProperty("lk_registro_solicitud"));
        dormirSeg(2);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método selecciona el registro de la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param solicitud Es el número de solicitar a seleccionar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param texto Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void seleccionarSolicitud(RemoteWebDriver driver, String solicitud, Properties Elementos, 
    		int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
        String elem = Elementos.getProperty("div_resultados");
        genericSteps.presionarTextoEnTablaResponse(driver, "td", solicitud, elem, Config, Elementos, contador, Escenario, navegador);
        dormirSeg(2);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite devolver la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarDevolverSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        this.clickJS(driver, "xpath", Elementos.getProperty("btn_devolver"));
        dormirSeg(2);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite ingresar el Motivo de Devolución.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param motivo Es el comprador a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void ingresarMotivoDevolucion(RemoteWebDriver driver, Properties Elementos, 
    		String motivo, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("txa_motivo_devolucion"), motivo);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite ejecutar la devolución de la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param confirmacion Es el mensaje de Confirmación a validar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarEjecutarMotivoDevolucion(RemoteWebDriver driver, String confirmacion, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        this.clickJS(driver, "xpath", Elementos.getProperty("btn_ejecutar_devolucion"));
        dormirSeg(2);
        String elem = Elementos.getProperty("div_msj_confirmacion");
        String text = this.buscarTextoTabla(driver, confirmacion, "td", elem);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite hacer clic en el botón Aceptar del mensaje Confirmación.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarAceptarConfirmacionDevolucion(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        this.clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_msj_confirmacion"));
        dormirSeg(2);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite ejecutar la devolución de la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarIconoAdvertenciaDevolucion(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
        this.clickJS(driver, "xpath", Elementos.getProperty("img_advertencia_devolucion"));
        dormirSeg(2);
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
    public String validarMensajeAdvertenciaLineaDevuelta(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("div_msj_informativo");
        String text = this.buscarTextoTabla(driver, texto, "td", elem);
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
     * Este método valida que se haya eliminado la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es la leyenda a validar en la notificación.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarSolicitudEliminada(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
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
     * Método para llenar form editar linea
     */
    public void llenarFormProcesarSolicitudesFiltroSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String solicitud)
    				throws InterruptedException{
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("comprador"));
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("solicitud"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("solicitud"), solicitud);
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton buscar
     */
    public void clickBtnBuscar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la fila de la solicitud
     */
    public void clickFilaSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String solicitud)
    				throws InterruptedException{
    	String locator = sobreEscribirLocator(Elementos.getProperty("fila_solicitud"), solicitud);
    	clickJS(driver, "xpath",locator);
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton agregar generador documentos
     */
    public void clickBtnAgregarGeneradorDoc(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath",Elementos.getProperty("btn_generador_doc"));
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
  
    /**
     * Método para seleccionar el boton crear
     */
    public void clickBtnCrear(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath",Elementos.getProperty("btn_crear"));
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton Aceptar el mensaje de informacion
     */
    public void clickBtnAceptarMsjInfo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath",Elementos.getProperty("btn_aceptar_info"));
      	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
}
