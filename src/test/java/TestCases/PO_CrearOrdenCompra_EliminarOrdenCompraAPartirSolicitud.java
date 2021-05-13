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
import steps.GestionarOrdenesSteps;

@SpiraTestConfiguration(
	    url="https://testing-it.spiraservice.net",
	    login="automationQA",
	    password="test1234", 
	    projectId=67,
	    testSetId=2668
	)

public class PO_CrearOrdenCompra_EliminarOrdenCompraAPartirSolicitud{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public AprobacionSteps aprobacionSteps = new AprobacionSteps();
    public GestionarOrdenesSteps gestionarOrdenesSteps = new GestionarOrdenesSteps();


    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UIGestionarOrdenes = null;
    
    
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
        UIMenusNavegador = genericSteps.getPropetiesFile("configuracion\\uielements\\menusNavegador.properties");
        UIGestionarOrdenes = genericSteps.getPropetiesFile("configuracion\\uielements\\gestionarOrdenes.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\crear_orden_compra\\dt_17340.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=17340)
    public void Test_PO_CrearOrdenCompra_EliminarOrdenCompraAPartirSolicitud() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String numeroOrden = filaDatos[3];
            String mensajeAdvertencia = filaDatos[4];
            try{

                    Escenario = "PO_Crear Orden de Compra_Eliminar orden de compra a partir de una solicitud "+Repeticion;

                    //Paso 1
                    Pasos.add(contador+".- Ingresar a la URL: "+Config.getProperty("urlOracle"));
                    genericSteps.ingresarAURL(driver, contador, Config, Escenario, Navegador);
                    
                    //Paso 2
                    contador++;
                    Pasos.add(contador+".- Ingresar Usuario: "+usuario+" y Contraseña: "+pass);
                    genericSteps.loginOracle(driver, usuario, pass, idioma, contador, Config, UILogin, Escenario, Navegador);
                    
                    //Paso 3
                    contador++;
                    Pasos.add(contador+".- Ir al menú Navegador: Compras - Órdenes de compra.");
                    menusNavegadorSteps.clickMenuHamburguesa(driver, UIMenusNavegador);
                    menusNavegadorSteps.abrirMenuComprasOrdenesCompra(driver, contador, Config, Escenario, Navegador, UIMenusNavegador);
                    
                    //Paso 4
                    contador++;
                    Pasos.add(contador+".- Ir al menú Tareas: Órdenes - Gestionar órdenes.");
                    gestionarOrdenesSteps.menuGestionarOrdenes(driver, UIGestionarOrdenes, contador, Config, Escenario, Navegador);
                    
                    //Paso 5
                    contador++;
                    Pasos.add(contador+".- Ingresar el número de la Orden: "+numeroOrden);
                    gestionarOrdenesSteps.ingresarOrden(driver, UIGestionarOrdenes, numeroOrden, contador, Config, Escenario, Navegador);

                    //Paso 6
                    contador++;
                    Pasos.add(contador+".- Presionar el botón Buscar.");
                    gestionarOrdenesSteps.buscarOrden(driver, UIGestionarOrdenes, contador, Config, Escenario, Navegador);

                    //Paso 7
                    contador++;
                    Pasos.add(contador+".- Seleccionar el registro de la Solicitud: "+numeroOrden);
                    gestionarOrdenesSteps.seleccionarRegistroOrden(driver, UIGestionarOrdenes, pass, contador, Config, Escenario, Navegador);
                    
                    //Paso 8
                    contador++;
                    Pasos.add(contador+".- Presionar sobre la opción Acciones - Suprimir.");
                    gestionarOrdenesSteps.presionarSuprimirOrden(driver, mensajeAdvertencia, UIGestionarOrdenes, contador, Config, Escenario, Navegador);
                    
                    //Paso 9
                    contador++;
                    Pasos.add(contador+".- Presionar sobre el botón Sí.");
                    gestionarOrdenesSteps.confirmarSuprimirOrden(driver, Config, UIGestionarOrdenes, contador, Escenario, Navegador);
                    
                    //Paso 10
                    contador++;
                    Pasos.add(contador+".- Validar que ya no exista la Orden.");
                    Resultado = gestionarOrdenesSteps.validarOrdenEliminada(driver, numeroOrden, Config, UIGestionarOrdenes, contador, Escenario, Navegador);
                    
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
    }

    @After
    public void cerrarTest(){
        genericSteps.cerrarNavegador(driver);
    }   
}
