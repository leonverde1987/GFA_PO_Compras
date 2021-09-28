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
import steps.CrearAcuerdoSteps;
import steps.CrearArticuloSteps;
import steps.CrearSolicitudNoIncluidaCatalogoSteps;
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

public class CS_CrearBorradorIngresandoLineasDeSolicitudAP{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public SolicitudesCompraSteps solicitudesCompraSteps = new SolicitudesCompraSteps();
    public CabeceraSteps cabeceraSteps = new CabeceraSteps();
    public CrearSolicitudNoIncluidaCatalogoSteps crearSolicitudNoIncluidaCatalogoSteps = new CrearSolicitudNoIncluidaCatalogoSteps();
    public CrearAcuerdoSteps crearAcuerdoSteps = new  CrearAcuerdoSteps();
   
    
    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UISolicitudesCompra = null;
    public Properties UICabecera = null;
    public Properties UICrearSolicitudNoIncluidaCatalogo = null;
    public Properties UICrearAcuerdo = null;

    
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
        UICrearSolicitudNoIncluidaCatalogo = genericSteps.getPropetiesFile("configuracion\\uielements\\crearSolicitudNoIncluidaCatalogo.properties");
        UICrearAcuerdo = genericSteps.getPropetiesFile("configuracion\\uielements\\crearAcuerdos.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\crear_solicitud\\dt_15318.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=15318)
    public void CS_CrearBorradorIngresandoLineasDeSolicitudAP_15318() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String mensaje = filaDatos[3];
            String tipoArticulo = filaDatos[4];
            String descripcion = filaDatos[5];
            String nombreCategoria = filaDatos[6];
            String nombreUM = filaDatos[7];
            String precio = filaDatos[8];
            String moneda = filaDatos[9];
            String proveedor = filaDatos[10];
            String articuloProveedor = filaDatos[11];
            String gfaSupervisor = filaDatos[12];
            String gfaLiderCategoria = filaDatos[13];
            
           
            
            try{

                    Escenario = "CS_CrearBorradorIngresandoLineasDeSolicitudAP "+Repeticion;

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
                    Pasos.add(contador+".- Seleccionar menu Mas Tareas");
                    solicitudesCompraSteps.clickBtnMasTareas(driver, UISolicitudesCompra, contador, Config, Escenario, Navegador);
                   
                    //Paso 6
                    contador++;
                    Pasos.add(contador+".- Seleccionar opcion Introducir Lineas de Solicitud");
                    solicitudesCompraSteps.clickOpcIntroducirLineaSolicitud(driver, UISolicitudesCompra, contador, Config, Escenario, Navegador);
                 
                  
                   //Paso 7
                    contador++;
                    Pasos.add(contador+".- Llenar formulario Crear Solicitud No Incluida en el Catalogo");
                    crearSolicitudNoIncluidaCatalogoSteps.llenarFormCSNoIncluidaCatalogo(driver, UICrearSolicitudNoIncluidaCatalogo,
                    		contador, Config, Escenario, Navegador, tipoArticulo, descripcion, nombreCategoria, 
                    		nombreUM, precio, moneda, proveedor, articuloProveedor);
               
                    //Paso 8
                    contador++;
                    Pasos.add(contador+".- Seleccionar boton Agregar al carro de la cabecera");
                    cabeceraSteps.clickBtnAgregarCarro(driver, UICabecera, contador, Config, Escenario, Navegador);
                    
                                    
                    //Paso 9
                    contador++;
                    Pasos.add(contador+".- Presionar sobre el boton agregar al carro");
                    cabeceraSteps.selectCarritoCompras(driver, UICabecera, contador, Config, Escenario, Navegador);
                    
                    //Paso 10
                    contador++;
                    Pasos.add(contador+"Seleccionar el boton revisar carrito");
                    cabeceraSteps.clickBtnRevisarCar(driver, UICabecera, contador, Config, Escenario, Navegador);
                    
                    //Paso 11
                    contador++;
                    Pasos.add(contador+"LLenar GFA Supervisor y GFA Categoria");
                    crearAcuerdoSteps.llenarFormGfaSupervisorCategoria(driver, UICrearAcuerdo,
                    		contador, Config, Escenario, Navegador, gfaSupervisor, gfaLiderCategoria);             
                    
                  
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
            }catch(Exception ex){
                Resultado = "Ejecución Fallida: "+ex;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }finally{
                genericSteps.logoutOracle(driver, UILogin);
                genericSteps.finalizarTestCase(driver, Escenario, Resultado, contador, Pasos, RutaEvidencia, Config.getProperty("Modulo"), Config.getProperty("Version"), Navegador);
                if(!"Exitoso".equals(Resultado.substring(0, 7))){
                    ResultadoGlobal = Resultado;
                }
                Resultado="Fallido";
                contador=1;
                Pasos.clear();
            }
            Repeticion++;
        }
    }

    @After
    public void cerrarTest(){
        genericSteps.cerrarNavegador(driver);
    }   
}
