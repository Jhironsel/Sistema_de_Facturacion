package sur.softsurena.formularios;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmMovimientoEntradaSalida extends javax.swing.JInternalFrame {

    private Object registro[] = new Object[3];
    private DefaultTableModel miTabla;
    
    public frmMovimientoEntradaSalida() {
        initComponents();
        agregarOyente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtFechas = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jFecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpReporte = new javax.swing.JPanel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Movimiento Entrada y Salida");
        setVisible(true);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 6, 6));

        jtFechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtFechas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtFechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFechasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtFechas);

        jPanel1.add(jScrollPane2);
        jPanel1.add(jCalendar1);

        jpReporte.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte"));

        javax.swing.GroupLayout jpReporteLayout = new javax.swing.GroupLayout(jpReporte);
        jpReporte.setLayout(jpReporteLayout);
        jpReporteLayout.setHorizontalGroup(
            jpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );
        jpReporteLayout.setVerticalGroup(
            jpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jpReporte);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtFechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFechasMouseClicked
        String fecha = jtFechas.getValueAt(jtFechas.getSelectedRow(), 0).toString().replace("/", ".");
        
        if (fecha.isEmpty()) {
            return;
        }
        reporte(fecha);
    }//GEN-LAST:event_jtFechasMouseClicked
    
    private void agregarOyente() {
        jCalendar1.getDayChooser().addPropertyChangeListener(
                (java.beans.PropertyChangeEvent evt) -> {
                    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
                    
                    jFecha.setText("Fecha Selecionada: "
                            + formatoDeFecha.format(jCalendar1.getDate()));

                    formatoDeFecha = new SimpleDateFormat("MM/dd/yyyy");
                    reporte(formatoDeFecha.format(jCalendar1.getDate()));
                    llenarTabla();
                });
    }

    //TODO Metodo de JasperReport
    private void reporte(String fecha) {
        try {
            JasperReport masterReporte = 
                    (JasperReport) JRLoader.loadObjectFromFile(
                                    "/Reportes/MovimientoES.jasper");
            
            Map parametros = new HashMap();
            parametros.put("fecha", fecha);
            
            JasperPrint jp = JasperFillManager.fillReport(masterReporte, parametros);
            
            JRViewer jviewer = new JRViewer(jp);
            
            jpReporte.removeAll();
            jpReporte.setLayout(new BorderLayout());
            jpReporte.add(jviewer, BorderLayout.CENTER);
            jviewer.setVisible(true);
            jpReporte.repaint();
            jpReporte.revalidate();
        } catch (JRException ex) {
            LOG.log(
                    Level.SEVERE, 
                    "Error al crear reporte de moviemientos de entrada y salida.", 
                    ex
            );
        }
    }

    private void llenarTabla() {
        try {
            String titulos[] = {"Fecha",  "Operacion", "Usuario"};
            jtFechas.removeAll();
            miTabla = new DefaultTableModel(null, titulos);

//            "SELECT r.FECHAENTRADA, IIF(r.OP = '+', 'Entrada', 'Salida') as operacion, r.IDUSUARIO "
//                  + "FROM TABLA_ENTRADAS_PRUDUCTOS r "
//                  + "WHERE EXTRACT(MONTH FROM r.FECHAENTRADA) = " + mes + " "
//                  + "and EXTRACT(YEAR FROM r.FECHAENTRADA) = " + year + " "
//                  + "GROUP BY r.FECHAENTRADA,  r.OP, r.IDUSUARIO"
            
            ResultSet rs = null;
                        
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {
                registro[0] = formatoDeFecha.format(rs.getDate("FECHAENTRADA"));
                registro[1] = rs.getString("operacion");
                registro[2] = rs.getString("IDUSUARIO");
                miTabla.addRow(registro);
            }
            jtFechas.setModel(miTabla);
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    "Error al consultar la tabla Entradas_Productos.", 
                    ex
            );
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jFecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpReporte;
    private javax.swing.JTable jtFechas;
    // End of variables declaration//GEN-END:variables
}
