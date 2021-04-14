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
    TestCases.AP_DarAltaAcuerdoConsignacion.class,
    TestCases.AP_ModificarAcuerdoConsignacion.class,
    TestCases.AP_EnviarAcuerdoProveedorImportado.class,
    TestCases.PO_AprobarAcuerdoProveedor_RechazarAcuerdoProveedor.class,
    TestCases.PO_AcuerdosProveedor_CancelarAcuerdoConsignacion.class,
    TestCases.AP_DarAltaAcuerdosDiesel.class,
//Validados
    TestCases.PO_AprobarAcuerdoProveedor_AprobarAcuerdoProveedorMayor100000Coma00DueñoCentroCostos.class,
    TestCases.PO_AprobarAcuerdoProveedor_AprobarAcuerdoProveedorMayor100000Coma00LiderTecnico.class,
    TestCases.MAS_CrearArticuloDiesel.class,
    TestCases.MAS_CopiarArticuloTipoProductosLimpieza.class,
    TestCases.AP_DarAltaAcuerdoCompraAbierto.class,
    TestCases.AP_ModificarAcuerdoCompraAbierto.class,      
    TestCases.PO_AprobarAcuerdoProveedor_ValidarNotificaciónAutoaprobaciónHasta1999Coma99.class,
    TestCases.PO_GestionarCicloVidaAcuerdoProveedor_ActualizarEstadoCongelacionAcuerdoProveedor.class,        
    TestCases.AP_DarAltaAcuerdoCompraContrato.class,
    TestCases.AP_ModificarAcuerdoCompraContrato.class,
    TestCases.AP_EnviarAcuerdoModificacion.class,
    TestCases.PO_AprobarAcuerdoProveedor_RevisarSolicitudAcuerdoProveedor.class,
    TestCases.AAP_ReasignarAcuerdoProveedor.class,
    TestCases.PO_GestionarCicloVidaAcuerdoProveedor_ActualizarEstadoRetencionAcuerdoProveedor.class,                
    TestCases.AP_DarAltaAcuerdoConsignacion.class,
    TestCases.AP_ModificarAcuerdoConsignacion.class,
    TestCases.AP_EnviarAcuerdoProveedorImportado.class,
    TestCases.PO_AprobarAcuerdoProveedor_RechazarAcuerdoProveedor.class,
    TestCases.PO_AcuerdosProveedor_CancelarAcuerdoConsignacion.class,
    TestCases.PO_AcuerdosProveedor_EliminarAcuerdoConsignacion.class,
    TestCases.PO_AcuerdosProveedor_ValidarPrivilegioSinAsignarCrearAcuerdoProveedor.class,
    TestCases.AP_DarAltaAcuerdosDiesel.class,
    TestCases.PO_AprobarAcuerdoProveedor_AprobarAcuerdoProveedorMayor100000Coma00DueñoCentroCostos.class,
    TestCases.PO_AprobarAcuerdoProveedor_AprobarAcuerdoProveedorMayor100000Coma00LiderTecnico.class,
    TestCases.PO_AprobarAcuerdoProveedor_AprobarAcuerdoProveedorMayor100000Coma00DirectorAdministracionFinanzas.class,
    TestCases.CS_DarAltaSolicitudAcuerdoProveedor.class,
    TestCases.AS_VerificarFondosSolicitud.class,
    TestCases.AP_ModificarAcuerdoProveedorImportado.class,
    TestCases.AAP_ResponderSolicitudAcuerdoProveedor.class,       
    TestCases.PO_GestionarCicloVidaAcuerdoProveedor_RetirarAcuerdoProveedor.class,
    TestCases.CS_AltaSolicitudCatalogoMaestroArticulosServicios.class,
    TestCases.CS_VeriPresuDispoSoliCatMtroArtServ.class,
    TestCases.CS_EnviarAprobAgregarLineasCatMtoArtServ.class,
    TestCases.PO_CrearSolicitud_CancelarSolicitudSinOrdenBotonCancelar.class,
    TestCases.AS_SolicitarInformacionAdicional.class,
    TestCases.AS_ResponderSolicitudInformacion.class,
    TestCases.PO_CrearSolicitud_EliminarSolicitudAgregarLíneasCatálogoMaestroArtículosServicios.class,        
    TestCases.CS_CrearBorradorDuplicidadSolicitudExistente.class,
    TestCases.MS_RetirarActualizarVerificarFondos.class,
    TestCases.PO_AprobarSolicitud_ValidarNotificaciónAutoaprobaciónHasta1999Coma99.class,
    TestCases.CS_CrearBorradorIngresandoLineasDeSolicitudAP.class,
    TestCases.MS_RetirarActualizarEnviarSolicitud.class,
    TestCases.GCVS_ReasignarSolicitud.class,
    TestCases.CS_CrearBorradorMedianteLineasCompras.class,
    TestCases.PO_ProcesarLineasSolicitud_DevolverLineasSolicitud.class,
    TestCases.PO_ModificarSolicitud_CancelarSolicitud.class,
    TestCases.GCVS_SeguimientoCicloVidaSol.class,
    TestCases.CS_CrearBorradorMedianteSolicitudQueNoSeanCatalogoAP.class,
    TestCases.CS_DarAltaSolicitudCompraUrgenteAP.class
})
public class RunGridChrome {
    
    @BeforeClass
    public static void TestRunnerGrid() throws InterruptedException, FileNotFoundException, IOException {
        Properties Config = new generic.genericGrid().getPropetiesFile("configuracion\\configuracion.properties");

        Config.setProperty("Navegador","chrome");
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Cambio de Navegador a Chrome");
       
    }
}