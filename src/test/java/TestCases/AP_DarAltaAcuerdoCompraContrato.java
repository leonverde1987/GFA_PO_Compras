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
import steps.EditarLineaSteps;
import steps.GenericSteps;
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

public class AP_DarAltaAcuerdoCompraContrato{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public CabeceraSteps cabeceraSteps = new CabeceraSteps();
    public MenuTareasSteps menuTareasSteps = new MenuTareasSteps();
    public CrearAcuerdoSteps crearAcuerdosSteps = new CrearAcuerdoSteps();
    public LineasSteps lineasSteps = new LineasSteps();
    public EditarLineaSteps editarLineaSteps = new EditarLineaSteps();
   
    
    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UICabecera = null;
    public Properties UIMenusTareas = null;
    public Properties UICrearAcuerdos = null;
    public Properties UILineas = null;
    public Properties UIEditarLinea = null;
    
    
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
        UICabecera = genericSteps.getPropetiesFile("configuracion\\uielements\\cabecera.properties");
        UIMenusTareas = genericSteps.getPropetiesFile("configuracion\\uielements\\menusTareas.properties");
        UILineas = genericSteps.getPropetiesFile("configuracion\\uielements\\lineas.properties");
        UIEditarLinea = genericSteps.getPropetiesFile("configuracion\\uielements\\editarLinea.properties");
        UICrearAcuerdos = genericSteps.getPropetiesFile("configuracion\\uielements\\crearAcuerdos.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\acuerdos_proveedor\\dt_17311.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=17311)
    public void AP_DarAltaAcuerdoCompraContrato_17311() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String mensaje = filaDatos[3];
            String estilo = filaDatos[4];
            String udNegocioCompras = filaDatos[5];
            String proveedor = filaDatos[6];
            String moneda = filaDatos[7];
            String comprador = filaDatos[8];
            String fechaInicio = filaDatos[9];
            String importeAcuerdo = filaDatos[10];
            String descripcion = filaDatos[11];
            String gfaSupervisor = filaDatos[12];
            String gfaLiderCategoria = filaDatos[13];
            String udNegocioSolicitante = filaDatos[14];
            String sitioCompras = filaDatos[15];
            String ubicacionEnvio = filaDatos[16];
            String udNegocioFactura = filaDatos[17];
            String ubicacionFactura = filaDatos[18];
            
            
        
            try{

                    Escenario = "AP_DarAltaAcuerdoCompraContrato "+Repeticion;

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
                    Pasos.add(contador+".- Seleccionar menú: Compras => Acuerdos de compra");
                    menusNavegadorSteps.abrirMenuAcuerdosCompra(driver, UIMenusNavegador, contador, 
                    		Config, Escenario, Navegador);
                    
                    //Paso 5
                    contador++;
                    Pasos.add(contador+".- Seleccionar menú: Tareas");
                    menuTareasSteps.clickBtnTareas(driver, UIMenusTareas, contador, Config, Escenario, Navegador);
                    
                    //Paso 6
                    contador++;
                    Pasos.add(contador+".- Seleccionar Crear acuerdo del menú tareas");
                    menuTareasSteps.clickBtnCrearAcuerdo(driver, UIMenusTareas, contador, Config, Escenario, Navegador);
                 
                    //Paso 7
                    contador++;
                    Pasos.add(contador+".- LLenar dialogo de crear acuerdo");
                    crearAcuerdosSteps.llenarDialogoCrearAcuerdo(driver, UICrearAcuerdos, contador, Config, Escenario, Navegador,
                    		estilo, udNegocioCompras, proveedor, moneda, comprador);
                    
                    //Paso 8
                    contador++;
                    Pasos.add(contador+".- Presionar el boton crear");
                    String empresa = "API";
                    String tipoAcuerdo = "AcuerdoCompraContrato";
                    crearAcuerdosSteps.clickBtnCrearDialogAcuerdos(driver, empresa ,UICrearAcuerdos, contador, Config, Escenario, Navegador, tipoAcuerdo);
                    
                    //Paso 9
                    contador++;
                    Pasos.add(contador+".- Ingresar informacion en los campos");
                    crearAcuerdosSteps.llenarFormAcuerdoCompraContrato(driver, UICrearAcuerdos, contador, Config, Escenario, Navegador,
                    		fechaInicio, importeAcuerdo, descripcion, gfaSupervisor, gfaLiderCategoria);
                    
                    //Paso 10
                    contador++;
                    Pasos.add(contador+".- Seleccionar el menu tab controles");
                    editarLineaSteps.selectMenuTabControles(driver, UIEditarLinea, contador, Config, Escenario, Navegador);
                    
                    //Paso 11
                    contador++;
                    Pasos.add(contador+".- LLenar formulario de controles");
                    crearAcuerdosSteps.LlenarFormControles(driver, UICrearAcuerdos, contador, Config, Escenario, Navegador, 
                    		udNegocioSolicitante, sitioCompras, ubicacionEnvio, udNegocioFactura, ubicacionFactura);
                    
                    
                  //Paso 11
                    contador++;
                    Pasos.add(contador+".- LLenar formulario de controles");
                    cabeceraSteps.clickBtnGuardarCerrarG(driver, UICabecera, contador, Config, Escenario, Navegador);
                    Resultado = "Exitoso";
                    
                    
                  
                    //Paso 12
                    //contador++;
                    //Pasos.add(contador+".- Presionar sobre el boton enviar de la cabecera");
                    //cabeceraSteps.clickBtnEnviar(driver, UICabecera, contador, Config, Escenario, Navegador);
                    
                    //Paso 13
                    //contador++;
                    //Pasos.add(contador+"Validar mensaje de confirmacion"); 
                    //crearAcuerdosSteps.clickBtnAceptarConfirmacion(driver, UICrearAcuerdos, contador, Config, Escenario, Navegador);
                    
                    
                   
                    
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
        
    }

    @After
    public void cerrarTest(){
        genericSteps.cerrarNavegador(driver);
    }   
}
