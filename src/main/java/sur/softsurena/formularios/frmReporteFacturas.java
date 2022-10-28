package sur.softsurena.formularios;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static sur.softsurena.datos.select.SelectMetodos.getFacturas;
import sur.softsurena.entidades.Clientes;
import sur.softsurena.entidades.Facturas;
import sur.softsurena.entidades.Opcion;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.datos.select.SelectMetodos.getClientesTablaSB;
import static sur.softsurena.datos.select.SelectMetodos.getClientesTablaSBCombo;

public class frmReporteFacturas extends javax.swing.JInternalFrame {
    
    public frmReporteFacturas() {
        
        initComponents();
        bgrTipo.add(rbtTodo);
        bgrTipo.add(rbtSeleccion);
        bgrFiltro.add(rbtFecha);
        bgrFiltro.add(rbtFactura);
        bgrFiltro.add(rbtCliente);
    }
    public void centralizar() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrFiltro = new javax.swing.ButtonGroup();
        bgrTipo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtArchivo = new javax.swing.JTextField();
        btnSeleccionArchivo = new javax.swing.JButton();
        rbtFecha = new javax.swing.JRadioButton();
        rbtFactura = new javax.swing.JRadioButton();
        rbtCliente = new javax.swing.JRadioButton();
        rbtTodo = new javax.swing.JRadioButton();
        rbtSeleccion = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dchFechaFinal = new com.toedter.calendar.JDateChooser();
        dchFechaInicial = new com.toedter.calendar.JDateChooser();
        cmbFacturaInicial = new javax.swing.JComboBox();
        cmbFacturaFinal = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox();
        btnGenerar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Reporte de Facturas");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("Archivo: ");

        txtArchivo.setText("Reporte");

