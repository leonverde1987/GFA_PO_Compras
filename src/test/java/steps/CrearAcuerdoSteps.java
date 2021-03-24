package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        //borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("moneda"));
        //seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("moneda"), moneda);
        //dormirSeg(1);
        //borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("comprador"));
        //seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("comprador"), comprador);
        
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método selecciona el boton crear en el dialogo de crear acuerdos
    */
    public void clickBtnCrearDialogAcuerdos(RemoteWebDriver driver, String libro, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String tipoAcuerdo)
    				throws InterruptedException, IOException{
    	dormirSeg(3);
       click(driver, "xpath", Elementos.getProperty("btn_crear"));        
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        //return this.obtenerAcuerdoCompra(driver, Elementos, empresa);
    	dormirSeg(6);
        this.obtenerDatoyGuradarArchivo(driver, Elementos, libro, tipoAcuerdo);
    } 
    
    /**
     * Este mÃ©todo obtiene el nÃºmero de la orden de trabajo. 
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param propiedad es el valor de la propiedad que se va actualizar en el archivo.
     * @return El nÃºmero de la orden de trabajo.
     * @throws InterruptedException
     * @throws IOException 
     */
    public String obtenerDatoyGuradarArchivo(RemoteWebDriver driver, Properties Elementos, String propiedad, String tipoAcuerdo) 
    		throws InterruptedException, IOException{
        //System.out.println(this.obtenerTexto(driver, "xpath", Elementos.getProperty("eam_lbl_orden_trabajo")).substring(25, 47));
    	String[] num_acuerdo = this.obtenerTexto(driver, "xpath", Elementos.getProperty("var_retorno_acuerdo_compra_abierto")).split(":");
    	this.setDato(propiedad, num_acuerdo[1].trim(), tipoAcuerdo);
    	return num_acuerdo[1].trim();
        //return this.obtenerTexto(driver, "xpath", Elementos.getProperty("var_retorno_acuerdo_compra_abierto")).substring(46, 56);
    }


     /**
     * Este mÃ©todo nos ayuda actualizar un valor en properties de orden de trabajo.
     * @param Propiedad Es el dato que vamos a guardar.
     * @throws InterruptedException 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void setDato(String propiedad, String elemento, String tipoAcuerdo) throws InterruptedException, FileNotFoundException, IOException{
        Properties ots = new generic.genericGrid().getPropetiesFile("C:\\ambiente\\precondiciones\\"+tipoAcuerdo+".properties");
        ots.setProperty(propiedad, elemento);
        ots.store(new FileWriter("C:\\ambiente\\precondiciones\\"+tipoAcuerdo+".properties"),"Actualizacion acuerdo de compra OK");
    }
    
    
    /**
    * Este mÃ©todo nos ayuda actualizar un valor en properties de orden de trabajo.
    * @param Propiedad Es el dato que vamos a guardar.
    * @throws InterruptedException 
    * @throws FileNotFoundException
    * @throws IOException
    */
   public void setDatoAcuerdoContrato(String propiedad, String elemento) throws InterruptedException, FileNotFoundException, IOException{
       Properties ots = new generic.genericGrid().getPropetiesFile("C:\\ambiente\\precondiciones\\acuerdoCompraContrato.properties");
       ots.setProperty(propiedad, elemento);
       ots.store(new FileWriter("C:\\ambiente\\precondiciones\\acuerdoCompraContrato.properties"),"Actualizacion acuerdo de compra contrato OK");
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
    
    /**
     * Este método nos ayuda actualizar un valor en properties de acuerdo de compra.
     * @param porpiedad Es el número del acuerdo de compra.
     * @throws InterruptedException 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void setGuardarAcuerdoCompra(String propiedad, String elemento) throws InterruptedException, FileNotFoundException, IOException{
        Properties ac = new generic.genericGrid().getPropetiesFile("configuracion\\acuerdoCompra.properties");
        ac.setProperty(propiedad, elemento);
        ac.store(new FileWriter("configuracion\\acuerdoCompra.properties"),"Actualización de Acuerdo de Compra");
    }
    
    /**
     * Este método nos ayuda a obtener un valor en properties de acuerdo de compra. 
     * @return El acuerdo de compra que recien se agregó.
     * @throws InterruptedException 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String getGuardarAcuerdoCompra(String libro) throws InterruptedException, FileNotFoundException, IOException{
        Properties ac = new generic.genericGrid().getPropetiesFile("configuracion\\acuerdoCompraAbierto.properties");      
        return ac.getProperty(libro);
    }
    
    /**
     * Este mÃ©todo nos ayuda a obtener un valor en properties de orden de trabajo. 
     * @return La orden de trabajo que recien se agregÃ³.
     * @throws InterruptedException 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String getDato(String empresa) throws InterruptedException, FileNotFoundException, IOException{
        Properties dato = new generic.genericGrid().getPropetiesFile("C:\\ambiente\\precondiciones\\acuerdoCompraAbierto.properties");      
        return dato.getProperty(empresa);
    }
    
    /**
     * Este método nos ayuda a obtener un valor en properties de acuerdo de compra. 
     * @return El acuerdo de compra que recien se agregó.
     * @throws InterruptedException 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String obtenerAcuerdoCompra(RemoteWebDriver driver, Properties Elementos, String propiedad) throws InterruptedException, IOException {
        this.setGuardarAcuerdoCompra(propiedad,this.obtenerTexto(driver, "xpath", Elementos.getProperty("h1_numero_acuerdo")).substring(46, 56));
        return Elementos.getProperty("h1_numero_acuerdo");
    }
    
}
