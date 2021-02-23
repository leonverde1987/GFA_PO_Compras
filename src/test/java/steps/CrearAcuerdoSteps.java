package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CrearAcuerdoSteps extends genericGrid{

    /**
     * Esté método llena dialogo de crear acuerdo
    */
    public void llenarDialogoCrearAcuerdo(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String estilo, String udNegocioCompras, String proveedor,
    		String moneda, String comprador ) throws InterruptedException{
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("estilo"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("estilo"), estilo);
        seleccionarComboByText(driver, "xpath", Elementos.getProperty("ud_negocio_compras"), udNegocioCompras);
        dormirSeg(1);
        ingresarTexto(driver, "xpath", Elementos.getProperty("proveedor"), proveedor);
        dormirSeg(1);
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("moneda"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("moneda"), moneda);
        dormirSeg(1);
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("comprador"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("comprador"), comprador);
        
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método selecciona el boton crear en el dialogo de crear acuerdos
    */
    public void clickBtnCrearDialogAcuerdos(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
       click(driver, "xpath", Elementos.getProperty("btn_crear"));        
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método llena formulario de acuerdo de compra de contrato 
    */
    public void llenarFormAcuerdoCompraContrato(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String fechaInicio, String importeAcuerdo,
    		String descripcion, String gfaSupervisor, String gfaLiderCategoria )
    				throws InterruptedException{
           ingresarTexto(driver, "xpath", Elementos.getProperty("fecha_inicio"), fechaInicio);
           ingresarTexto(driver, "xpath", Elementos.getProperty("importe_acuerdo"), importeAcuerdo);
           ingresarTexto(driver, "xpath", Elementos.getProperty("descripcion"), descripcion);
           seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_supervisor"), gfaSupervisor);
           seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_Lider_Categoria"), gfaLiderCategoria);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método llena formulario de acuerdo de compra de contrato 
    */
    public void llenarFormGfaSupervisorCategoria(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String gfaSupervisor, 
    		String gfaLiderCategoria)
    				throws InterruptedException{
           seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_supervisor"), gfaSupervisor);
           seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_Lider_Categoria"), gfaLiderCategoria);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método selecciona el boton aceptar del mensaje de confirmacion 
    */
    public void clickBtnAceptarConfirmacion(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
         clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_confirmacion"));         
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método selecciona el boton agregar fila en la seccion de lineas
    */
    public void clickBtnAddFilaLinea(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
         clickJS(driver, "xpath", Elementos.getProperty("btn_add_fila_linea"));         
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método llena el formulario de una linea
     * @throws FileNotFoundException 
    */
    public void llenarFormLinea(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String lineaArticulo, String lineaArticuloProveedor,
    		String lineaPrecio, String lineaFechaCaducidad) throws InterruptedException, FileNotFoundException{
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("linea_articulo"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("linea_articulo"), lineaArticulo);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("linea_articulo_proveedor"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("linea_articulo_proveedor"), lineaArticuloProveedor);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("linea_precio"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("linea_precio"), lineaPrecio);
    	JSscrollToElement(driver, waitUIElementPresent(driver, "xpath",Elementos.getProperty("linea_fecha_caducidad")));
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("linea_fecha_caducidad"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("linea_fecha_caducidad"), lineaFechaCaducidad);  
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método selecciona la linea del articulo
    */
    public void selectLineaArt(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("fila_articulo"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Método para llenar formulario de controles
     */
    public void LlenarFormControles(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String udNegocioSolicitante, String sitioCompras,
    		String ubicacionEnvio, String udNegocioFactura, String ubicacionFactura)
    				throws InterruptedException{
    	//borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("ud_negocio_solicitante"));
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("ud_negocio_solicitante"), udNegocioSolicitante);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("sitio_compras"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("sitio_compras"), sitioCompras);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("ubicacion_envio"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("ubicacion_envio"), ubicacionEnvio);
    	//borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("ud_negocio_factura"));
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("ud_negocio_factura"), udNegocioFactura);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("ubicacion_factura"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("ubicacion_factura"), ubicacionFactura);
        
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Esté método el menu tab condiciones de consignacion
    */
    public void clickMenuTabCondicionesConsiga(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_tab_condicones_consigna"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    
    
    /**
     * Esté método llena el formulario de condiciones de consignacion
    */
    public void llenarFormCondicionesConsig(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String puntoInicioAntiguedad,
    		String frecuenciaAvisoConsumo, String fechaCierreFacturacion, String resumenAvisoConsumo)
    				throws InterruptedException{
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("punto_inicio_antiguedad"), puntoInicioAntiguedad);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("frecuencia_aviso_consumo"), frecuenciaAvisoConsumo);
    	ingresarTexto(driver, "xpath", Elementos.getProperty("fecha_cierre_facturacion"), fechaCierreFacturacion);
    	String locator = sobreEscribirLocator(Elementos.getProperty("resumen_aviso_consumo"), resumenAvisoConsumo);
    	clickJS(driver, "xpath", locator);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
   
    
}