        btnSeleccionArchivo.setText("...");
        btnSeleccionArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionArchivoActionPerformed(evt);
            }
        });

        rbtFecha.setMnemonic('f');
        rbtFecha.setSelected(true);
        rbtFecha.setText("Fecha");
        rbtFecha.setEnabled(false);
        rbtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFechaActionPerformed(evt);
            }
        });

        rbtFactura.setMnemonic('n');
        rbtFactura.setText("Numero de Factura");
        rbtFactura.setEnabled(false);
        rbtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFacturaActionPerformed(evt);
            }
        });

        rbtCliente.setMnemonic('c');
        rbtCliente.setText("Cliente");
        rbtCliente.setEnabled(false);
        rbtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtClienteActionPerformed(evt);
            }
        });

        rbtTodo.setMnemonic('t');
        rbtTodo.setSelected(true);
        rbtTodo.setText("Todas");
        rbtTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTodoActionPerformed(evt);
            }
        });

        rbtSeleccion.setMnemonic('s');
        rbtSeleccion.setText("Selección");
        rbtSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtSeleccionActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha Inicial: ");

        jLabel3.setText("Fecha Final: ");

        jLabel4.setText("Factura Inicial: ");

        jLabel5.setText("Factura Final: ");

        dchFechaFinal.setEnabled(false);

        dchFechaInicial.setEnabled(false);

        cmbFacturaInicial.setEnabled(false);

        cmbFacturaFinal.setEnabled(false);

        jLabel7.setText("Cliente: ");

        cmbCliente.setEnabled(false);

        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Reportar Factura 32 x 32.png"))); // NOI18N
        btnGenerar.setMnemonic('g');
        btnGenerar.setText("General Reporte");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbFacturaInicial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbFacturaFinal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dchFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dchFechaInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnGenerar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4)
                                .addComponent(txtArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccionArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtTodo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtSeleccion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtCliente)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionArchivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtTodo)
                    .addComponent(rbtSeleccion))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtFecha)
                    .addComponent(rbtFactura)
                    .addComponent(rbtCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(dchFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(dchFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(cmbFacturaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(cmbFacturaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerar)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtSeleccionActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtSeleccionActionPerformed

    private void rbtTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTodoActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtTodoActionPerformed

    private void rbtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFechaActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtFechaActionPerformed

    private void rbtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFacturaActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtFacturaActionPerformed

    private void rbtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtClienteActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_rbtClienteActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if (txtArchivo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar o Selecionar un Nombre de Archivo...");
            return;
        }
        try {
            String archivo = txtArchivo.getText();
            String sql = "SELECT factura.idFactura, factura.idCliente, "
                    + " (nombres||' '||apellidos) AS nombreFull, "
                    + "fecha, idLinea, idProducto, (select descripcion from productos where idProducto like detalleFactura.idProducto) as descripcion, precio, "
                    + "cantidad, precio * cantidad AS Valor "
                    + "FROM factura "
                    + "INNER JOIN cliente ON factura.idCliente = cliente.idCliente "
                    + "INNER JOIN detalleFactura ON factura.idFactura = detalleFactura.idFactura ";

            String filtro = "";

            if (rbtTodo.isSelected()) {
                filtro = "";
            } else {
                //Para Realizar la Consulta por Nombre del Cliente...
                if (rbtCliente.isSelected()) {
                    if (cmbCliente.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe Selecionar un Cliente...");
                        cmbCliente.requestFocusInWindow();
                        return;
                    }
                    filtro = "WHERE factura.idCliente = '"
                            + ((Opcion) cmbCliente.getSelectedItem()).getValor() + "'";
                }

                //Para Realizar la Consulta por Numero de Factura...
                if (rbtFactura.isSelected()) {
                    if (cmbFacturaInicial.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe Selecionar una Factura Inicial...");
                        cmbFacturaInicial.requestFocusInWindow();
                        return;
                    }
                    if (cmbFacturaFinal.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debe Selecionar una Factura Final...");
                        cmbFacturaFinal.requestFocusInWindow();
                        return;
                    }
                    
                    if(cmbFacturaInicial.getSelectedIndex() > cmbFacturaFinal.getSelectedIndex()){
                        JOptionPane.showMessageDialog(null, "Factura Inicial Maryor que la Final");
                        cmbFacturaInicial.requestFocusInWindow();
                        return;
                    }

                    filtro = "WHERE factura.idFactura >= "
                            + ((Opcion) cmbFacturaInicial.getSelectedItem()).getValor()
                            + " and factura.idFactura <= "
                            + ((Opcion) cmbFacturaFinal.getSelectedItem()).getValor();
                }

                //Para Realizar la Consulta por Fecha...
                if (rbtFecha.isSelected()) {
                    if (dchFechaInicial.getDate() == null) {
                        JOptionPane.showMessageDialog(null, "Debe Selecionar una Fecha Inicial...");
                        dchFechaInicial.requestFocusInWindow();
                        return;
                    }
                    if (dchFechaFinal.getDate() == null) {
                        JOptionPane.showMessageDialog(null, "Debe Selecionar una Fecha Final...");
                        dchFechaFinal.requestFocusInWindow();
                        return;
                    }

                    filtro = "WHERE fecha >= '"
                            + Utilidades.formatDate(dchFechaInicial.getDate(), "MM-dd-yyyy")
                            + "' and fecha <= '"
                            + Utilidades.formatDate(dchFechaFinal.getDate(), "MM-dd-yyyy") + "'";
                }
            }
            //Adicionamos el fitro a la Consulta....
            sql = sql + filtro;

//            Reporte.reporteFacturas(archivo, getConsulta(sql));
            
            JOptionPane.showMessageDialog(null, "Reporte Generado...");
            dispose();
        } catch (Exception ex) {
            //Instalar Logger
        }
        
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            
            //Cargamos Clientes
            Clientes cli = Clientes.builder().
                    id_persona(-1).
                    pNombre("Seleccione un cliente").
                    sNombre("").
                    apellidos("").build();
            
            cmbCliente.addItem(cli);
            
            getClientesTablaSBCombo(cmbCliente);

            //Cargamos Facturas
            Facturas fac = Facturas.builder().id(-1).build();
            cmbFacturaInicial.addItem(cli);
            cmbFacturaFinal.addItem(cli);
            ResultSet rsFac = getFacturas();
            while (rsFac.next()) {
                fac = Facturas.builder().id(rsFac.getInt("ID")).build();
                cmbFacturaInicial.addItem(fac);
                cmbFacturaFinal.addItem(fac);
            }

        } catch (SQLException ex) {
            //Instalar Logger
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnSeleccionArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionArchivoActionPerformed
        frmSelectorArchivo miArchivo = new frmSelectorArchivo(null, closable);
        miArchivo.setLocationRelativeTo(null);
        miArchivo.setVisible(true);
        String archivo = miArchivo.getArchivo();
        if (!archivo.equals("")) {
            txtArchivo.setText(archivo);
        }
    }//GEN-LAST:event_btnSeleccionArchivoActionPerformed
    private void habilitarCampos() {
        if (rbtTodo.isSelected()) {
            rbtFecha.setEnabled(false);
            rbtFactura.setEnabled(false);
            rbtCliente.setEnabled(false);

            dchFechaInicial.setEnabled(false);
            dchFechaFinal.setEnabled(false);

            cmbCliente.setEnabled(false);

            cmbFacturaInicial.setEnabled(false);
            cmbFacturaFinal.setEnabled(false);

        } else {
            rbtFecha.setEnabled(true);
            rbtFactura.setEnabled(true);
            rbtCliente.setEnabled(true);

            if (rbtFecha.isSelected()) {
                dchFechaInicial.setEnabled(true);
                dchFechaFinal.setEnabled(true);

                cmbCliente.setEnabled(false);

                cmbFacturaInicial.setEnabled(false);
                cmbFacturaFinal.setEnabled(false);
            }
            if (rbtFactura.isSelected()) {
                dchFechaInicial.setEnabled(false);
                dchFechaFinal.setEnabled(false);

                cmbCliente.setEnabled(false);

                cmbFacturaInicial.setEnabled(true);
                cmbFacturaFinal.setEnabled(true);
            }
            if (rbtCliente.isSelected()) {
                dchFechaInicial.setEnabled(false);
                dchFechaFinal.setEnabled(false);

                cmbCliente.setEnabled(true);

                cmbFacturaInicial.setEnabled(false);
                cmbFacturaFinal.setEnabled(false);
                
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrFiltro;
    private javax.swing.ButtonGroup bgrTipo;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnSeleccionArchivo;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JComboBox cmbFacturaFinal;
    private javax.swing.JComboBox cmbFacturaInicial;
    private com.toedter.calendar.JDateChooser dchFechaFinal;
    private com.toedter.calendar.JDateChooser dchFechaInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton rbtCliente;
    private javax.swing.JRadioButton rbtFactura;
    private javax.swing.JRadioButton rbtFecha;
    private javax.swing.JRadioButton rbtSeleccion;
    private javax.swing.JRadioButton rbtTodo;
    private javax.swing.JTextField txtArchivo;
    // End of variables declaration//GEN-END:variables
}
