package sur.softsurena.formularios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static sur.softsurena.entidades.Productos.buscarProducto;

public class frmBusquedaProducto extends javax.swing.JDialog {

    private static final Logger LOG = Logger.getLogger(frmBusquedaProducto.class.getName());

    private DefaultTableModel miTabla;
    private String respuesta = "";

    public String getRespuesta() {
        return respuesta;
    }

    public frmBusquedaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCriterio = new RSMaterialComponent.RSTextFieldIconOne();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTabla = new RSMaterialComponent.RSTableMetroCustom();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda de Productos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtCriterio.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        txtCriterio.setPlaceholder("Busqueda por Descripción o por Código de Producto");
        txtCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioActionPerformed(evt);
            }
        });
        txtCriterio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioKeyReleased(evt);
            }
        });

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTabla.setShowGrid(true);
        jScrollPane3.setViewportView(tblTabla);

        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCriterio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarTabla();
        txtCriterio.requestFocusInWindow();

    }//GEN-LAST:event_formWindowOpened

    private void txtCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioActionPerformed
        llenarTabla();
        btnAceptarActionPerformed(evt);
    }//GEN-LAST:event_txtCriterioActionPerformed

    private void txtCriterioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioKeyReleased
        llenarTabla();
    }//GEN-LAST:event_txtCriterioKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        respuesta = "";
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tblTabla.getRowCount() == 0 || tblTabla.getSelectedRow() == -1) {
            respuesta = "";
            dispose();
            return;
        }
        for (int i = 0; i < tblTabla.getRowCount(); i++) {
            if (tblTabla.isRowSelected(i)) {
                respuesta = (tblTabla.getValueAt(i, 0).toString());
                dispose();
                return;
            }
        }
        respuesta = (tblTabla.getValueAt(0, 0).toString());
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed
    private void llenarTabla() {
        String titulos[] = {"ID Producto", "Codigo", "Descripcion"};
        
        Object registro[] = new Object[titulos.length];
        
        miTabla = new DefaultTableModel(null, titulos);
        
        if (txtCriterio.getText().equals("")) {
            miTabla = null;
            tblTabla.setModel(miTabla);
            return;
        } 

        ResultSet rs = buscarProducto(txtCriterio.getText());

        try {
            while (rs.next()) {
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("codigo");
                registro[2] = rs.getString("descripcion");
                miTabla.addRow(registro);
            }
            tblTabla.setModel(miTabla);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        if (tblTabla.getRowCount() > 1) {
            btnAceptar.setEnabled(true);
            tblTabla.getSelectionModel().setSelectionInterval(0, 0);
        }else{
            btnAceptar.setEnabled(false);
        }
        
        try {
            rs.close();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private javax.swing.JScrollPane jScrollPane3;
    private RSMaterialComponent.RSTableMetroCustom tblTabla;
    private RSMaterialComponent.RSTextFieldIconOne txtCriterio;
    // End of variables declaration//GEN-END:variables
}
