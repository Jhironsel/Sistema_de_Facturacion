package sur.softsurena.hilos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import static sur.softsurena.conexion.Conexion.getCnn;
import static sur.softsurena.formularios.frmPrincipal.jPanelImpresion;
import static sur.softsurena.formularios.frmPrincipal.jprImpresion;
import sur.softsurena.formularios.frmPrintFacturaConReporte;
import sur.softsurena.utilidades.Utilidades;

public class hiloImpresionFactura extends Thread {

    private boolean continuar = true;
    private final boolean preVista;
    private final boolean credito;
    private String fileReporte;
    private final Map parametros;

    public hiloImpresionFactura(Boolean preVista, Boolean credito,
            String fileReporte, Map parametros) {
        this.preVista = preVista;
        this.credito = credito;
        this.fileReporte = fileReporte;
        this.parametros = parametros;
        jPanelImpresion.setVisible(true);
    }

    @Override
    public void run() {
        if (continuar) {
            try {
                jprImpresion.setValue(20);
                jprImpresion.setString("20% Orden tomada");
                JasperReport masterReporte
                        = (JasperReport) JRLoader.loadObjectFromFile(
                                fileReporte);
                jprImpresion.setValue(27);
                jprImpresion.setString("27% Documento Cargado");
                JasperPrint jp = JasperFillManager.fillReport(masterReporte, parametros,
                        getCnn());
                jprImpresion.setValue(42);
                jprImpresion.setString("42% Documento Creado");
                fileReporte = System.getProperty("user.dir") + "/Reportes/reporteTemp.pdf";
                JasperExportManager.exportReportToPdfFile(jp, fileReporte);
                jprImpresion.setValue(58);
                jprImpresion.setString("58% PDF Creado, Enviando...");                
                if (preVista) {
                    jprImpresion.setValue(70);
                    jprImpresion.setString("70% Extrayendo imagen");
                    Utilidades.extractPrintImage(fileReporte.replace("pdf", "png"), jp);
                    jprImpresion.setValue(77);
                    jprImpresion.setString("77% Image Creada");
                    frmPrintFacturaConReporte miReport = new frmPrintFacturaConReporte(null, true);
                    jprImpresion.setValue(89);
                    jprImpresion.setString("89% Imagen cargada");
                    terminar();
                    miReport.setCopia(credito);
                    miReport.setLocationRelativeTo(null);
                    miReport.setVisible(true);
                } else {
                    jprImpresion.setValue(73);
                    jprImpresion.setString("73% Generando Documento");
                    
                    FileInputStream in = new FileInputStream(fileReporte);
                    Doc doc = new SimpleDoc(in, DocFlavor.INPUT_STREAM.PDF, null);
                    
                    jprImpresion.setValue(80);
                    jprImpresion.setString("80% Buscando Impres. Princ.");
                    
                    PrintService service = PrintServiceLookup.lookupDefaultPrintService();
                    service.createPrintJob().print(doc, null);
                    
                    jprImpresion.setValue(88);
                    jprImpresion.setString("88% Enviando....");
                    
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        //Instalar Logger
                    }                    
                    terminar();
                }
            } catch (JRException | FileNotFoundException | PrintException ex) {
                //Instalar Logger
            }
            detenElHilo();
        }
    }

    public void terminar() {
        jprImpresion.setString("Cargado con Exito!!!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //Instalar Logger
        }
        
        jprImpresion.setValue(100);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //Instalar Logger
        }
        jPanelImpresion.setVisible(false);
    }

    public void detenElHilo() {
        continuar = false;
    }

    public void iniciarElHilo() {
        continuar = true;
    }
}
