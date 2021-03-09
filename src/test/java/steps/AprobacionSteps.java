package steps;


import generic.genericGrid;
import steps.GenericSteps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AprobacionSteps extends genericGrid {
    public GenericSteps genericSteps = new GenericSteps();
    
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
    public void clickCampanaNotificaciones(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
            clickJS(driver, "xpath", Elementos.getProperty("ic_notificaciones"));
            dormirSeg(3);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
       
    /**
     * Este metodo valida el documento de Compra autoaprobado.
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
    
    public String validarNotificacionRechazada(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String numeroAcuerdo) throws InterruptedException{
    	String msj = "Exitoso";
        try{
        	String locator = sobreEscribirLocator(Elementos.getProperty("noti_rechazada"), numeroAcuerdo);
        	this.waitUIElementPresent(driver, "xpath", locator);
        }catch(Exception e){
            msj = "Fallido, Resultado Esperado: " + e;
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
    
     /**
     * Este metodo hace clic en la notificación del documento a aprobar
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param texto Es la leyenda a validar para la notificación.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickNotificacionAcuerdoAprobacion(RemoteWebDriver driver, Properties Elementos, 
    		String texto, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException, Exception{
    	dormirSeg(3);
        String elem = Elementos.getProperty("div_lista_notificaciones");
        genericSteps.presionarTextoEnTablaResponse(driver, "a", texto, elem, Config, Elementos, contador, Escenario, navegador);
        //genericSteps.switchWindowByIndex(driver, 1);
        dormirSeg(5);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    public void clickNotificacionAcuerdoAprobacion_1(RemoteWebDriver driver, Properties Elementos, 
    		int contador, Properties Config, String Escenario, String navegador, String numeroAcuerdo
    		) throws InterruptedException, Exception{
    	dormirSeg(3);
        String locator = sobreEscribirLocator(Elementos.getProperty("noti"), numeroAcuerdo);
    	clickJS(driver, "xpath", locator);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    public void validar_que_no_exista_btn_aprobar(RemoteWebDriver driver, Properties Elementos, 
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException, Exception{
    	dormirSeg(3);
    	try{
    		boolean btn_exist = genericSteps.AssertExistElement(driver, "xpath", Elementos.getProperty("btn_aprobar"));
        	assertFalse(btn_exist, "El boton aprobar existe");
        } catch(AssertionError e){
            System.out.println("El elemento existe"+e);
            
        } catch(Exception ex){
            System.out.println("El elemento existe"+ex);            
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }

    
    /**
     * Este método hace clic en el botón Aprobar.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickBtnAprobar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException, Exception{
      
        	dormirSeg(2);
        	click(driver, "xpath", Elementos.getProperty("btn_aprobar"));
        	dormirSeg(5);
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
       
    }
    
    /**
     * Este método hace clic en el botón Aprobar.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickBtnAprobarSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException, Exception{
        clickJS(driver, "xpath", Elementos.getProperty("btn_aprobar_solicitud"));
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en el botón Ejecutar.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickBtnEjecutar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException, Exception{
        clickJS(driver, "xpath", Elementos.getProperty("btn_ejecutar_aprobacion"));
        genericSteps.switchWindowByIndex(driver, 0);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este metodo valida que se haya aprobado el Documento por el Aprobador
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es la leyenda a validar en la notificación.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarDocumentoAprobadoAprobador(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("div_documento_aprobado");
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
     * Este metodo valida que se haya aprobado el Documento por el Aprobador
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es la leyenda a validar en la notificación.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarSolicitudAprobadaAprobador(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("div_solicitud_aprobada");
        String text = this.buscarTextoTabla(driver, texto, "strong", elem);
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
     * Este metodo valida que se haya aprobado el Documento por el Aprobador
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es la leyenda a validar en la notificación.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarSolicitudAprobadaLiderTecnico(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("tab_solicitud_aprobada");
        String text = this.buscarTextoTabla(driver, texto, "strong", elem);
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
     * Este metodo valida que se haya aprobado el Documento por el Aprobador
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es la leyenda a validar en la notificación.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarOrdenAprobadaAprobador(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("tab_orden_aprobada");
        String text = this.buscarTextoTabla(driver, texto, "strong", elem);
        String msj = "";
        String resultado = this.AssertComparaMensajes(text, "Exitoso");
       if (this.AssertComparaMensajes1(text, "Exitoso")){
        	resultado = "Exitoso";
		} 
        else {
			resultado = "Fallido";
		} 
        return resultado;
        
    }
    
    /**
     * Este metodo valida que se haya aprobado el Documento por el Aprobador
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es la leyenda a validar en la notificación.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarOrdenAprobadaLiderTecnico(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("tab_orden_aprobada_lider");
        String text = this.buscarTextoTabla(driver, texto, "strong", elem);
        String msj = "";
        try{
            msj = this.AssertComparaMensajes(text, "Exitoso");
        }catch(ComparisonFailure e){
            msj = "Fallido, Resultado Esperado: "+e;
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
    
    public String validarDocumentoAprobadoFinal(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(2);
        String elem = Elementos.getProperty("div_lista_notificaciones");
        String text = this.buscarTextoTabla(driver, texto, "a", elem);
        String msj = "";
        try{
            msj = this.AssertComparaMensajes(text, "Fallido");
        }catch(ComparisonFailure e){
            msj = "Exitoso, Resultado Esperado: "+e;
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
    
    /************************** RECHAZAR **************************/
    
    /**
     * Este método hace clic en el icono Agregar Comentario.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickIcnAgregarComentario(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException, Exception{
        
        genericSteps.switchWindowByIndex(driver, 1);
    	dormirSeg(5);
    	bajarScroll(driver);
    	dormirSeg(1);
        clickJS(driver, "xpath", Elementos.getProperty("icon_agregar_comentario"));
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite ingresar el Comentario.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param comentario Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void ingresarComentario(RemoteWebDriver driver, Properties Elementos, 
    		String comentario, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
    	dormirSeg(3);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("txa_comentario"), comentario);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en el botón Aceptar del Comentario.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickBtnAceptarComentario(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException, Exception{
        clickJS(driver, "xpath", Elementos.getProperty("btn_ok_comentario"));
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en el botón Rechazar para el Acuerdo.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickBtnRechazar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException, Exception{
        clickJS(driver, "xpath", Elementos.getProperty("btn_rechazar"));
        genericSteps.switchWindowByIndex(driver, 0);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en el botón Rechazar para la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickBtnRechazarSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException, Exception{
        clickJS(driver, "xpath", Elementos.getProperty("btn_rechazar_solicitud"));
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método permite ingresar el Comentario.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param comentario Es la solicitud a buscar.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void ingresarComentarioSolicitud(RemoteWebDriver driver, Properties Elementos, 
    		String comentario, int contador, Properties Config, String Escenario, String navegador
    		) throws InterruptedException{
    	dormirSeg(3);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("txa_comentario_solicitud"), comentario);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en el botón Ejecutar para rechazar la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickBtnEjecutarRechazoSinMotivoSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException, Exception{
        clickJS(driver, "xpath", Elementos.getProperty("btn_ejecutar_rechazo"));
        //genericSteps.switchWindowByIndex(driver, 0);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método hace clic en el botón Ejecutar para rechazar la Solicitud.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public void clickBtnEjecutarRechazoSolicitud(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, String Escenario, String navegador) throws InterruptedException, Exception{
        clickJS(driver, "xpath", Elementos.getProperty("btn_ejecutar_rechazo"));
        genericSteps.switchWindowByIndex(driver, 0);
        dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método valida que se muestra mensaje de Error al rechazar sin motivo.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param contador Es el contador.
     * @param Config Es la configuración de la prueba.
     * @param Escenario Es el escenario de la prueba.
     * @param navegador Es el navegador a usar en la prueba.
     * @throws InterruptedException 
     */
    public String validarMensajeErrorRechazoSolicitud(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        dormirSeg(3);
        String elem = Elementos.getProperty("tab_mensaje_error");
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
     * Este mÃ©todo nos ayuda a obtener un valor en properties de orden de trabajo. 
     * @return La orden de trabajo que recien se agregÃ³.
     * @throws InterruptedException 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String getDato(String empresa, String tipoAcuerdo) throws InterruptedException, FileNotFoundException, IOException{
        Properties dato = new generic.genericGrid().getPropetiesFile("C:\\ambiente\\precondiciones\\"+tipoAcuerdo+".properties");      
        return dato.getProperty(empresa);
    }
    
}