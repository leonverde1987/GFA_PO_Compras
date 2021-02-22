/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpiraRun;

import com.inflectra.spiratest.addons.junitextension.SpiraTestListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.junit.Test;
import org.junit.runner.JUnitCore;

/**
 *
 * @author TestingIT
 */
public class RunGrid {
    
    @Test
    public void TestRunnerGrid() throws InterruptedException, FileNotFoundException, IOException {
        Properties Config = new generic.genericGrid().getPropetiesFile("configuracion\\configuracion.properties");
        JUnitCore core = new JUnitCore();
        core.addListener(new SpiraTestListener());
        
        String ruta = new generic.evidenceGrid().creaCarpetaRepeticion();
        Config.setProperty("rutaEvidencia",ruta);
        //new generic.genericGrid().leventarNodosGrid();
        
        Config.setProperty("Navegador","chrome");
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Cambio de Navegador a Chrome");
        core.run (TestCases.PO_AprobarAcuerdoProveedor_ValidarNotificaciónAutoaprobaciónHasta1999Coma99.class);
        //core.run (TestCases.PO_ModificarSolicitud_CancelarSolicitud.class);
        

        //Para firefox 
        Config.setProperty("Navegador","firefox");
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Cambio de Navegador a firefox");

        // Para edge
        /*Config.setProperty("Navegador","edge");
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Cambio de Navegador a EDGE");*/
    
    }
}