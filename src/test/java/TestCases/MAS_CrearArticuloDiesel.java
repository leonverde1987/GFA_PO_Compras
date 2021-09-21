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

import steps.CrearArticuloSteps;
import steps.GenericSteps;
import steps.LoginSteps;
import steps.MenuTareasSteps;
import steps.MenusNavegadorSteps;

@SpiraTestConfiguration(
	    url="https://testing-it.spiraservice.net",
	    login="automationQA",
	    password="test1234", 
	    projectId=67,
	    testSetId=2668
	)

public class MAS_CrearArticuloDiesel{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public MenusNavegadorSteps menusNavegadorSteps = new MenusNavegadorSteps();
    public MenuTareasSteps menuTareasSteps = new MenuTareasSteps();
    public CrearArticuloSteps crearArticuloSteps = new CrearArticuloSteps();


    //UIELEMENTS
    public Properties UILogin = null;
    public Properties UIMenusNavegador = null;
    public Properties UIConfigMantenimiento = null;
    public Properties UIMenusTareas = null;
    public Properties UICrearArticulo = null;
    
    
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
        UIMenusTareas = genericSteps.getPropetiesFile("configuracion\\uielements\\menusTareas.properties");
        UICrearArticulo = genericSteps.getPropetiesFile("configuracion\\uielements\\crearArticulo.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\datos\\PO_compras\\maestro_articulos_servicios\\dt_19620.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        
    }
    
    @Test
    @SpiraTestCase(testCaseId=19620)
    public void MAS_CrearArticuloDiesel_19620() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String usuario = filaDatos[0];
            String pass = filaDatos[1];
            String idioma = filaDatos[2];
            String mensaje = filaDatos[3];
            String organizacion = filaDatos[4];
            String articuloNuevoCopia = filaDatos[5];
            String numeroArticulos = filaDatos[6];
            String claseArticulo = filaDatos[7];
            String articulo = filaDatos[8];
            String descripcion = filaDatos[9];
            String descripcionLarga = filaDatos[10];
            String unidadMedidaPrincipal = filaDatos[11];
            String catalogo = filaDatos[12];
            try{

                    Escenario = "MAS_CrearArticuloDiesel "+Repeticion;

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
                    Pasos.add(contador+".- Seleccionar menú: Cuentas X Pagar => Pagos ");
                    menusNavegadorSteps.abrirMenuInformacionProductos(driver, UIMenusNavegador, contador, 
                    		Config, Escenario, Navegador);
                    
                    //Paso 5
                    contador++;
                    Pasos.add(contador+".- Seleccionar menú: Tareas");
                    menuTareasSteps.clickBtnTareas(driver, UIMenusTareas, contador, Config, Escenario, Navegador);
                    
                    //Paso 6
                    contador++;
                    Pasos.add(contador+".- Seleccionar Crear articulo del menú tareas");
                    menuTareasSteps.clickBtnCrearArticulo(driver, UIMenusTareas, contador, Config, Escenario, Navegador);
                    
                    //Paso 7
                    contador++;
                    Pasos.add(contador+".- Ingresar los parametros requeridos");
                    crearArticuloSteps.llenarDialogoCrearArticulo(driver, UICrearArticulo, contador, Config, Escenario, Navegador,
                    		organizacion, articuloNuevoCopia, numeroArticulos, claseArticulo);
                    
                    //Paso 8
                    contador++;
                    Pasos.add(contador+".- Seleccionar el boton aceptar en el dialogo de crear articulo");
                    crearArticuloSteps.clickAceptarCrearArticulo(driver, UICrearArticulo, contador, Config, Escenario, Navegador);
                    
                    //Paso 9
                    contador++;
                    Pasos.add(contador+".- Ingresar informacion en los campos");
                    crearArticuloSteps.llenarFormCrearArticulo(driver, UICrearArticulo, contador, Config, Escenario, Navegador,
                    		articulo, descripcion);
                    
                    //Paso 10
                    contador++;
                    Pasos.add(contador+".- Ir a la pestaña Vision General");
                    crearArticuloSteps.irPestaniaVisionGeneral(driver, UICrearArticulo,  contador, Config, Escenario, Navegador);
                    
                    //Paso 11
                    contador++;
                    Pasos.add(contador+".- Ingresar la informacion en los campos de la pestaña Vision general");
                    crearArticuloSteps.llenarFormVisionGeneral(driver, UICrearArticulo, contador, Config, Escenario, Navegador,
                    		descripcionLarga, unidadMedidaPrincipal);
                    
                    //Paso 12
                    contador++;
                    Pasos.add(contador+".- Ir a la pestaña Categorias");
                    crearArticuloSteps.irPestaniaCategorias(driver, UICrearArticulo,  contador, Config, Escenario, Navegador);
                    
                    //Paso 13
                    contador++;
                    Pasos.add(contador+".- Presionar sobre el icono Agregar");
                    crearArticuloSteps.clickCategoriasAgregarFila(driver, UICrearArticulo, contador, Config, Escenario, Navegador);
                    
                    //Paso 14
                    contador++;
                    Pasos.add(contador+".- Ingresar informacion para agregar fila");
                    crearArticuloSteps.llenarFormCateAddFila(driver, UICrearArticulo, contador, Config, Escenario, Navegador,
                    		catalogo);
                    
                    //Paso 15
                    contador++;
                    Pasos.add(contador+".- Ir a la pestaña Especificaciones");
                    crearArticuloSteps.irPestaniaEspecificaciones(driver, UICrearArticulo,  contador, Config, Escenario, Navegador);
                 
                    //Paso 16
                    contador++;
                    Pasos.add(contador+".- Seleccionar Link Atributos Adicionales");
                    crearArticuloSteps.clickAtributosAdicionales(driver, UICrearArticulo, contador, Config, Escenario, Navegador);
                    
                    //Paso 17
                    contador++;
                    Pasos.add(contador+".- Validar que se muestren los campos a elegir");
                    crearArticuloSteps.assertLblContexto(driver, UICrearArticulo, contador, Config, Escenario, Navegador);
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
