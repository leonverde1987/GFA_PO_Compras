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
import steps.CrearOrdenSteps;
import steps.CrearSolicitudNoIncluidaCatalogoSteps;
import steps.EditarDocumentoOC;
import steps.EditarLineaSteps;
import steps.GeneradorDocumentos;
import steps.GenericSteps;
import steps.GestionarSolicitudesSteps;
import steps.LineasSteps;
import steps.LoginSteps;
import steps.MenuTareasSteps;
import steps.MenusNavegadorSteps;
import steps.ProcesarSolicitudesSteps;
import steps.RecibirArticulosSteps;
import steps.SolicitudesCompraSteps;

@SpiraTestConfiguration(
	    url="https://testing-it.spiraservice.net",
	    login="automationQA",
	    password="test1234", 
	    projectId=67,
	    testSetId=2668
	)

public class GR_RecepcionParcialArticulos{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public CabeceraSteps cabeceraSteps = new CabeceraSteps();
    public LineasSteps lineasSteps = new LineasSteps();
    public MenuTareasSteps menuTareasSteps = new MenuTareasSteps();
    public ProcesarSolicitudesSteps procesarSolicitudesSteps = new ProcesarSolicitudesSteps();
    public GeneradorDocumentos generadorDocumentos = new GeneradorDocumentos();
    public EditarDocumentoOC editarDocumentoOC = new EditarDocumentoOC();
    public CrearOrdenSteps crearOrden = new CrearOrdenSteps();
    public EditarLineaSteps editarLineaSteps = new EditarLineaSteps();
    public GestionarSolicitudesSteps gestionarSolicitudesSteps = new GestionarSolicitudesSteps();
    public RecibirArticulosSteps recibirArticulosSteps = new RecibirArticulosSteps();
   
   
    
    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UICabecera = null;
    public Properties UILineas = null;
    public Properties UIMenuTareas = null;
    public Properties UIProcesarSolicitudes = null;
    public Properties UIGeneradorDocumentos = null;
    public Properties UIEditarDocumentoOC = null;
    public Properties UICrearOrden = null;
    public Properties UIEditarLinea = null;
    public Properties UIGestionarSolicitudes = null;
    public Properties UIRecibirArticulos = null;
    
    
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
        UIMenuTareas = genericSteps.getPropetiesFile("configuracion\\uielements\\menusTareas.properties");
        UIProcesarSolicitudes = genericSteps.getPropetiesFile("configuracion\\uielements\\procesarSolicitudes.properties");
        UIGeneradorDocumentos = genericSteps.getPropetiesFile("configuracion\\uielements\\generadorDocumentos.properties");
        UIEditarDocumentoOC = genericSteps.getPropetiesFile("configuracion\\uielements\\editarDocumentoOC.properties");
        UICrearOrden = genericSteps.getPropetiesFile("configuracion\\uielements\\crearOrden.properties");
        UIEditarLinea = genericSteps.getPropetiesFile("configuracion\\uielements\\editarLinea.properties");
        UIGestionarSolicitudes = genericSteps.getPropetiesFile("configuracion\\uielements\\gestionarSolicitudes.properties");
        UIRecibirArticulos = genericSteps.getPropetiesFile("configuracion\\uielements\\recibirArticulos.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\gestionar_recibos\\dt_20643.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=20643)
    public void GR_RecepcionParcialArticulos_20643() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String mensaje = filaDatos[3];
            String introducidaPor = filaDatos[4];
            String solicitud = filaDatos[5];
            String cantidad = filaDatos[6];
            String notaEmbarque = filaDatos[7];
            String notaEmpaquetado = filaDatos[8];
            
            
            try{

                    Escenario = "GR_RecepcionParcialArticulos "+Repeticion;

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
                    menusNavegadorSteps.abrirMenuMisRecepciones(driver, UIMenusNavegador, contador, 
                    		Config, Escenario, Navegador);
                    
                    //Paso 5
                    contador++;
                    Pasos.add(contador+".- Llenar formulario de recibir articulos");
                   recibirArticulosSteps.llenarRecibirArticulos(driver, UIRecibirArticulos, 
                		   contador, Config, Escenario, Navegador, introducidaPor, solicitud);
                   
                   //Paso 6
                   contador++;
                   Pasos.add(contador+".- Seleccionar el boton Buscar");
                   recibirArticulosSteps.clickBtnBuscar(driver, UIRecibirArticulos,
                		   contador, Config, Escenario, Navegador);
                   

                   //Paso 7
                   contador++;
                   Pasos.add(contador+".- Seleccionar el registro de la solicitud");
                   recibirArticulosSteps.clickRegSolicitud(driver, UIRecibirArticulos,
                		   contador, Config, Escenario, Navegador, solicitud);
                   
                   

                   //Paso 8
                   contador++;
                   Pasos.add(contador+".- Presionar sobre el boton recibir");
                   recibirArticulosSteps.clickBtnRecibir(driver, UIRecibirArticulos, 
                		   contador, Config, Escenario, Navegador);
                   

                   //Paso 9
                   contador++;
                   Pasos.add(contador+".- Presionar sobre el boton moston mostrar cantidad de repcion");
                   recibirArticulosSteps.clickBtnMostrarCantRec(driver, UIRecibirArticulos, 
                		   contador, Config, Escenario, Navegador);
                   

                   //Paso 10
                   contador++;
                   Pasos.add(contador+".- Ingresar la informacion en los campos");
                   recibirArticulosSteps.ingresarCantRepcion(driver, UIRecibirArticulos,
                		   contador, Config, Escenario, Navegador, cantidad, notaEmbarque, notaEmpaquetado);
                   

                   //Paso 11
                   contador++;
                   Pasos.add(contador+".- Presionar sobre el botn enviar");
                   cabeceraSteps.clickBtnEnviar(driver, UICabecera,
                		   contador, Config, Escenario, Navegador);
                   

                   //Paso 12
                   contador++;
                   Pasos.add(contador+".- Seleccionar el boton Aceptar");
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
    }

    @After
    public void cerrarTest(){
        genericSteps.cerrarNavegador(driver);
    }   
}
