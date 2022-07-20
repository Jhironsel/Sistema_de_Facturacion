package sur.softsurena.formularios;

import java.awt.Color;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static sur.softsurena.datos.delete.DeleteMetodos.borrarFactura;
import static sur.softsurena.datos.insert.InsertMetodos.agregarDetalleFactura;
import static sur.softsurena.datos.insert.InsertMetodos.agregarFacturaNombre;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.entidades.Factura;
import sur.softsurena.entidades.HeaderFactura;

public class frmTemporal extends java.awt.Dialog {

    private String nombreCliente, userName;
    private Integer idFactura, idCliente, idTurno;
    private DefaultTableModel miTabla;
    private Factura facturas;
    private final DefaultTableCellRenderer tcr;

    public frmTemporal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrabar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalCantidad = new javax.swing.JTextField();
        txtTotalValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnGrabar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(1, 1, 1));
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnGrabar.setMnemonic('t');
        btnGrabar.setToolTipText("Confirmar Factura");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('t');
        btnCancelar.setToolTipText("Cancelar Factura Actual");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblDetalle.setAutoCreateRowSorter(true);
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tblDetalle);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de la Factura"));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Neto:");

        txtTotalCantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTotalCantidad.setForeground(new java.awt.Color(0, 0, 153));
        txtTotalCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCantidad.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        txtTotalCantidad.setDoubleBuffered(true);
        txtTotalCantidad.setEnabled(false);
        txtTotalCantidad.setMinimumSize(new java.awt.Dimension(20, 19));
        txtTotalCantidad.setPreferredSize(new java.awt.Dimension(20, 19));

        txtTotalValor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTotalValor.setForeground(new java.awt.Color(0, 0, 153));
        txtTotalValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalValor.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        txtTotalValor.setDoubleBuffered(true);
        txtTotalValor.setEnabled(false);
        txtTotalValor.setMinimumSize(new java.awt.Dimension(20, 19));
        txtTotalValor.setPreferredSize(new java.awt.Dimension(20, 19));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Cantidad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTotalCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, txtTotalValor});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalValor, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Nombre: ");
        jLabel1.setToolTipText("");

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGrabar))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(txtCliente))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGrabar)
                    .addComponent(btnCancelar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        HeaderFactura hf = HeaderFactura.builder().
                idCliente(idCliente).
                idTurno(idTurno).
                estado('t').
                userName(userName).
                nombreTemp(nombreCliente)
                .build();
                
        Factura f = Factura.builder().id(idFactura).headerFactura(hf).build();
        
        if (agregarFacturaNombre(f) < 1) {
            JOptionPane.showMessageDialog(this, 
                    "Esta compra no se ha registrado...");
            return;
        } else {
            for (int i = 0; i < facturas.getDetalleFactura().size(); i++) {
                
                if (agregarDetalleFactura(f) < -1) {
                    borrarFactura(idFactura);
                    JOptionPane.showMessageDialog(this, 
                            "Esta compra no se ha registrado...");
                    return;
                }
            }
        }
        setVisible(false);
    }//GEN-LAST:event_btnGrabarActionPerformed
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tblDetalle.setModel(miTabla);
        tblDetalle.setRowSelectionInterval(miTabla.getRowCount() - 1, miTabla.getRowCount() - 1);
        repararRegistro2();
        totales();
        txtCliente.setText(nombreCliente);
    }//GEN-LAST:event_formWindowOpened
    public void repararRegistro2() {
        TableColumn miTableColumn;
        int[] columWidth = {80, 200, 15};
        
        for (int i = 0; i < columWidth.length; i++) {
            miTableColumn = tblDetalle.getColumnModel().getColumn(i);
            miTableColumn.setPreferredWidth(columWidth[i]);
        }
        
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tcr.setFont(new java.awt.Font("Tahoma", 50, 80));
        tcr.setBackground(Color.yellow);
        tblDetalle.getColumnModel().getColumn(2).setCellRenderer(tcr);
    }

    private void totales() {
        int num = tblDetalle.getRowCount();
        BigDecimal sumCan = BigDecimal.ZERO;
        BigDecimal sumVal = BigDecimal.ZERO;
        
        for (int i = 0; i < num; i++) {
            sumCan = sumCan.add(new BigDecimal(tblDetalle.getValueAt(i, 0).toString()));
            sumVal = sumVal.add(new BigDecimal(tblDetalle.getValueAt(i, 2).toString()));
        }
        
        txtTotalCantidad.setText("" + sumCan);
        txtTotalValor.setText("RD$" + sumVal);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblDetalle;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtTotalCantidad;
    private javax.swing.JTextField txtTotalValor;
    // End of variables declaration//GEN-END:variables
}
