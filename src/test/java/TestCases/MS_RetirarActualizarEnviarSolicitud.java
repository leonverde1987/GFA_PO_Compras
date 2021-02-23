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
import steps.EditarSolicitudSteps;
import steps.GenericSteps;
import steps.GestionarSolicitudesSteps;
import steps.LineasSteps;
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

public class MS_RetirarActualizarEnviarSolicitud{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public SolicitudesCompraSteps solicitudesCompraSteps = new SolicitudesCompraSteps();
    public CabeceraSteps cabeceraSteps = new CabeceraSteps();
    public CrearSolicitudNoIncluidaCatalogoSteps crearSolicitudNoIncluidaCatalogoSteps = new CrearSolicitudNoIncluidaCatalogoSteps();
    public CrearAcuerdoSteps crearAcuerdoSteps = new  CrearAcuerdoSteps();
    public LineasSteps lineasSteps = new LineasSteps();
    public GestionarSolicitudesSteps gestionarSolicitudesSteps = new GestionarSolicitudesSteps();
    public EditarSolicitudSteps editarSolicitudSteps = new EditarSolicitudSteps();
   
    
    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UISolicitudesCompra = null;
    public Properties UICabecera = null;
    public Properties UICrearSolicitudNoIncluidaCatalogo = null;
    public Properties UICrearAcuerdo = null;
    public Properties UILineas = null;
    public Properties UIGestionarSolicitudes = null;
    public Properties UIEditarSolicitud = null;

    
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
        UILineas = genericSteps.getPropetiesFile("configuracion\\uielements\\lineas.properties");
        UIGestionarSolicitudes = genericSteps.getPropetiesFile("configuracion\\uielements\\gestionarSolicitudes.properties");
        UIEditarSolicitud = genericSteps.getPropetiesFile("configuracion\\uielements\\editarSolicitud.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\modificar_solicitud\\dt_15378.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=15378)
    public void MS_RetirarActualizarEnviarSolicitud_15378() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String mensaje = filaDatos[3];
            String introducidaPor = filaDatos[4];
            String solicitud = filaDatos[5];
            String proveedor = filaDatos[6];
            String articulo = filaDatos[7];
            String editSolDescripcion = filaDatos[8];
            String editSolGfaSupervisor = filaDatos[9];
            String editSolGfaLiderCatego = filaDatos[10];

            
            try{

                    Escenario = "MS_RetirarActualizarEnviarSolicitud "+Repeticion;

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
                    Pasos.add(contador+".- Seleccionar el menu Gestionar Solicitudes");
                    solicitudesCompraSteps.clickGestionarSolicitudes(driver, UISolicitudesCompra, contador, Config, Escenario, Navegador);
                    
                    //Paso 6
                    contador++;
                    Pasos.add(contador+".- Llenar formulario gestionar solicitudes Buscar");
                    gestionarSolicitudesSteps.llenarFormGestionarSolBuscar(driver, UIGestionarSolicitudes,
                    		contador, Config, Escenario, Navegador, introducidaPor, solicitud, proveedor, articulo);
                    
                  //Paso 7
                    contador++;
                    Pasos.add(contador+".- Seleccionar el boton Buscar");
                    gestionarSolicitudesSteps.clickBtnBuscar(driver, UIGestionarSolicitudes, 
                    		contador, Config, Escenario, Navegador);
                    
                  //Paso 8
                    contador++;
                    Pasos.add(contador+".- Seleccionar el registro de la solicitud");
                    gestionarSolicitudesSteps.selectRegSolicitud(driver, UIGestionarSolicitudes,
                    		contador, Config, Escenario, Navegador, solicitud);
                    
                    //Paso 9
                    contador++;
                    Pasos.add(contador+".- Seleccionar sobre la opcion Acciones");
                    lineasSteps.menuAcciones(driver, UILineas,
                    		contador, Config, Escenario, Navegador);
                    
                   //Paso 10
                    contador++;
                    Pasos.add(contador+".- Seleccionar la opcion Editar del menu Acciones");
                    lineasSteps.menuAccionesEditar(driver, UILineas,
                    		contador, Config, Escenario, Navegador);
                    
                    
                    //Paso 11
                    contador++;
                    Pasos.add(contador+".- Editar formulario de solicitud");
                    editarSolicitudSteps.llenarFormEditarSolicitud(driver, UIEditarSolicitud, contador, Config, Escenario,
                    		Navegador, editSolDescripcion, editSolGfaSupervisor, editSolGfaLiderCatego);
                    
                 
                    //Paso 12
                    contador++;
                    Pasos.add(contador+".- Seleccionar boton enviar de la cabecera");
                    cabeceraSteps.clickBtnEnviar(driver, UICabecera,
                    		contador, Config, Escenario, Navegador);
                   
                                 
                    
                  //Paso 14
                    contador++;
                    Pasos.add(contador+".- Seleccionar boton Aceptar ");
                    cabeceraSteps.clickBtnAceptarmsj(driver, UICabecera,
                    		contador, Config, Escenario, Navegador);
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
