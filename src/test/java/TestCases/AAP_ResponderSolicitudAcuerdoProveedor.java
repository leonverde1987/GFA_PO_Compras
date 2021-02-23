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
import steps.EnviarInformacionSteps;
import steps.GenericSteps;
import steps.GestionarSolicitudesSteps;
import steps.LineasSteps;
import steps.LoginSteps;
import steps.MenuTareasSteps;
import steps.MenusNavegadorSteps;
import steps.SolicitarInformacionSteps;
import steps.SolicitudesCompraSteps;

@SpiraTestConfiguration(
	    url="https://testing-it.spiraservice.net",
	    login="automationQA",
	    password="test1234", 
	    projectId=67,
	    testSetId=2668
	)

public class AAP_ResponderSolicitudAcuerdoProveedor{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public CabeceraSteps cabeceraSteps = new CabeceraSteps();
    public LineasSteps lineasSteps = new LineasSteps();
    public SolicitarInformacionSteps solicitarInformacionSteps = new SolicitarInformacionSteps();
    public EnviarInformacionSteps enviarInformacionSteps = new EnviarInformacionSteps();
    
    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UICabecera = null;
    public Properties UILineas = null;
    public Properties UISolicitarInformacion = null;
    public Properties UIEnviarInformacion = null;

    
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
        UILineas = genericSteps.getPropetiesFile("configuracion\\uielements\\lineas.properties");
        UISolicitarInformacion = genericSteps.getPropetiesFile("configuracion\\uielements\\solicitarInformacion.properties");
        UIEnviarInformacion = genericSteps.getPropetiesFile("configuracion\\uielements\\enviarInformacion.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\aprobar_acuerdo_proveedor\\dt_25162.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=25162)
    public void AAP_ResponderSolicitudAcuerdoProveedor_25162() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String mensaje = filaDatos[3];
            String filtroBusqueda = filaDatos[4];
            String nombre = filaDatos[5];
            String comentario = filaDatos[6];
            String opcDevolucion = filaDatos[7];          
    
            try{

                    Escenario = "AAP_ResponderSolicitudAcuerdoProveedor "+Repeticion;

                    //Paso 1
                    Pasos.add(contador+".- Abrir navegador en la URL: "+Config.getProperty("urlOracle"));
                    genericSteps.ingresarAURL(driver, contador, Config, Escenario, Navegador);
                    
                    //Paso 2
                    contador++;
                    Pasos.add(contador+".- Ingresamos Usuario: "+usuario+" y Contraseña:"+pass);
                    genericSteps.loginOracle(driver, usuario, pass, idioma, contador, Config, UILogin, Escenario, Navegador);
                    
                    //Paso 3
                    contador++;
                    Pasos.add(contador+".- Presionar sobre la campana de notificaciones");
                    menusNavegadorSteps.presionarCampanaNotificaciones(driver, UIMenusNavegador,
                    		contador, Config, Escenario, Navegador);
                                      
                    //Paso 4
                    contador++;
                    Pasos.add(contador+".- Seleccionar Opcion ");
                    menusNavegadorSteps.selectFiltroNotificacion(driver, UIMenusNavegador,
                    		contador, Config, Escenario, Navegador, filtroBusqueda);
                    genericSteps.switchWindowByIndex(driver, 1);
                    
                    
                    //Paso 5
                    Pasos.add(contador+".- agregar comentario");
                    lineasSteps.addComentario(driver, UILineas,
                    		contador, Config, Escenario, Navegador);
                    
                    //Paso 6
                    contador++;
                    Pasos.add(contador+".- seleccionar el menu acciones ");
                    lineasSteps.menuAcciones1(driver, UILineas,
                    		contador, Config, Escenario, Navegador);
                    

                    //Paso 7
                    contador++;
                    Pasos.add(contador+".- seleccionar el menu acciones ");
                    lineasSteps.menuAccionesEnviarInfo(driver, UILineas,
                    		contador, Config, Escenario, Navegador);
                    
                    //Paso 8
                    contador++;
                    Pasos.add(contador+".- seleccionar la opcion enviar informacion dentro del menu acciones ");
                    genericSteps.switchWindowByIndex(driver, 0);
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
