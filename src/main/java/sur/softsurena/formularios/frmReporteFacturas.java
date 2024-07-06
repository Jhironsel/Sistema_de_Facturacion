package sur.softsurena.formularios;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Factura;
import static sur.softsurena.metodos.M_Factura.getFacturas;
import sur.softsurena.utilidades.Utilidades;

public class frmReporteFacturas extends javax.swing.JInternalFrame
       {

    public frmReporteFacturas() {

        initComponents();

        JTextField editorFecha = (JTextField) dchFechaInicial.getDateEditor();

        editorFecha.setBorder(
                javax.swing.BorderFactory.createTitledBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                new java.awt.Color(0, 0, 255)), "Fecha inicial"));

        editorFecha = (JTextField) dchFechaFinal.getDateEditor();

        editorFecha.setBorder(
                javax.swing.BorderFactory.createTitledBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                new java.awt.Color(0, 0, 255)), "Fecha final"));
    }

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtArchivo = new javax.swing.JTextField();
        btnSeleccionArchivo = new javax.swing.JButton();
        btnGenerar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        dchFechaInicial = new com.toedter.calendar.JDateChooser();
        dchFechaFinal = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        cmbFacturaInicial = new javax.swing.JComboBox();
        cmbFacturaFinal = new javax.swing.JComboBox();
        cmbCliente = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Reporte de Facturas");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        txtArchivo.setText("Reporte");
        txtArchivo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Nombre archivo"));

        btnSeleccionArchivo.setText("...");
        btnSeleccionArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionArchivoActionPerformed(evt);
            }
        });

        btnGenerar.setText("Generar reporte");
        btnGenerar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGenerar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PUBLISH);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dchFechaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(dchFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dchFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dchFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Por Fecha", jPanel1);

        cmbFacturaInicial.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Factura inicial"));

        cmbFacturaFinal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Factura final"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbFacturaInicial, 0, 379, Short.MAX_VALUE)
                    .addComponent(cmbFacturaFinal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbFacturaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbFacturaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbFacturaFinal, cmbFacturaInicial});

        jTabbedPane1.addTab("Por rango", jPanel2);

        cmbCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Listado de clientes"));

        jCheckBox1.setText("Parametrizada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSeleccionArchivo)))
                            .addComponent(jCheckBox1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSeleccionArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        /*
            El campo o ComboBox de cliente debe de estar habilitado cuando es
        seleccionado y quiera buscarse los numero o identificador de factura. 
        
         */
        //Cargamos Clientes
        Cliente cli = Cliente
                .builder()
                .id_persona(-1)
                .pnombre("Seleccione un cliente")
                .snombre("")
                .apellidos("")
                .build();

        cmbCliente.addItem(cli);

        //TODO Traer solo clientes.
        
//        getClientes(
//                FiltroBusqueda
//                        .builder()
//                        .estado(true)
//                        .build()
//        ).stream().forEach(cliente -> {
//            cmbCliente.addItem(cliente);
//        });

        //Cargamos Facturas
        Factura fac = 
                Factura
                        .builder()
                        .id(-1)
                        .build();

        cmbFacturaInicial.addItem(cli);

        cmbFacturaFinal.addItem(cli);

        getFacturas().stream().forEach(x -> {
            cmbFacturaInicial.addItem(fac);
            cmbFacturaFinal.addItem(fac);
        });

    }//GEN-LAST:event_formInternalFrameOpened

    private void btnSeleccionArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionArchivoActionPerformed
        frmSelectorArchivo miArchivo = new frmSelectorArchivo(null, closable);
        miArchivo.setLocationRelativeTo(null);
        miArchivo.setVisible(true);
        String archivo = miArchivo.getArchivo();
        if (!archivo.isBlank()) {
            txtArchivo.setText(archivo);
        }
    }//GEN-LAST:event_btnSeleccionArchivoActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if (txtArchivo.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this, 
                    "Debe ingresar o Selecionar un Nombre de Archivo...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        //TODO Investigar que hace esta variable.
        String archivo = txtArchivo.getText();
        String sql = "SELECT factura.idFactura, factura.idCliente, "
                + " (nombres||' '||apellidos) AS nombreFull, "
                + "fecha, idLinea, idProducto, (select descripcion from productos where idProducto like detalleFactura.idProducto) as descripcion, precio, "
                + "cantidad, precio * cantidad AS Valor "
                + "FROM factura "
                + "INNER JOIN cliente ON factura.idCliente = cliente.idCliente "
                + "INNER JOIN detalleFactura ON factura.idFactura = detalleFactura.idFactura ";

        if (cmbCliente.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this, 
                    "Debe Selecionar un Cliente.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            cmbCliente.requestFocusInWindow();
            return;
        }
        
        String filtro = "WHERE factura.idCliente = '"
                + ((Cliente) cmbCliente.getSelectedItem()).getId_persona() + "'";

        //Para Realizar la Consulta por Numero de Factura...
        //Si las factura es seleccionada.
        if (cmbFacturaInicial.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this, 
                    "Debe Selecionar una Factura Inicial...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            cmbFacturaInicial.requestFocusInWindow();
            return;
        }
        if (cmbFacturaFinal.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this, 
                    "Debe Selecionar una Factura Final...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            cmbFacturaFinal.requestFocusInWindow();
            return;
        }

        if (cmbFacturaInicial.getSelectedIndex() > cmbFacturaFinal.getSelectedIndex()) {
            JOptionPane.showInternalMessageDialog(
                    this, 
                    "Factura Inicial Maryor que la Final",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            cmbFacturaInicial.requestFocusInWindow();
            return;
        }

        filtro = "WHERE factura.idFactura >= "
                + ((Factura) cmbFacturaInicial.getSelectedItem()).getId()
                + " and factura.idFactura <= "
                + ((Factura) cmbFacturaFinal.getSelectedItem()).getId();

        //Para Realizar la Consulta por Fecha...
        //Si la fecha es seleccionada.
        if (dchFechaInicial.getDate() == null) {
            JOptionPane.showInternalMessageDialog(
                    this, 
                    "Debe Selecionar una Fecha Inicial...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            dchFechaInicial.requestFocusInWindow();
            return;
        }
        if (dchFechaFinal.getDate() == null) {
            JOptionPane.showInternalMessageDialog(
                    this, 
                    "Debe Selecionar una Fecha Final...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            dchFechaFinal.requestFocusInWindow();
            return;
        }

        filtro = "WHERE fecha >= '"
                + Utilidades.formatDate(dchFechaInicial.getDate(), "MM-dd-yyyy")
                + "' and fecha <= '"
                + Utilidades.formatDate(dchFechaFinal.getDate(), "MM-dd-yyyy") + "'";

        //Adicionamos el fitro a la Consulta....
        sql = sql + filtro;

//            Reporte.reporteFacturas(archivo, getConsulta(sql));
        JOptionPane.showInternalMessageDialog(
                this, 
                "Reporte Generado...",
                "",
                JOptionPane.INFORMATION_MESSAGE
        );
        dispose();

    }//GEN-LAST:event_btnGenerarActionPerformed
    private void habilitarCampos() {
        dchFechaInicial.setEnabled(false);
        dchFechaFinal.setEnabled(false);

        cmbCliente.setEnabled(false);

        cmbFacturaInicial.setEnabled(false);
        cmbFacturaFinal.setEnabled(false);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnGenerar;
    private javax.swing.JButton btnSeleccionArchivo;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JComboBox cmbFacturaFinal;
    private javax.swing.JComboBox cmbFacturaInicial;
    private com.toedter.calendar.JDateChooser dchFechaFinal;
    private com.toedter.calendar.JDateChooser dchFechaInicial;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtArchivo;
    // End of variables declaration//GEN-END:variables
}
