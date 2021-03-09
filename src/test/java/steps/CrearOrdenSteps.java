package steps;


import generic.genericGrid;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CrearOrdenSteps extends genericGrid{

    /**
     * Esté método llena dialogo de crear acuerdo
    */
    public void llenarDialogoCrearOrden(RemoteWebDriver driver, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador,
    		String estilo, String udNegocioCompras,  String udNegocioSolicitante, String proveedor, String ubicacion,
    		String moneda, String comprador ) throws InterruptedException{
        borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("estilo"));
        seleccionarComboInputByValue(driver, "xpath", Elementos.getProperty("estilo"), estilo);
        //borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("ud_negocio_compras"));
        //seleccionarComboByText(driver, "xpath", Elementos.getProperty("ud_negocio_compras"), udNegocioCompras);
        //borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("ud_negocio_solicitante"));
        //seleccionarComboByText(driver, "xpath", Elementos.getProperty("ud_negocio_solicitante"), udNegocioSolicitante);
        ingresarTexto(driver, "xpath", Elementos.getProperty("proveedor"), proveedor);
        ingresarTexto(driver, "xpath", Elementos.getProperty("ubicacion"), ubicacion);
        //borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("moneda"));
        //seleccionarComboByValue(driver, "xpath", Elementos.getProperty("moneda"), moneda);
        //borrarTextoPrecargado(driver, "xpath", Elementos.getProperty("comprador"));
        //seleccionarComboByValue(driver, "xpath", Elementos.getProperty("comprador"), comprador);
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    	
    } 
    
    /**
     * Esté método seleccionar el boton crear
     * @throws IOException 
    */
    public void clickBtnCrear(RemoteWebDriver driver, String libro, Properties Elementos,
    		int contador, Properties Config, String Escenario, String navegador) throws InterruptedException, IOException{
        clickJS(driver, "xpath", Elementos.getProperty("btn_crear"));
    	this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    	this.obtenerDatoyGuradarArchivo(driver, Elementos, libro);
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
   public String obtenerDatoyGuradarArchivo(RemoteWebDriver driver, Properties Elementos, String propiedad) throws InterruptedException, IOException{
       //System.out.println(this.obtenerTexto(driver, "xpath", Elementos.getProperty("eam_lbl_orden_trabajo")).substring(25, 47));
       this.setDato(propiedad, this.obtenerTexto(driver, "xpath", Elementos.getProperty("lbl_crear_orden")).substring(36, 46));
       return this.obtenerTexto(driver, "xpath", Elementos.getProperty("lbl_crear_orden")).substring(36, 46);
   }


    /**
    * Este mÃ©todo nos ayuda actualizar un valor en properties de orden de trabajo.
    * @param Propiedad Es el dato que vamos a guardar.
    * @throws InterruptedException 
    * @throws FileNotFoundException
    * @throws IOException
    */
   public void setDato(String propiedad, String elemento) throws InterruptedException, FileNotFoundException, IOException{
       Properties ots = new generic.genericGrid().getPropetiesFile("C:\\ambiente\\precondiciones\\ordenCompraDisel.properties");
       ots.setProperty(propiedad, elemento);
       ots.store(new FileWriter("C:\\ambiente\\precondiciones\\ordenCompraDisel.properties"),"Actualizacion OC Disel");
   }
   

    
    

   
    
   
    
}
