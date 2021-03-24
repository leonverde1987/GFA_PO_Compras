package steps;


import generic.genericGrid;
import steps.GenericSteps;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GestionarSolicitudesSteps extends genericGrid {
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
    	dormirSeg(3);
        String elem = Elementos.getProperty("div_resultados");
        genericSteps.presionarTextoEnTablaResponse(driver, "td", texto, elem, Config, Elementos, contador, Escenario, navegador);
        dormirSeg(2);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en la Campana de Notificaciones
     * @param driver Elemento WebDriver de la prueba.
     * @param advertencia Es el mensaje de Advertencia a validar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarSuprimirSolicitud(RemoteWebDriver driver, String advertencia, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
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
    public void confirmarSuprimirSolicitud(RemoteWebDriver driver, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
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
     * Este método hace clic en la opoción Acciones - Cancelar solicitud
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarCancelarSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("lk_acciones"));
            dormirSeg(2);
            clickJS(driver,"xpath", Elementos.getProperty("lk_cancelar"));
            dormirSeg(3);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite ingresar el Motivo Cancelación.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param motivo Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void ingresarComentario(RemoteWebDriver driver, Properties Elementos, 
    		String motivo, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
    	dormirSeg(3);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("txa_motivo"), motivo);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en el botón Aceptar del Motivo Cancelación.
     * @param driver Elemento WebDriver de la prueba.
     * @param confirmacion Es el mensaje de Advertencia a validar.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarAceptarMotivoCancelacion(RemoteWebDriver driver, String confirmacion, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_cancelacion"));
            dormirSeg(4);
            String mensaje = Elementos.getProperty("div_msj_confirmacion");
            genericSteps.ValidarTextoEnObjetoResponse(driver, "td", confirmacion, mensaje, Config, Elementos, contador, Escenario, navegador);
            dormirSeg(3);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en el botón Cancelar del Motivo Cancelación.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarCancelarMotivoCancelacion(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("btn_cancelar_cancelacion"));
            dormirSeg(2);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en el botón Aceptar del mensaje de Confirmación.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void presionarBtnAceptarMensajeConfirmacionCancelacion(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_msj"));
            dormirSeg(2);
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
    public String validarEstadoSolicitud(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("div_solicitud");
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
     * Este método hace clic en el botón Cancelar del Motivo Cancelación.
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

    /**
     * Método para llenar el formulario de buscar de gestionar solicitudes
     */
    public void llenarFormGestionarSolBuscar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String introducidaPor, String solicitud, String proveedor, String articulo)
    				throws InterruptedException{
       borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("introducida_por"));
       //seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("introducida_por"), introducidaPor);
       ingresarTexto(driver, "xpath", Elementos.getProperty("solicitud"), solicitud);
       //seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("solicitud"), solicitud);
       //seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("proveedor"), proveedor);
       //seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("articulo"), articulo);
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
     * Método para seleccionar el registro de la solicitud
     */
    public void selectRegSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String solicitud)
    				throws InterruptedException{
    	String locator = sobreEscribirLocator(Elementos.getProperty("registro_solicitud"), solicitud);
    	clickJS(driver, "xpath", locator);
    	 this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    /**
     * Método para seleccionar el registro de la solicitud
     */
    public void selectRegSolicitudDetalle(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String solicitud)
    				throws InterruptedException{
    	String locator = sobreEscribirLocator(Elementos.getProperty("detalle_registro_solicitud"), solicitud);
    	clickJS(driver, "xpath", locator);
    	 this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    
    /**
     * Método para ingresar el numero de orden
     */
    public void ingresarNumeroOrden(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador,String noOrden)
    				throws InterruptedException{
    	 borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("comprador"));
    	 ingresarTexto(driver, "xpath", Elementos.getProperty("numero_orden"), noOrden);
    	 this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    /**
     * Método para seleccionar el boton buscar
     */
    public void clickBtnBuscar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador,String noOrden)
    				throws InterruptedException{
    	 clickJS(driver, "xpath", Elementos.getProperty("btn_buscar"));
    	
    	 this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
}
