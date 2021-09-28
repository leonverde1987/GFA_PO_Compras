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

public class PO_AcuerdosProveedor_EliminarAcuerdoConsignacion{
    
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
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\acuerdos_proveedor\\dt_15382.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=15382)
    public void Test_PO_AcuerdosProveedor_EliminarAcuerdoConsignacion() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        String tipoAcuerdos = "acuerdoCompraConsignacion";
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            //String numeroAcuerdo = filaDatos[3];
            String mensajeAdvertencia = filaDatos[4];
            String libro = filaDatos[5];
            numeroAcuerdo = aprobacionSteps.getDato(libro, tipoAcuerdos);
            try{

                    Escenario = "PO_Acuerdos de Proveedor_Eliminar acuerdo de consignación "+Repeticion;

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
                    Pasos.add(contador+".- Ingresar el número de Acuerdo: "+numeroAcuerdo);
                    gestionarAcuerdosSteps.ingresarAcuerdo(driver, UIGestionarAcuerdos, numeroAcuerdo, contador, Config, Escenario, Navegador);

                    //Paso 6
                    contador++;
                    Pasos.add(contador+".- Presionar el botón Buscar.");
                    gestionarAcuerdosSteps.buscarAcuerdo(driver, UIGestionarAcuerdos, contador, Config, Escenario, Navegador);

                    //Paso 7
                    contador++;
                    Pasos.add(contador+".- Seleccionar el registro de la Solicitud: "+numeroAcuerdo);
                    gestionarAcuerdosSteps.seleccionarRegistroAcuerdo(driver, UIGestionarAcuerdos, numeroAcuerdo, contador, Config, Escenario, Navegador);
                    
                    //Paso 8
                    contador++;
                    Pasos.add(contador+".- Presionar sobre la opción Acciones - Suprimir.");
                    gestionarAcuerdosSteps.presionarSuprimirAcuerdo(driver, mensajeAdvertencia, UIGestionarAcuerdos, contador, Config, Escenario, Navegador);
                    
                    //Paso 9
                    contador++;
                    Pasos.add(contador+".- Presionar sobre el botón Sí.");
                    gestionarAcuerdosSteps.confirmarSuprimirAcuerdo(driver, Config, UIGestionarAcuerdos, contador, Escenario, Navegador);
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
