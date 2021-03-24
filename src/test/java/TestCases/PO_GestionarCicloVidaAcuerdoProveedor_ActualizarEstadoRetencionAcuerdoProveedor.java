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
import steps.GestionarAcuerdosSteps;

@SpiraTestConfiguration(
	    url="https://testing-it.spiraservice.net",
	    login="automationQA",
	    password="test1234", 
	    projectId=67,
	    testSetId=2668
	)

public class PO_GestionarCicloVidaAcuerdoProveedor_ActualizarEstadoRetencionAcuerdoProveedor{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public AprobacionSteps aprobacionSteps = new AprobacionSteps();
    public GestionarAcuerdosSteps gestionarAcuerdosSteps = new GestionarAcuerdosSteps();


    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UIGestionarAcuerdos = null;
    
    
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
    public String numeroAcuerdo="";
        
    @Before
    public void PrepararEjecucion() throws FileNotFoundException, MalformedURLException, InterruptedException{
    
        Config = genericSteps.getPropetiesFile("configuracion\\configuracion.properties");
        UILogin = genericSteps.getPropetiesFile("configuracion\\uielements\\loginPage.properties");
        UIMenusNavegador = genericSteps.getPropetiesFile("configuracion\\uielements\\menusNavegador.properties");
        UIGestionarAcuerdos = genericSteps.getPropetiesFile("configuracion\\uielements\\gestionarAcuerdos.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\ciclo_vida_acuerdo_proveedor\\dt_17326.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=17326)
    public void Test_PO_GestionarCicloVidaAcuerdoProveedor_ActualizarEstadoRetencionAcuerdoProveedor() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        String tipoAcuerdo = "acuerdoCompraContrato";
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String BU = filaDatos[3];
            String libro = filaDatos[4];
            String motivo = filaDatos[5];
            String mensajeConfirmacion = filaDatos[6];
            String estado = filaDatos[7];
            numeroAcuerdo = aprobacionSteps.getDato(libro, tipoAcuerdo);
            try{

                    Escenario = "PO_Gestionar el Ciclo de Vida de Acuerdo de Proveedor_Actualizar estado de retención de acuerdo de proveedor "+Repeticion;

                    //Paso 1
                    Pasos.add(contador+".- Ingresar a la URL: "+Config.getProperty("urlOracle"));
                    genericSteps.ingresarAURL(driver, contador, Config, Escenario, Navegador);
                    
                    //Paso 2
                    contador++;
                    Pasos.add(contador+".- Ingresar Usuario: "+usuario+" y Contraseña: "+pass);
                    genericSteps.loginOracle(driver, usuario, pass, idioma, contador, Config, UILogin, Escenario, Navegador);
                    
                    //Paso 3
                    contador++;
                    Pasos.add(contador+".- Ir al menú Navegador: Compras - Acuerdos de compra.");
                    menusNavegadorSteps.clickMenuHamburguesa(driver, UIMenusNavegador);
                    menusNavegadorSteps.abrirMenuComprasAcuerdosCompra(driver, contador, Config, Escenario, Navegador, UIMenusNavegador);
                    
                    //Paso 4
                    contador++;
                    Pasos.add(contador+".- Ir al menú Tareas: Acuerdos - Gestionar acuerdos.");
                    gestionarAcuerdosSteps.menuGestionarAcuerdos(driver, UIGestionarAcuerdos, contador, Config, Escenario, Navegador);
                    
                    //Paso 5
                    contador++;
                    Pasos.add(contador+".- Ingresar el número de Acuerdo: "+numeroAcuerdo+" y seleccionar la Unidad de Negocios: "+BU);
                    gestionarAcuerdosSteps.seleccionarUnidadNegocios(driver, UIGestionarAcuerdos, BU, contador, Config, Escenario, Navegador);
                    gestionarAcuerdosSteps.ingresarAcuerdo(driver, UIGestionarAcuerdos, numeroAcuerdo, contador, Config, Escenario, Navegador);

                    //Paso 6
                    contador++;
                    Pasos.add(contador+".- Presionar el botón Buscar.");
                    gestionarAcuerdosSteps.buscarAcuerdo(driver, UIGestionarAcuerdos, contador, Config, Escenario, Navegador);

                    //Paso 7
                    contador++;
                    Pasos.add(contador+".- Seleccionar el registro del Acuerdo: "+numeroAcuerdo);
                    gestionarAcuerdosSteps.seleccionarRegistroAcuerdo(driver, UIGestionarAcuerdos, numeroAcuerdo, contador, Config, Escenario, Navegador);
                    
                    //Paso 8
                    contador++;
                    Pasos.add(contador+".- Presionar sobre la opción Acciones - Retener.");
                    gestionarAcuerdosSteps.presionarRetenerAcuerdo(driver, UIGestionarAcuerdos, contador, Config, Escenario, Navegador);
                    
                    //Paso 9
                    contador++;
                    Pasos.add(contador+".- Ingresar el Motivo.");
                    gestionarAcuerdosSteps.ingresarMotivoRetencion(driver, UIGestionarAcuerdos, motivo, contador, Config, Escenario, Navegador);
                    
                    //Paso 10
                    contador++;
                    Pasos.add(contador+".- Presionar el botón Aceptar.");
                    gestionarAcuerdosSteps.presionarAceptarMotivoRetencion(driver, mensajeConfirmacion, UIGestionarAcuerdos, contador, Config, Escenario, Navegador);

                    //Paso 11
                    contador++;
                    Pasos.add(contador+".- Presionar sobre el botón Aceptar.");
                    gestionarAcuerdosSteps.presionarAceptarMensajeConfirmacionRetencion(driver, Config, UIGestionarAcuerdos, contador, Escenario, Navegador);
                    
                    //Resultado Final
                    contador++;
                    Pasos.add(contador+".- Validar que el Acuerdo haya cambiado el estatus a "+estado);
                    Resultado = gestionarAcuerdosSteps.validarEstadoAcuerdo(driver, estado, UIGestionarAcuerdos, contador, Config, Escenario, Navegador);
                    
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
