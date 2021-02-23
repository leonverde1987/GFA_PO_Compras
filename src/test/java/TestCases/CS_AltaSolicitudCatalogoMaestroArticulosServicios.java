package TestCases;

import com.inflectra.spiratest.addons.junitextension.*;
import org.junit.Test;
import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;

import steps.CabeceraSteps;
import steps.CrearArticuloSteps;
import steps.GenericSteps;
import steps.LoginSteps;
import steps.MenuTareasSteps;
import steps.MenusNavegadorSteps;
import steps.SolicitudesCompraSteps;

@SpiraTestConfiguration(
	    url="https://testing-it.spiraservice.net",
	    login="automationQA",
	    password="test1234", 
	    projectId=67,
	    testSetId=2668
	)

public class CS_AltaSolicitudCatalogoMaestroArticulosServicios{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public SolicitudesCompraSteps solicitudesCompraSteps = new SolicitudesCompraSteps();
    public CabeceraSteps cabeceraSteps = new CabeceraSteps();
   
    
    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UISolicitudesCompra = null;
    public Properties UICabecera = null;
    
    
    public Properties Config = null;
    //public Properties Datos = null;
    public Properties Elementos = null;
    private RemoteWebDriver driver = null;
    public List<String> Pasos = new ArrayList<String>();
    public int contador = 0;
    public String Resultado = "";
    public String ResultadoGlobal = "";
    public String Escenario = "";
    public String RutaEvidencia = "";
    public String Navegador="";
    public CSVReader DataDriven=null;
    public String[] filaDatos=null;
  
    @Before
    public void PrepararEjecucion() throws FileNotFoundException, MalformedURLException, InterruptedException{
    
        Config = genericSteps.getPropetiesFile("configuracion\\configuracion.properties");
        UILogin = genericSteps.getPropetiesFile("configuracion\\uielements\\loginPage.properties");
        UIMenusNavegador = genericSteps.getPropetiesFile("configuracion\\uielements\\menusNavegador.properties");
        UISolicitudesCompra = genericSteps.getPropetiesFile("configuracion\\uielements\\solicitudesCompra.properties");
        UICabecera = genericSteps.getPropetiesFile("configuracion\\uielements\\cabecera.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\crear_solicitud\\dt_19611.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=19611)
    public void CS_AltaSolicitudCatalogoMaestroArticulosServicios_19611() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String mensaje = filaDatos[3];
            String categoria = filaDatos[4];
            String cantidad = filaDatos[5];
            String gfaSupervisor = filaDatos[6];
            try{

                    Escenario = "CS_AltaSolicitudCatalogoMaestroArticulosServicios "+Repeticion;

                    //Paso 1
                    Pasos.add(contador+".- Abrir navegador en la URL: "+Config.getProperty("urlOracle"));
                    genericSteps.ingresarAURL(driver, contador, Config, Escenario, Navegador);
                    
                    //Paso 2
                    contador++;
                    Pasos.add(contador+".- Ingresamos Usuario: "+usuario+" y Contraseña:"+pass);
                    genericSteps.loginOracle(driver, usuario, pass, idioma, contador, Config, UILogin, Escenario, Navegador);
                    
                    //Paso 3
                    contador++;
                    Pasos.add(contador+".- Abrir menú hamburguesa ");
                    menusNavegadorSteps.clickMenuHamburguesa(driver, UIMenusNavegador, contador, Config, Escenario, Navegador);
                 
                    //Paso 4
                    contador++;
                    Pasos.add(contador+".- Seleccionar menú: Compras => Solicitudes de compra ");
                    menusNavegadorSteps.abrirMenuSolicitudesCompra(driver, UIMenusNavegador, contador, 
                    		Config, Escenario, Navegador);
                    
                    //Paso 5
                    contador++;
                    Pasos.add(contador+".- Presionar sobre la opcion Comprar por categoria");
                    solicitudesCompraSteps.clickListaComprarCategoria(driver, UISolicitudesCompra, contador, Config, Escenario, Navegador);
                    
                    //Paso 6
                    contador++;
                    Pasos.add(contador+"Seleccionar una categoria");
                    solicitudesCompraSteps.selectCategoria(driver, UISolicitudesCompra, contador, Config, Escenario, Navegador, categoria);
                    
                    //Paso 7
                    contador++;
                    Pasos.add(contador+"Ingresar la cantidad de articulos del modelo a adquirir");
                    solicitudesCompraSteps.ingresarCantProdPlp(driver, UISolicitudesCompra, contador, Config, Escenario, Navegador, cantidad);
                    
                    //Paso 8
                    contador++;
                    Pasos.add(contador+"Seleccionar el boton agregar al carro");
                    solicitudesCompraSteps.selectBtnAddCarUno(driver, UISolicitudesCompra, contador, Config, Escenario, Navegador);
                    
                    //Paso 9
                    contador++;
                    Pasos.add(contador+"Seleccionar el boton carrito de la cabecera");
                    cabeceraSteps.selectCarritoCompras(driver, UICabecera, contador, Config, Escenario, Navegador);
                    
                    //Paso 10
                    contador++;
                    Pasos.add(contador+"Seleccionar el boton revisar carrito");
                    cabeceraSteps.clickBtnRevisarCar(driver, UICabecera, contador, Config, Escenario, Navegador);
                    
                    //Paso 11
                    contador++;
                    Pasos.add(contador+"Llenar formulario de solicitu de compra"); 
                    solicitudesCompraSteps.llenarFormSolicitudCompra(driver, UISolicitudesCompra, contador, Config, Escenario, Navegador,
                    		gfaSupervisor, categoria);
                    
                    //Paso 12
                    contador++;
                    Pasos.add(contador+"Seleccionar el boton guardar y cerrar"); 
                   cabeceraSteps.clickBtnGuardarCerrarG(driver, UICabecera, contador, Config, Escenario, Navegador);
                   
                   //Paso 13
                   contador++;
                   Pasos.add(contador+"Verifico que se haya guardado la solicitud"); 
                   solicitudesCompraSteps.clickBtnAceptarConfirmacionSolicitud(driver, UISolicitudesCompra, contador, Config, Escenario, Navegador);
                   Resultado = "Exitoso";
                   
                    
            }catch(NoSuchElementException s){
                Resultado = "Ejecución Fallida, No se encontró elemento: "+s;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }catch(InterruptedException e){
                Resultado = "Ejecución Fallida: "+e;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }finally{
                genericSteps.finalizarTestCase(driver, Escenario, Resultado, contador, Pasos, RutaEvidencia, Config.getProperty("Modulo"), Config.getProperty("Version"), Navegador);
                if(!"Exitoso".equals(Resultado.substring(0, 7))){
                    ResultadoGlobal = Resultado;
                }
                Resultado="Fallido";
                contador=0;
            }
            Repeticion++;
        }
        if(!"Exitoso".equals(ResultadoGlobal.substring(0, 7))){
            throw new Exception("Navegador: "+Navegador + "\n Resultado: \n" + ResultadoGlobal);
        }
    }

    @After
    public void cerrarTest(){
        genericSteps.cerrarNavegador(driver);
    }   
}
