package sur.softsurena.formularios;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sur.softsurena.entidades.Opcion;
import static sur.softsurena.entidades.Turnos.cerrarTurno;
import static sur.softsurena.entidades.Turnos.idTurnoActivo;
import static sur.softsurena.entidades.Turnos.usuarioTurnoActivo;
import sur.softsurena.hilos.hiloImpresionFactura;

public class frmCerrarTurno extends java.awt.Dialog {

    private static final Logger LOG = Logger.getLogger(frmCerrarTurno.class.getName());

    private int idTurno;
    private boolean aceptar;

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }

    public frmCerrarTurno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPreviewPanel1 = new org.jdesktop.swingx.color.GradientPreviewPanel();
        jcbUsuarios = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();

        setResizable(false);
        setTitle("Cerrar Turno de Cajero");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        gradientPreviewPanel1.setOpaque(false);
        gradientPreviewPanel1.setRadial(true);
        gradientPreviewPanel1.setReflected(true);
        gradientPreviewPanel1.setRepeated(true);
        gradientPreviewPanel1.setReversed(true);

        jcbUsuarios.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N

        jLabel1.setText("Cajeros:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cerrar Turno");

        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.setEffectButton(RSMaterialComponent.RSButtonMaterialIconOne.EFFECTBUTTON.RAISED);
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("");
        btnCancelar.setEffectButton(RSMaterialComponent.RSButtonMaterialIconOne.EFFECTBUTTON.RAISED);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gradientPreviewPanel1Layout = new javax.swing.GroupLayout(gradientPreviewPanel1);
        gradientPreviewPanel1.setLayout(gradientPreviewPanel1Layout);
        gradientPreviewPanel1Layout.setHorizontalGroup(
            gradientPreviewPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPreviewPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPreviewPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPreviewPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(180, 180, 180))
                    .addComponent(jcbUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPreviewPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        gradientPreviewPanel1Layout.setVerticalGroup(
            gradientPreviewPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPreviewPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gradientPreviewPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPreviewPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gradientPreviewPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Opcion miOpcion = new Opcion("0", "Seleccione un usuario");
        jcbUsuarios.removeAllItems();
        jcbUsuarios.addItem(miOpcion);
//        ResultSet rs = getUsuariosActivo();
        ResultSet rs = null;
        try {
            while (rs.next()) {
                miOpcion = new Opcion(
                        rs.getString("idUsuario"),
                        rs.getString("Nombres") + " " + rs.getString("Apellidos")
                );
                jcbUsuarios.addItem(miOpcion);

            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setAceptar(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String idUsuario = ((Opcion) jcbUsuarios.getSelectedItem()).getValor();
        if (idUsuario.equals("0")) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un Usuario");
            return;
        }
        if (!usuarioTurnoActivo(idUsuario)) {
            JOptionPane.showMessageDialog(null, "Usuario sin Turno Abierto...");
            return;
        }

        setIdTurno(idTurnoActivo(idUsuario));

        if (cerrarTurno(idUsuario)) {
            JOptionPane.showMessageDialog(null, "Turno Cerrado");
        } else {
            JOptionPane.showMessageDialog(null, "Problema para cerrar Turno");
        }

        imprimirReporte(((Opcion) jcbUsuarios.getSelectedItem()).getDescripcion());
        setAceptar(true);
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed
    private void imprimirReporte(String nombreUsuario) {
        
        Map parametros = new HashMap();
        parametros.put("idTurno", getIdTurno());
        parametros.put("idUsuario", nombreUsuario);
        
        hiloImpresionFactura miHilo = new hiloImpresionFactura(
                true,//Mostrar Reporte
                false,//Con Copia
                "/Reportes/reporteCuadre.jasper",
                parametros,
                frmPrincipal.jPanelImpresion,
                frmPrincipal.jprImpresion);
        
        miHilo.start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private org.jdesktop.swingx.color.GradientPreviewPanel gradientPreviewPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox jcbUsuarios;
    // End of variables declaration//GEN-END:variables
}
