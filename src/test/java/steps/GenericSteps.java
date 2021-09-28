package steps;


import generic.genericGrid;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import org.junit.ComparisonFailure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericSteps extends genericGrid{
    
    /**
     * Este método nos ayuda a regresar el nombre del navegador.
     * @param Cadena Nombre completo del navegador segun el driver.
     * @return Nombre corto del navegador.
     */
    public String navegador(String Cadena){
        String navegador="";
        Cadena = Cadena.substring(17, Cadena.length());
        //RemoteWebDriver: firefox on WINDOWS (32e13b4d-f272-43f3-9ad8-045535191a9a)
        for(int a = 0; Cadena.length() > a; a++){
            if(" ".equals(Cadena.substring(a, a+1))){
                a=Cadena.length()+1;
            }
            else{
                navegador = navegador + Cadena.substring(a, a+1);
            }
        }
        return navegador;
    }
    
    
    /**
     * Esté Método nos ayuda a dirigir el driver a una URL en especifico.
     * @param driver Elemento WebDriver de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @throws FileNotFoundException Cacha cualquier excepción en la ejecución.
     * @throws InterruptedException Cacha si el archivo Config no existe.
     */
    public void ingresarAURL(RemoteWebDriver driver, int contador, Properties Config, String Escenario, String navegador) throws FileNotFoundException, InterruptedException {
        try{
            this.abrirURl(driver, Config.getProperty("urlOracle"));
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        }catch(InterruptedException e){
            System.out.println("Mensaje: "+e);
        }
        
    }
    
    /**
     * Esté metodo nos ayuda a cerrar el driver.
     * @param driver  
     */
    public void cerrarNavegador(RemoteWebDriver driver) {
        this.cerrarDriver(driver);
    }
    
	/**
     * Captura una evidencia cuando el Test Falla.
     * @param driver Elemento WebDriver de la prueba.
     * @param Config Es el archivo config de la prueba.
     * @param error Es el número de error detectado.
     * @param Escenario Es el nombre del caso de prueba.
     * @param navegador Es el nombre del navegador donde se ejecuta la prueba.
     * @throws InterruptedException Cacha cualquier excepción.
     */
    public void capturarEvidencia(RemoteWebDriver driver, Properties Config, int error, String Escenario, String navegador) throws InterruptedException{
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), error, Escenario, navegador);
    }
    
    /**
     * Esté método finaliza el Test Case y genera las evidencias.
     * @param driver Es el nombre del driver.
     * @param Escenario Es el nombre del Test Case.
     * @param Resultado Es el resultado del Testa Case Exitoso, Fallido o Ejecución Fallida.
     * @param contador Es el total de pasos ejecutados.
     * @param Pasos Es el detalle de los pasos ejecutados.
     * @param RutaEvidencia Es la ruta principal de la evidencia.
     * @param Modulo Es el módulo del aplicativo que se ejecuta.
     * @param Version Es la versión del aplicativo.
     * @throws Exception Cacha cualquier excepción en la ejecución.
     */
    public void finalizarTestCase(RemoteWebDriver driver, String Escenario, String Resultado, int contador, List<String> Pasos, String RutaEvidencia, String Modulo, String Version, String navegador) throws Exception{
        this.GenerarEvidencias(driver, Escenario, Resultado, contador, Pasos, RutaEvidencia, Modulo, Version, navegador);
    }
    
    /**
     * 
     * @param Config
     * @throws InterruptedException
     * @throws FileNotFoundException 
     */
    public void ejecucionGrid(Properties Config) throws InterruptedException, FileNotFoundException{
        this.leventarNodosGrid();
    }
    
    /**
     * Cerramos los nodos del grid selenium.
     * @throws InterruptedException Cacha cualquier excepción de ejecución.
     */
    public void finEjecucionGrid() throws InterruptedException{
        this.cierraNodosGrid();
    }

    /**
     * Esté método nos ingresa contenido en un componente de texto.
     * @param driver Elemento WebDriver de la prueba.
     * @param usuario Es el valor del texto que se va ingresar al componente.
     * @param contador Es el controlador de pasos ejecutados.
     * @param contrasena Es la contraseña para hacer Login.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo. 
     * @param Escenario Nombre del caso de prueba a ejecutar.
     * @throws FileNotFoundException Cacha cualquier excepción en la ejecución.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void loginOracle(RemoteWebDriver driver, String usuario, String contrasena, String idioma, 
    		int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws FileNotFoundException, InterruptedException {
        this.ingresarTexto(driver, "id", Elementos.getProperty("id_usuario"), usuario);
        this.ingresarTexto(driver, "id", Elementos.getProperty("id_contrasena"), contrasena);
        this.seleccionarComboByValue(driver, "id", Elementos.getProperty("sl_idioma"), idioma);
        this.click(driver, "id", Elementos.getProperty("btn_conexion"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método nos ayuda a seleccionar una opción del combo prefijos.
     * @param driver Elemento WebDriver de la prueba.
     * @param textoBuscar Es el valor del texto que se va ingresar al componente.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @param Escenario Nombre del caso de prueba a ejecutar.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void seleccionarPrefijo(RemoteWebDriver driver, String textoBuscar, int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws InterruptedException{
        this.seleccionarComboByText(driver, "id", Elementos.getProperty("id_cbo_prefijo"), textoBuscar);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método nos ayuda a presionar el .
     * @param driver Elemento WebDriver de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @param Escenario Nombre del caso de prueba a ejecutar.
     * @param navegador Es el navegador donde se ejecuto la prueba.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void presionarBotonMas(RemoteWebDriver driver, int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws InterruptedException{
        this.click(driver, "xpath", Elementos.getProperty("xpath_btn_signoMas"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método nos ayuda a presionar el .
     * @param driver Elemento WebDriver de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @param Escenario Nombre del caso de prueba a ejecutar.
     * @param navegador Es el navegador donde se ejecuto la prueba.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void presionarConsultar(RemoteWebDriver driver, int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws InterruptedException{
        this.click(driver, "xpath", Elementos.getProperty("xpath_btn_consultar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método nos ayuda a presionar el botón tareas menú izquierda
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void clickBtnTareas(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
        this.click(driver, "xpath", Elementos.getProperty("btn_tareas"));
        
    }
    
    /**
     * Est´s método nos ayuda a validar el mensaje del resultado esperado. 
     * @param driver Elemento WebDriver de la prueba.
     * @param Dato Es el archivo de datos de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return Regresa el resultado Exitoso o Fallido y su detalle. 
     * @throws InterruptedException 
     */
    public String validarMensajeData(RemoteWebDriver driver, String mensajeActual, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        String msj = "";
        try{
            msj = this.AssertMsjElemento(driver, "xpath", mensajeActual, Elementos.getProperty("id_msj_ErrorLogin"));
        }catch(ComparisonFailure e){
            msj = "Fallido, Resultado Esperado: "+e;
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
    
    /**
     * Esté método valida la cuenta de compenzación de costos. 
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es el texto que vamos a buscar en el objeto.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param navegador Es el navegador donde se ejecuto la prueba.
     * @return Regresa el resultado Exitoso o Fallido y su detalle. 
     * @throws InterruptedException 
     */
    public String validarTextoEnObjeto(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        String text = this.buscarTextoTabla(driver, texto, "td", Elementos.getProperty("div_tabla_resultados"));
        String msj = "";
        try{
            msj = this.AssertComparaMensajes(text, "Exitoso");
        }catch(ComparisonFailure e){
            msj = "Fallido, Resultado Esperado: "+e;
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
    
        public String ValidarTextoEnObjetoResponse(RemoteWebDriver driver, String tagName, String texto, String atributo, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        String text = this.buscarTextoTabla(driver, texto, tagName, atributo);
        //String msj = "";
        /*try{
            msj = this.AssertComparaMensajes(text, "Exitoso");
        }catch(ComparisonFailure e){
            msj = "Fallido, Resultado Esperado: "+e;
        }*/
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return text;
    }
    /**
     * Esté método valida la cuenta de compenzación de costos. 
     * @param driver Elemento WebDriver de la prueba.
     * @param texto Es el texto que vamos a buscar en el objeto.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param navegador Es el navegador donde se ejecuto la prueba.
     * @throws InterruptedException 
     */
    public void presionarTextoEnTabla(RemoteWebDriver driver, String texto, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        this.presionarLkTabla(driver, texto, "div", Elementos.getProperty("div_seleccionar_proveedor"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método valida la cuenta de compenzación de costos. 
     * @param driver Elemento WebDriver de la prueba.
     * @param tagName Es el findBy del elemento.
     * @param texto Es el texto que vamos a buscar en el objeto.
     * @param atributo Es el elemento a buscar.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param navegador Es el navegador donde se ejecuto la prueba.
     * @throws InterruptedException 
     */
    public void presionarTextoEnTablaResponse(RemoteWebDriver driver, String tagName, String texto, String atributo, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        this.presionarLkTabla(driver, texto, tagName, atributo);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /* El método permite hacer switch a otra ventana por parte del contenido de su nombre
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param windowsTitle String parte del titulo de la entana
     */
    public boolean switchWindowByTitle(WebDriver driver, String windowsTitle) throws Exception{
    	try {
    		Boolean result = false;
    		for (String handle: driver.getWindowHandles()) {
    			driver.switchTo().window(handle);
		    	if (driver.getTitle().toString().contains(windowsTitle)) {
		    		result = true;
		    		break;
		    	}
    		}
    		
    		return result;
    	}
    	catch(Exception ex) {
    		throw new Exception("Error al hacer switch a la ventana: " + windowsTitle);
    	}	
    }

     /* El método permite hacer switch a otra ventana por el index de la ventana
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param windowsTitle String parte del titulo de la entana
     */
    public boolean switchWindowByIndex(WebDriver driver, int windowsIndex) throws Exception{
    	dormirSeg(2);
    	try {
    		Boolean result = false;
    		int index = 0;
    		for (String handle: driver.getWindowHandles()) {
    			driver.switchTo().window(handle);
		    	if (index == windowsIndex) {
		    		result = true;
		    		break;
		    	}
		    	index++;
    		}
    		
    		return result;
    	}
    	catch(Exception ex) {
    		throw new Exception("Error al hacer switch a la ventana con index: " + windowsIndex);
    	}	
    }
    
    /**
     * Esté método cierra la sesión del usuario.
     * @param driver Elemento WebDriver de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo. 
     * @param Escenario Nombre del caso de prueba a ejecutar.
     * @param navegador Es el navegador a utilizar.
     * @throws FileNotFoundException Cacha cualquier excepción en la ejecución.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void cerrarSesion(RemoteWebDriver driver, int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws FileNotFoundException, InterruptedException {
        this.dormirSeg(2);
        this.clickJS(driver, "xpath", Elementos.getProperty("lk_usuario"));
        this.dormirSeg(2);
        this.clickJS(driver, "xpath", Elementos.getProperty("lk_cerrar_sesion"));
        this.dormirSeg(2);
        this.clickJS(driver, "xpath", Elementos.getProperty("btn_confirmar_cierre"));
    }

    
    /**
     * Esté método selecciona el boton guardar de la cabecera. 
     */
    public void presionarBtnGuardarCabecera(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) 
    		throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_guardar_cabecera"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    public void logoutOracle(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
    	try {
            this.clickJS(driver, "xpath", Elementos.getProperty("lg_img_sesion"));
            this.dormirSeg(1);
            this.clickJS(driver, "xpath", Elementos.getProperty("lg_lnk_cerrar_sesion"));
            this.dormirSeg(3);
            this.click(driver, "xpath", Elementos.getProperty("lg_btn_confirma_logOut"));    		
    	} catch (Exception e) {
			// TODO: handle exception
    		System.out.println("Error Al hacer logout. Exception: " + e.getMessage());
		}
    }
}




