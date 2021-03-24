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
import steps.GenericSteps;
import steps.LoginSteps;
import steps.MenusNavegadorSteps;
import steps.AprobacionSteps;

@SpiraTestConfiguration(
	    url="https://testing-it.spiraservice.net",
	    login="automationQA",
	    password="test1234", 
	    projectId=67,
	    testSetId=2668
	)

public class PO_AprobarSolicitud_RechazarSolicitud{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public AprobacionSteps aprobacionSteps = new AprobacionSteps();


    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UIAutoaprobacion = null;
    public Properties UIAprobacion = null;
    
    
    public Properties Config = null;
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
        UIAutoaprobacion = genericSteps.getPropetiesFile("configuracion\\uielements\\autoaprobacion.properties");
        UIAprobacion = genericSteps.getPropetiesFile("configuracion\\uielements\\aprobacion.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\aprobar_solicitud\\dt_20159.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=20159)
    public void Test_PO_AprobarSolicitud_RechazarSolicitud() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String numeroSolicitud = filaDatos[3];
            String comentario = filaDatos[4];
            String solicitante = filaDatos[5];
            try{

                    Escenario = "PO_Aprobar Solicitud_Rechazar solicitud "+Repeticion;

                    //Paso 1
                    Pasos.add(contador+".- Ingresar a la URL: "+Config.getProperty("urlOracle"));
                    genericSteps.ingresarAURL(driver, contador, Config, Escenario, Navegador);
                    
                    //Paso 2
                    contador++;
                    Pasos.add(contador+".- Ingresar Usuario: "+usuario+" y Contraseña: "+pass);
                    genericSteps.loginOracle(driver, usuario, pass, idioma, contador, Config, UILogin, Escenario, Navegador);
                    
                    //Paso 3
                    contador++;
                    Pasos.add(contador+".- Presionar sobre la campana de Notificaciones.");
                    aprobacionSteps.clickCampanaNotificaciones(driver, UIAutoaprobacion, contador, Config, Escenario, Navegador);
                    
                    //Paso 4
                    contador++;
                    Pasos.add(contador+".- Presionar sobre la notificación para aprobación de la Solicitud de Compra: "+numeroSolicitud);
                    aprobacionSteps.clickNotificacionAcuerdoAprobacion(driver, UIAutoaprobacion, "Acción Necesaria: Aprobar solicitud "+numeroSolicitud, contador, Config, Escenario, Navegador);
                    
                    //Paso 5
                    contador++;
                    Pasos.add(contador+".- Presionar el botón Rechazar.");
                    aprobacionSteps.clickBtnRechazarSolicitud(driver, UIAprobacion, contador, Config, Escenario, Navegador);
                    
                    //Paso 6
                    contador++;
                    Pasos.add(contador+".- Ingresar el Comentario.");
                    aprobacionSteps.ingresarComentarioSolicitud(driver, UIAprobacion, comentario, contador, Config, Escenario, Navegador);
                    
                    //Paso 7
                    contador++;
                    Pasos.add(contador+".- Presionar el botón Ejecutar.");
                    aprobacionSteps.clickBtnEjecutarRechazoSolicitud(driver, UIAprobacion, contador, Config, Escenario, Navegador);
                    
                    //Paso 8
                    contador++;
                    Pasos.add(contador+".- Validar que se haya rechazado la Solicitud de compra.");
                    genericSteps.cerrarSesion(driver, contador, Config, UILogin, Escenario, Navegador);
                    genericSteps.loginOracle(driver, solicitante, pass, idioma, contador, Config, UILogin, Escenario, Navegador);
                    aprobacionSteps.clickCampanaNotificaciones(driver, UIAutoaprobacion, contador, Config, Escenario, Navegador);
                    Resultado = aprobacionSteps.validarFacturaAutoaprobada(driver, "Mensaje Informativo: Solicitud "+numeroSolicitud+" rechazada", Config, UIAutoaprobacion, contador, Escenario, Navegador);
                    
            }catch(NoSuchElementException s){
                Resultado = "Ejecución Fallida, No se encontró elemento: "+s;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }catch(InterruptedException e){
                Resultado = "Ejecución Fallida: "+e;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }finally{
                genericSteps.cerrarSesion(driver, contador, Config, UILogin, Escenario, Navegador);
                genericSteps.finalizarTestCase(driver, Escenario, Resultado, contador, Pasos, RutaEvidencia, Config.getProperty("Modulo"), Config.getProperty("Version"), Navegador);
                if(!"Exitoso".equals(Resultado.substring(0, 7))){
                    ResultadoGlobal = Resultado;
                }
                Resultado="Fallido";
                contador=0;
                Pasos.clear();
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
