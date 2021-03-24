/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpiraRun;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author TestingIT
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestCases.PO_AprobarSolicitud_RechazarSolicitudSinMotivo.class,
    TestCases.PO_AprobarSolicitud_RechazarSolicitud.class,
    TestCases.PO_AprobarSolicitud_AprobarSolicitudCompraMayor100000Coma00DueñoCentroCostos.class,
    TestCases.PO_AprobarSolicitud_AprobarSolicitudCompraMayor100000Coma00LiderTecnico.class,
    TestCases.PO_AprobarSolicitud_AprobarSolicitudCompraMayor100000Coma00DirectorAdministracionFinanzas.class,
    TestCases.COC_AltaOrdenComprarApartirSolicitud.class,
    TestCases.COC_ModificarOCApartirSolicitud.class,
    TestCases.COC_EnviarOrdenCompraApartirSolicitudParaAprobacion.class,
    TestCases.GCVOC_ActualizarEdoCongelacion.class,
    TestCases.PO_CrearOrdenCompra_EliminarOrdenCompraAPartirSolicitud.class,
    TestCases.CS_CrearOrdenCompraDesdeINV.class,
    TestCases.PO_AprobarOrdenCompra_RevisarDetalleSolicitudAprobacion.class,
    TestCases.PO_AprobarOrdenCompra_AprobarOrdenCompraMayor100000Coma00DueñoCentroCostos.class,
    TestCases.PO_AprobarOrdenCompra_AprobarOrdenCompraMayor100000Coma00LiderTecnico.class,
    TestCases.PO_AprobarOrdenCompra_AprobarOrdenCompraMayor100000Coma00DirectorAdministracionFinanzas.class,        
    TestCases.GR_RecepcionParcialArticulos.class,
    TestCases.COC_DarAltaOrdenCompraEAM.class,
    TestCases.PO_AprobarOrdenCompra_ValidarNotificaciónAutoaprobaciónHasta1999Coma99.class,       
    TestCases.GR_RecibirArticulo.class,
    TestCases.GCVOC_ActualizarEdoCierre.class,         
    TestCases.COC_DarAltaOrdenCompraDisel.class,
    TestCases.MOC_CrearOrdenDeCambioDeOC.class,
    TestCases.COC_CalcularImpTransaccionOC.class,
    TestCases.GCVOC_ActualizarEdoRetencion.class,        
    TestCases.COC_DarAltaOrdenConsignacion.class,
    TestCases.COC_ModificarOrdenConsignacion.class,
    TestCases.AOC_SolicitarInfoOC.class,
    TestCases.PO_AprobarOrdenCompra_RechazarOrdenCompra.class,
    TestCases.GCVOC_RetirarOrdenCompra.class,   
    TestCases.PO_CrearSolicitud_CancelarSolicitudConOrdenBotonCancelar.class,
    TestCases.AC_CrearAgenteCompra.class,
    TestCases.AC_ModificarAccesoAgenteCompras.class,
    TestCases.AC_ModificarAgenteCompras.class
})
public class RunGridFirefox {
    
    @BeforeClass
    public static void TestRunnerGrid() throws InterruptedException, FileNotFoundException, IOException {
        Properties Config = new generic.genericGrid().getPropetiesFile("configuracion\\configuracion.properties");
        
        //Para firefox 
        Config.setProperty("Navegador","firefox");
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Cambio de Navegador a firefox");
          
              
    }
}