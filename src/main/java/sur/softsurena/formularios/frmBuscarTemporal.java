package sur.softsurena.formularios;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import static sur.softsurena.entidades.Temporales.getTemporales;
import sur.softsurena.hilos.hiloImpresionFactura;

public final class frmBuscarTemporal extends java.awt.Dialog {

    private static final Logger LOG = Logger.getLogger(frmBuscarTemporal.class.getName());
    
    private DefaultTableModel miTabla;
    private boolean aceptar;
    private String factura;
    private final DefaultTableCellRenderer tcr;

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }


    public frmBuscarTemporal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        btnCancelar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(668, 258));
        setResizable(false);
        setTitle("Facturas en Temporales");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblDetalle.setAutoCreateRowSorter(true);
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° Factura", "Nombre Cliente", "Fecha", "Hora", "Cajero", "Monto"
            }
        ));
        jScrollPane1.setViewportView(tblDetalle);

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('t');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar Factura Actual");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGrabar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(1, 1, 1));
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnGrabar.setMnemonic('t');
        btnGrabar.setText("Aceptar");
        btnGrabar.setToolTipText("Confirmar Factura");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(1, 1, 1));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Impresora.png"))); // NOI18N
        btnAceptar.setMnemonic('I');
        btnAceptar.setText("Imprimir Cuenta");
        btnAceptar.setToolTipText("");
        btnAceptar.setBorder(null);
        btnAceptar.setBorderPainted(false);
        btnAceptar.setPreferredSize(new java.awt.Dimension(123, 44));
        btnAceptar.setSelected(true);
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGrabar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar, btnGrabar});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setAceptar(false);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if (tblDetalle.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe selecionar una Factura...");
            return;
        }
        setAceptar(true);
        setFactura(tblDetalle.getValueAt(tblDetalle.getSelectedRow(), 0).toString());
        dispose();
    }//GEN-LAST:event_btnGrabarActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        btnAceptar.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tblDetalle.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado Factura");
            return;
        }
        Map parametros = new HashMap();
        parametros.put("idFactura", Integer.parseInt(
                String.valueOf(miTabla.getValueAt(tblDetalle.getSelectedRow(), 0))));
        hiloImpresionFactura miFactura
                = new hiloImpresionFactura(
                        true, //Mostrar Reporte
                        false,
                        "/Reportes/factura.jasper",
                        parametros);
        miFactura.start();
    }//GEN-LAST:event_btnAceptarActionPerformed
    /**
     * Metodo utilizado para llenar las tablas de las facturas que existen en 
     * temporal.
     * Actualizado el 05 Junio 2022: nota: 
     */
    private void llenarTabla() {
        try {
            String titulos[] = {"N° Factura", "Nombre Cliente", "Fecha", "Hora",
                "Cajero", "Monto"};

            miTabla = new DefaultTableModel(null, titulos);
            
            //Consulta a la base de datos que trae los registros
            ResultSet rs = getTemporales();
            
            //Objecto utlizado en la construción de la tabla.
            Object registro[] = new Object[6];
            
            while (rs.next()) {
                registro[0] = rs.getString("ID");
                
                if (rs.getInt("ID_CLIENTE") == 0) {
                    registro[1] = rs.getString("NOMBRETEMP");
                } else {
                    registro[1] = rs.getString("PNOMBRE") + (
                            rs.getString("PNOMBRE") == null || 
                                rs.getString("SNOMBRE").isEmpty() ? 
                            "" : rs.getString("SNOMBRE")) + " " + 
                            rs.getString("APELLIDOS");
                }
                
                registro[2] = rs.getString("Fecha");
                registro[3] = rs.getString("Hora");
                registro[4] = rs.getString("IDUsuario");
                registro[5] = rs.getString("Monto");

                miTabla.addRow(registro);//Se van insertando los registros.
            }
            
            //Se agrega el modelo a la tabla.
            tblDetalle.setModel(miTabla);
            
            //Para Alinear el Texto de la Table a la Derecha...
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            tblDetalle.getColumnModel().getColumn(0).setCellRenderer(tcr);

            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            tblDetalle.getColumnModel().getColumn(5).setCellRenderer(tcr);

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        //Ordenando las columnas
        TableColumn miTableColumn;
        for (int i = 0; i <= 5; i++) {
            miTableColumn = tblDetalle.getColumnModel().getColumn(i);
            if (i == 0) {
                miTableColumn.setPreferredWidth(170);
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(400);
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(150);
            }
            if (i == 3) {
                miTableColumn.setPreferredWidth(130);
            }
            if (i == 4) {
                miTableColumn.setPreferredWidth(130);
            }
            if (i == 5) {
                miTableColumn.setPreferredWidth(160);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblDetalle;
    // End of variables declaration//GEN-END:variables
}
