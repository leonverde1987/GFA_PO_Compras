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
import steps.EditarDocumentoOC;
import steps.GeneradorDocumentos;
import steps.GenericSteps;
import steps.LineasSteps;
import steps.LoginSteps;
import steps.MenuTareasSteps;
import steps.MenusNavegadorSteps;
import steps.ProcesarSolicitudesSteps;
import steps.SolicitudesCompraSteps;

@SpiraTestConfiguration(
	    url="https://testing-it.spiraservice.net",
	    login="automationQA",
	    password="test1234", 
	    projectId=67,
	    testSetId=2668
	)

public class COC_DarAltaOrdenCompraEAM{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public SolicitudesCompraSteps solicitudesCompraSteps = new SolicitudesCompraSteps();
    public CabeceraSteps cabeceraSteps = new CabeceraSteps();
    public CrearSolicitudNoIncluidaCatalogoSteps crearSolicitudNoIncluidaCatalogoSteps = new CrearSolicitudNoIncluidaCatalogoSteps();
    public CrearAcuerdoSteps crearAcuerdoSteps = new  CrearAcuerdoSteps();
    public LineasSteps lineasSteps = new LineasSteps();
    public MenuTareasSteps menuTareasSteps = new MenuTareasSteps();
    public ProcesarSolicitudesSteps procesarSolicitudesSteps = new ProcesarSolicitudesSteps();
    public GeneradorDocumentos generadorDocumentos = new GeneradorDocumentos();
    public EditarDocumentoOC editarDocumentoOC = new EditarDocumentoOC();
   
    
    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UISolicitudesCompra = null;
    public Properties UICabecera = null;
    public Properties UICrearSolicitudNoIncluidaCatalogo = null;
    public Properties UICrearAcuerdo = null;
    public Properties UILineas = null;
    public Properties UIMenuTareas = null;
    public Properties UIProcesarSolicitudes = null;
    public Properties UIGeneradorDocumentos = null;
    public Properties UIEditarDocumentoOC = null;
    
    
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
        UIMenuTareas = genericSteps.getPropetiesFile("configuracion\\uielements\\menusTareas.properties");
        UIProcesarSolicitudes = genericSteps.getPropetiesFile("configuracion\\uielements\\procesarSolicitudes.properties");
        UIGeneradorDocumentos = genericSteps.getPropetiesFile("configuracion\\uielements\\generadorDocumentos.properties");
        UIEditarDocumentoOC = genericSteps.getPropetiesFile("configuracion\\uielements\\editarDocumentoOC.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\crear_orden_compra\\dt_20642.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=20642)
    public void COC_DarAltaOrdenCompraEAM_20642() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String mensaje = filaDatos[3];
            String solicitud = filaDatos[4];
            String tipo = filaDatos[5];
            String acuerdoOrigen = filaDatos[6];
            String estilo = filaDatos[7];
            String proveedor = filaDatos[8];
            String sitioProveedor = filaDatos[9];
            String moneda = filaDatos[10];
            String editDocDescripcion = filaDatos[11];
            String editDocGfaSupervisor = filaDatos[12];
            String editDocGfaLiderCatego = filaDatos[13];
            String fechaSolicitada = filaDatos[14];
            String fechaPrometida = filaDatos[15];
            
            
            
            try{

                    Escenario = "COC_DarAltaOrdenCompraEAM "+Repeticion;

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
                    menusNavegadorSteps.abrirMenuOrdenesCompra(driver, UIMenusNavegador, contador, 
                    		Config, Escenario, Navegador);
                    
                    //Paso 5
                    contador++;
                    Pasos.add(contador+".-Seleccionar el menu tareas");
                    menuTareasSteps.clickBtnTareas(driver, UIMenuTareas, contador, 
                    		Config, Escenario, Navegador);
                   
                    //Paso 6
                    contador++;
                    Pasos.add(contador+".-seleccionar la opcion procesar solicitudes ");
                    menuTareasSteps.clickBtnProcesarSolicitudes(driver, UIMenuTareas, contador, 
                    		Config, Escenario, Navegador); 
                    
                    //Paso 7
                    contador++;
                    Pasos.add(contador+".-Ingresar solicitud de compra");
                    procesarSolicitudesSteps.llenarFormProcesarSolicitudesFiltroSolicitud(driver, UIProcesarSolicitudes,
                    		contador, Config, Escenario, Navegador, solicitud);
                    
                    //Paso 8
                    contador++;
                    Pasos.add(contador+".-Presionar el boton buscar");
                    procesarSolicitudesSteps.clickBtnBuscar(driver, UIProcesarSolicitudes,
                    		contador, Config, Escenario, Navegador);
                    
                    //Paso 9
                    contador++;
                    Pasos.add(contador+".-Seleccionar la casilla de la solicitud de compra");
                    procesarSolicitudesSteps.clickFilaSolicitud(driver, UIProcesarSolicitudes,
                    		contador, Config, Escenario, Navegador, solicitud);
                    
                    //Paso 10
                    contador++;
                    Pasos.add(contador+".-Presionar el boton agregar al generador de documentos");
                    procesarSolicitudesSteps.clickBtnAgregarGeneradorDoc(driver, UIProcesarSolicitudes,
                    		contador, Config, Escenario, Navegador);
                    
                    //Paso 11
                    contador++;
                    Pasos.add(contador+".-Ingresar la informacion en los campos");
                    generadorDocumentos.llenarFormGeneradorDoc(driver, UIGeneradorDocumentos,
                    		contador, Config, Escenario, Navegador, tipo, acuerdoOrigen, estilo, proveedor, sitioProveedor, moneda);
                    
                    //Paso 12
                    contador++;
                    Pasos.add(contador+".-Presionar el boton Aceptar");
                    generadorDocumentos.clickBtnEditar(driver, UIGeneradorDocumentos, 
                    		contador, Config, Escenario, Navegador);
              
                    //Paso13
                    contador++;
                    Pasos.add(contador+".-Presionar el boton Agregar mas lineas");
                   cabeceraSteps.clickBtnAddLineas(driver, UICabecera,
                		   contador, Config, Escenario, Navegador);
                  
                   //Paso 14
                   contador++;
                   Pasos.add(contador+".-Seleccionar las lineas a agregar");
                   procesarSolicitudesSteps.clickFilaSolicitud(driver, UIProcesarSolicitudes,
                   		contador, Config, Escenario, Navegador, solicitud);
                   
                   //Paso 15
                   contador++;
                   Pasos.add(contador+".-Presionar el boton agregar al generador de documentos");
                   procesarSolicitudesSteps.clickBtnAgregarGeneradorDoc(driver, UIProcesarSolicitudes,
                   		contador, Config, Escenario, Navegador);
                   
                 //Paso 16
                   contador++;
                   Pasos.add(contador+".-Presionar sobre el boton crear");
                   procesarSolicitudesSteps.clickBtnCrear(driver, UIProcesarSolicitudes,
                		   contador, Config, Escenario, Navegador);
                   
                   //Paso 17
                   contador++;
                   Pasos.add(contador+".-Presionar sobre el boton aceptar");
                   cabeceraSteps.clickBtnAceptarmsj(driver, UICabecera,
                		   contador, Config, Escenario, Navegador);
                   
                   //Paso 18
                   contador++;
                   Pasos.add("Ingresar la informacion en los campos");
                   editarDocumentoOC.llenarFormEditarDocOC(driver, UIEditarDocumentoOC,
                		   contador, Config, Escenario, Navegador, editDocDescripcion, editDocGfaSupervisor, editDocGfaLiderCatego);
                   
                   //Paso 19
                   contador++;
                   Pasos.add("Seleccionar la pestaña programas");
                   lineasSteps.clickPestaniaProgramas(driver, UILineas, 
                		   contador, Config, Escenario, Navegador);
                   
                   //Paso 20
                   contador++;
                   Pasos.add("Ingresar la informacion en los campos");
                   lineasSteps.fechasPestaniaProgramas(driver, UILineas,
                		   contador, Config, Escenario, Navegador, fechaSolicitada, fechaPrometida);
                   
                   //Paso 21
                   contador++;
                   Pasos.add("Seleccionar el menu acciones");
                   cabeceraSteps.clickBtnAcciones(driver, UICabecera,
                		   contador, Config, Escenario, Navegador);
                   
                   //Paso 22
                   contador++;
                   Pasos.add("Seleccionar la opcion validar");
                   cabeceraSteps.clickBtnValidar(driver, UICabecera,
                		   contador, Config, Escenario, Navegador);
                   
                   // Paso 23
                   contador++;
                   Pasos.add("Aceptar mensaje");
                   cabeceraSteps.clickBtnAceptarmsj(driver, UICabecera,
                		   contador, Config, Escenario, Navegador);
                   
                   //Paso 24
                   contador++;
                   Pasos.add("Seleciconar boton enviar");
                   cabeceraSteps.clickBtnEnviar(driver, UICabecera,
                		   contador, Config, Escenario, Navegador);
                   
                   //Paso 25
                   contador++;
                   Pasos.add("Aceptar mensaje");
                   cabeceraSteps.clickBtnAceptarmsj(driver, UICabecera,
                		   contador, Config, Escenario, Navegador);
                   
                   
                   
                
                   
                   
                   
                    
             
                    
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
