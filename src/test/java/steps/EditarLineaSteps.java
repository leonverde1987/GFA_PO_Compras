package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EditarLineaSteps extends genericGrid{

    /**
     * Método para llenar form editar linea
     */
    public void llenarFormEditarLinea(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String tipoLinea, String articulo, String unidadMedida, String precio)
    				throws InterruptedException{
    	//borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("tipo_linea"));
    	//seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("tipo_linea"), tipoLinea);
    	//borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("articulo"));
    	//ingresarTexto(driver, "xpath", Elementos.getProperty("articulo"), articulo);
    	//borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("unidad_medida"));
    	//seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("unidad_medida"), unidadMedida);
    	dormirSeg(3);
    	//borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("precio"));
    	//ingresarTexto(driver, "xpath", Elementos.getProperty("precio"), precio);
    	clickJS(driver, "xpath", Elementos.getProperty("permitir_sustitucion_precio"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Método para seleccionar el menu tabs controles
     */
    public void selectMenuTabControles(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador)
    				throws InterruptedException{
    	clickJS(driver, "xpath", Elementos.getProperty("menu_tab_controles"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    /**
     * Método para ingresar numero de acuerdo
     */
    public void ingresarAcuerdo(RemoteWebDriver driver, Properties Elementos, int contador, Properties Config, 
    		String Escenario, String navegador, String acuerdo)
    				throws InterruptedException{
    	ingresarTexto(driver, "xpath", Elementos.getProperty("txt_acuerdo"), acuerdo);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }

  
    
    
   
   
    
}
