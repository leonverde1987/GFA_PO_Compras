package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CabeceraSteps extends genericGrid{

    /**
     * Método para seleccionar el carrito de compras
     */
    public void selectCarritoCompras(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_carrito_compras"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton revisar carrito
     */
    public void clickBtnRevisarCar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_revisar_carrito"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton guardar y cerrar dentro del boton guardar
     */
    public void clickBtnGuardarCerrarG(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("btn_guardar"));
    	dormirSeg(2);
        clickJS(driver, "xpath", Elementos.getProperty("btn_guardar_guardar_cerrar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton enviar
     */
    public void clickBtnEnviar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("btn_enviar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton ver ciclo de vida
     */
    public void clickBtnVerCicloVida(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("btn_ver_ciclo_vida"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar el boton Ver PDF
     */
    public void clickBtnVerPdf(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("btn_mensaje_ver_pdf"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton Ver PDF
     */
    public void clickBtnAceptarmsj(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("btn_mensaje_aceptar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton acciones
     */
    public void clickBtnAcciones(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	dormirSeg(2);
    	click(driver, "xpath", Elementos.getProperty("menu_btn_acciones"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton acciones => Editar
     */
    public void clickBtnAccionesEditar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("menu_btn_acciones_editar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton acciones => Reasignar
     */
    public void clickBtnAccionesReasignar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("menu_btn_acciones_reaccionar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton acciones => retirar
     */
    public void clickBtnAccionesRetirar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("menu_btn_acciones_retirar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar ingresar motivo
     */
    public void ingresarMotivoRetiro(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	//click(driver, "xpath", Elementos.getProperty("txt_motivo_retirar"));
    	ingresarTexto(driver, "xpath", Elementos.getProperty("txt_motivo_retirar"), "text");
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar ingresar motivo
     */
    public void clickAceptarMotivoRetiro(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("aceptar_motivo_retirar"));
    	//ingresarTexto(driver, "xpath", Elementos.getProperty("txt_motivo_retirar"), "text");
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar el boton acepatr
     */
    public void clickBtnAceptar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	dormirSeg(2);
    	click(driver, "xpath", Elementos.getProperty("btn_aceptar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton listo
     */
    public void clickBtnListo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("btn_listo"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar el si del mensahe
     *      */
    public void clickBtnSiMsj(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("btn_si_mensaje"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el si del mensahe
     *      */
    public void clickBtnSiMsj_1(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("btn_si_mensaje_1"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton agregar mas lineas
     */
    public void clickBtnAddLineas(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("btn_add_lineas"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el boton validar
     */
    public void clickBtnValidar(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("td_validar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para seleccionar el boton agregar a carro 
     */
    public void clickBtnAgregarCarro(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
    	click(driver, "xpath", Elementos.getProperty("btn_add_carro"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el el boton Comprobar Fondos
     */
    public void selectBtnComprobarFondos(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_comprobar_fondos"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el el boton Guardar cabecera
     */
    public void selectBtnGuardarCabecera(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador) throws InterruptedException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_guardar_cabecera"));
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
     * Esté método selecciona el boton aceptar del mensaje de confirmacion 
    */
    public void clickBtnAceptarConfirmacion2(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador)
    				throws InterruptedException{
        dormirSeg(2); 
    	clickJS(driver, "xpath", Elementos.getProperty("btn_aceptar_confirmacion_2"));         
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
   
   
    
}
