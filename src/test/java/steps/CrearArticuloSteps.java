package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CrearArticuloSteps extends genericGrid{

    /**
     * Esté método llena formulario de crear artículo
    */
    public void llenarDialogoCrearArticulo(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String organizacion, String articuloNuevoCopia, String numeroArticulos,
    		String claseArticulo) throws InterruptedException{
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("organizacion"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("organizacion"), organizacion);
    	String locator = sobreEscribirLocator(Elementos.getProperty("articulo_nuevo_copia"), articuloNuevoCopia);
    	clickJS(driver, "xpath", locator);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("numero_articulos"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("numero_articulos"), numeroArticulos);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("clase_articulo"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("clase_articulo"), claseArticulo);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método llena formulario de crear artículo de copia
    */
    public void llenarDialogoCrearArticuloCopia(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String organizacion, String articuloNuevoCopia, String numeroArticulos)
    				throws InterruptedException{
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("organizacion"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("organizacion"), organizacion);
    	String locator = sobreEscribirLocator(Elementos.getProperty("articulo_nuevo_copia"), articuloNuevoCopia);
    	clickJS(driver, "xpath", locator);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("numero_articulos"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("numero_articulos"), numeroArticulos);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método da click en el boton aceptar crear articulo
    */
    public void clickAceptarCrearArticulo(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("aceptar_crear_articulo"));
      this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    /**
     * Esté método llena formulario de crear artículo
    */
    public void llenarFormCrearArticulo(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String articulo, String descripcion) throws InterruptedException{
    	String random = numeroRandomString();
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("articulo"));
        ingresarTexto(driver, "xpath", Elementos.getProperty("articulo"), articulo+random);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("descripcion"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("descripcion"), descripcion);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método mueve el foco de la pantalla a la pestaña Vision General
     * @throws FileNotFoundException 
    */
    public void irPestaniaVisionGeneral(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException, FileNotFoundException{
    	JSscrollToElement(driver, waitUIElementPresent(driver, "xpath", 
        		Elementos.getProperty("pestania_vision_general")));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 

    /**
     * Esté método llena formulario de crear artículo
    */
    public void llenarFormVisionGeneral(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String descripcionLarga, String unidadMedidaPrincipal) throws InterruptedException{
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("descripcion_larga"));
        ingresarTexto(driver, "xpath", Elementos.getProperty("descripcion_larga"), descripcionLarga);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("unidad_medida_principal"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("unidad_medida_principal"), unidadMedidaPrincipal);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método mueve el foco de la pantalla a la pestaña Categorias
    */
    public void irPestaniaCategorias(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("pestania_categorias"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método selecciona el boton agregar fila de la pestaña categorias
    */
    public void llenarFormCateAddFila(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String catalogo)
    				throws InterruptedException{
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("catalogo"), catalogo);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 

    /**
     * Esté método selecciona el boton agregar fila de la pestaña categorias
    */
    public void clickCategoriasAgregarFila(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("categorias_agregar_fila"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    

    /**
     * Esté método selecciona el boton aplicar de la busqueda de organizacion
    */
    public void clickBtnAplicarBusquedaOrg(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_aplicar_busqueda_organizacion"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método selecciona el boton listo de la busqueda de organizacion
    */
    public void clickBtnListoBusquedaOrg(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_listo_busqueda_organizacion"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    
    /**
     * Esté método mueve el foco de la pantalla a la pestaña Especificaciones
     * @throws FileNotFoundException 
    */
    public void irPestaniaEspecificaciones(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException, FileNotFoundException{
    	clickJS(driver, "xpath", Elementos.getProperty("pestania_Especificaciones"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Esté método mueve el foco de la pantalla a la pestaña Planificacion
     * @throws FileNotFoundException 
    */
    public void irPestaniaPlanificacion(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException, FileNotFoundException{
    	clickJS(driver, "xpath", Elementos.getProperty("pestania_Planificacion"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método mueve el foco de la pantalla a la pestaña Asociaciones
     * @throws FileNotFoundException 
    */
    public void irPestaniaAsociaciones(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException, FileNotFoundException{
    	clickJS(driver, "xpath", Elementos.getProperty("pestania_Asociaciones"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    
    /**
     * Esté método selecciona el icono seleccionar agregar
     * @throws FileNotFoundException 
    */
    public void clickIconoSeleccionarAgregar(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException, FileNotFoundException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_seleccionar_agregar"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }

    /**
     * Esté método ingresa la organizacion en el fltro de busqueda
     * @throws FileNotFoundException 
    */
    public void ingresarOrganizacionBusqueda(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String organizacionBusqueda)
    				throws InterruptedException, FileNotFoundException{
    	ingresarTexto(driver, "xpath", Elementos.getProperty("txt_organizacion_busqueda"), organizacionBusqueda);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    
    /**
     * Esté método selecciona el link atributos adicionales
    */
    public void clickAtributosAdicionales(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("atributos_adicionales"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método selecciona el link atributos adicionales
    */
    public void assertLblContexto(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
    	AssertMsjElemento(driver, "xpath", "Contexto", Elementos.getProperty("label_contexto"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Esté método selecciona la lupa para buscar articulos
    */
    public void clickLupaArticulos(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("lupita_articulo"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método ingresa el codigo del articulo a buscar
    */
    public void ingresarCodigoArticulo(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador, String codigoArticulo)
    				throws InterruptedException{
    	ingresarTexto(driver, "xpath", Elementos.getProperty("codigo_articulo_empieza_por"), codigoArticulo);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método da click sobre el boton buscar para ver los resultados de la busqueda de un articulo
    */
    public void clickBtnBuscarArticulo(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_buscar_articulo"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método da click sobre el primer resultado del articulo buscado
    */
    public void clickFilaUnoArticuloEncontrado(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("fila_uno_articulo_encontrado"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método da click sobre el boton aceptar de la busqueda
    */
    public void clickBtnAceptarBusqueda(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_busqueda_articulo"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    

    /**
     * Esté método llena formulario de Organizacion de articulo
    */
    public void llenarFormOrganizacionArticulo(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String contexto, String gfaUsoCfdi, String gfaGlClass, String gfaClasificacionArticulo, String gfaTipoCompra )
    				throws InterruptedException{
    	//borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("contexto"));
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("contexto"), contexto);
    	
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("gfa_uso_cfdi"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_uso_cfdi"), gfaUsoCfdi);    	
    	
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("gfa_gl_class"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_gl_class"), gfaGlClass);
    	
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("gfa_clasificacion_articulo"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_clasificacion_articulo"), gfaClasificacionArticulo);
    	
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("gfa_tipo_compra"));
    	seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("gfa_tipo_compra"), gfaTipoCompra);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    /**
     * Esté método llena formulario de planificacion
    */
    public void llenarFormPlanificacion(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String metodoPlanificacionInv, String fabricarComprar, String minima, String maxima, String metodoPlanificacionStockSeg,
    		String autorizacionLiberacionNec, String caducidadAutoNotifiEnvioAnti, String enConsignacion)
    				throws InterruptedException{
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("metodo_planificacion_inv"), metodoPlanificacionInv);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("fabricar_comprar"), fabricarComprar);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("minima"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("minima"), minima);
    	borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("maxima"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("maxima"), maxima);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("metodo_planificacion_stock_seg"), metodoPlanificacionStockSeg);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("autorizacion_liberacion_nec"), autorizacionLiberacionNec);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("caducidad_auto_notifi_envio_anti"), caducidadAutoNotifiEnvioAnti);
    	seleccionarComboByText(driver, "xpath", Elementos.getProperty("en_consignacion"), enConsignacion);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
    
    
    
    /**
     * Esté método valida que exista la etiqueta social
    */
    public void assertLblSocial(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
    	AssertMsjElemento(driver, "xpath", "Social", Elementos.getProperty("lbl_social"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    } 
   
    
}
