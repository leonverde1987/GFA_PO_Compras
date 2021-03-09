package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LineasSteps extends genericGrid{

    /**
     * Método para seleccionar el boton editar en lineas
     */
    public void selectBtnEditar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_editar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el numero de acuerdo en la linea
     */
    public void selectNumeroAcuerdo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("numero_acuerdo"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion Si en el boton urgente
     */
    public void selectOpcSiUrgente(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("opc_si_urgente"), "Sí");
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para llenar el formulario detalles de la linea
     */
    public void llenarFormDetallesLinea(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String fechaEntrega, String tipoDestino,
    		String subinventario) throws InterruptedException{
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("fecha_entrega"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("fecha_entrega"), fechaEntrega);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("tipo_destino"), tipoDestino);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("subinventario"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("subinventario"), subinventario);
    	
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar el menu Acciones
     */
    public void menuAcciones(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("menu_acciones"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el menu Acciones
     */
    public void menuAcciones1(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("menu_acciones1"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para agregar comentario
     */
    public void addComentario(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("img_add_comentario"));
    	dormirSeg(3);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("comentario"), "comentario");
    	clickJS(driver, "xpath", Elementos.getProperty("btn_Aceptar_comentario"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar la opcion editar del menu Acciones
     */
    public void menuAccionesEditar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_acciones_editar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion retener del menu Acciones
     */
    public void menuAccionesRetener(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_acciones_retener"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar la opcion congelar del menu Acciones
     */
    public void menuAccionesCongelar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_acciones_congelar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar la opcion retirar del menu Acciones
     */
    public void menuAccionesRetirar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_acciones_retirar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion crear del menu Acciones
     */
    public void menuAccionesCrear(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_acciones_crear"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion cerrar del menu Acciones
     */
    public void menuAccionesCerrar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_acciones_cerrar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para ingresar motivo de retencion
     */
    public void motivoRetencion(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	ingresarTexto(driver, "xpath", Elementos.getProperty("motivo_retencion"), "test");
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar el boton aceptar el motivo de retencion
     */
    public void aceptarMotivoRetencion(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("aceptar_motivo_retencion"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar la opcion solicitar informacion dentro del menu acciones
     */
    public void menuAccionesSolicitarInfo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_acciones_solicitar_info"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion enviar informacion dentro del menu acciones
     */
    public void menuAccionesEnviarInfo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_acciones_enviar_info"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion Reasignacion dentro del menu acciones
     */
    public void menuAccionesReasignacion(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_acciones_reasignacion"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion Solicitar mas informacion dentro del menu acciones
     */
    public void menuAccionesSolicitarMasInfo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_acciones_solicitar_info"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la opcion agregar lineas
     */
    public void clickAddLinea(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_add_fila"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para llenar un registro de lineas
     * @throws FileNotFoundException 
     */
    public void llenarRegLinea(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String lineaArticulo, String lineaCantidad) throws InterruptedException, FileNotFoundException{
    	dormirSeg(3);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("articulo"), lineaArticulo);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("cantidad"), lineaCantidad);
    	dormirSeg(3);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("cantidad"), lineaCantidad);
    	dormirSeg(1);
    	JSscrollToElement(driver, waitUIElementPresent(driver, "xpath", 
         		Elementos.getProperty("ubicacion")));    	
    	ingresarTexto(driver, "xpath", Elementos.getProperty("ubicacion"), "LEON CORPORATIVO");
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
  
    /**
     * Método para seleccionar la pestaña programas
     */
    public void clickPestaniaProgramas(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("pestania_programas"));
    	dormirSeg(2);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar la pestaña lineas
     */
    public void clickPestaniaLineas(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("pestania_lineas"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para ingresar fechas en la pestaña programs
     */
    public void fechasPestaniaProgramas(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String fechaSolicitada, String fechaPrometida ) throws InterruptedException{
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("programa_fecha_solicitada"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("programa_fecha_solicitada"), fechaSolicitada);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("programa_fecha_prometida"), fechaPrometida);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar del menu Acciones => Duplicar
     */
    public void menuAccionesDuplicar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("menu_acciones_duplicar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar crear solicitud nueva en el mensaje de advertencia
     */
    public void menuCrearSolicitudNuevaMsjInfo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("crear_solicitud_nueva_msj_info"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar boton si en el mensaje de advertencia
     */
    public void clickSiAdvertencia(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("si_advertencia"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
   
   
    
}
