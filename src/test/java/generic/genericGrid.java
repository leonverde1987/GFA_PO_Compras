package generic;


import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver; 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class genericGrid extends evidenceGrid {
    
    public static final char SEPARATOR=',';
    public static final char QUOTE='"';
    /*
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    CONFIGURACIONES
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    */
    
    /***
     * En este método abrimos archivos properties del proyecto.
     * @param Archivo Esla ruta del archivo.
     * @return El archivo de propiedades con la configuración.
     * @throws FileNotFoundException si no encuentra el archivo en la ruta.
     */
    public Properties getPropetiesFile(String Archivo){
        Properties prop = new Properties();
        try{
        	//CREAR ARCHIVO SI NO EXISTE
    		File f = new File(Archivo);
    		if(!f.exists()){
    			f.getParentFile().mkdirs();
    			f.createNewFile();
    		}else{
    			System.out.println("File already exists");
    		}
    		
    		//LEER DATO
            Reader reader = new InputStreamReader((new FileInputStream(Archivo)), "UTF-8"); 
            prop.load(reader);
        } catch(IOException e) {
            System.out.println("Error IO Al crear Properties: " + e.getMessage());
            e.printStackTrace();
        } catch(Exception ex) {
            System.out.println("Error Al crear Properties: " + ex.getMessage());
            ex.printStackTrace();
        }
        return prop;
    }
    
    /**
     * Este método nos sirve para obtener un archivo CSV en una variable tipo CSVReader.
     * @param ruta Es la ruta dentro de la PC donde encontramos el archivo CSV.
     * @return Una variable tipo CSVReader con el contenido del archivo CSV.
     */
    public CSVReader ObtenerDatos(String ruta){
        CSVReader datos = null;
        try{    
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(ruta), "UTF-8");
            //datos = new CSVReader(new FileReader(ruta), SEPARATOR, QUOTE);
            datos = new CSVReader(inputStreamReader, SEPARATOR, QUOTE);
            
        }catch(IOException e){
            System.out.println("No se puede abrir el archivo de Datos verifique la ruta: "+ e);
        }catch(Exception ex){
            System.out.println("No se puede abrir el archivo de Datos verifique la ruta: "+ ex);
        }
        return datos;
    }
    
    /**
     * Este método nos ayuda abrir los driver con el navegador que se necesite.
     * @param navegador Es el nombre dle navegador que vamos a levantar.
     * @param config Es el acrhico de configuración properties.
     * @return driver Es el RemoteWebDriver con el navegador abierto.
     * @throws MalformedURLException Cuando no encunetra la ruta del driver.
     * @throws InterruptedException Cuando no se puede iniciar el driver.
     */
    public RemoteWebDriver openGridBrowser(String navegador, Properties config) throws MalformedURLException, InterruptedException{
        RemoteWebDriver driver = null;
        URL url=null;
        String driverPath = "C:/ambiente/selenium_drivers";
        try{
        
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setPlatform(Platform.WINDOWS);
            
            if("chrome".equals(navegador)){
                capabilities.setBrowserName(navegador);
                capabilities = DesiredCapabilities.chrome();
                url = new URL("http://localhost:5557/wd/hub");
                //driver = new RemoteWebDriver(url, capabilities);
                
        		System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
        		driver = new ChromeDriver();
        		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            }
            if("ie".equals(navegador)){
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                //capabilities.setBrowserName(navegador);
                //capabilities = DesiredCapabilities.internetExplorer();
//                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
//                capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,false);
                url = new URL("http://localhost:5559/wd/hub");
                driver = new RemoteWebDriver(url, ieOptions);
            }
            if("edge".equals(navegador)){
                EdgeOptions optionEdge = new EdgeOptions();
                //capabilities.setBrowserName(navegador);
                //capabilities = DesiredCapabilities.edge();
                url = new URL("http://localhost:5557/wd/hub");
                driver = new RemoteWebDriver(url, optionEdge);
            }
            if("firefox".equals(navegador)){
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                //capabilities.setBrowserName(navegador);
                //capabilities = DesiredCapabilities.firefox();
                url = new URL("http://localhost:5556/wd/hub");
                //driver = new RemoteWebDriver(url, firefoxOptions);

        		System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver.exe");
        		driver = new FirefoxDriver();
        		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            }
            if("motorolaOneVision".equals(navegador)){
                DesiredCapabilities capabilitie =new DesiredCapabilities();
                capabilitie.setCapability("deviceName", navegador);
                capabilitie.setCapability("platformVerion", "9");
                capabilitie.setCapability("platformName", "Android");
                capabilitie.setCapability("device", "ZY326LRQHS");
                capabilitie.setCapability("browserName", "Chrome");
                url = new URL("http://localhost:4723/wd/hub");
                driver = new RemoteWebDriver(url, capabilitie);
            }
            
            
        }catch(Exception e){
            System.out.println(e);
        }
            driver.manage().window().maximize();
            return driver;
        }
    
    
    
    /**
     * Este método levanta el HUB de selenium grid y los nodos para cada navegador. 
     * @throws InterruptedException No puede iniciar el driver.
     * @throws FileNotFoundException No encuentra el driver del navegador.
     */
    public void leventarNodosGrid() throws InterruptedException, FileNotFoundException{
        Properties Config = this.getPropetiesFile("configuracion\\configuracion.properties");
        try {
            String cmd = "cmd /c start cmd.exe /K java -jar "+Config.getProperty("seleniumServer")+" -role hub -port "+Config.getProperty("hubPort");
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException ioe) {
            System.out.println ("Hub: "+ioe);
        }
        Thread.sleep(5000);
        try {
            String cmd = "cmd /c start cmd.exe /K java -Dwebdriver.gecko.driver="+Config.getProperty("gecko")+" -jar "+Config.getProperty("seleniumServer")+" -role webdriver -hub http://localhost:5555/grid/register -port "+Config.getProperty("geckoPort")+" -browser browserName=firefox";
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException ioe) {
            System.out.println ("Gecko node: "+ioe);
        }
        Thread.sleep(5000);
        try {
            String cmd = "cmd /c start cmd.exe /K java -Dwebdriver.chrome.driver="+Config.getProperty("chrome")+" -jar "+Config.getProperty("seleniumServer")+" -role webdriver -hub http://localhost:5555/grid/register -port "+Config.getProperty("chromePort")+" -browser browserName=chrome";
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException ioe) {
            System.out.println ("Chrome node: "+ioe);
        }
        /*Thread.sleep(5000);
        try {
            String cmd = "cmd /c start cmd.exe /K java -Dwebdriver.edge.driver="+Config.getProperty("edge")+" -jar "+Config.getProperty("seleniumServer")+" -role webdriver -hub http://localhost:5555/grid/register -port "+Config.getProperty("edgePort")+" -browser browserName=iexplorer";
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException ioe) {
            System.out.println ("Edege node: "+ioe);
        } 
        Thread.sleep(5000);
        try {
            String cmd = "cmd /c start cmd.exe /K java -Dwebdriver.ie.driver="+Config.getProperty("ie")+" -jar "+Config.getProperty("seleniumServer")+" -role webdriver -hub http://localhost:5555/grid/register -port "+Config.getProperty("iePort")+" -browser browserName=iexplorer";
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException ioe) {
            System.out.println ("Edege node: "+ioe);
        }*/
    }
    
    /**
     * Este método cierra los nodos Selenium Grid que estan levantados.
     */
    public void cierraNodosGrid(){
        try {
            String cmd = "cmd /c start cmd.exe /K TASKKILL /F /IM cmd.exe /T";
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException ioe) {
            System.out.println ("Edege node: "+ioe);
        }
        
    }
    
    /**
     * Este método genera las evidencias de un script ejecutado.
     * @param driver Es el remoteWebDriver que utilizamos.
     * @param Escenario Es el nombre del caso de prueba para generar la evidencia.
     * @param Resultado Es el resultado que se obtuvo en caso de prueba.
     * @param contador Es el total de pasos ejecutados en el caso de prueba.
     * @param Pasos Es el detalle de los pasos de prueba.
     * @param RutaEvidencia Es la ruta donde se guardaron las capturas.
     * @param Modulo Es el Módulo del casos de prueba.
     * @param Version Es la versión del aplicativo.
     * @param navegador Es el nombre del navegador donde se ejecuto el caso de prueba.
     */
    public void GenerarEvidencias(RemoteWebDriver driver, String Escenario, String Resultado, int contador, List<String> Pasos, String RutaEvidencia, String Modulo, String Version, String navegador){
        try{
            System.out.println("Lista: "+Pasos);
            
            Escenario = this.remplazarCaracteresEspeciales(Escenario);

            //Generamos PDF
            this.crearPDF(Escenario, Resultado, contador, Pasos, RutaEvidencia, Modulo, Version, navegador);
            //Generamos HTML
            this.crearHTML(Escenario, Resultado, contador, Pasos, RutaEvidencia, Modulo, Version, navegador);
            //
            this.crearCSVResultados(Escenario, Resultado, RutaEvidencia, Modulo, navegador, Pasos.toString());

        }catch(Exception e){
            System.out.println("Error al crear Evidencia: " + e);
        }
    }
    
    
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //METODOS ACCIONES
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************


    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //NAVEGADOR
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************

    /***
     * El método le da un tiempo de 10 segundos al webDriver.
     * @param driver Es el RemoteWebDriver de la ejecución.
     * @param URL Es la url que vamos abrir en el driver.
     */
    public void abrirURl(RemoteWebDriver driver, String URL){
        try{
            driver.get(URL);
        }catch(Exception e){
            System.out.println("Mensaje: "+e);
        }
    }
    
    
    /***
     * El método nos ayuda a cerrar un WebDriver.
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     */
    public void cerrarDriver(WebDriver driver){
            driver.close();
    }
    
    
    
    
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //CLICK Y SEND KEYS
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************


    /***
     * El método nos ayuda a dar clic a un elemento.
     * @param driver es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium que se le va a dar Clic.
     * @throws InterruptedException 
     */
    public void click(RemoteWebDriver driver, String findby, String Elemento) throws InterruptedException{
        WebElement el = this.driverWait(driver, findby, Elemento);
        el.click();
    }


    /***
     * El método nos ayuda a dar clic a un elemento mediante JS.
     * @param driver es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium que se le va a dar Clic.
     * @throws InterruptedException 
     */
    public void clickJS(RemoteWebDriver driver, String findby, String Elemento) throws InterruptedException{
        WebElement el = this.waitUIElementPresent(driver, findby, Elemento);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", el);
    }
    

    /***
     * El método nos ayuda a ingresar texto a un elemento.
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium al que le vamos agregar texto.
     * @param Texto Es el texto que se va ingresar al campo.
     */
    public void ingresarTexto(RemoteWebDriver driver, String findby, String Elemento, String Texto){
        WebElement elemen = this.driverWait(driver, findby, Elemento);
        elemen.clear();
        elemen.sendKeys(Texto);
    }

    /***
     * El método nos ayuda a enviar submit sobre un elemento.
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium al que le vamos agregar texto.
     */
    public void submit(RemoteWebDriver driver, String findby, String Elemento){
        WebElement elemen = this.driverWait(driver, findby, Elemento);
        elemen.submit();
    }


    /***
     * El método nos ayuda a presionar enter sobre un elemento.
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium al que le vamos agregar texto.
     */
    public void enter(RemoteWebDriver driver, String findby, String Elemento){
        WebElement el = this.driverWait(driver, findby, Elemento);
    	Actions action = new Actions(driver);
    	action.sendKeys(el, Keys.ENTER).build().perform();
    }


    /***
     * El método obtiene el texto de un objeto.
     * @param driver es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium.
     * @return Regresa el texto del objeto o un vacio en caso de no encontrar el findby.
     */
    public String obtenerTexto(RemoteWebDriver driver, String findby, String Elemento){
        String texto = "";
        WebElement Element = this.driverWait(driver, findby, Elemento);
        texto = Element.getText();
        return texto;
    }
    
    /***
     * El método obtiene el value de un objeto.
     * @param driver es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium.
     * @return Regresa el texto del objeto o un vacio en caso de no encontrar el findby.
     */
    public String obtenerValue(RemoteWebDriver driver, String findby, String Elemento){
        String texto = "";
        WebElement Element = this.driverWait(driver, findby, Elemento);
        texto = Element.getAttribute("value");
        return texto;
    }
    
    
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //COMBO BOX, DROPDOWN LIST
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************

    
    /***
     * El método nos ayuda a seleccionar un texto de un cbo por su atributo text, select o dropdownlist.
     * @param driver es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium del cbo, select o dropdownlist.
     * @param Texto Es el valor del texto que se busca en el elemento.
     */
    public void seleccionarComboByText(RemoteWebDriver driver, String findby, String Elemento, String Texto){
        WebElement combo = this.driverWait(driver, findby, Elemento);
        Select cbo = new Select(combo);
        cbo.selectByVisibleText(Texto);
    }
    
    /***
     * El método nos ayuda a seleccionar un texto de un cbo por su atributo value, select o dropdownlist.
     * @param driver es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium del cbo, select o dropdownlist.
     * @param Texto Es el valor del texto que se busca en el elemento.
     */
    public void seleccionarComboByValue(RemoteWebDriver driver, String findby, String Elemento, String Texto){
        WebElement combo = this.driverWait(driver, findby, Elemento);
        Select cbo = new Select(combo);
        cbo.selectByValue(Texto);
    }

    /***
     * El método nos ayuda a ingresar un texto y despues seleccionarlo de la lista.
     * @param driver es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium del cbo, select o dropdownlist.
     * @param Texto Es el valor del texto que se busca en el elemento.
     * @throws InterruptedException 
     */
    public void seleccionarComboInputByValue(RemoteWebDriver driver, String findby, String Elemento, String Texto) throws InterruptedException{
        WebElement combo = this.driverWait(driver, findby, Elemento);
        dormirSeg(2);
        combo.sendKeys(Texto);
        dormirSeg(3);
        combo.sendKeys(Keys.DOWN);
        dormirSeg(3);
        combo.sendKeys(Keys.ENTER);
        dormirSeg(3);
    }
    

    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //SCROLLS
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************

    /**
     * Es el método que nos sirve para bajar el scroll en un remoteWebDriver.
     * @param driver Es el driver de la prueba. 
     * @throws InterruptedException Cuando no se puede interactuar con el driver.
     */
    public void bajarScroll(RemoteWebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }
    
    /**
     * Es el método que nos sirve para bajar el scroll en un remoteWebDriver.
     * @param driver Es el driver de la prueba. 
     * @throws InterruptedException Cuando no se puede interactuar con el driver.
     */
    public void subirScroll(RemoteWebDriver driver) throws FileNotFoundException, InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1000)");
    }
    
    /**
     * Es el método que nos sirve para bajar el scroll en un remoteWebDriver.
     * @param driver Es el driver de la prueba. 
     * @throws InterruptedException Cuando no se puede interactuar con el driver.
     */
    public void bajarTecla(RemoteWebDriver driver, int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws FileNotFoundException, InterruptedException {
    	Actions action = new Actions(driver);
    	action.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).perform(); 
    }
    
    
    
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //SLEEPS
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************

    /***
     * El método le da un tiempo de 3 segundos al webDriver.
     * @exception InterruptedException Para manejar excepciones con el hilo de procesamiento que se esta deteniendo.
     */
    public void dormirSeg(int segundos) throws InterruptedException{
        Thread.sleep((segundos * 1000));
    }
    


    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //ASSERTION
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************

    
    /***
     * El método nos ayuda obtener un elemento pero utiliza el driver wait para darle tiempo al navegador de reaccionar.
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium al que le vamos agregar texto.
     */
    public WebElement driverWait(RemoteWebDriver driver, String findby, String Elemento){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement el = null;
        switch(findby) {
            case "id":
                el = wait.until(ExpectedConditions.elementToBeClickable(By.id(Elemento)));
                break;
            case "name":
            	el = wait.until(ExpectedConditions.elementToBeClickable(By.name(Elemento)));
                break;
            case "xpath":
            	el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Elemento)));
                break;
        }
        return el;
    }
    
    /***
     * El método nos ayuda obtener un elemento pero utiliza el driver wait para darle tiempo al navegador de reaccionar.
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium al que le vamos agregar texto.
     */
    public WebElement waitUIElementPresent(RemoteWebDriver driver, String findby, String Elemento){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement el = null;
        switch(findby) {
            case "id":
                el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Elemento)));
                break;
            case "name":
                el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Elemento)));
                break;
            case "xpath":
                el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Elemento)));
                break;
        }
        return el;
    }
    

    /*
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    ASSERTS
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    */
    
    /**
     * En este método vamos a validar que dos mensajes sean iguales.
     * @param driver Es el remoteWebDriver donde se ejecuta la prueba. 
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param msjActual Es el valr del texto que se compara.
     * @param Elemento Es el elemento del que se va a comparr el texto.
     */
    public String AssertMsjElemento(RemoteWebDriver driver, String findby, String msjActual, String Elemento) throws InterruptedException{
        String msj = "";
        try{
            this.dormirSeg(1);
            Assert.assertEquals(this.obtenerTexto(driver, findby, Elemento), msjActual);
            msj = "Exitoso";
        }catch(AssertionError e){
            System.out.println("Mensaje Assert Fail: "+e);
            msj = "Fallido, Reusltado Esperado: "+e;
        }
        
        return msj;
    }
    
    /**
     * En este método vamos a validar un like en un mensaje.
     * @param driver Es el remoteWebDriver donde se ejecuta la prueba. 
     * @param findby Es el valor del texto que se compara.
     * @param msjActual Es el valor del texto que se compara.
     * @param Elemento Es el elemento del que se va a comparr el texto.
     * @param like Es el texto que vamos a buscar en el mensaje.
     * @return Regresa un Exitoso o Fallido dependiendo de la aserción.
     */
    public String AssertTrueElemento(RemoteWebDriver driver, String findby, String Elemento, String like) throws InterruptedException{
   	 String msj = "";
        try{
            this.dormirSeg(1);
            Assert.assertTrue(this.obtenerTexto(driver, findby, Elemento).contains(like));
            msj = "Exitoso";
        }catch(AssertionError e){
            System.out.println("Mensaje Assert Fail: "+e);
            msj = "Fallido, Resultado Esperado: "+e;
        }
        
        return msj;
   	
   }
    
   /**
     * En este método vamos a validar el texto de dos variables tipo string.
     * @param Resultado Es el resultado que arrojo la busqueda en la tabla. 
     * @param msjActual Es el valor que vamos a comparar.
     * @return Regresa un Exitoso o Fallido dependiendo de la aserción.
     */
    public String AssertComparaMensajes(String Resultado, String msjActual) throws InterruptedException{
   	 String msj = "";
        try{
            this.dormirSeg(1);
            Assert.assertEquals(Resultado, msjActual);
            msj = "Exitoso";
        }catch(AssertionError e){
            System.out.println("Mensaje Assert Fail: "+e);
            msj = "Fallido, Resultado Esperado: "+e;
        }
        
        return msj;
   	
   }
    
    public boolean AssertComparaMensajes1(String text, String msjActual) throws InterruptedException{
    	String msj = "";
           boolean result;
		try{
               this.dormirSeg(1);
               Assert.assertEquals(text, msjActual);
               result = true;
           }catch(AssertionError e){
               System.out.println("Mensaje Assert Fail: "+e);
               result = false;
           }
           
           return result;
      	
      }
    
    public boolean AssertExistElement(RemoteWebDriver driver, String findby, String Elemento) throws InterruptedException, NoSuchElementException{
    	boolean result = false;
		try{
               //this.waitUIElementPresent(driver, findby, Elemento);
            driver.findElement(By.xpath(Elemento));   
			result = true;
           }catch(Exception e){
               System.out.println("No Existe el elemento"+e);
               result = false;
           }
           return result;
      	
      }

    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //TABLE
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************

    /***
     * El método buscar un texto en una objeto.
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param texto Es el texto que vamos a buscar en la tabla.
     * @param tagName Es tipo de componente en donde queremos buscar el texto, Ejemplo DIV, TD, TR, SPAN, etc.
     * @param xpath Es el selector selenium donde queremos buscar el texto y es solo en tipo XPATH.
     * @exception InterruptedException Para manejar excepciones con el hilo de procesamiento que se esta deteniendo.
     * @return Retorna Exitoso si encuentra el texto o Fallido si no lo encuntra.
     */
    public String buscarTextoTabla(RemoteWebDriver driver, String texto, String tagName, String xpath) throws InterruptedException{
        WebElement table = driver.findElement(By.xpath(xpath));
        List<WebElement> buscarTexto = table.findElements(By.tagName(tagName));
        String Resultado = "Fallido";
        for(int a=0; buscarTexto.size() > a; a++){
            WebElement b = buscarTexto.get(a);
            String txt = buscarTexto.get(a).getText();
            txt.trim();
            System.out.println("Texto = "+txt);
            if(txt.equals(texto)){
                Resultado = "Exitoso";
                System.out.println(txt);
                a = buscarTexto.size()+2;
            }
        }
        return Resultado;
    }
    
    /***
     * El método presiona un texto en una tabla.
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param texto Es el texto que vamos a presionar en la tabla.
     * @param tagName Es tipo de componente en donde queremos presionar el texto, Ejemplo DIV, TD, TR, SPAN, etc.
     * @param xpath Es el selector selenium donde queremos presionar el texto y es solo en tipo XPATH.
     * @exception InterruptedException Para manejar excepciones con el hilo de procesamiento que se esta deteniendo.
     */
    public void presionarLkTabla(RemoteWebDriver driver, String texto, String tagName, String xpath) throws InterruptedException{
        WebElement table = driver.findElement(By.xpath(xpath));
        List<WebElement> buscarTexto = table.findElements(By.tagName(tagName));
        for(int a=0; buscarTexto.size() > a; a++){
            WebElement b = buscarTexto.get(a);
            String txt = buscarTexto.get(a).getText();
            if(txt.equals(texto)){
                System.out.println(txt);
                buscarTexto.get(a).click();
                a = buscarTexto.size()+2;
            }
        }
    }
    
    /***
     * El método nos ayuda a seleccionar una posisión de un, select o dropdownlist.
     * @param driver es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium del cbo, select o dropdownlist.
     * @param Index Es el valor del texto que se busca en el elemento.
     */
    public void seleccionarComboByIndex(RemoteWebDriver driver, String findby, String Elemento, int Index){
        WebElement combo = this.driverWait(driver, findby, Elemento);
        Select cbo = new Select(combo);
        cbo.selectByIndex(Index);
    } 
	
    
    /***
     * El método permite hacer switch a otra ventana por parte del contenido de su nombre
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param windowsTitle String parte del titulo de la entana
     */
    public boolean switchWindowByTitle(WebDriver driver, String windowsTitle) throws Exception{
    	try {
    		Boolean result = false;
    		for (String handle: driver.getWindowHandles()) {
    			driver.switchTo().window(handle);
		    	if (driver.getTitle().toString().contains(windowsTitle)) {
		    		result = true;
		    		break;
		    	}
    		}
    		
    		return result;
    	}
    	catch(Exception ex) {
    		throw new Exception("Error al hacer switch a la ventana: " + windowsTitle);
    	}	
    }

    
    /***
     * El método permite hacer switch a otra ventana por el index de la ventana
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param windowsTitle String parte del titulo de la entana
     */
    public boolean switchWindowByIndex(WebDriver driver, int windowsIndex) throws Exception{
    	try {
    		Boolean result = false;
    		int index = 0;
    		for (String handle: driver.getWindowHandles()) {
    			driver.switchTo().window(handle);
		    	if (index == windowsIndex) {
		    		result = true;
		    		break;
		    	}
		    	index++;
    		}
    		
    		return result;
    	}
    	catch(Exception ex) {
    		throw new Exception("Error al hacer switch a la ventana con index: " + windowsIndex);
    	}	
    }

      
    /***
     * El método nos ayuda a borrar lo que traiga precargado un campo de texto
     * @param driver Es el webDriver en el que se ejecuta la pruebas automatizada.
     * @param findby Es el tipo de selector selenium id, name o XPATH.
     * @param Elemento Es el selector selenium al que le vamos agregar texto.
     * @param Texto Es el texto que se va ingresar al campo.
     */
    public void borrarTextoPrecargado(RemoteWebDriver driver, String findby, String Elemento){
        WebElement elemen = this.driverWait(driver, findby, Elemento);
        elemen.clear();
    }

    
    

    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //SCROLLS
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************

    
    
    /**
     * Es el metodo hace scroll a un elemento para hacerlo visible a la pantalla
     * @param driver Es el driver de la prueba. 
     * @throws InterruptedException Cuando no se puede interactuar con el driver.
     */
    public void JSscrollToElement(RemoteWebDriver driver, WebElement element) throws FileNotFoundException, InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /*
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    UTILERIAS
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    */
    
    /**
     * En este método genera un numero random
     */
    public String numeroRandomString() throws InterruptedException{
    	return String.valueOf(System.currentTimeMillis());
    }
    
    /**
     * En este método remplaza el texto para un xpath dinamico
     * dt_value es la palabra que se reservo para mapear el xpath e identificar el texto dinamico
     */
    public String sobreEscribirLocator(String locator, String newLocator) throws InterruptedException{
    	return locator.replace("${DT_VALUE}", newLocator);
    	
    }

}	

