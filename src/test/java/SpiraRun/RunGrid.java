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
        new generic.genericGrid().leventarNodosGrid();
        
        Config.setProperty("Navegador","chrome");
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Cambio de Navegador a Chrome");
        
        //validados
        //core.run(TestCases.AP_DarAltaAcuerdoConsignacion.class);
        //core.run(TestCases.AP_ModificarAcuerdoConsignacion.class);
        //core.run(TestCases.AP_EnviarAcuerdoProveedorImportado.class);
        //core.run(TestCases.PO_AprobarAcuerdoProveedor_RechazarAcuerdoProveedor.class);
        //core.run(TestCases.PO_AcuerdosProveedor_CancelarAcuerdoConsignacion.class);
        core.run(TestCases.AP_DarAltaAcuerdosDiesel.class);
        core.run(TestCases.PO_AprobarAcuerdoProveedor_AprobarAcuerdoProveedorMayor100000Coma00DueñoCentroCostos.class);
      
        
        
/**
          core.run(TestCases.MAS_CrearArticuloDiesel.class);
          core.run(TestCases.MAS_CopiarArticuloTipoProductosLimpieza.class);
          core.run(TestCases.AP_DarAltaAcuerdoCompraAbierto.class);
          core.run(TestCases.AP_ModificarAcuerdoCompraAbierto.class);      
          core.run(TestCases.PO_AprobarAcuerdoProveedor_ValidarNotificaciónAutoaprobaciónHasta1999Coma99.class);
          core.run(TestCases.PO_GestionarCicloVidaAcuerdoProveedor_ActualizarEstadoCongelacionAcuerdoProveedor.class);        
          core.run(TestCases.AP_DarAltaAcuerdoCompraContrato.class);
          core.run(TestCases.AP_ModificarAcuerdoCompraContrato.class);
          core.run(TestCases.AP_EnviarAcuerdoModificacion.class);
          core.run(TestCases.PO_AprobarAcuerdoProveedor_RevisarSolicitudAcuerdoProveedor.class);
          core.run(TestCases.AAP_ReasignarAcuerdoProveedor.class);
          core.run(TestCases.PO_GestionarCicloVidaAcuerdoProveedor_ActualizarEstadoRetencionAcuerdoProveedor.class);                
          core.run(TestCases.AP_DarAltaAcuerdoConsignacion.class);
          core.run(TestCases.AP_ModificarAcuerdoConsignacion.class);
          core.run(TestCases.AP_EnviarAcuerdoProveedorImportado.class);
          core.run(TestCases.PO_AprobarAcuerdoProveedor_RechazarAcuerdoProveedor.class);
          core.run(TestCases.PO_AcuerdosProveedor_CancelarAcuerdoConsignacion.class);
          core.run(TestCases.PO_AcuerdosProveedor_EliminarAcuerdoConsignacion.class);
          core.run(TestCases.AP_DarAltaAcuerdosDiesel.class);
          core.run(TestCases.PO_AprobarAcuerdoProveedor_AprobarAcuerdoProveedorMayor100000Coma00DueñoCentroCostos.class);
          core.run(TestCases.PO_AprobarAcuerdoProveedor_AprobarAcuerdoProveedorMayor100000Coma00LiderTecnico.class);
          core.run(TestCases.PO_AprobarAcuerdoProveedor_AprobarAcuerdoProveedorMayor100000Coma00DirectorAdministracionFinanzas.class);
          core.run(TestCases.CS_DarAltaSolicitudAcuerdoProveedor.class);
          core.run(TestCases.AS_VerificarFondosSolicitud.class);
          core.run(TestCases.AP_ModificarAcuerdoProveedorImportado.class);
          core.run(TestCases.AAP_ResponderSolicitudAcuerdoProveedor.class);       
          core.run(TestCases.PO_GestionarCicloVidaAcuerdoProveedor_RetirarAcuerdoProveedor.class);
          core.run(TestCases.CS_AltaSolicitudCatalogoMaestroArticulosServicios.class);
          core.run(TestCases.CS_VeriPresuDispoSoliCatMtroArtServ.class);
          core.run(TestCases.CS_EnviarAprobAgregarLineasCatMtoArtServ.class);
          core.run(TestCases.PO_CrearSolicitud_CancelarSolicitudSinOrdenBotonCancelar.class);
          core.run(TestCases.AS_SolicitarInformacionAdicional.class);
          core.run(TestCases.AS_ResponderSolicitudInformacion.class);
          core.run(TestCases.PO_CrearSolicitud_EliminarSolicitudAgregarLíneasCatálogoMaestroArtículosServicios.class);        
          core.run(TestCases.CS_CrearBorradorDuplicidadSolicitudExistente.class);
          core.run(TestCases.MS_RetirarActualizarVerificarFondos.class);
          core.run(TestCases.PO_AprobarSolicitud_ValidarNotificaciónAutoaprobaciónHasta1999Coma99.class);
          core.run(TestCases.CS_CrearBorradorIngresandoLineasDeSolicitudAP.class);
          core.run(TestCases.MS_RetirarActualizarEnviarSolicitud.class);
          core.run(TestCases.GCVS_ReasignarSolicitud.class);
          core.run(TestCases.CS_CrearBorradorMedianteLineasCompras.class);
          core.run(TestCases.PO_ProcesarLineasSolicitud_DevolverLineasSolicitud.class);
          core.run(TestCases.PO_ModificarSolicitud_CancelarSolicitud.class);
          core.run(TestCases.GCVS_SeguimientoCicloVidaSol.class);
          core.run(TestCases.CS_CrearBorradorMedianteSolicitudQueNoSeanCatalogoAP.class);
          core.run(TestCases.CS_DarAltaSolicitudCompraUrgenteAP.class);
        
        //Para firefox 
        Config.setProperty("Navegador","firefox");
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Cambio de Navegador a firefox");
          core.run(TestCases.PO_AprobarSolicitud_RechazarSolicitudSinMotivo.class);
          core.run(TestCases.PO_AprobarSolicitud_RechazarSolicitud.class);
          core.run(TestCases.PO_AprobarSolicitud_AprobarSolicitudCompraMayor100000Coma00DueñoCentroCostos.class);
          core.run(TestCases.PO_AprobarSolicitud_AprobarSolicitudCompraMayor100000Coma00LiderTecnico.class);
          core.run(TestCases.PO_AprobarSolicitud_AprobarSolicitudCompraMayor100000Coma00DirectorAdministracionFinanzas.class);
          core.run(TestCases.COC_AltaOrdenComprarApartirSolicitud.class);
          core.run(TestCases.COC_ModificarOCApartirSolicitud.class);
          core.run(TestCases.COC_EnviarOrdenCompraApartirSolicitudParaAprobacion.class);
          core.run(TestCases.GCVOC_ActualizarEdoCongelacion.class);
          core.run(TestCases.PO_CrearOrdenCompra_EliminarOrdenCompraAPartirSolicitud.class);
          core.run(TestCases.CS_CrearOrdenCompraDesdeINV.class);
          core.run(TestCases.PO_AprobarOrdenCompra_RevisarDetalleSolicitudAprobacion.class);
          core.run(TestCases.PO_AprobarOrdenCompra_AprobarOrdenCompraMayor100000Coma00DueñoCentroCostos.class);
          core.run(TestCases.PO_AprobarOrdenCompra_AprobarOrdenCompraMayor100000Coma00LiderTecnico.class);
          core.run(TestCases.PO_AprobarOrdenCompra_AprobarOrdenCompraMayor100000Coma00DirectorAdministracionFinanzas.class);        
          core.run(TestCases.GR_RecepcionParcialArticulos.class);
          core.run(TestCases.COC_DarAltaOrdenCompraEAM.class);
          core.run(TestCases.PO_AprobarOrdenCompra_ValidarNotificaciónAutoaprobaciónHasta1999Coma99.class);        
          core.run(TestCases.GR_RecibirArticulo.class);
          core.run(TestCases.GCVOC_ActualizarEdoCierre.class);         
          core.run(TestCases.COC_DarAltaOrdenCompraDisel.class);
          core.run(TestCases.MOC_CrearOrdenDeCambioDeOC.class);
          core.run(TestCases.COC_CalcularImpTransaccionOC.class);
          core.run(TestCases.GCVOC_ActualizarEdoRetencion.class);        
          core.run(TestCases.COC_DarAltaOrdenConsignacion.class);
          core.run(TestCases.COC_ModificarOrdenConsignacion.class);
          core.run(TestCases.AOC_SolicitarInfoOC.class);
          core.run(TestCases.PO_AprobarOrdenCompra_RechazarOrdenCompra.class);
          core.run(TestCases.GCVOC_RetirarOrdenCompra.class);        
          core.run(TestCases.PO_CrearSolicitud_CancelarSolicitudConOrdenBotonCancelar.class);
          core.run(TestCases.AC_CrearAgenteCompra.class);
          core.run(TestCases.AC_ModificarAccesoAgenteCompras.class);
          core.run(TestCases.AC_ModificarAgenteCompras.class);
        
*/        
    }
}